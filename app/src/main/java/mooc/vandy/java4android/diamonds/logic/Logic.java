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
        // Height of drawing is (size * 2) +1
        printBorder(size);
        //printTopOfDiamond(size);
        //printCenterLineOfDiamond(size);
        printBottomOfDiamond(size);
        printBorder(size);
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
    }

    public void printTopOfDiamond(int size) {
        mOut.print("|");
        for (int i = 0; i < size * 2; i++) {
            printCurrentLine(i, size, "/", "\\");
        }
        mOut.print("|");
    }

    public void printCenterLineOfDiamond(int size) {
        mOut.print("|");
        for (int i = 0; i < size * 2; i++) {
            if (i == 0) {
                mOut.print("<");
            } else if (i == size * 2 - 1) {
                mOut.print(">");
            } else {
                if (size % 2 == 0) {
                    mOut.print("-");
                } else {
                    mOut.print("=");
                }
            }
        }
        mOut.print("|");
    }

    public void printBottomOfDiamond(int size) {
        // Set up loop for the "height" of the diamond
        for (int i = 0; i <= size * 2 - 2; i++) {
            mOut.print("|");
            // Let's call a separate function to handle
            // actually drawing the line.
            printCurrentLine(i, size, "\\", "/");
            mOut.print("|");
        }
    }

    public void printCurrentLine(int i, int size, String start, String stop) {
        // Set a variable for the "middle" line characters
        String spacer = "";
        if (i % 2 == 0) {
            spacer = "-";
        } else {
            spacer = "=";
        }

        // Draw the leading spaces
        for (int j = size; j > i; j--) {
            mOut.print(" ");
        }

        // Draw the leading edge of the diamond
        mOut.print(start);

        // Draw the contents of the diamond
        for (int j = 0; j < i; j++) {
            mOut.print(spacer);
        }

        // Draw the trailing edge of the diamond
        mOut.print(stop);

        // Draw the trailing spaces
        for (int j= size; j <=i; j++) {
            mOut.print(" ");
        }
    }
}
