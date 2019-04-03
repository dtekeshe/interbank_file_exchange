package com.bsva.dmcs.reportv02.settlement;

import com.bsva.dmcs.reportv02.dto.TxnGroupTotalsDTO;
import com.bsva.dmcs.reportv02.util.Justification;
import static com.bsva.dmcs.reportv02.util.StringUtils.format;

import com.bsva.dto.AcquirerCode;
import com.bsva.dto.StatementDTO;
import com.bsva.dto.TxnGroupTotalDTO;
import com.bsva.entities.v02.settlement.CCR00XDataEntity;
import com.bsva.entities.v02.settlement.CCR00XFinalTotalsDataEntity;
import com.bsva.entities.v02.settlement.CCR00XSummaryDataEntity;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CCR001DetailWriter {

    private final static String LINE_SEPARATOR = System.getProperty("line.separator");

    protected final static DecimalFormat DECIMAL_FORMAT
            = new DecimalFormat("###,###,###,##0.00");
    private static double trxnGrandTotal = 0.00;
    private static double trxnGrandVat = 0.00;
    private static double trxnGrandCharge = 0.00;
    private static double trxnGrandInterChange = 0.00;
    
    private static double trxnGrandTotalSarb = 0.00;
    private static double trxnGrandVatSarb = 0.00;
    private static double trxnGrandChargeSarb = 0.00;
    private static double trxnGrandInterChangeSarb = 0.00;
    
    private static double trxnFinalTotalNett = 0.00;
    private static double trxnFinalVat = 0.00;
    private static double trxnFinalCharge = 0.00;
    private static double trxnFinalInterchange = 0.00;
    
    private static double trxnFinalTotalNettSarb = 0.00;
    private static double trxnFinalVatSarb = 0.00;
    private static double trxnFinalChargeSarb = 0.00;
    private static double trxnFinalInterchangeSarb = 0.00;

    

    public static void writeColumnHeader(PrintWriter out) {

        String s =
                format( "", 15, ' ', Justification.LEFT) +
                format( "COUNT", 10, ' ', Justification.RIGHT) +
                format( "AMOUNT", 16, ' ', Justification.RIGHT) +
                format( "INTERCHANGE", 16, ' ', Justification.RIGHT) +
                format( "VAT", 16, ' ', Justification.RIGHT) +
                format( "TOTAL", 16, ' ', Justification.RIGHT) +
                format( "NETT", 16, ' ', Justification.RIGHT);

        out.println( s );

        s =
                format( "", 73, ' ', Justification.RIGHT) +
                format( "CHARGES", 16, ' ', Justification.RIGHT) +
                format( "AMOUNT", 16, ' ', Justification.RIGHT);

        out.println( s + LINE_SEPARATOR );
    }
    //writing transactions for Billateral Billing
    public static void writeTxnDetails(PrintWriter out, List<CCR00XDataEntity> data) {

        for (CCR00XDataEntity txn : data) {

        	double billFee = abs(txn.getBillingFee());
        	double billFeeAmount = abs(txn.getBillingFeeAmount());
        	double billVat = abs(txn.getBillingVAT());
        	double billAmount = 0.00;
        	double totalCharges = 0.00;
        	  if("FLEET CARD".equals(txn.getId().getSubService())){
        		  billAmount = abs(billFee);
        		   totalCharges = ((billFee) + billVat);
        	  }else{
        		  billAmount = abs(billFee + billFeeAmount);
        		   totalCharges = ((billFeeAmount + billFee) + billVat);
        	  }
        	
            double nett = ((txn.getTranValue() / 100.0) + totalCharges);
            String s =
                    format( txn.getTxnDescription(), 15, ' ', Justification.LEFT) +
                    //txn Count
                    format( (CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? "" : "" + txn.getVolume()), 10, ' ', Justification.RIGHT) +
                    //txn Amount
                    format( DECIMAL_FORMAT.format(abs(txn.getTranValue() / 100.0)), 16, ' ', Justification.RIGHT) +
                            sign(txn.getTranValue()) +
                    //txn Interchange
                    format( DECIMAL_FORMAT.format(abs(billAmount)),16, ' ', Justification.RIGHT) +
                            //sign(txn.getBillingFee()+ txn.getBillingFeeAmount()) +
                    //txn Vat
                    format( DECIMAL_FORMAT.format(abs(billVat)), 16, ' ', Justification.RIGHT) +
                            //sign(txn.getBillingVAT()) +
                    //txn Total Charge
                    format( DECIMAL_FORMAT.format(abs(totalCharges )),16, ' ', Justification.RIGHT) +
                           // sign(totalCharges) +
                    //txn net amount
                    format(DECIMAL_FORMAT.format(abs(nett)), 16, ' ', Justification.RIGHT) +
                    		sign(nett);

            out.println( s );
        }
    }
    //writing transactions for Sarb Billing
    public static void writeTxnSARBVMDetails(PrintWriter out, List<CCR00XDataEntity> data) {

        for (CCR00XDataEntity txn : data) {

        	double billFee = txn.getBillingFee();
        	double billFeeAmount = txn.getBillingFeeAmount();
        	double billAmount = (billFee + billFeeAmount);
        	double billVat = txn.getBillingVAT();
        	double billValue = (txn.getTranValue() / 100.0);
            double totalCharges = ((billFeeAmount + billFee) + billVat);
            double nett = ((txn.getTranValue() / 100.0) + totalCharges);
            String s =
                    format( txn.getTxnDescription(), 15, ' ', Justification.LEFT) +
                    //txn Count
                    format( (CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? "" : "" + txn.getVolume()), 10, ' ', Justification.RIGHT) +
                    //txn Amount
                    format( DECIMAL_FORMAT.format(abs(billValue)), 16, ' ', Justification.RIGHT) +
                            sign(billValue) +
                    //txn Interchange
                    format( DECIMAL_FORMAT.format(abs(billAmount)),16, ' ', Justification.RIGHT) +
                            sign(billAmount) +
                    //txn Vat
                    format( DECIMAL_FORMAT.format(abs(billVat)), 16, ' ', Justification.RIGHT) +
                            sign(billVat) +
                    //txn Total Charge
                    format( DECIMAL_FORMAT.format(abs(totalCharges )),16, ' ', Justification.RIGHT) +
                            sign(totalCharges) +
                    //txn net amount
                    format(DECIMAL_FORMAT.format(abs(nett)), 16, ' ', Justification.RIGHT) +
                    		sign(nett);

            out.println( s );
        }
    }

    private static String sign(Double value) {
        return value < 0.0 ? "-" : " ";
    }

    private static Double abs(Double value) {
        return Math.abs(value);
    }
    //writing summary for Bilateral Billing
    public static void writeSummaryTxnDetails(PrintWriter out, List<CCR00XSummaryDataEntity> data) {

        for (CCR00XSummaryDataEntity txn : data) {

        	double billFee = txn.getBillingFee();
        	double billFeeAmount = txn.getBillingFeeAmount();
        	double billVat = txn.getBillingVAT();
            double totalCharges = 0.00;
        	double billAmount = 0.00;
	        	if("FLEET CARD".equals(txn.getId().getSubService())){
	      		  billAmount = abs(billFee);
	      		  totalCharges = (abs(billFee) + abs(billVat));
	        	}else{
	      		  billAmount = abs(billFee + billFeeAmount);
	      		 totalCharges = ((abs(billFeeAmount) + abs(billFee)) + abs(billVat));
	      	  }
            double nett = ((txn.getTranValue() / 100.0) + totalCharges);

            String s =
                    format( txn.getTxnDescription(), 15, ' ', Justification.LEFT) +
                            format(CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0:txn.getVolume(), 10, ' ', Justification.RIGHT) +
                            
                            format( DECIMAL_FORMAT.format(abs(txn.getTranValue() / 100.0)),16, ' ', Justification.RIGHT) +
                                    sign(txn.getTranValue()) +
                                  //txn Interchange
                            format( DECIMAL_FORMAT.format(abs(billAmount)), 16, ' ', Justification.RIGHT) +
                                    //sign(txn.getBillingFee() + txn.getBillingFeeAmount()) +
                            format( DECIMAL_FORMAT.format(abs(txn.getBillingVAT())), 16, ' ', Justification.RIGHT) +
                                   // sign(txn.getBillingVAT()) +
                            format( DECIMAL_FORMAT.format(totalCharges),        16, ' ', Justification.RIGHT) +
                                   // sign(totalCharges) +
                            format( DECIMAL_FORMAT.format(abs(nett )),              16, ' ', Justification.RIGHT) +
                                    sign(nett);
            out.println( s );
        }
    }
    //writing summary for Sarb Billing
    public static void writeSummarySarbVMTxnDetails(PrintWriter out, List<CCR00XSummaryDataEntity> data) {

        for (CCR00XSummaryDataEntity txn : data) {

        	double billFee = txn.getBillingFee();
        	double billFeeAmount = txn.getBillingFeeAmount();
        	double billVat = txn.getBillingVAT();
        	double billAmount = (billFee + billFeeAmount);
        	double billvalue = (txn.getTranValue() / 100.0);
            double totalCharges = (((billFeeAmount + billFee)) + billVat);
            double nett = ((txn.getTranValue() / 100.0) + totalCharges);

            String s =
                    format( txn.getTxnDescription(), 15, ' ', Justification.LEFT) +
                            format(CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0:txn.getVolume(), 10, ' ', Justification.RIGHT) +
                            
                            format( DECIMAL_FORMAT.format(abs(billvalue)),16, ' ', Justification.RIGHT) +
                                    sign(billvalue) +
                                  //txn Interchange
                            format( DECIMAL_FORMAT.format(abs(billAmount)), 16, ' ', Justification.RIGHT) +
                                    sign(billAmount) +
                            format( DECIMAL_FORMAT.format(abs(billVat)), 16, ' ', Justification.RIGHT) +
                                    sign(billVat) +
                            format( DECIMAL_FORMAT.format(abs(totalCharges)),        16, ' ', Justification.RIGHT) +
                                    sign(totalCharges) +
                            format( DECIMAL_FORMAT.format(abs(nett )),              16, ' ', Justification.RIGHT) +
                                    sign(nett);
            out.println( s );
        }
    }
    //Bilateral Final Totals
    public static void writeFinalTotalsTxnDetails(PrintWriter out, List<CCR00XFinalTotalsDataEntity> data) {

        for (CCR00XFinalTotalsDataEntity txn : data) {

        	double billFee = abs(txn.getBillingFee());
        	double billFeeAmount = abs(txn.getBillingFeeAmount());
        	double billAmount = abs(billFee + billFeeAmount);
        	double billVat = abs(txn.getBillingVAT());
            double totalCharges = 0.00;
        	if("FLEET CARD".equals(txn.getId().getSubService())){
      		  		billAmount = abs(billFee);
      		  		totalCharges = ( billFee + billVat);
      	  		}else{
      	  			billAmount = abs(billFee + billFeeAmount);
      	  			totalCharges = ((billFeeAmount + billFee) + billVat);
      	  		}
        	
            double nett = ((txn.getTranValue() / 100.0) + totalCharges);

            String s =
                    format( txn.getTxnDescription(), 15, ' ', Justification.LEFT) +
                            format(CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0:txn.getVolume(), 10, ' ', Justification.RIGHT) +
                            format( DECIMAL_FORMAT.format(abs(txn.getTranValue() / 100.0)), 16, ' ', Justification.RIGHT) +
                                    sign(txn.getTranValue()) +
                                  //txn Interchange
                            format( DECIMAL_FORMAT.format(billAmount), 16, ' ', Justification.RIGHT) +
                                    //sign(txn.getBillingFee()+ txn.getBillingFeeAmount()) +
                            format( DECIMAL_FORMAT.format(billVat), 16, ' ', Justification.RIGHT) +
                                    //sign(txn.getBillingVAT()) +
                            format( DECIMAL_FORMAT.format(totalCharges),        16, ' ', Justification.RIGHT) +
                                    //sign(totalCharges) +
                            format( DECIMAL_FORMAT.format(abs(nett)),              16, ' ', Justification.RIGHT)  +
                                    sign(nett);
            out.println( s );
        }
    }
    //sarb Final Totals
    public static void writeFinalTotalsTxnSARBVMDetails(PrintWriter out, List<CCR00XFinalTotalsDataEntity> data) {

        for (CCR00XFinalTotalsDataEntity txn : data) {

        	double billFee = txn.getBillingFee();
        	double billFeeAmount = txn.getBillingFeeAmount();
        	double billVat = txn.getBillingVAT();
        	double billAmount = (billFee + billFeeAmount);
        	double billvalue = (txn.getTranValue() / 100.0);
            double totalCharges = ((billFeeAmount + billFee) + billVat);
            double nett = ((txn.getTranValue() / 100.0) + totalCharges);

            String s =
                    format( txn.getTxnDescription(), 15, ' ', Justification.LEFT) +
                            format(CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0:txn.getVolume(), 10, ' ', Justification.RIGHT) +
                            format( DECIMAL_FORMAT.format(abs(billvalue)), 16, ' ', Justification.RIGHT) +
                                    sign(txn.getTranValue()) +
                                  //txn Interchange
                            format( DECIMAL_FORMAT.format(abs(billAmount)), 16, ' ', Justification.RIGHT) +
                                    sign(billAmount) +
                            format( DECIMAL_FORMAT.format(abs(billVat)), 16, ' ', Justification.RIGHT) +
                                    sign(txn.getBillingVAT()) +
                            format( DECIMAL_FORMAT.format(abs(totalCharges)),        16, ' ', Justification.RIGHT) +
                                    sign(totalCharges) +
                            format( DECIMAL_FORMAT.format(nett),              16, ' ', Justification.RIGHT)  +
                                    sign(nett);
            out.println( s );
        }
    }

    public static void writeTxnGroupUnderline(PrintWriter out) {

        String s =
                format( "", 15, ' ', Justification.LEFT) +
                format( "---------", 10, ' ', Justification.RIGHT) +
                format( "---------------", 16, ' ', Justification.RIGHT) +
                format( "---------------", 16, ' ', Justification.RIGHT) +
                format( "---------------", 16, ' ', Justification.RIGHT) +
                format( "---------------", 16, ' ', Justification.RIGHT) +
                format( "---------------", 16, ' ', Justification.RIGHT);

        out.println( s );
    }
    //SubTotals for Bilateral Billing 
    public static void writeTxnSubTotals(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = abs(total.getBillingFee());
    	double billFeeAmount = abs(total.getBillingFeeAmount());
    	double billVat = abs(total.getBillingVAT());
        double totalCharges = ((billFee + billFeeAmount)+ billVat);
        double netTotals = (total.getTranValue() / 100.0);
        double billAmount = (billFee + billFeeAmount);
        double nett = (netTotals  + totalCharges);
        
        trxnGrandInterChange = trxnGrandInterChange + billAmount;
        trxnGrandVat = trxnGrandVat + billVat;
        trxnGrandCharge = trxnGrandCharge + totalCharges;
        trxnGrandTotal = trxnGrandTotal + nett;
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(netTotals)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                      //txn Interchange
                format( DECIMAL_FORMAT.format(billAmount), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(billVat), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(totalCharges)),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(nett)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
    }
    //SubTotals for Bilateral Billing for Fleet Card 
    public static void writeTxnSubTotalsFleetCard(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = abs(total.getBillingFee());
    	double billFeeAmount = abs(total.getBillingFeeAmount());
    	double billVat = abs(total.getBillingVAT());
        double totalCharges = (billFee + billVat);
        double netTotals = (total.getTranValue() / 100.0);
        double billAmount = (billFee);
        double nett = (netTotals  + totalCharges);
        
        trxnGrandInterChange = trxnGrandInterChange + billAmount;
        trxnGrandVat = trxnGrandVat + billVat;
        trxnGrandCharge = trxnGrandCharge + totalCharges;
        trxnGrandTotal = trxnGrandTotal + nett;
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(netTotals)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                      //txn Interchange
                format( DECIMAL_FORMAT.format(billAmount), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(billVat), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(totalCharges)),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(nett)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
    }
    //SubTotals for Bilateral Billing Only for FLEET CARD SUBSERVICES 
    public static void writeTxnSubTotalsFleet(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = abs(total.getBillingFee());
    	double billFeeAmount = abs(total.getBillingFeeAmount());
    	double billVat = abs(total.getBillingVAT());
        double totalCharges = (billFee +  billVat);
        double netTotals = (total.getTranValue() / 100.0);
        double billAmount = (billFee);
        double nett = (netTotals  + totalCharges);
        
        trxnGrandInterChange = trxnGrandInterChange + billAmount;
        trxnGrandVat = trxnGrandVat + billVat;
        trxnGrandCharge = trxnGrandCharge + totalCharges;
        trxnGrandTotal = trxnGrandTotal + nett;
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(netTotals)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                      //txn Interchange
                format( DECIMAL_FORMAT.format(billAmount), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(billVat), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(totalCharges)),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(nett)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
    }
    //subTotals for SARB Billing
    public static void writeTxnSARBVMSubTotals(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = total.getBillingFee();
    	double billFeeAmount = total.getBillingFeeAmount();
    	double billVat = total.getBillingVAT();
    	double billAmount = (billFee + billFeeAmount);
    	double billvalue = (total.getTranValue() / 100.0);
        double totalCharges = ((billFee + billFeeAmount)+ billVat);
        double netTotals = (total.getTranValue() / 100.0);
        
        double nett = (netTotals  + totalCharges);
        
        trxnGrandInterChangeSarb = trxnGrandInterChangeSarb + billAmount;
        trxnGrandVatSarb = trxnGrandVatSarb + billVat;
        trxnGrandChargeSarb = trxnGrandChargeSarb + totalCharges;
        trxnGrandTotalSarb = trxnGrandTotalSarb + nett;
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(billvalue)), 16, ' ', Justification.RIGHT) +
                        sign(billvalue) +
                format( DECIMAL_FORMAT.format(abs(billAmount)), 16, ' ', Justification.RIGHT) +
                        sign(billAmount) +
                format( DECIMAL_FORMAT.format(abs(billVat)), 16, ' ', Justification.RIGHT) +
                        sign(billVat) +
                format( DECIMAL_FORMAT.format(abs(totalCharges)),          16, ' ', Justification.RIGHT) +
                        sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(nett)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
    }
    
  //Bilateral Billing grandTotals
    public static void writeTxnGrandTotalsFleet(PrintWriter out, String narrative, TxnGroupTotalDTO total) {

    	double billFee = abs(total.getBillingFee());
    	double billFeeAmount = abs(total.getBillingFeeAmount());
    	double billVat = abs(total.getBillingVAT());
    	double billAmount = (billFee + billFeeAmount);
        double totalCharges = ((total.getBillingFee() + total.getBillingFeeAmount())+ total.getBillingVAT());
        double netTotals = (total.getTranValue() / 100.0);
       // double totalCharges = (total.getBillingFeeAmount() + (abs(total.getBillingFee()) + abs(total.getBillingVAT())));
       
        double nett = (netTotals  + totalCharges);

        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(netTotals)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandInterChange)), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandVat)), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandCharge)),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandTotal)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
        
        trxnGrandTotal = 0.00;
        trxnGrandCharge = 0.00;
        trxnGrandVat = 0.00;
        trxnGrandInterChange = 0.00;
    }
    //Bilateral Billing grandTotals
    public static void writeTxnGrandTotals(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = abs(total.getBillingFee());
    	double billFeeAmount = abs(total.getBillingFeeAmount());
    	double billVat = abs(total.getBillingVAT());
    	double billAmount = (billFee + billFeeAmount);
        double totalCharges = ((total.getBillingFee() + total.getBillingFeeAmount())+ total.getBillingVAT());
        double netTotals = (total.getTranValue() / 100.0);
       // double totalCharges = (total.getBillingFeeAmount() + (abs(total.getBillingFee()) + abs(total.getBillingVAT())));
       
        double nett = (netTotals  + totalCharges);

        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(netTotals)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandInterChange)), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandVat)), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandCharge)),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandTotal)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
        
        trxnGrandTotal = 0.00;
        trxnGrandCharge = 0.00;
        trxnGrandVat = 0.00;
        trxnGrandInterChange = 0.00;
    }
    
    //Bilateral Billing grandTotals for Fleet Card
    public static void writeTxnGrandTotalsFleetCard(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = abs(total.getBillingFee());
    	double billFeeAmount = abs(total.getBillingFeeAmount());
    	double billVat = abs(total.getBillingVAT());
    	double billAmount = (billFee );
        double totalCharges = (total.getBillingFee() + total.getBillingVAT());
        double netTotals = (total.getTranValue() / 100.0);
       // double totalCharges = (total.getBillingFeeAmount() + (abs(total.getBillingFee()) + abs(total.getBillingVAT())));
       
        double nett = (netTotals  + totalCharges);

        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(netTotals)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandInterChange)), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandVat)), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandCharge)),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandTotal)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
        
        trxnGrandTotal = 0.00;
        trxnGrandCharge = 0.00;
        trxnGrandVat = 0.00;
        trxnGrandInterChange = 0.00;
    }
    //Sarb Billing grandTotals
    public static void writeTxnGrandSARBVMTotals(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = total.getBillingFee();
    	double billFeeAmount = total.getBillingFeeAmount();
    	double billVat = total.getBillingVAT();
    	double billAmount = (billFee + billFeeAmount);
    	double billvalue = (total.getTranValue() / 100.0);
        double totalCharges = ((total.getBillingFee() + total.getBillingFeeAmount())+ total.getBillingVAT());
        double netTotals = (total.getTranValue() / 100.0);
       // double totalCharges = (total.getBillingFeeAmount() + (abs(total.getBillingFee()) + abs(total.getBillingVAT())));
       
        double nett = (netTotals  + totalCharges);

        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(billvalue)), 16, ' ', Justification.RIGHT) +
                        sign(billvalue) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandInterChangeSarb)), 16, ' ', Justification.RIGHT) +
                        sign(billAmount) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandVatSarb)), 16, ' ', Justification.RIGHT) +
                        sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandChargeSarb)),          16, ' ', Justification.RIGHT) +
                        sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(trxnGrandTotalSarb)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
        
        trxnGrandInterChangeSarb = 0.00;
        trxnGrandTotalSarb = 0.00;
        trxnGrandChargeSarb = 0.00;
        trxnGrandVatSarb = 0.00;
    }
    //Calculating the final Trxn Final Totals Bilateral
    public static void writeTxnFinalSubTotals(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = abs(total.getBillingFee());
    	double billFeeAmount = abs(total.getBillingFeeAmount());
    	double billAmount = (billFee + billFeeAmount);
    	double billVat = abs(total.getBillingVAT());
        double totalCharges = ((billFee + billFeeAmount)+ billVat);
        double netTotals = (total.getTranValue() / 100.0);
        double nett = (netTotals  + totalCharges);
        
        trxnFinalInterchange = trxnFinalInterchange + abs((billFee + billFeeAmount));
        trxnFinalCharge = trxnFinalCharge + abs(totalCharges);
        trxnFinalVat = trxnFinalVat + abs(billVat);
        trxnFinalTotalNett = trxnFinalTotalNett + abs(nett);
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(netTotals)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                format( DECIMAL_FORMAT.format(abs(billAmount)), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(billVat), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(totalCharges)),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(nett)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
        
    }
  //Calculating the final Trxn Final Totals Bilateral for Fleet Card
    public static void writeTxnFinalSubTotalsFleetCard(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = abs(total.getBillingFee());
    	double billFeeAmount = abs(total.getBillingFeeAmount());
    	double billAmount = (billFee );
    	double billVat = abs(total.getBillingVAT());
        double totalCharges = (billFee + billVat);
        double netTotals = (total.getTranValue() / 100.0);
        double nett = (netTotals  + totalCharges);
        
        trxnFinalInterchange = trxnFinalInterchange + abs((billFee));
        trxnFinalCharge = trxnFinalCharge + abs(totalCharges);
        trxnFinalVat = trxnFinalVat + abs(billVat);
        trxnFinalTotalNett = trxnFinalTotalNett + abs(nett);
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(netTotals)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                format( DECIMAL_FORMAT.format(abs(billAmount)), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(billVat), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(totalCharges)),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(nett)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
        
    }
    
    //Calculating the final Trxn FinalTotals SARB
    public static void writeTxnFinalSARBVMSubTotals(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	double billFee = total.getBillingFee();
    	double billFeeAmount = total.getBillingFeeAmount();
    	double billVat = total.getBillingVAT();
    	double billAmount = (billFee + billFeeAmount);
    	double billvalue = (total.getTranValue() / 100.0);
        double totalCharges = ((billFee + billFeeAmount)+ billVat);
        double netTotals = (total.getTranValue() / 100.0);
        double nett = (netTotals  + totalCharges);
        
        trxnFinalInterchangeSarb = trxnFinalInterchangeSarb + (billFee + billFeeAmount);
        trxnFinalChargeSarb = trxnFinalChargeSarb + totalCharges;
        trxnFinalVatSarb = trxnFinalVatSarb + billVat;
        trxnFinalTotalNettSarb = trxnFinalTotalNettSarb + nett;
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(billvalue)), 16, ' ', Justification.RIGHT) +
                        sign(billvalue) +
                format( DECIMAL_FORMAT.format(abs(billAmount)), 16, ' ', Justification.RIGHT) +
                        sign(billAmount) +
                format( DECIMAL_FORMAT.format(abs(billVat)), 16, ' ', Justification.RIGHT) +
                        sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(abs(totalCharges)),          16, ' ', Justification.RIGHT) +
                        sign(totalCharges) +
                format( DECIMAL_FORMAT.format(abs(nett)),                  16, ' ', Justification.RIGHT)+
                        sign(nett);

        out.println( s  + LINE_SEPARATOR);
        
    }
    //Bilateral Billing final grand total
    public static void writeTxnFinalGrandTotals(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	TxnGroupTotalsDTO txnGroupTotalsDTO = new TxnGroupTotalsDTO();
    	txnGroupTotalsDTO.addBillingFee(total.getBillingFee());
    	txnGroupTotalsDTO.addBillingFeeAmount(total.getBillingFeeAmount());
    	txnGroupTotalsDTO.addBillingVAT(total.getBillingVAT());
    	txnGroupTotalsDTO.addTranValue(total.getTranValue());
    	txnGroupTotalsDTO.addVolume(total.getVolume());
    	
        double finalBillingFee = abs(txnGroupTotalsDTO.getBillingFee());
        double finalBillingFeeAmount =abs( txnGroupTotalsDTO.getBillingFeeAmount());
        double finalBillingVat = abs(txnGroupTotalsDTO.getBillingVAT()); 
        double finalTotalCharges =  ((finalBillingFeeAmount + finalBillingFee)+finalBillingVat);
        double finalNett = (((txnGroupTotalsDTO.getBillingFee()+ txnGroupTotalsDTO.getBillingFeeAmount()) + txnGroupTotalsDTO.getBillingVAT()))+(txnGroupTotalsDTO.getTranValue()/100.0);
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(txnGroupTotalsDTO.getTranValue()/100.0)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                format( DECIMAL_FORMAT.format(finalBillingFeeAmount + finalBillingFee), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(finalBillingVat), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(finalTotalCharges),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(finalNett),                  16, ' ', Justification.RIGHT)+
                        sign(finalNett);

        out.println( s  + LINE_SEPARATOR);
    }
    //Bilateral Billing final grand total for Fleet Card
    public static void writeTxnFinalGrandTotalsFleetCard(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	TxnGroupTotalsDTO txnGroupTotalsDTO = new TxnGroupTotalsDTO();
    	txnGroupTotalsDTO.addBillingFee(total.getBillingFee());
    	txnGroupTotalsDTO.addBillingFeeAmount(total.getBillingFeeAmount());
    	txnGroupTotalsDTO.addBillingVAT(total.getBillingVAT());
    	txnGroupTotalsDTO.addTranValue(total.getTranValue());
    	txnGroupTotalsDTO.addVolume(total.getVolume());
    	
        double finalBillingFee = abs(txnGroupTotalsDTO.getBillingFee());
        double finalBillingVat = abs(txnGroupTotalsDTO.getBillingVAT()); 
        double finalTotalCharges =  ( finalBillingFee+finalBillingVat);
        double finalNett = ((txnGroupTotalsDTO.getBillingFee() + txnGroupTotalsDTO.getBillingVAT()))+(txnGroupTotalsDTO.getTranValue()/100.0);
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(txnGroupTotalsDTO.getTranValue()/100.0)), 16, ' ', Justification.RIGHT) +
                        sign(total.getTranValue()) +
                format( DECIMAL_FORMAT.format(finalBillingFee), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingFee() + total.getBillingFeeAmount()) +
                format( DECIMAL_FORMAT.format(finalBillingVat), 16, ' ', Justification.RIGHT) +
                        //sign(total.getBillingVAT()) +
                format( DECIMAL_FORMAT.format(finalTotalCharges),          16, ' ', Justification.RIGHT) +
                        //sign(totalCharges) +
                format( DECIMAL_FORMAT.format(finalNett),                  16, ' ', Justification.RIGHT)+
                        sign(finalNett);

        out.println( s  + LINE_SEPARATOR);
    }
    
    //Sarb billing final GrandTotals
    public static void writeTxnFinalSARBVMGrandTotals(PrintWriter out, String narrative, TxnGroupTotalsDTO total) {

    	TxnGroupTotalsDTO txnGroupTotalsDTO = new TxnGroupTotalsDTO();
    	txnGroupTotalsDTO.addBillingFee(total.getBillingFee());
    	txnGroupTotalsDTO.addBillingFeeAmount(total.getBillingFeeAmount());
    	txnGroupTotalsDTO.addBillingVAT(total.getBillingVAT());
    	txnGroupTotalsDTO.addTranValue(total.getTranValue());
    	txnGroupTotalsDTO.addVolume(total.getVolume());
    	
        double finalBillFee = txnGroupTotalsDTO.getBillingFee();
        double finalBillingFee = txnGroupTotalsDTO.getBillingFeeAmount();
        double billAmount = (finalBillFee + finalBillingFee);
    	double billvalue = (total.getTranValue() / 100.0);
        double finalBillingVat = txnGroupTotalsDTO.getBillingVAT(); 
        double finalTotalCharges =  ((txnGroupTotalsDTO.getBillingFee() + txnGroupTotalsDTO.getBillingFeeAmount())+finalBillingVat);
        double finalNett = (((txnGroupTotalsDTO.getBillingFee()+ txnGroupTotalsDTO.getBillingFeeAmount()) + finalBillingVat))+(txnGroupTotalsDTO.getTranValue()/100.0);
        
        String s =
                format( narrative, 15, ' ', Justification.LEFT) +
                format( "" + total.getVolume(), 10, ' ', Justification.RIGHT) +
                
                format( DECIMAL_FORMAT.format(abs(billvalue)), 16, ' ', Justification.RIGHT) +
                        sign(billvalue) +
                format( DECIMAL_FORMAT.format(abs(billAmount)), 16, ' ', Justification.RIGHT) +
                        sign(billAmount) +
                format( DECIMAL_FORMAT.format(abs(finalBillingVat)), 16, ' ', Justification.RIGHT) +
                        sign(finalBillingVat) +
                format( DECIMAL_FORMAT.format(abs(finalTotalCharges)),          16, ' ', Justification.RIGHT) +
                        sign(finalTotalCharges) +
                format( DECIMAL_FORMAT.format(abs(finalNett)),                  16, ' ', Justification.RIGHT)+
                        sign(finalNett);

        out.println( s  + LINE_SEPARATOR);
    }


    public static void writeTxnDetails(PrintWriter out, Map<AcquirerCode, StatementDTO> issuerData) {

        for (AcquirerCode acquirerCode : issuerData.keySet()) {

            StatementDTO statementDTO = issuerData.get(acquirerCode);

            String s =
                    format( statementDTO.getInterchangeInstitionName(), 24, ' ', Justification.LEFT) +
                    format( DECIMAL_FORMAT.format(statementDTO.getAcquiringInterchangeFee()),
                                                                        22, ' ', Justification.RIGHT) +
                    format( DECIMAL_FORMAT.format(statementDTO.getIssuingInterchangeFee()),
                                                                        25, ' ', Justification.RIGHT) +
                    format( DECIMAL_FORMAT.format(
                                    statementDTO.getAcquiringInterchangeFee()
                                    .subtract(statementDTO.getIssuingInterchangeFee())),
                                                                        29, ' ', Justification.RIGHT);

            out.println(s);
        }
    }

    public static void writeTxnGroupTotals(PrintWriter out, Map<AcquirerCode, StatementDTO> issuerData) {

        String s =
                format( "", 88, ' ', Justification.LEFT) + "==============";
        out.println( s );

        s =
                format( "TOTAL INTERCHANGE FEES DUE/PAYABLE", 83, ' ', Justification.RIGHT) +
                format( DECIMAL_FORMAT.format(nett(issuerData)), 19, ' ', Justification.RIGHT);
        out.println( s );

        s =
                format( "", 88, ' ', Justification.LEFT) + "==============";
        out.println( s  + LINE_SEPARATOR + LINE_SEPARATOR);

        out.println("THE ABOVE AMOUNT WILL BE DEBITED/CREDITED TO YOUR NOMINATED ACCOUNT" + LINE_SEPARATOR );

    }

    private static BigDecimal nett(Map<AcquirerCode, StatementDTO> issuerData) {

        BigDecimal nett = BigDecimal.ZERO;

        for (AcquirerCode acquirerCode : issuerData.keySet()) {
            StatementDTO statementDTO = issuerData.get(acquirerCode);
            nett = nett.add(
                        statementDTO.getAcquiringInterchangeFee()
                                .subtract(statementDTO.getIssuingInterchangeFee()));
        }

        return nett;
    }
    
    /*public static void main(String[] args) {
		
    	CCR001DetailWriter ccr001DetailWriter = new CCR001DetailWriter();
    	//ccr001DetailWriter
	}*/
}
