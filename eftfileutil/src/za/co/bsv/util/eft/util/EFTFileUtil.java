/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.util;

/**
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class EFTFileUtil {
    public final static int LEFT_JUSTIFY  = 0;
    public final static int RIGHT_JUSTIFY = 1;

    /**
     * Takes a number and returns a zero filled string of the number by appending
     * zeroes infront of the given number to ensure that the length of the string
     * is equals the number of the given digits .
     *
     * @param value the number to appends zeroes infront of.
     * @param digits the number of digits that the returned string lenght must equal
     * @return a zero feeled string with length equal <code>digits</code>
     */
    public static String numberToString(long value, int digits) {
        long total = (long)Math.pow(10, digits - 1);

        StringBuilder buff = new StringBuilder();
        while(((total != 0) && (value / total) == 0)) {
            buff.append("0");
            total = total / 10;
        }
        if(value != 0) { //For value == 0, the while loop will add the last zero
            buff.append(value);
        }
        return ensureLength(buff.toString(),'0', digits, RIGHT_JUSTIFY);
    }
    /**
     * Fills the sting with spaces at the end, returns a string with length
     * equal the given required length.
     *
     * @param value the string to fill with a character
     * @param ch the character to fill the string with
     * @param requiredLength the required length of the output string
     * @param justify where to fill the string
     * @return a string with length <code>requiredLength</code>
     */
    public static String ensureLength(String value, char ch, int requiredLength, int justify) {
        if(value == null) {
            value = "";
        }
        int length = value.length();
        StringBuilder buff = null;
        if (length < requiredLength) {
            buff = new StringBuilder();

            if(justify == LEFT_JUSTIFY) {
                buff.append(value);
            }
            int diff = requiredLength - length;

            for (int i = 0; i < diff; i++) {
                buff.append(ch);
            }

            if(justify == RIGHT_JUSTIFY) {
                buff.append(value);
            }
        }
        else {
            buff = new StringBuilder(value.substring(0, requiredLength));
        }
        return buff.toString();
    }
}
