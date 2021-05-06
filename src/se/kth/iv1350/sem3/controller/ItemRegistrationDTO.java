package se.kth.iv1350.sem3.controller;

import se.kth.iv1350.sem3.model.ItemDisplayDTO;

/**
 * A transfer object that contains the state of a sale after registering
 * an item.
 */
public class ItemRegistrationDTO {

    private ItemDisplayDTO itemInfo;
    private float runningTotal;

    /**
     * Creates a new object containing registration info.
     *
     * @param itemInfo Display information of the item.
     * @param runningTotal The current running total of the sale.
     */
    public ItemRegistrationDTO(ItemDisplayDTO itemInfo, float runningTotal) {
        this.itemInfo = itemInfo;
        this.runningTotal = runningTotal;
    }

    /**
     * Gets reduced information about the registered item.
     *
     * @return Display information of the registered item.
     */
    public ItemDisplayDTO getItemInfo() {
        return itemInfo;
    }

    /**
     * Gets the current running total.
     *
     * @return The current running total of the sale.
     */
    public float getRunningTotal() {
        return runningTotal;
    }
}
