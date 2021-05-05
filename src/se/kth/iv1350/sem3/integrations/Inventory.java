package se.kth.iv1350.sem3.integrations;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Inventory {

    private Dictionary<Integer, ItemDTO> items;

    /**
     * Initializes a new inventory system.
     */
    public Inventory() {
        items = new Hashtable<>();
        addItems();
    }

    private void addItems() {
        addItem(new ItemDTO(1, "Milk", 10, 0.06f));
        addItem(new ItemDTO(2, "Cheese", 25, 0.06f));
        addItem(new ItemDTO(3, "Bacon", 15, 0.12f));
        addItem(new ItemDTO(4, "Toilet paper", 500, 0.25f));
        addItem(new ItemDTO(5, "Bread", 13.37f, 0.12f));
    }

    private void addItem(ItemDTO item) {
        items.put(item.getId(), item);
    }

    /**
     * Gets item information belonging to an item with the given itemId.
     *
     * @param itemId
     * @return Information about an item.
     */
    public ItemDTO getItem(int itemId) {
        return items.get(itemId);
    }

    /**
     * Removes items from the inventory.
     *
     * @param items
     */
    public void removeItems(List<PurchasedItemDTO> items) {
        
    }
}
