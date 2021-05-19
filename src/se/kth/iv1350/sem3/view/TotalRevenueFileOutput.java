package se.kth.iv1350.sem3.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.sem3.controller.TotalRevenueObserver;

/**
 * Observer that gets updated to write the total revenue to a file.
 */
public class TotalRevenueFileOutput implements TotalRevenueObserver {

    private static final String OUTPUT_FILE = "revenue.log";

    private PrintWriter writer;
    private float totalRevenue;

    /**
     * Creates a new revenue file logger.
     * @throws IOException if it can't open the file.
     */
    public TotalRevenueFileOutput() throws IOException {
        writer = new PrintWriter(new FileWriter(OUTPUT_FILE), true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(float total) {
        totalRevenue += total;
        writer.println("The new total revenue is: " + totalRevenue);
    }

}
