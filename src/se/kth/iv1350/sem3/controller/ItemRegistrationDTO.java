package se.kth.iv1350.sem3.controller;

import se.kth.iv1350.sem3.model.ItemDisplayDTO;

public class ItemRegistrationDTO {

    private ItemDisplayDTO itemInfo;
    private float runningTotal;

    /**
     * Creates a new object containing registration info.
     *
     * @param itemInfo
     * @param runningTotal
     */
    public ItemRegistrationDTO(ItemDisplayDTO itemInfo, float runningTotal) {
        this.itemInfo = itemInfo;
        this.runningTotal = runningTotal;
    }

    /**
     * Gets reduced information about the registered item.
     *
     * @return
     */
    public ItemDisplayDTO getItemInfo() {
        return itemInfo;
    }

    /**
     * Gets the current running total.
     *
     * @return
     */
    public float getRunningTotal() {
        return runningTotal;
    }
}
