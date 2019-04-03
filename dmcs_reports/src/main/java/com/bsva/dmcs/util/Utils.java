package com.bsva.dmcs.util;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author RinusE
 */
public class Utils {
    public static boolean IsNumeric(String inStr) {
        if (inStr == null) {
            return false;
        }
        if (inStr.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
            return true;
        } else {
            return false;
        }
    }    
    public static String padRight(String s, int n) { 
        return String.format("%1$-" + n + "s", s);   
    } 
 
    public static String padLeft(String s, int n) { 
        return String.format("%1$" + n + "s", s);   
    } 
    public static String padZeroLeft(String s, int n) { 
        if (s.length() > n) {
            s = s.substring(s.length() - n);
        }
        return padLeft(s,n).replace(' ', '0');
        //return String.format("%1$" + n + "s", s);   
    } 
    public static String padZeroRight(String s, int n) { 
        if (s.length() > n) {
            s = s.substring(s.length() - n);
        }
        return padRight(s,n).replace(' ', '0');
        //return String.format("%1$" + n + "s", s);   
    } 
    public static String padZeroLeft(int s,int n) {
        String str = "" + s;
        return padZeroLeft(str,n);
    }

    public static String padZeroLeft(long s,int n) {
        String str = "" + s;
        return padZeroLeft(str,n);
    }

    public static String getRightPadded(long inNo,int n) {
        String retStr = "" + inNo;
        if (retStr.length() > n) {
            retStr = retStr.substring(retStr.length() - n);
            return retStr;
        } else {
            return padZeroLeft(retStr,n);
        }
    }
    
    public static String formatAmount(long inAmount, int resultLen) {
        return formatAmount((double)inAmount/100,resultLen);
    }
    
    public static String formatAmount(double inAmount, int resultLen) {
        String longFormat = "###,###,###,###,###,###,###.##";
        boolean ltZero = false;
        if (inAmount < 0) {
            ltZero = true;
            inAmount = inAmount * -1;
        } 
        String retFormat = longFormat.substring(34 - (34 - resultLen));
        DecimalFormat utilFormatter = new DecimalFormat(retFormat);
        String result = utilFormatter.format(inAmount).replace(',', ' ');
        if (ltZero) {
            result += "-";
        } else {
            result += " ";
        }
        return result;
    }
    
    public static String formatInteger(int inNumber,int resultLen) {
        return formatInteger((long)inNumber,resultLen);
    }
    
    public static String formatInteger(long inNumber,int resultLen) {
        String longFormat = "###,###,###,###,###,###,###.##";
        String retFormat = longFormat.substring(31 - (31 - resultLen));
        boolean ltZero = false;
        if (inNumber < 0) {
            ltZero = true;
            inNumber = inNumber * -1;
        } 

        DecimalFormat utilFormatter = new DecimalFormat(retFormat);
        String result = utilFormatter.format(inNumber).replace(',', ' ');
        if (ltZero) {
            result += "-";
        } else {
            result += " ";
        }
        return result;
    }
    public static String getJulianDate(String inDateCCYYMMDD) {
            if (inDateCCYYMMDD.length() == 8) {
                GregorianCalendar gc = new GregorianCalendar();
                /*gc.set(GregorianCalendar.DAY_OF_MONTH, Integer.parseInt(inProcDate.substring(6,8)));
                gc.set(GregorianCalendar.MONTH, Integer.parseInt(inProcDate.substring(4,6)));
                gc.set(GregorianCalendar.YEAR, Integer.parseInt(inProcDate.substring(0,4)));*/

                /*This stupid calendar's month is zero offset,
                 * (i.e. January = 0)
                 *so we need to subtract 1 from the actual month!
                 * To veryfy, see Gregorian Calendar's static value for
                 * the month names.
                 */
                gc.set(Integer.parseInt(inDateCCYYMMDD.substring(0,4)),
                        Integer.parseInt(inDateCCYYMMDD.substring(4,6)) - 1,
                        Integer.parseInt(inDateCCYYMMDD.substring(6,8)));

                int doy = gc.get(GregorianCalendar.DAY_OF_YEAR);
                return inDateCCYYMMDD.substring(2,4) + String.format("%03d",doy);
            } else {
                return "00000";
            }
    }
    public static byte[] convertToEBCDIC(String inputStr) {
        byte[] outputStr = new byte[inputStr.length()];
        //for (int xx=0;xx<inputStr.length();xx++) {
           // outputStr = AsciiEbcdic.convAsciiBAtoEBCDIC(inputStr);
        //}
        return outputStr;
    }
    
    public static int getIntFromHexBytes(byte[] inputByteArr) {
        String hexStr = "";
        for (int xx=0;xx< inputByteArr.length;xx++) {
            hexStr += Integer.toHexString(inputByteArr[xx]);
        }
        return Integer.parseInt(hexStr,16);
    }
    public static int getIntFromHexBytes(int[] inputIntArr) {
        String hexStr = "";
        for (int xx=0;xx< inputIntArr.length;xx++) {
            hexStr += Integer.toHexString(inputIntArr[xx]);
        }
        return Integer.parseInt(hexStr,16);
    }
    public static byte[] extendByteArray(byte[] inByteArr,int extendByLength) {
        byte[] newByteArr = new byte[inByteArr.length + extendByLength];
        System.arraycopy(inByteArr, 0, newByteArr, 0, inByteArr.length);
        return newByteArr;
    }
}
