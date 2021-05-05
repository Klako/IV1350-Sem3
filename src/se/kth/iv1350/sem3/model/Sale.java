package se.kth.iv1350.sem3.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import se.kth.iv1350.sem3.integrations.Accounting;
import se.kth.iv1350.sem3.integrations.Inventory;
import se.kth.iv1350.sem3.integrations.ItemDTO;
import se.kth.iv1350.sem3.integrations.PurchasedItemDTO;
import se.kth.iv1350.sem3.integrations.PaymentDTO;
import se.kth.iv1350.sem3.integrations.SaleInformationDTO;

public class Sale {

    private Inventory inventory;
    private Accounting accounting;

    private List<SaleItem> items;

    /**
     * Initializes a new sale.
     *
     * @param inventory
     * @param accounting
     */
    public Sale(Inventory inventory, Accounting accounting) {
        this.inventory = inventory;
        this.accounting = accounting;
        items = new LinkedList<>();
    }

    /**
     * Adds a new item of the given type to the sale.
     *
     * @param itemId
     * @return Information about the added item.s
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
     * @return
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
     * @return
     */
    public float getTotalWithTax() {
        float sum = 0;
        for (SaleItem saleItem : items) {
            sum += calculateNetPrice(saleItem.getItem()) * saleItem.getQuantity();
        }
        return sum;
    }

    /**
     * Finalizes the sale, paying the given amount.
     *
     * @param amount
     * @return The difference between total and amount payed.
     */
    public float pay(float amount) {
        float totalWithTax = getTotalWithTax();
        float change = amount - totalWithTax;
        List<PurchasedItemDTO> purchasedItems = convertPurchasedItems();
        accounting.logSale(new SaleInformationDTO(
                purchasedItems,
                new PaymentDTO(amount, change)
        ));
        inventory.removeItems(purchasedItems);
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
