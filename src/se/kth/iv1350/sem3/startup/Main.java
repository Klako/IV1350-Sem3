package se.kth.iv1350.sem3.startup;

import java.util.logging.Level;
import se.kth.iv1350.sem3.view.*;
import se.kth.iv1350.sem3.controller.*;
import se.kth.iv1350.sem3.integrations.*;
import se.kth.iv1350.sem3.util.POSLogger;

public class Main {

    /**
     * Initializes and runs the program.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();
        Accounting accounting = new Accounting();
        Printer printer = new Printer();
        SaleInfoHandler saleInfoHandler = new SaleInfoHandler(
                accounting, inventory, printer
        );
        Controller controller = new Controller(inventory, saleInfoHandler);
        controller.AddRevenueObserver(new TotalRevenueView());
        controller.AddRevenueObserver(new TotalRevenueFileOutput());
        View view = new View(controller);

        try {
            POSLogger.setup();
        } catch (Exception ex) {
            System.err.println("Could not setup logger: " + ex.getMessage());
            return;
        }

        try {
            view.processSale1();
            view.processSale2();
        } catch (Exception ex) {
            POSLogger.log(Level.SEVERE, ex);
        }

    }
}
