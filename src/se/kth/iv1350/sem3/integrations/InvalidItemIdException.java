package se.kth.iv1350.sem3.integrations;

/**
 * Thrown when a specified item cannot be found in the database.
 */
public class InvalidItemIdException extends Exception {

    private int itemId;

    /**
     * Creates a new instance with a message specifying the id of an item that
     * cannot be found.
     *
     * @param itemId An id of an item that cannot be found.
     */
    public InvalidItemIdException(int itemId) {
        super("An item with item id " + itemId + " does not exist.");
        this.itemId = itemId;
    }

    /**
     * @return The id of the item that cannot be found.
     */
    public int getItemId() {
        return itemId;
    }
}
