package se.kth.iv1350.sem3.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.sem3.integrations.Accounting;
import se.kth.iv1350.sem3.integrations.Inventory;
import se.kth.iv1350.sem3.integrations.ItemDTO;
import se.kth.iv1350.sem3.model.ItemDisplayDTO;

/**
 *
 * @author klako
 */
public class ControllerTest {

    public ControllerTest() {
    }

    /**
     * Test of registerItem method, of class Controller.
     */
    @Test
    public void testSingleRegisterItem() {
        System.out.println("registerItem");
        int itemId = 2;
        Inventory inventory = new Inventory();
        Accounting accounting = new Accounting();
        Controller instance = new Controller(inventory, accounting);
        ItemDTO item = inventory.getItem(itemId);
        instance.startNewSale();
        ItemRegistrationDTO result = instance.registerItem(itemId);
        assertEquals(item.getDescription(), result.getItemInfo().getDescription());
        assertEquals(item.getPrice(), result.getItemInfo().getPrice(), 0.0);
        assertEquals(item.getPrice(), result.getRunningTotal(), 0.0);
    }

}
