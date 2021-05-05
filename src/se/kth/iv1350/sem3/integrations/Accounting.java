package se.kth.iv1350.sem3.integrations;

import java.util.LinkedList;
import java.util.List;

public class Accounting {

    List<SaleInformationDTO> sales;

    /**
     * Initialized a new accounting system.
     */
    public Accounting() {
        this.sales = new LinkedList<>();
    }

    /**
     * Logs the sale in the accounting system.
     *
     * @param saleInfo
     */
    public void logSale(SaleInformationDTO saleInfo) {
        sales.add(saleInfo);
    }
}
