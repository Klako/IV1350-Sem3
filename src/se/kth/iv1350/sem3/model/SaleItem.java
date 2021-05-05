package se.kth.iv1350.sem3.model;

import se.kth.iv1350.sem3.integrations.ItemDTO;

public class SaleItem {

    private ItemDTO item;
    private int quantity;

    /**
     * Creates an object handling the item information during a sale.
     *
     * @param item
     */
    public SaleItem(ItemDTO item) {
        this.item = item;
        quantity = 1;
    }

    /**
     * Gets the item being bought.
     *
     * @return
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * Gets the quantity of the item being bought.
     *
     * @return
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
