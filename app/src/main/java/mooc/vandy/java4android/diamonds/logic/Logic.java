package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here

        // Define some variables for the "edges" of our triangle.
        String start = "/";
        String stop = "\\";

        // Stick the end of our range in a variable
        int max = size * 2 + 1;

        for (int i = 0; i < max; i++) {
            if (i == 0 || i == max - 1) {
                printBorder(size);
            } else {
                // Swap start and stop characters when
                // we get to the bottom of the diamond.
                if (i == size) {
                    start = "<";
                    stop = ">";
                } else if (i > size) {
                    start = "\\";
                    stop = "/";
                }

                // Let's call a separate function to handle
                // actually drawing the line.
                printCurrentLine(i, size, start, stop);
            }
        }
    }

    public void printCurrentLine(int i, int size, String start, String stop) {
        // Set a variable for the "middle" line characters
        String spacer = "==";
        if (i % 2 == 0) {
            spacer = "--";
        }

        // Draw the left border
        mOut.print("|");

        // Draw the leading spaces
        if (i <= size) {
            for (int j = size; j > i; j--) {
                mOut.print(" ");
            }
        } else {
            for (int j = 0; j < i - size; j++) {
                mOut.print(" ");
            }
        }

        // Draw the leading edge of the diamond
        mOut.print(start);

        // Draw the contents of the line
        if (i <= size) {
            for (int j = 1; j < i; j++) {
                mOut.print(spacer);
            }
        } else {
            for (int j = size * 2 - 1; j > i; j--) {
                mOut.print(spacer);
            }
        }

        // Draw the trailing edge of the diamond
        mOut.print(stop);

        // Draw the trailing spaces
        if (i <= size) {
            for (int j = size; j > i; j--) {
                mOut.print(" ");
            }
        } else {
            for (int j = 0; j < i - size; j++) {
                mOut.print(" ");
            }
        }

        // Draw the right border
        mOut.println("|");
    }

    // Print the string representing the top
    // and bottom borders of the ASCII art item.
    public void printBorder(int size) {
        for (int i = 0; i < size * 2  + 2; i++) {
            if (i == 0 || i == size * 2 + 1) {
                mOut.print("+");
            }
            else {
                mOut.print("-");
            }
        }
        mOut.print("\n");
    }
}
