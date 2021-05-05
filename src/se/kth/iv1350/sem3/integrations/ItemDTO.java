package se.kth.iv1350.sem3.integrations;

public class ItemDTO {

    private int id;
    private String description;
    private float price;
    private float vat;

    /**
     * Creates a new object containing information about an item.
     *
     * @param id
     * @param description
     * @param price
     * @param vat
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
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the item id.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the item's price.
     *
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     * Gets the established VAT for the item.
     *
     * @return
     */
    public float getVat() {
        return vat;
    }
}
