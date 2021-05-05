package se.kth.iv1350.sem3.startup;

import se.kth.iv1350.sem3.view.*;
import se.kth.iv1350.sem3.controller.*;
import se.kth.iv1350.sem3.integrations.*;

public class Main {

    /**
     * Initializes and runs the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Accounting accounting = new Accounting();
        Controller controller = new Controller(inventory, accounting);
        View view = new View(controller);

        view.processSale();
    }
}
