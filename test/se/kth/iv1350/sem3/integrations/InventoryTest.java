package se.kth.iv1350.sem3.integrations;

import java.util.LinkedList;
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
        int itemId = 1;
        Inventory instance = new Inventory();
        ItemDTO result = instance.getItem(itemId);
        assertEquals(itemId, result.getId());
        
        int invalidItemid = 0;
        try{
            instance.getItem(invalidItemid);
            fail("Didn't throw exception on bad item id");
        } catch (InvalidItemIdException ex) {
            assertEquals(invalidItemid, ex.getItemId());
        } catch (Exception ex){
            fail("Wrong exception");
        }
        
        instance.setServerActive(false);
        
        try{
            instance.getItem(itemId);
            fail("Didn't throw exception on server inactive");
        } catch (InventoryServerException ex){
            assertTrue(
                "Bad exception message, does not contain 'running'",
                ex.getMessage().contains("running")
            );
        } catch (Exception ex){
            fail("Wrong exception");
        }
    }
}
