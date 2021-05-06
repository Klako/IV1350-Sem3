package se.kth.iv1350.sem3.integrations;

/**
 * Represents physical items of a type in the inventory.
 */
public class InventoryItem {
    private ItemDTO item;
    private int quantity;
    
    /**
     * Instantiates an inventory item.
     * @param item An item that is stored.
     * @param quantity A quantity of that item.
     */
    public InventoryItem(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    
    /**
     * Gets the item stored in the inventory.
     * @return The item stored in the inventory.
     */
    public ItemDTO getItem(){
        return item;
    }
    
    /**
     * Gets the quantity of this type in the inventory.
     * @return The quantity of items.
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     * Decrements the quantity of the inventory item.
     * @param decrement The amount to decrement by.
     */
    public void decrementQuantity(int decrement){
        quantity -= decrement;
    }
}
