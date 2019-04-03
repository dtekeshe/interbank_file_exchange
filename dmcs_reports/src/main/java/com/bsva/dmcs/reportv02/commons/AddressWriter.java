package com.bsva.dmcs.reportv02.commons;

import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.entities.v02.members.MemberAddressEntity;

import java.io.PrintWriter;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

/**
 * TODO Document
 */
public class AddressWriter {

    private final static String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void write1( PrintWriter out,MemberAddressEntity acquirerAddress,
                              MemberAddressEntity issuerAddress
                               ) {

        String s =
                format( "TO:-",                           6, ' ', Justification.LEFT) +
                format( acquirerAddress.getContactName(),25, ' ', Justification.LEFT) +
                format( "",                              35, ' ', Justification.LEFT) +
                format( "FROM:-",                         8, ' ', Justification.LEFT) +
                format( issuerAddress.getContactName(),  25, ' ', Justification.LEFT) ;
        out.println( s );

        s =
                format( "",                             6, ' ', Justification.LEFT) +
                format( acquirerAddress.getBankName(), 25, ' ', Justification.LEFT) +
                format( "",                            35, ' ', Justification.LEFT) +
                format( "",                             8, ' ', Justification.LEFT) +
                format( issuerAddress.getBankName(),   25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                format( acquirerAddress.getMemberAddress1(),    25, ' ', Justification.LEFT) +
                format( "",                                     35, ' ', Justification.LEFT) +
                format( "",                                     8,  ' ', Justification.LEFT) +
                format( issuerAddress.getMemberAddress1(),      25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                format( acquirerAddress.getMemberAddress2(),    25, ' ', Justification.LEFT) +
                format( "",                                     35, ' ', Justification.LEFT) +
                format( "",                                     8,  ' ', Justification.LEFT) +
                format( issuerAddress.getMemberAddress2(),      25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                format( acquirerAddress.getMemberAddress3(),    25, ' ', Justification.LEFT) +
                format( "",                                     35, ' ', Justification.LEFT) +
                format( "",                                     8,  ' ', Justification.LEFT) +
                format( issuerAddress.getMemberAddress3(),      25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                format( acquirerAddress.getMemberAddress4(),    25, ' ', Justification.LEFT) +
                format( "",                                     35, ' ', Justification.LEFT) +
                format( "",                                     8,  ' ', Justification.LEFT) +
                format( issuerAddress.getMemberAddress4(),      25, ' ', Justification.LEFT);
        out.println( s + LINE_SEPARATOR);

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                format( "VAT REG. NO. " +
                        acquirerAddress.getVatRegNumber(),      25, ' ', Justification.LEFT)+
                format( "",                                     35, ' ', Justification.LEFT) +
                format( "",                                     8,  ' ', Justification.LEFT) +
                format( "VAT REG. NO. " +
                		issuerAddress.getVatRegNumber(),        25, ' ', Justification.LEFT) ;
        out.println( s + LINE_SEPARATOR + LINE_SEPARATOR);
    }
    public static void write2( PrintWriter out,MemberAddressEntity acquirerAddress,
            MemberAddressEntity issuerAddress
             ) {

			String s =
			format( "TO:-",                           6, ' ', Justification.LEFT) +
			format( acquirerAddress.getContactName(),25, ' ', Justification.LEFT) +
			format( "",                              35, ' ', Justification.LEFT) +
			format( "FROM:-",                         8, ' ', Justification.LEFT) +
			format( issuerAddress.getContactName(),  25, ' ', Justification.LEFT) ;
			out.println( s );
			
			s =
			format( "",                             6, ' ', Justification.LEFT) +
			format( acquirerAddress.getBankName(), 25, ' ', Justification.LEFT) +
			format( "",                            35, ' ', Justification.LEFT) +
			format( "",                             8, ' ', Justification.LEFT) +
			format( issuerAddress.getBankName(),   25, ' ', Justification.LEFT);
			out.println( s );
			
			s =
			format( "",                                     6,  ' ', Justification.LEFT) +
			format( acquirerAddress.getMemberAddress1(),    25, ' ', Justification.LEFT) +
			format( "",                                     35, ' ', Justification.LEFT) +
			format( "",                                     8,  ' ', Justification.LEFT) +
			format( issuerAddress.getMemberAddress1(),      25, ' ', Justification.LEFT);
			out.println( s );
			
			s =
			format( "",                                     6,  ' ', Justification.LEFT) +
			format( acquirerAddress.getMemberAddress2(),    25, ' ', Justification.LEFT) +
			format( "",                                     35, ' ', Justification.LEFT) +
			format( "",                                     8,  ' ', Justification.LEFT) +
			format( issuerAddress.getMemberAddress2(),      25, ' ', Justification.LEFT);
			out.println( s );
			
			s =
			format( "",                                     6,  ' ', Justification.LEFT) +
			format( acquirerAddress.getMemberAddress3(),    25, ' ', Justification.LEFT) +
			format( "",                                     35, ' ', Justification.LEFT) +
			format( "",                                     8,  ' ', Justification.LEFT) +
			format( issuerAddress.getMemberAddress3(),      25, ' ', Justification.LEFT);
			out.println( s );
			
			s =
			format( "",                                     6,  ' ', Justification.LEFT) +
			format( acquirerAddress.getMemberAddress4(),    25, ' ', Justification.LEFT) +
			format( "",                                     35, ' ', Justification.LEFT) +
			format( "",                                     8,  ' ', Justification.LEFT) +
			format( issuerAddress.getMemberAddress4(),      25, ' ', Justification.LEFT);
			out.println( s + LINE_SEPARATOR);
			
			s =
			format( "",                                     6,  ' ', Justification.LEFT) +
			format( "VAT REG. NO. " +
					acquirerAddress.getVatRegNumber(),      25, ' ', Justification.LEFT)+
			format( "",                                     35, ' ', Justification.LEFT) +
			format( "",                                     8,  ' ', Justification.LEFT) +
			format( "VAT REG. NO. " +
					issuerAddress.getVatRegNumber(),        25, ' ', Justification.LEFT) ;
			out.println( s + LINE_SEPARATOR + LINE_SEPARATOR);
}
    


    public static void writeSummarypage( PrintWriter out,MemberAddressEntity acquirerAddress,
                              MemberAddressEntity issuerAddress) {

	        String s =
	        		format( "TO:-",                         8, ' ', Justification.LEFT) +
	        		format( issuerAddress.getContactName(),  25, ' ', Justification.LEFT) +
	                format( "",                              35, ' ', Justification.LEFT) +
	                format( "FROM:-",                           6, ' ', Justification.LEFT) +
	                format( acquirerAddress.getContactName(),25, ' ', Justification.LEFT) ;
	        out.println( s );
	
	        s =
	                format( "",                             8, ' ', Justification.LEFT) +
	                format( issuerAddress.getBankName(),   25, ' ', Justification.LEFT)+
	                format( "",                            35, ' ', Justification.LEFT) +
	                format( "",                             6, ' ', Justification.LEFT) +
	                format( acquirerAddress.getBankName(), 25, ' ', Justification.LEFT) ;
	        
	        out.println( s );
	
	        s =
	        		format( "",                                     8,  ' ', Justification.LEFT) +
	        		format( issuerAddress.getMemberAddress1(),      25, ' ', Justification.LEFT)+
	        		format( "",                            35, ' ', Justification.LEFT) +
	                format( "",                                     6,  ' ', Justification.LEFT) +
	                format( acquirerAddress.getMemberAddress1(),    25, ' ', Justification.LEFT) ;
	        out.println( s );
	
	        s =
	        		format( "",                                     8,  ' ', Justification.LEFT) +
	        		format( issuerAddress.getMemberAddress2(),      25, ' ', Justification.LEFT)+
	        		format( "",                            35, ' ', Justification.LEFT) +
	                format( "",                                     6,  ' ', Justification.LEFT) +
	                format( acquirerAddress.getMemberAddress2(),    25, ' ', Justification.LEFT) ;
	        out.println( s );
	
	        s =
	        		format( "",                                     8,  ' ', Justification.LEFT) +
	        		format( issuerAddress.getMemberAddress3(),      25, ' ', Justification.LEFT)+
	        		format( "",                            35, ' ', Justification.LEFT) +
	                format( "",                                     6,  ' ', Justification.LEFT) +
	                format( acquirerAddress.getMemberAddress3(),    25, ' ', Justification.LEFT) ;
	        out.println( s );
	
	        s =
	        		format( "",                                     8,  ' ', Justification.LEFT) +
	        		format( issuerAddress.getMemberAddress4(),      25, ' ', Justification.LEFT)+
	        		format( "",                            35, ' ', Justification.LEFT) +
	                format( "",                                     6,  ' ', Justification.LEFT) +
	                format( acquirerAddress.getMemberAddress4(),    25, ' ', Justification.LEFT) ;
	        out.println( s + LINE_SEPARATOR);
	
	        s =
	        		format( "",                                     8,  ' ', Justification.LEFT) +
	        		format( "VAT REG. NO. " +
	        				issuerAddress.getVatRegNumber(),        25, ' ', Justification.LEFT) +
	        		format( "",                            35, ' ', Justification.LEFT) +
	                format( "",                                     6,  ' ', Justification.LEFT) +
	                format( "VAT REG. NO. " +
	                		acquirerAddress.getVatRegNumber(),      25, ' ', Justification.LEFT);
	        out.println( s + LINE_SEPARATOR + LINE_SEPARATOR);
    }



    public static void write( PrintWriter out,
                              MemberAddressEntity issuerAddress,
                              String reportID) {

        String s =
                format( ( "001".equals(reportID) ?  "TO:-" : "FROM:-"), 6, ' ', Justification.LEFT) +
                        format( issuerAddress.getContactName(),  25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                             6, ' ', Justification.LEFT) +
                        format( issuerAddress.getBankName(),   25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                        format( issuerAddress.getMemberAddress1(),      25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                        format( issuerAddress.getMemberAddress2(),      25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                        format( issuerAddress.getMemberAddress3(),      25, ' ', Justification.LEFT);
        out.println( s );

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                        format( issuerAddress.getMemberAddress4(),      25, ' ', Justification.LEFT);
        out.println( s + LINE_SEPARATOR);

        s =
                format( "",                                     6,  ' ', Justification.LEFT) +
                        format( "VAT REG. NO. " +
                                issuerAddress.getVatRegNumber(),        25, ' ', Justification.LEFT);
        out.println( s + LINE_SEPARATOR + LINE_SEPARATOR);
    }
}
