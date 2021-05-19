package se.kth.iv1350.sem3.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.sem3.model.*;
import se.kth.iv1350.sem3.integrations.*;

/**
 * Class for handling calls between view and model.
 */
public class Controller {

    private Inventory inventory;
    private SaleInfoHandler saleInfoHandler;

    private Sale currentSale;

    private List<TotalRevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * Creates a new controller for handling sales.
     *
     * @param inventory The inventory integration
     * @param accounting The accounting integration
     */
    public Controller(Inventory inventory, SaleInfoHandler saleInfoHandler) {
        this.inventory = inventory;
        this.saleInfoHandler = saleInfoHandler;
    }

    /**
     * Initialized a new sale. Must be called before adding items etc.
     */
    public void startNewSale() {
        currentSale = new Sale(inventory, saleInfoHandler);
    }

    /**
     * Registers an item to the current sale.
     *
     * @param itemId The inventory ID of the item.
     * @return Information about the updated state of the sale.
     */
    public ItemRegistrationDTO registerItem(int itemId)
            throws InvalidItemIdException {
        ItemDisplayDTO itemInfo = currentSale.addItem(itemId);
        return new ItemRegistrationDTO(itemInfo, currentSale.getTotal());
    }

    /**
     * Calculate the final total amount to be payed.
     *
     * @return The calculated total including tax.
     */
    public float calculateTotal() {
        return currentSale.getTotalWithTax();
    }

    /**
     * Make a payment of the given amount.
     *
     * @param amount The amount to pay.
     * @return The overflow of the payment.
     */
    public float pay(float amount) {
        float change = currentSale.pay(amount);
        updateRevenueObservers();
        return change;
    }

    private void updateRevenueObservers() {
        float currentTotal = currentSale.getTotalWithTax();
        for (TotalRevenueObserver observer : revenueObservers) {
            observer.update(currentTotal);
        }
    }

    /**
     * Adds a revenue observer to the controller.
     *
     * @param observer an observer that handles updates to the programs total
     * revenue.
     */
    public void AddRevenueObserver(TotalRevenueObserver observer) {
        revenueObservers.add(observer);
    }
}
