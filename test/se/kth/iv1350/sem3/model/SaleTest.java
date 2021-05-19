package se.kth.iv1350.sem3.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.sem3.controller.Controller;
import se.kth.iv1350.sem3.integrations.Accounting;
import se.kth.iv1350.sem3.integrations.InvalidItemIdException;
import se.kth.iv1350.sem3.integrations.Inventory;
import se.kth.iv1350.sem3.integrations.InventoryServerException;
import se.kth.iv1350.sem3.integrations.ItemDTO;
import se.kth.iv1350.sem3.integrations.Printer;
import se.kth.iv1350.sem3.integrations.SaleInfoHandler;

/**
 *
 * @author klako
 */
public class SaleTest {

    public SaleTest() {
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
     * Test of addItem method, of class Sale.
     */
    @Test
    public void testAddItem() throws Exception {
        System.out.println("addItem");
        Inventory inventory = new Inventory();
        SaleInfoHandler saleInfoHandler = new SaleInfoHandler(
                new Accounting(), inventory, new Printer()
        );
        ItemDTO item1 = inventory.getItem(4);
        Sale instance = new Sale(inventory, saleInfoHandler);
        ItemDisplayDTO result = instance.addItem(item1.getId());
        assertEquals(item1.getPrice(), result.getPrice(), 0.1);
        assertEquals(item1.getDescription(), result.getDescription());

        int invalidItemid = 0;
        try {
            instance.addItem(invalidItemid);
            fail("Didn't throw exception on bad item id");
        } catch (InvalidItemIdException ex) {
            assertEquals(invalidItemid, ex.getItemId());
        } catch (Exception ex) {
            fail("Wrong exception");
        }
        
        ItemDTO item2 = inventory.getItem(3);
        
        inventory.setServerActive(false);

        try {
            instance.addItem(item2.getId());
            fail("Didn't throw exception on server inactive");
        } catch (InventoryServerException ex) {
            assertTrue(
                    "Bad exception message, does not contain 'running'",
                    ex.getMessage().contains("running")
            );
        } catch (Exception ex) {
            fail("Wrong exception");
        }
    }

    /**
     * Test of getTotal method, of class Sale.
     */
    @Test
    public void testGetTotal() throws Exception {
        System.out.println("getTotal");
        Inventory inventory = new Inventory();
        SaleInfoHandler saleInfoHandler = new SaleInfoHandler(
                new Accounting(), inventory, new Printer()
        );
        ItemDTO item1 = inventory.getItem(4);
        Sale instance = new Sale(inventory, saleInfoHandler);
        float result1 = instance.getTotal();
        assertEquals(0.0, result1, 0.0);
        instance.addItem(item1.getId());
        float result2 = instance.getTotal();
        assertEquals(item1.getPrice(), result2, 0.1);
    }

    /**
     * Test of getTotalWithTax method, of class Sale.
     */
    @Test
    public void testGetTotalWithTax() throws Exception {
        Inventory inventory = new Inventory();
        SaleInfoHandler saleInfoHandler = new SaleInfoHandler(
                new Accounting(), inventory, new Printer()
        );
        ItemDTO item1 = inventory.getItem(1);
        ItemDTO item2 = inventory.getItem(3);
        float totalWithTax = item1.getPrice() * (1 + item1.getVat())
                + item2.getPrice() * (1 + item2.getVat());
        Sale instance = new Sale(inventory, saleInfoHandler);
        instance.addItem(item1.getId());
        instance.addItem(item2.getId());
        float result = instance.getTotalWithTax();
        assertEquals(totalWithTax, result, 0.1);
    }

    /**
     * Test of pay method, of class Sale.
     */
    @Test
    public void testPay() throws Exception {
        System.out.println("pay");
        float amount = 150;
        Inventory inventory = new Inventory();
        SaleInfoHandler saleInfoHandler = new SaleInfoHandler(
                new Accounting(), inventory, new Printer()
        );
        ItemDTO item1 = inventory.getItem(1);
        ItemDTO item2 = inventory.getItem(3);
        float totalWithTax = item1.getPrice() * (1 + item1.getVat())
                + item2.getPrice() * (1 + item2.getVat());
        Sale instance = new Sale(inventory, saleInfoHandler);
        instance.addItem(item1.getId());
        instance.addItem(item2.getId());
        float expectedChange = amount - totalWithTax;
        float result = instance.pay(amount);
        assertEquals(expectedChange, result, 0.1);
    }

}
