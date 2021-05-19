package se.kth.iv1350.sem3.model;

import java.awt.image.SampleModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.sem3.integrations.Inventory;
import se.kth.iv1350.sem3.integrations.ItemDTO;

/**
 *
 * @author klako
 */
public class SaleItemTest {
    
    public SaleItemTest() {
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
     * Test of incrementQuantity method, of class SaleItem.
     */
    @Test
    public void testIncrementQuantity() throws Exception {
        System.out.println("incrementQuantity");
        Inventory inventory = new Inventory();
        ItemDTO item = inventory.getItem(2);
        SaleItem instance = new SaleItem(item);
        assertEquals(1,instance.getQuantity());
        instance.incrementQuantity();
        assertEquals(2, instance.getQuantity());
    }
    
}
