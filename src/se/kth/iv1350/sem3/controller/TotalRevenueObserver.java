package se.kth.iv1350.sem3.controller;

/**
 * Interface for an observer that receives a new total every time it updates.
 */
public interface TotalRevenueObserver {
    /**
     * Updates the total for the observer.
     * @param total The total for the last purchase.
     */
    public void update(float total);
}
