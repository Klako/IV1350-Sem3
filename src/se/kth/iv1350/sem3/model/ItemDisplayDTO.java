package se.kth.iv1350.sem3.model;

public class ItemDisplayDTO {

    private String description;
    private float price;

    /**
     * Creates a new object containing display information for an item.
     *
     * @param description
     * @param price
     */
    public ItemDisplayDTO(String description, float price) {
        this.description = description;
        this.price = price;
    }

    /**
     * Gets the description of the item.
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the price of the item.
     *
     * @return
     */
    public float getPrice() {
        return price;
    }
}
