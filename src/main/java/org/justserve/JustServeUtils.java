package org.justserve;


/**
 * Utility class providing common functionalities for the JustServe application.
 * This class offers methods for printing messages to standard output and error streams.
 *
 * <p><b>Best Practices:</b></p>
 * <ul>
 *     <li>Use {@link #justServePrint(String)} for general informational messages.</li>
 *     <li>Use {@link #justServePrintErr(String, Object...)} for error messages, especially when formatting is needed.</li>
 *     <li>Avoid instantiating this class directly as it is designed to be a utility class with static methods.</li>
 * </ul>
 *
 * <p><b>Contributing:</b></p>
 * <p>When adding new utility methods, ensure they are static and well-documented with Javadoc comments.</p>
 */
class JustServeUtils {

    JustServeUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Prints a message to standard output.
     *
     * @param message The message to print.
     */
    static void justServePrint(String message) {
        System.out.println(message);
    }

    /**
     * Prints a formatted error message to standard error.
     *
     * @param message The format string for the error message.
     * @param args    The arguments referenced by the format specifiers in the message string.
     */
    static void justServePrintErr(String message, Object... args) {
        System.err.printf(message, args);
    }

}
