package se.kth.iv1350.sem3.integrations;

/**
 * Class that handles what happens to the sale information when the sale ends.
 */
public class SaleInfoHandler {
    private Accounting accounting;
    private Inventory inventory;
    private Printer printer;
    
    /**
     * Instantiates a handler for the end sale information.
     * @param accounting An accounting system integration.
     * @param inventory An inventory system integration.
     * @param printer A printer integration.
     */
    public SaleInfoHandler(
            Accounting accounting,
            Inventory inventory,
            Printer printer
    ) {
        this.accounting = accounting;
        this.inventory = inventory;
        this.printer = printer;
    }
    
    /**
     * Handles what happens to the sale information at the end of a sale.
     * @param saleInfo The information of the sale.
     */
    public void handle(SaleInformationDTO saleInfo){
        accounting.logSale(saleInfo);
        inventory.removeItems(saleInfo.getItems());
        printer.print(saleInfo);
    }
}
