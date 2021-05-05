package se.kth.iv1350.sem3.controller;

import se.kth.iv1350.sem3.model.*;
import se.kth.iv1350.sem3.integrations.*;

public class Controller {

    private Inventory inventory;
    private Accounting accounting;

    private Sale currentSale;

    /**
     * Creates a new controller for handling sales.
     *
     * @param inventory
     * @param accounting
     */
    public Controller(Inventory inventory, Accounting accounting) {
        this.inventory = inventory;
        this.accounting = accounting;
    }

    /**
     * Initialized a new sale. Must be called before adding items etc.
     */
    public void startNewSale() {
        currentSale = new Sale(inventory, accounting);
    }

    /**
     * Registers an item to the current sale.
     *
     * @param itemId
     * @return Information about the updated state of the sale.
     */
    public ItemRegistrationDTO registerItem(int itemId) {
        ItemDisplayDTO itemInfo = currentSale.addItem(itemId);
        return new ItemRegistrationDTO(itemInfo, currentSale.getTotal());
    }

    /**
     * Calculate the final total amount to be payed.
     *
     * @return
     */
    public float calculateTotal() {
        return currentSale.getTotalWithTax();
    }

    /**
     * Make a payment of the given amount.
     *
     * @param amount
     * @return The overflow of the payment.
     */
    public float pay(float amount) {
        float change = currentSale.pay(amount);
        return change;
    }
}
