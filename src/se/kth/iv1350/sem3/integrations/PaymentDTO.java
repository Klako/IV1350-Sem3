package se.kth.iv1350.sem3.integrations;

/**
 * A transfer object that represents the results of a payment.
 */
public class PaymentDTO {

    private float amount;
    private float change;

    /**
     * Creates an object containing information about a payment.
     *
     * @param amount An amount payed.
     * @param change An amount of payment change.
     */
    public PaymentDTO(float amount, float change) {
        this.amount = amount;
        this.change = change;
    }

    /**
     * Gets the amount paid.
     *
     * @return The amount paid.
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Gets the amount of change.
     *
     * @return The amount of change.
     */
    public float getChange() {
        return change;
    }
}
