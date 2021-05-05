package se.kth.iv1350.sem3.integrations;

public class PaymentDTO {

    private float amount;
    private float change;

    /**
     * Creates an object containing information about a payment.
     *
     * @param amount
     * @param change
     */
    public PaymentDTO(float amount, float change) {
        this.amount = amount;
        this.change = change;
    }

    /**
     * Gets the amount paid.
     *
     * @return
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Gets the amount of change.
     *
     * @return
     */
    public float getChange() {
        return change;
    }
}
