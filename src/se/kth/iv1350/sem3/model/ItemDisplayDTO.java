package se.kth.iv1350.sem3.model;

/**
 * A transfer object that contains display information for an item.
 */
public class ItemDisplayDTO {

    private String description;
    private float price;

    /**
     * Creates a new object containing display information for an item.
     *
     * @param description A description of the item.
     * @param price A price of the item.
     */
    public ItemDisplayDTO(String description, float price) {
        this.description = description;
        this.price = price;
    }

    /**
     * Gets the description of the item.
     *
     * @return The item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the price of the item.
     *
     * @return The item price.
     */
    public float getPrice() {
        return price;
    }
}
