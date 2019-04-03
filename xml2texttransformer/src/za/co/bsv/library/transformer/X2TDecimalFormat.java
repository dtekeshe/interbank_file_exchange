/*
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.library.transformer;

import java.math.RoundingMode;

import java.text.DecimalFormat;


/**
 *
 * @author Bongani Hlope <bonganih@bankservafrica.com>
 */
public class X2TDecimalFormat {
    private DecimalFormat df;
    private boolean prefix = false;
    private boolean nonZero = false;
    private boolean useComma = false;
    private boolean replaceWithSpaces = false;

    public X2TDecimalFormat(String pattern) {
        StringBuilder buff = new StringBuilder();

        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if('c' == ch) {
                useComma = true;
            }
            else if('n' == ch) {
                nonZero = true;
            }
            else if('p' == ch) {
                prefix = true;
            }
            else if('s' == ch) {
                replaceWithSpaces = true;
            }
            else {
                buff.append(ch);
            }
        }
        pattern = buff.toString();

        df = new DecimalFormat(pattern);
        df.setRoundingMode(RoundingMode.DOWN);
    }

    public String format(double d) {
        String retval = "";

        if(nonZero && d == 0) {
            return retval;
        }
        retval = df.format(d);
        
        if(replaceWithSpaces) {
            retval = retval.replaceAll(",", " ");
        }

        if(useComma) {
            retval = retval.replaceAll("\\.", ",");
        }

        if(d >= 0 && prefix) {
            retval = "+" + retval;
        }
        return retval;
    }

    public String format(long l) {
        String retval = "";

        if(nonZero && l == 0) {
            return retval;
        }
        retval = df.format(l);
        
        if(replaceWithSpaces) {
            retval = retval.replaceAll(",", " ");
        }

        if(useComma) {
            retval = retval.replaceAll("\\.", ",");
        }

        if(l >= 0 && prefix) {
            retval = "+" + retval;
        }
        return retval;
    }
}
