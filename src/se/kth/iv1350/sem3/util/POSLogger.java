package se.kth.iv1350.sem3.util;

import java.io.IOException;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Logger for the point of sale program.
 */
public class POSLogger {

    private final static String LOG_FILE_NAME = "pos.log";
    private final static String LOGGER_NAME = "PointOfSale";
    private static Logger logger;

    /**
     * Logs a message to a file, and to the console if the level is severe.
     *
     * @param level The level to log the message at.
     * @param message The message to log.
     */
    public static void log(Level level, String message) {
        logger.log(level, message);
    }

    /**
     * Logs an exception to a file, and to the console if the level is severe.
     *
     * @param level The level to log the message at.
     * @param exception The exception to log.
     */
    public static void log(Level level, Exception exception) {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append(exception.getMessage() + "\n");
        for (StackTraceElement elem : exception.getStackTrace()) {
            msgBuilder.append("\t" + formatStackTraceElem(elem) + "\n");
        }
        logger.log(level, msgBuilder.toString());
    }

    private static String formatStackTraceElem(StackTraceElement elem) {
        return elem.getClassName() + "::" + elem.getMethodName()
                + " [" + elem.getLineNumber() + "]";
    }

    public static void setup() throws IOException {
        logger = Logger.getLogger(LOGGER_NAME);
        logger.setUseParentHandlers(false);
        FileHandler fileLog = new FileHandler(LOG_FILE_NAME);
        fileLog.setFormatter(new FileFormatter());
        logger.addHandler(fileLog);
        ConsoleHandler consoleLog = new ConsoleHandler();
        consoleLog.setLevel(Level.SEVERE);
        logger.addHandler(consoleLog);
    }

    private static class FileFormatter extends SimpleFormatter {

        private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

        @Override
        public String format(LogRecord record) {
            return String.format(format,
                    new Date(record.getMillis()),
                    record.getLevel().getName(),
                    record.getMessage()
            );
        }
    }
}
