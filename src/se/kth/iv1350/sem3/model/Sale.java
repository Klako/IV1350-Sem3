package se.kth.iv1350.sem3.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import se.kth.iv1350.sem3.integrations.Accounting;
import se.kth.iv1350.sem3.integrations.Inventory;
import se.kth.iv1350.sem3.integrations.ItemDTO;
import se.kth.iv1350.sem3.integrations.PurchasedItemDTO;
import se.kth.iv1350.sem3.integrations.PaymentDTO;
import se.kth.iv1350.sem3.integrations.SaleInfoHandler;
import se.kth.iv1350.sem3.integrations.SaleInformationDTO;

/**
 * Represents a sale in progress.
 */
public class Sale {

    private SaleInfoHandler saleInfoHandler;
    private Inventory inventory;

    private List<SaleItem> items;

    /**
     * Initializes a new sale.
     *
     * @param inventory An inventory system integration
     * @param saleInfoHandler A handler for the end sale information. 
     */
    public Sale(Inventory inventory, SaleInfoHandler saleInfoHandler) {
        this.saleInfoHandler = saleInfoHandler;
        this.inventory = inventory;
        items = new LinkedList<>();
    }

    /**
     * Adds a new item of the given type to the sale.
     *
     * @param itemId The inventory id of an item.
     * @return Information about the added item.
     */
    public ItemDisplayDTO addItem(int itemId) {
        SaleItem foundItem = findItem(itemId);

        if (foundItem == null) {
            ItemDTO inventoryItem = inventory.getItem(itemId);
            SaleItem newItem = new SaleItem(inventoryItem);
            items.add(newItem);
            foundItem = newItem;
        } else {
            foundItem.incrementQuantity();
        }

        return new ItemDisplayDTO(
                foundItem.getItem().getDescription(),
                foundItem.getItem().getPrice()
        );
    }

    /**
     * Gets the running total of the sale.
     *
     * @return The current running total.
     */
    public float getTotal() {
        float sum = 0;
        for (SaleItem saleItem : items) {
            sum += saleItem.getItem().getPrice() * saleItem.getQuantity();
        }
        return sum;
    }

    /**
     * Gets the total including each item's tax.
     *
     * @return The current running total including tax.
     */
    public float getTotalWithTax() {
        float sum = 0;
        for (SaleItem saleItem : items) {
            sum += calculateNetPrice(saleItem.getItem())
                    * saleItem.getQuantity();
        }
        return sum;
    }

    /**
     * Finalizes the sale, paying the given amount.
     *
     * @param amount The amount payed.
     * @return The difference between taxed running total and amount payed.
     */
    public float pay(float amount) {
        float totalWithTax = getTotalWithTax();
        float change = amount - totalWithTax;
        List<PurchasedItemDTO> purchasedItems = convertPurchasedItems();
        SaleInformationDTO saleInfo = new SaleInformationDTO(
                purchasedItems,
                new PaymentDTO(amount, change)
        );
        saleInfoHandler.handle(saleInfo);
        return change;
    }

    private List<PurchasedItemDTO> convertPurchasedItems() {
        List<PurchasedItemDTO> purchasedItems = new ArrayList<>();

        for (SaleItem saleItem : items) {
            purchasedItems.add(new PurchasedItemDTO(
                    saleItem.getItem(),
                    saleItem.getQuantity()
            ));
        }
        return purchasedItems;
    }

    private float calculateNetPrice(ItemDTO item) {
        return item.getPrice() * (1 - item.getVat());
    }

    private SaleItem findItem(int itemId) {
        for (SaleItem item : items) {
            if (item.getItem().getId() == itemId) {
                return item;
            }
        }
        return null;
    }
}
