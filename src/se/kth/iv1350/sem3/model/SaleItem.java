package se.kth.iv1350.sem3.model;

import se.kth.iv1350.sem3.integrations.ItemDTO;

/**
 * Represents an item (type) that is being processed in a sale.
 */
public class SaleItem {

    private ItemDTO item;
    private int quantity;

    /**
     * Creates an object handling the item information during a sale.
     *
     * @param item An item from the inventory system.
     */
    public SaleItem(ItemDTO item) {
        this.item = item;
        quantity = 1;
    }

    /**
     * Gets the item being bought.
     *
     * @return The item being processed.
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * Gets the quantity of the item being bought.
     *
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Increases the quantity of this item by one.
     */
    public void incrementQuantity() {
        quantity++;
    }
}
