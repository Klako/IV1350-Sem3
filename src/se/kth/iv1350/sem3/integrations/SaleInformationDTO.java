package se.kth.iv1350.sem3.integrations;

import java.util.List;

public class SaleInformationDTO {

    private List<PurchasedItemDTO> items;
    private PaymentDTO payment;

    /**
     * Creates a new object containing information about a finished sale.
     *
     * @param items
     * @param payment
     */
    public SaleInformationDTO(List<PurchasedItemDTO> items, PaymentDTO payment) {
        this.items = items;
        this.payment = payment;
    }

    /**
     * Gets the list of purchased items.
     *
     * @return
     */
    public List<PurchasedItemDTO> getItems() {
        return items;
    }

    /**
     * Gets the sale's payment information.
     *
     * @return
     */
    public PaymentDTO getPayment() {
        return payment;
    }
}
