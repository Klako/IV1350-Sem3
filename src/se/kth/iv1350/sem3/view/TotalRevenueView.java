package se.kth.iv1350.sem3.view;

import se.kth.iv1350.sem3.controller.TotalRevenueObserver;

/**
 * Observer that gets updated to display the total revenue of the program in the
 * console.
 */
public class TotalRevenueView implements TotalRevenueObserver {

    private float totalRevenue;

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(float total) {
        totalRevenue += total;
        System.out.println("The new total revenue is: " + totalRevenue);
    }

}
