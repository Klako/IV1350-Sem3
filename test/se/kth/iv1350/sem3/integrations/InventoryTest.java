package se.kth.iv1350.sem3.integrations;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author klako
 */
public class InventoryTest {
    
    public InventoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setServerActive method, of class Inventory.
     */
    @Test
    public void testSetServerActive() {
        System.out.println("setServerActive");
        boolean serverActive = false;
        Inventory instance = new Inventory();
        instance.setServerActive(serverActive);
        assertEquals(serverActive, instance.getServerActive());
    }

    /**
     * Test of getItem method, of class Inventory.
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        int itemId = 0;
        Inventory instance = new Inventory();
        ItemDTO expResult = null;
        ItemDTO result = instance.getItem(itemId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItems method, of class Inventory.
     */
    @Test
    public void testRemoveItems() {
        System.out.println("removeItems");
        List<PurchasedItemDTO> items = null;
        Inventory instance = new Inventory();
        instance.removeItems(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
