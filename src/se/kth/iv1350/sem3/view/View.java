package se.kth.iv1350.sem3.view;

import se.kth.iv1350.sem3.controller.*;

/**
 * Class for handling the user interface.
 */
public class View {

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Processes a hard coded sale.
     */
    public void processSale() {
        controller.startNewSale();
        ItemRegistrationDTO registration = controller.registerItem(1);
        System.out.println("description: " + registration.getItemInfo().getDescription());
        System.out.println("price: " + registration.getItemInfo().getPrice());
        System.out.println("total: " + registration.getRunningTotal());
        registration = controller.registerItem(2);
        System.out.println("description: " + registration.getItemInfo().getDescription());
        System.out.println("price: " + registration.getItemInfo().getPrice());
        System.out.println("total: " + registration.getRunningTotal());
        registration = controller.registerItem(1);
        System.out.println("description: " + registration.getItemInfo().getDescription());
        System.out.println("price: " + registration.getItemInfo().getPrice());
        System.out.println("total: " + registration.getRunningTotal());
        registration = controller.registerItem(3);
        System.out.println("description: " + registration.getItemInfo().getDescription());
        System.out.println("price: " + registration.getItemInfo().getPrice());
        System.out.println("total: " + registration.getRunningTotal());
        float total = controller.calculateTotal();
        System.out.println("final total: " + total);
        float payment = 1000;
        System.out.println("payment: " + payment);
        float change = controller.pay(payment);
        System.out.println("change: " + change);
    }
}
