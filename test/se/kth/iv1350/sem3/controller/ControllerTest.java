package se.kth.iv1350.sem3.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.sem3.integrations.Accounting;
import se.kth.iv1350.sem3.integrations.InvalidItemIdException;
import se.kth.iv1350.sem3.integrations.Inventory;
import se.kth.iv1350.sem3.integrations.InventoryServerException;
import se.kth.iv1350.sem3.integrations.ItemDTO;
import se.kth.iv1350.sem3.integrations.Printer;
import se.kth.iv1350.sem3.integrations.SaleInfoHandler;
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
    public void testRegisterItem() throws Exception {
        System.out.println("registerItem");
        Inventory inventory = new Inventory();
        SaleInfoHandler saleInfoHandler = new SaleInfoHandler(
                new Accounting(), inventory, new Printer()
        );
        Controller instance = new Controller(inventory, saleInfoHandler);
        ItemDTO item1 = inventory.getItem(2);
        instance.startNewSale();
        ItemRegistrationDTO result1 = instance.registerItem(item1.getId());
        assertEquals(item1.getDescription(), result1.getItemInfo().getDescription());
        assertEquals(item1.getPrice(), result1.getItemInfo().getPrice(), 0.0);
        assertEquals(item1.getPrice(), result1.getRunningTotal(), 0.0);

        ItemDTO item2 = inventory.getItem(1);
        float totalPrice1 = item1.getPrice() + item2.getPrice();
        ItemRegistrationDTO result2 = instance.registerItem(item2.getId());
        assertEquals(totalPrice1, result2.getRunningTotal(), 0.1);

        float totalPrice2 = totalPrice1 + item1.getPrice();
        ItemRegistrationDTO result3 = instance.registerItem(item1.getId());
        assertEquals(totalPrice2, result3.getRunningTotal(), 0.1);
        
        int invalidItemid = 0;
        try{
            instance.registerItem(invalidItemid);
            fail("Didn't throw exception on bad item id");
        } catch (InvalidItemIdException ex) {
            assertEquals(invalidItemid, ex.getItemId());
        } catch (Exception ex){
            fail("Wrong exception");
        }
        
        assertEquals(totalPrice2, result3.getRunningTotal(), 0.1);
        
        ItemDTO item3 = inventory.getItem(3);
        
        inventory.setServerActive(false);
        
        try{
            instance.registerItem(item3.getId());
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

    /**
     * Test of calculateTotal method, of class Controller.
     */
    @Test
    public void testCalculateTotal() throws Exception {
        System.out.println("calculateTotal");
        Inventory inventory = new Inventory();
        SaleInfoHandler saleInfoHandler = new SaleInfoHandler(
                new Accounting(), inventory, new Printer()
        );
        ItemDTO item1 = inventory.getItem(1);
        ItemDTO item2 = inventory.getItem(3);
        float totalWithTax = item1.getPrice() * (1 + item1.getVat())
                + item2.getPrice() * (1 + item2.getVat());
        Controller instance = new Controller(inventory, saleInfoHandler);
        instance.startNewSale();
        instance.registerItem(item1.getId());
        instance.registerItem(item2.getId());
        float result = instance.calculateTotal();
        assertEquals(totalWithTax, result, 0.1);
    }

    /**
     * Test of pay method, of class Controller.
     */
    @Test
    public void testPay() throws Exception {
        System.out.println("pay");
        Inventory inventory = new Inventory();
        SaleInfoHandler saleInfoHandler = new SaleInfoHandler(
                new Accounting(), inventory, new Printer()
        );
        ItemDTO item1 = inventory.getItem(5);
        ItemDTO item2 = inventory.getItem(3);
        float totalWithTax = item1.getPrice() * (1 + item1.getVat())
                + item2.getPrice() * (1 + item2.getVat());
        Controller instance = new Controller(inventory, saleInfoHandler);
        instance.startNewSale();
        instance.registerItem(item1.getId());
        instance.registerItem(item2.getId());
        float amount = 150;
        float expectedChange = amount - totalWithTax;
        float result = instance.pay(amount);
        assertEquals(expectedChange, result, 0.1);
    }
}
