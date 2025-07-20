package org.justserve;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;


/**
 * A utility class for printing to the console using the JustServe color scheme.
 * <a href="https://justserve.zendesk.com/hc/en-us/articles/30949071567387-Style-Guides">See style guide</a>
 */
public final class JustServePrinter {

    private final static Ansi blue = ansi().fgRgb(0, 101, 189);
    private final static Ansi orange = ansi().fgRgb(244, 121, 32);
    private final static Ansi red = ansi().fgRgb(217, 83, 79);

    private final static Ansi normalStyle = blue;
    private final static Ansi emphasisStyle = orange;
    private final static Ansi errorStyle = red.bold();



    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private JustServePrinter() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    private static void print(String message, String... style) {
        System.out.print(Ansi.ansi().render(String.format("@|%s %s|@", String.join(",", style), message)));
    }

    /**
     * Prints a standard message using the primary brand color (JustServe Blue).
     *
     * @param message The message to print.
     */
    public static void printNormal(String message) {
        ansi().fgRgb()
    }

    /**
     * Prints a standard message using the primary brand color (JustServe Blue).
     *
     * @param message The message to print.
     */
    public static void printEmphasis(String message) {
        print(message, emphasisStyle);
    }

    /**
     * Prints an error message to the standard error stream in red.
     *
     * @param message The error message to print.
     */
    public static void printError(String message) {
        print(message, errorStyle);
    }

    /**
     * Prints an error message to the standard error stream in red.
     *
     * @param message The error message to print.
     */
    public static void printError(String message, Object... args) {
        print(String.format(message, args), errorStyle);
    }
}