package se.kth.iv1350.sem3.view;

import java.util.logging.Level;
import se.kth.iv1350.sem3.controller.*;
import se.kth.iv1350.sem3.integrations.InvalidItemIdException;
import se.kth.iv1350.sem3.util.POSLogger;

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
    public void processSale1() {
        controller.startNewSale();
        registerItem(0);
        registerItem(1);
        registerItem(0);
        endSale();
    }
    
    /**
     * Processes another hard coded sale.
     */
    public void processSale2(){
        controller.startNewSale();
        registerItem(1);
        registerItem(2);
        registerItem(3);
        endSale();
    }
    
    private void endSale(){
        float total = controller.calculateTotal();
        System.out.println("final total: " + total);
        float payment = 1000;
        System.out.println("payment: " + payment);
        float change = controller.pay(payment);
        System.out.println("change: " + change);
    }

    private void registerItem(int itemId) {
        try {
            ItemRegistrationDTO registration = controller.registerItem(itemId);
            System.out.println("description: "
                    + registration.getItemInfo().getDescription()
            );
            System.out.println("price: "
                    + registration.getItemInfo().getPrice()
            );
            System.out.println("total: " + registration.getRunningTotal());
        } catch (InvalidItemIdException ex) {
            POSLogger.log(Level.WARNING, ex);
            System.out.println("Could not register item with id "
                    + ex.getItemId()
                    + ". The item does not exist."
            );
        }
    }
}
