package se.kth.iv1350.sem3.integrations;

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
public class InventoryItemTest {
    
    public InventoryItemTest() {
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
     * Test of decrementQuantity method, of class InventoryItem.
     */
    @Test
    public void testDecrementQuantity() {
        System.out.println("decrementQuantity");
        int startQuantity = 12;
        int decrement = 2;
        InventoryItem instance = new InventoryItem(
                new ItemDTO(1, "test", 1f, 0.1f), startQuantity
        );
        int endQuantity = startQuantity - decrement;
        instance.decrementQuantity(decrement);
        assertEquals(endQuantity, instance.getQuantity());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
