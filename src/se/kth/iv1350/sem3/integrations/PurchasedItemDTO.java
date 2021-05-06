package se.kth.iv1350.sem3.integrations;

/**
 * A transfer object to compile log data for the accounting system.
 */
public class PurchasedItemDTO {

    private ItemDTO item;
    private int quantity;

    /**
     * Creates a new object containing information about a purchased type of
     * item.
     *
     * @param item A purchased item.
     * @param quantity A quantity of the item.
     */
    public PurchasedItemDTO(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Gets the purchased item type.
     *
     * @return The purchased item.
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * Gets the quantity of purchased items.
     *
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

}
