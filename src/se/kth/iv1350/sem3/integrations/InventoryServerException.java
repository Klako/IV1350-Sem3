package se.kth.iv1350.sem3.integrations;

/**
 * Thrown when something goes wrong with the inventory server itself.
 */
public class InventoryServerException extends RuntimeException {

    /**
     * Creates a new instance with a message describing what's wrong with the
     * inventory server.
     *
     * @param msg Message containing what went wrong with the server.
     */
    public InventoryServerException(String msg) {
        super("Something went wrong with the inventory server: " + msg);
    }
}
