package se.kth.iv1350.sem3.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.sem3.integrations.Accounting;
import se.kth.iv1350.sem3.integrations.Inventory;
import se.kth.iv1350.sem3.integrations.ItemDTO;

/**
 *
 * @author klako
 */
public class SaleTest {

    public SaleTest() {
    }

    /**
     * Test of addItem method, of class Sale.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        int itemId = 1;
        Inventory inventory = new Inventory();
        Accounting accounting = new Accounting();
        Sale instance = new Sale(inventory, accounting);
        ItemDTO item = inventory.getItem(itemId);
        ItemDisplayDTO result = instance.addItem(itemId);
        assertEquals(item.getDescription(), result.getDescription());
        assertEquals(item.getPrice(), result.getPrice(), 0.0);
    }

}
