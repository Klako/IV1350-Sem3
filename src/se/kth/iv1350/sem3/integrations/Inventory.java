package se.kth.iv1350.sem3.integrations;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Integration to the inventory system.
 */
public class Inventory {

    private Dictionary<Integer, InventoryItem> items;

    /**
     * Initializes a new inventory system.
     */
    public Inventory() {
        items = new Hashtable<>();
        addDefaultItems();
    }

    private void addDefaultItems() {
        addItem(new ItemDTO(1, "Milk", 10, 0.06f), 100);
        addItem(new ItemDTO(2, "Cheese", 25, 0.06f), 100);
        addItem(new ItemDTO(3, "Bacon", 15, 0.12f), 100);
        addItem(new ItemDTO(4, "Toilet paper", 500, 0.25f), 100);
        addItem(new ItemDTO(5, "Bread", 13.37f, 0.12f), 100);
    }

    private void addItem(ItemDTO item, int quantity) {
        InventoryItem invItem = new InventoryItem(item, quantity);
        items.put(item.getId(), invItem);
    }

    /**
     * Gets item information belonging to an item with the given itemId.
     *
     * @param itemId The inventory id of the item.
     * @return Information about an item.
     */
    public ItemDTO getItem(int itemId) {
        return items.get(itemId).getItem();
    }

    /**
     * Removes items from the inventory.
     *
     * @param items List of purchased items
     */
    public void removeItems(List<PurchasedItemDTO> items) {
        for (PurchasedItemDTO purchasedItem : items) {
            int itemId = purchasedItem.getItem().getId();
            InventoryItem invItem = this.items.get(itemId);
            invItem.decrementQuantity(purchasedItem.getQuantity());
        }
    }
}
