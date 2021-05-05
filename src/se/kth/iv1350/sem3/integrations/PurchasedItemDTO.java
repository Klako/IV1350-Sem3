package se.kth.iv1350.sem3.integrations;

public class PurchasedItemDTO {

    private ItemDTO item;
    private int quantity;

    /**
     * Creates a new object containing information about a purchased type of
     * item.
     *
     * @param item
     * @param quantity
     */
    public PurchasedItemDTO(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Gets the purchased item type.
     *
     * @return
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * Gets the quantity of purchased items.
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

}
