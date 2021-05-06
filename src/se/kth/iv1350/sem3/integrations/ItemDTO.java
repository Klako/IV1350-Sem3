package se.kth.iv1350.sem3.integrations;

/**
 * A transfer object that contains information about an item stored in the
 * inventory system.
 */
public class ItemDTO {

    private int id;
    private String description;
    private float price;
    private float vat;

    /**
     * Creates a new object containing information about an item.
     *
     * @param id An item inventory id.
     * @param description An item description.
     * @param price An item's price.
     * @param vat An item's tax.
     */
    public ItemDTO(int id, String description, float price, float vat) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.vat = vat;
    }

    /**
     * Gets the description about the item.
     *
     * @return The item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the item id.
     *
     * @return The inventory id of the item.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the item's price.
     *
     * @return The item's price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Gets the established VAT for the item.
     *
     * @return The item's tax.
     */
    public float getVat() {
        return vat;
    }
}
