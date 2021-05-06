package se.kth.iv1350.sem3.integrations;

import java.util.List;

/**
 * A transfer object to compile log data for the accounting system.
 */
public class SaleInformationDTO {

    private List<PurchasedItemDTO> items;
    private PaymentDTO payment;

    /**
     * Creates a new object containing information about a finished sale.
     *
     * @param items A list of purchased items
     * @param payment A sale payment.
     */
    public SaleInformationDTO(List<PurchasedItemDTO> items, PaymentDTO payment) {
        this.items = items;
        this.payment = payment;
    }

    /**
     * Gets the list of purchased items.
     *
     * @return The list of purchased items
     */
    public List<PurchasedItemDTO> getItems() {
        return items;
    }

    /**
     * Gets the sale's payment information.
     *
     * @return The sale payment
     */
    public PaymentDTO getPayment() {
        return payment;
    }
}
