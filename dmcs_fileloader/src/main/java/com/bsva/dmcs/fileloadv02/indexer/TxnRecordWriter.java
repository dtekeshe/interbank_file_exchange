package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dao.v02.members.MemberServicesDAO;
import com.bsva.dao.v02.OutputControlDAO;
import com.bsva.dmcs.fileloadv02.dto.MastercardPDSDTO;
import com.bsva.dmcs.fileloadv02.dto.Service;
import com.bsva.dmcs.fileloadv02.dto.SubService;

import com.bsva.dmcs.fileloadv02.dto.Justification;
import com.bsva.dmcs.fileloadv02.model.*;
import com.bsva.dmcs.fileloadv02.util.FileIndexerUtils;
import com.bsva.dmcs.fileloadv02.util.SystemConfigurationException;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.Filename;
import com.bsva.dto.OriginDestinationPair;
import com.bsva.entities.CsfDeliveryServices;
import com.bsva.entities.v02.members.MemberParamKey;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.format;
import static com.bsva.dmcs.fileloadv02.util.StringUtils.parseInt;


/**
 * @author AugustineA
 *
 */
public class TxnRecordWriter {

    private final Service service;
    private final SubService subService;
    private String fileNameid = null;
    private int cardType = 0;

    private final String filenamePrefix;

    // TODO Inject
    private FilenameServer filenameServer;

    private final static Map<String, Integer> MINIMUM_OUTPUT_FILES_FOR_SERVICE;
    static {
        // TODO Parameterize into a database table
        MINIMUM_OUTPUT_FILES_FOR_SERVICE = new HashMap<>();
        MINIMUM_OUTPUT_FILES_FOR_SERVICE.put("VISA CARD",       64);
        MINIMUM_OUTPUT_FILES_FOR_SERVICE.put("MASTERCARD",        64);
        MINIMUM_OUTPUT_FILES_FOR_SERVICE.put("FLEET CARD", 25);
        MINIMUM_OUTPUT_FILES_FOR_SERVICE.put("DINERS",     49);
        MINIMUM_OUTPUT_FILES_FOR_SERVICE.put("AMEX",       64);
    }

    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#########.##");
    private final static DecimalFormat DECIMAL_FORMATD = new DecimalFormat("#########.#####");

    public TxnRecordWriter(Service service, SubService subService, String outFilenamePrefix)
            throws SystemConfigurationException {

        this.service = service;
        this.subService = subService;
        filenamePrefix = outFilenamePrefix;

//        List<CsoSeqNumbers> seqNumbers = new CsoSeqNumbersDao().findAll();
//        Map<String, Integer> lastSeqNumbers = MapFactory.lastSeqNumbers(filenamePrefix, seqNumbers);

        // max file sizes
//        List<CsfMemberService> issuerList = new CsfMemberServiceDao().findAll();
        Map<MemberParamKey, Long> outputFileSizeLimits = new MemberServicesDAO().memberFileLimits();

        // filenames
        Map<OriginDestinationPair, List<Filename>> filenames
                = new OutputControlDAO().filenames(service.name(), subService.getDescription());

        if (filenames == null ||
                filenames.size() < MINIMUM_OUTPUT_FILES_FOR_SERVICE.get(subService.getDescription()) ) {
        //     throw new SystemConfigurationException("ISSUER / ACQUIRER PAIR COUNT FOR " + subService.getDescription() +
        //                            " NOT EQUAL TO " +
        //                            MINIMUM_OUTPUT_FILES_FOR_SERVICE.get(subService.getDescription()));
        }

        filenameServer = new FilenameServer(subService, filenamePrefix, filenames, outputFileSizeLimits);
    }

    public void write(  PrintWriter out,
                        FileHeaderDTO header,
                        List<FileDetailDTO> payLines) {

        FileDetailDTO payment = payLines.get(0);

        Filename filename = null;

        OriginDestinationPair pair = null;

        if ( "C".equals(payLines.get(0).getStatus())) {
             pair
                    = new OriginDestinationPair(
                    payment.getAcquirerCode(),
                    payment.getIssuerCode(),
                    payment.getDistributionCode(),
                    service.name(),
                    subService.getDescription(),
                    filenamePrefix);

            filename = filenameServer.getFilename(pair);
        }

        for ( FileDetailDTO paymentLine : payLines ) {
        	
        	cardType = payLines.get(0).getCardType().intValue();
            // is file full
            if (filename != null) {
                if (!isNotFull(filename)) {
                    filename = filenameServer.getFilename(pair);
                }

                // update counters
                filename.setTransactionCount(filename.getTransactionCount() + 1);
                paymentLine.setOutputLineId(filename.getTransactionCount().longValue());
                paymentLine.setTransCount(filename.getTransactionCount().longValue());
                paymentLine.setCardType(cardType);
                if ( ( paymentLine.getTcrCode() == TCRCode.TCR0) && (paymentLine.getAmount() != null)) {
                    filename.addTxnAmount(paymentLine.getAmount().doubleValue());
                    FileIndexerUtils.updateOutputControlCounters(paymentLine, filename);
                }
            }
            // writing payment line
            write( out, header, paymentLine, (filename != null ? filename.getFilename() : null) );
            // set filename
            paymentLine.setOutputFilename(filename != null ? filename.getFilename() : null);
         
        }
    }

    private static void write(PrintWriter out,
                             FileHeaderDTO header,
                             FileDetailDTO payment,
                             String filename ) {

        BillingData billingData = payment.getBillingData();
        TerminalInfo terminalInfo = payment.getTerminalInfo();
        Integer txnCode = payment.getBillingTxnCode();
        if (txnCode == null) {
            txnCode = payment.getTxnCode();
        }
        //writing to the payment Instruction table
        String s =
                // format( payment.getInput(), payment.getInputLength(), ' ', Justification.LEFT) +
                format("" + header.getFileSeqNumber(), 10, ' ', Justification.LEFT) +
                format("" + payment.getTxnSeqNumber(), 11, ' ', Justification.LEFT) +
                format("" + header.getServiceID(), 4, ' ', Justification.LEFT) +
                format("" + header.getSubServiceID(), 10, ' ', Justification.LEFT) +
                format("" + payment.getLineID(), 10, ' ', Justification.LEFT) +
                format("" + payment.getAcquirerCode(), 6, ' ', Justification.RIGHT) +
                format("" + payment.getIssuerCode(), 6, ' ', Justification.RIGHT) +
                format("" + payment.getCardType(), 2, ' ', Justification.RIGHT) +
                format("" + payment.getLineID(), 10, ' ', Justification.RIGHT) +
                format(filename, 8, ' ', Justification.LEFT) +

                // billing data
                format((( billingData != null && billingData.getPercentFee() != null )  ?
                		DECIMAL_FORMATD.format(billingData.getPercentFee().doubleValue() / 100.0) : "0"),
                                                                        11, ' ', Justification.RIGHT) +
                format((( billingData != null && billingData.getFlatFee() != null )  ?
                		DECIMAL_FORMATD.format(billingData.getFlatFee().doubleValue() / 100.0) : "0"),
                                                                        11, ' ', Justification.RIGHT) +
                format((( billingData != null && billingData.getVat() != null )  ?
                		DECIMAL_FORMATD.format(billingData.getVat()) : "0"),
                                                                        11, ' ', Justification.RIGHT) +
                format((( billingData != null && billingData.getCashBackPercentFee() != null )  ?
                		DECIMAL_FORMATD.format(billingData.getCashBackPercentFee().doubleValue() / 100.00) : "0"),
                                                                        11, ' ', Justification.RIGHT) +
                format((( billingData != null && billingData.getCashBackFlatFee() != null )  ?
                		DECIMAL_FORMATD.format(billingData.getCashBackFlatFee().doubleValue() / 100.0) : "0"),
                                                                        11, ' ', Justification.RIGHT) +
                format((( billingData != null && billingData.getCashBackVAT() != null )  ?
                		DECIMAL_FORMATD.format(billingData.getCashBackVAT().doubleValue()) : "0"),
                                                                        11, ' ', Justification.RIGHT) +

                // terminal info
                format(((terminalInfo != null && terminalInfo.getPosEntryMode() != null) ?
                        terminalInfo.getPosEntryMode().toString() : "0"), 2, '0', Justification.RIGHT) +
                format(((terminalInfo != null && terminalInfo.getTerminalCapability() != null) ?
                        terminalInfo.getTerminalCapability().toString() : "0"), 1, '0', Justification.RIGHT) +
                format(((terminalInfo != null && terminalInfo.getChipCard() != null) ?
                        terminalInfo.getChipCard().toString() : "0"), 1, '0', Justification.RIGHT) +
                format(((terminalInfo != null && terminalInfo.getEcommIndicator() != null) ?
                        terminalInfo.getEcommIndicator().toString() : "0"), 1, '0', Justification.RIGHT) +
                format(((terminalInfo != null && terminalInfo.getCardPresent() != null) ?
                        terminalInfo.getCardPresent().toString() : "0"), 1, '0', Justification.RIGHT) +
                format((( billingData != null && billingData.getRateDescriptor() != null )  ?
                        billingData.getRateDescriptor().toString() : ""), 11, ' ', Justification.LEFT) +

                // cashback
                format(payment.getCashbackAmount().toString(), 11, '0', Justification.RIGHT) +
                ( payment.hasCashBack() ? "Y" : "N" ) +

                // status
                format(payment.getStatus(), 1 , ' ', Justification.RIGHT) +

                // txn code
                format(""+ txnCode, 2 , ' ', Justification.RIGHT) +

                // date time for fleet card
                format(
                   (payment.getDateTime() != null ? "" + payment.getDateTime().getTime() : "0"),
                                                               20, ' ', Justification.LEFT) +
                // message type indicator
                format((payment.getMessageTypeIndicator() != null ? payment.getMessageTypeIndicator() : " "),
                        4, ' ', Justification.RIGHT) +
                // primary bit map
                format((payment.getPrimaryBitmap() != null ? payment.getPrimaryBitmap() : "0000000000000000000000000000000000000000000000000000000000000000"),
                        64, ' ', Justification.LEFT) +
                // secondary bit map
                format((payment.getSecondaryBitmap() != null ? payment.getSecondaryBitmap() : "0000000000000000000000000000000000000000000000000000000000000000"),
                        64, ' ', Justification.LEFT) +
                // txn amount
                format((payment.getAmount() != null ? payment.getAmount() : 0),
                        11, ' ', Justification.RIGHT) +
                // processing code
                format((payment.getProcessingCode() != null ? payment.getProcessingCode() : "0"),
                        6, ' ', Justification.RIGHT) +
                // account number
                format((payment.getAccountNumber() != null ? payment.getAccountNumber() : " "),
                       20, ' ', Justification.LEFT) +
                // acquirer bin
                format((payment.getAcquirerBin() != null ? payment.getAcquirerBin() : 0 ),
                        6, ' ', Justification.RIGHT) +
                // issuer bin
                format((payment.getIssuerBin() != null ? payment.getIssuerBin() : 0 ),
                        6, ' ', Justification.RIGHT) +
                // TCR Number
                //(payment.getTcrCode().getId() != null ? payment.getTcrCode().getId() : "0");
                format((payment.getTcrCode().getId() != null ? payment.getTcrCode().getId() : 0)
                		,1,' ',Justification.RIGHT) +
                format((payment.getSubProduct() != null ? payment.getSubProduct() : "1")
                		,2,' ',Justification.RIGHT) +
                format((payment.getProduct() != null ? payment.getProduct(): "1")
                		,1,' ',Justification.RIGHT)
                ///============================ getting new Data for mastercard==============================		
                //getting new Data for mastercard
                		+
                format((payment.getTransactionCode() != null ? payment.getTransactionCode(): "0")
                		,1,' ',Justification.RIGHT)
                		+
                format((payment.getP2Pan() != null ? payment.getP2Pan(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getP31AcquirerRefData() != null ? payment.getP31AcquirerRefData(): "0")//
                		,23,' ',Justification.RIGHT)
                		+
                format((payment.getP12LocalDate() != null ? payment.getP12LocalDate(): "11")//
                		,6,' ',Justification.RIGHT)
                		+
                format((payment.getP4transAmount() != null ? payment.getP4transAmount(): "0")
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getP38approvalCode() != null ? payment.getP38approvalCode(): "0")
                		,6,' ',Justification.RIGHT)
                		+
                format((payment.getP43cardAcceptorName() != null ? payment.getP43cardAcceptorName(): "0")
                		,99,' ',Justification.RIGHT)
                		+
                format((payment.getP25MessageReasonCode() != null ? payment.getP25MessageReasonCode(): "0")//
                		,4,' ',Justification.RIGHT)
                		+
                format((payment.getP26CardAcceptorBusCode() != null ? payment.getP26CardAcceptorBusCode(): "0")//
                		,4,' ',Justification.RIGHT)
                		+
                format((payment.getP30OriginalAmount() != null ? payment.getP30OriginalAmount(): "0")//
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getSystemSeqNumber2() != null ? payment.getSystemSeqNumber2(): "0")
                		,6,' ',Justification.RIGHT)
                		+
                format((payment.getP24FunctionCode() != null ? Integer.valueOf(payment.getP24FunctionCode()): 0)
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getRecordId() != null ? payment.getRecordId(): "0")
                		,1,' ',Justification.RIGHT)
                		+
                format((payment.getFinancialIndicator() != null ? payment.getFinancialIndicator(): "0")
                		,1,' ',Justification.RIGHT)
                		+
                format((payment.getProcessStatus() != null ? payment.getProcessStatus(): "1")
                		,1,' ',Justification.RIGHT)
                		+
                format((payment.getSystemSeqNumber() != null ? payment.getSystemSeqNumber(): "1")
                		,6,' ',Justification.RIGHT)
                		//starting to populate all fields for the index files
                		+
                format((payment.getP12localDate() != null ? payment.getP12localDate(): "11")
                		,6,' ',Justification.RIGHT)
                		+
                format((payment.getP13localTime() != null ? payment.getP13localTime(): "11")
                		,6,' ',Justification.RIGHT)
                		+
                format((payment.getP5ReconciliationAmount() != null ? payment.getP5ReconciliationAmount(): "0")
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getMessageReasonCode() != null ? payment.getMessageReasonCode(): "0")
                		,4,' ',Justification.RIGHT)
                		+
                format((payment.getCardAcceptorbusCode() != null ? payment.getCardAcceptorbusCode(): "0")
                		,4,' ',Justification.RIGHT)
                		+
                format((payment.getRetrievalRefNumber() != null ? payment.getRetrievalRefNumber(): "0")
                		,6,' ',Justification.RIGHT)
                		+
                format((payment.getApprovalCode() != null ? payment.getApprovalCode(): "0")
                		,6,' ',Justification.RIGHT)
                		+
                format((payment.getIcclength() != null ? payment.getIcclength(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getIccSystemRelatedData() != null ? payment.getIccSystemRelatedData(): "0")
                		,119,' ',Justification.RIGHT)
                		+
                format((payment.getP2PanLength() != null ? payment.getP2PanLength(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getP2Pan() != null ? payment.getP2Pan(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getPointOfSaleData() != null ? payment.getPointOfSaleData(): "0")
                		,12,' ',Justification.RIGHT)
                		//starting here
                		+
                format((payment.getCardAcceptorTerminalId() != null ? payment.getCardAcceptorTerminalId(): "0")
                		,8,' ',Justification.RIGHT)
                		+
                format((payment.getCardAcceptorId() != null ? payment.getCardAcceptorId(): "0")
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getFunctionCode() != null ? payment.getFunctionCode(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getAcquirerRefLength() != null ? payment.getAcquirerRefLength(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getP31AcquirerRefData() != null ? payment.getP31AcquirerRefData(): "0")
                		,23,' ',Justification.RIGHT)
                		+
                format((payment.getCode() != null ? payment.getCode(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getCardAcceptorLength() != null ? payment.getCardAcceptorLength(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getP26cardAcceptorName() != null ? payment.getP26cardAcceptorName(): "0")
                		,47,' ',Justification.RIGHT)
                		+
                format((payment.getAdditionalDataLength() != null ? payment.getAdditionalDataLength(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getAdditionalData() != null ? payment.getAdditionalData(): "0")
                		,250,' ',Justification.RIGHT)
                		+
                format((payment.getP20currencyCode() != null ? payment.getP20currencyCode(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getReconcilliationCode() != null ? payment.getReconcilliationCode(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getMessageNumber() != null ? payment.getMessageNumber(): "0")
                		,6,' ',Justification.RIGHT)
                		+
                format((payment.getS70NetworkmanCountryCode() != null ? payment.getS70NetworkmanCountryCode(): "0")
                		,8,' ',Justification.RIGHT)
                		+
                format((payment.getS72Datalen() != null ? payment.getS72Datalen(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getS72DataRecord() != null ? payment.getS72DataRecord(): "0")
                		,100,' ',Justification.RIGHT)
                		+
                format((payment.getS73Actiondate() != null ? payment.getS73Actiondate(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getS74NoofCredits() != null ? payment.getS74NoofCredits(): "0")
                		,10,' ',Justification.RIGHT)
                		+
                format((payment.getS75ReversalNoofCredits() != null ? payment.getS75ReversalNoofCredits(): "0")
                		,10,' ',Justification.RIGHT)
                		+
                format((payment.getS76NoofDebits() != null ? payment.getS76NoofDebits(): "0")
                		,10,' ',Justification.RIGHT)
                		+
                format((payment.getS77ReversalNoofDebits() != null ? payment.getS77ReversalNoofDebits(): "0")
                		,10,' ',Justification.RIGHT)
                		+
                format((payment.getS78NumberTransfers() != null ? payment.getS78NumberTransfers(): "0")
                		,10,' ',Justification.RIGHT)
                		+
                format((payment.getS79ReversalNumberTransfers() != null ? payment.getS79ReversalNumberTransfers(): "0")
                		,10,' ',Justification.RIGHT)
                		+
                format((payment.getS80NumberEnquiries() != null ? payment.getS80NumberEnquiries(): "0")
                		,10,' ',Justification.RIGHT)
                		+
                format((payment.getS81NumberAuthorisations() != null ? payment.getS81NumberAuthorisations(): "0")
                		,10,' ',Justification.RIGHT)
                		
                		+
                format((payment.getS82ProcessingFeeCredits() != null ? payment.getS82ProcessingFeeCredits(): "0")
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getS83TransactionfeeCredits() != null ? payment.getS83TransactionfeeCredits(): "0")
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getS84ProcessingFeeDebits() != null ? payment.getS84ProcessingFeeDebits(): "0")
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getS85TransctionfeeAmounts() != null ? payment.getS85TransctionfeeAmounts(): "0")
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getS86AmountCredits() != null ? payment.getS86AmountCredits(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getS87ReversalAmountCredits() != null ? payment.getS87ReversalAmountCredits(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getS88AmountDebits() != null ? payment.getS88AmountDebits(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getS89ReversalAmountDebits() != null ? payment.getS89ReversalAmountDebits(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getS90OriginatingDataElements() != null ? payment.getS90OriginatingDataElements(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getS91FileUpdateCode() != null ? payment.getS91FileUpdateCode(): "0")
                		,1,' ',Justification.RIGHT)
                		+
                format((payment.getS92FilesSecurityCode() != null ? payment.getS92FilesSecurityCode(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getS93Length() != null ? payment.getS93Length(): "0")
                		,2,' ',Justification.RIGHT)
                		
                		+
                format((payment.getS93TransactionDestInstId() != null ? payment.getS93TransactionDestInstId(): "0")
                		,11,' ',Justification.RIGHT)
                		+
                format((payment.getS94Length() != null ? payment.getS94Length(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getS94TransactionorigInstId() != null ? payment.getS94TransactionorigInstId(): "0")
                		,11,' ',Justification.RIGHT)
                		+
                format((payment.getS95CardIssrefDataLength() != null ? payment.getS95CardIssrefDataLength(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getS95CardIssuerRefData() != null ? payment.getS95CardIssuerRefData(): "0")
                		,12,' ',Justification.RIGHT)
                		
                		+
                format((payment.getS96MessageSecuritycode() != null ? payment.getS96MessageSecuritycode(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getS97NetSettlementAmount() != null ? payment.getS97NetSettlementAmount(): "0")
                		,16,' ',Justification.RIGHT)
                		+
                format((payment.getS98Payee() != null ? payment.getS98Payee(): "0")
                		,25,' ',Justification.RIGHT)
                		+
                format((payment.getS99SettlementInstidCode() != null ? payment.getS99SettlementInstidCode(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getS100RcvingInstidCode() != null ? payment.getS100RcvingInstidCode(): "0")
                		,11,' ',Justification.RIGHT)
                		+
                format((payment.getS100Riilen() != null ? payment.getS100Riilen(): "0")
                		,2,' ',Justification.RIGHT)
                		+
                format((payment.getS101Filename() != null ? payment.getS101Filename(): "0")
                		,4,' ',Justification.RIGHT)
                		+
                format((payment.getS102AccountIdentification1() != null ? payment.getS102AccountIdentification1(): "0")
                		,28,' ',Justification.RIGHT)
                		+
                format((payment.getS103AccountIdentification2() != null ? payment.getS103AccountIdentification2(): "0")
                		,28,' ',Justification.RIGHT)
                		+
                format((payment.getS104TransactionDescription() != null ? payment.getS104TransactionDescription(): "0")
                		,30,' ',Justification.RIGHT)
                		+
                format((payment.getS111Len() != null ? payment.getS111Len(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getS111AmtcurrencyConversion() != null ? payment.getS111AmtcurrencyConversion(): "0")
                		,12,' ',Justification.RIGHT)
                		+
                format((payment.getS123Addlen() != null ? payment.getS123Addlen(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getS123AdditionalData() != null ? payment.getS123AdditionalData(): "0")
                		,43,' ',Justification.RIGHT)
                		+
                format((payment.getS124Addlen() != null ? payment.getS124Addlen(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getS124AdditionalData() != null ? payment.getS124AdditionalData(): "0")
                		,43,' ',Justification.RIGHT)
                		+
                format((payment.getS125Addlen() != null ? payment.getS125Addlen(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getS125AdditionalData() != null ? payment.getS125AdditionalData(): "0")
                		,43,' ',Justification.RIGHT)
                		+
                format((payment.getS127NetworkData() != null ? payment.getS127NetworkData(): "0")
                		,43,' ',Justification.RIGHT)
                		+
                format((payment.getS127Addlen() != null ? payment.getS127Addlen(): "0")
                		,3,' ',Justification.RIGHT)
                		+
                format((payment.getP24FunctionCode() != null ? Integer.valueOf(payment.getP24FunctionCode()): 0)
                		,3,' ',Justification.RIGHT)//
                		+
                format((payment.getRecordId() != null ? Integer.valueOf(payment.getRecordId()): 0)
                		,1,' ',Justification.RIGHT)
                		+
                format((payment.getP31AcquirerRefData() != null ? payment.getP31AcquirerRefData(): "0")
                		,23,' ',Justification.RIGHT)
                		+
                format((payment.getInput() != null ? payment.getInput(): "0")
                		,2230,' ',Justification.RIGHT)
                	;

        out.println(s);
    }


    private String filenamePrefix(List<CsfDeliveryServices> deliveryServices, SubService subService) {
        for (CsfDeliveryServices deliveryService : deliveryServices) {
            if ( subService.getDescription().equalsIgnoreCase(deliveryService.getSubService())
                    && "O".equalsIgnoreCase(deliveryService.getInwardOutwardInd())) {
            		return deliveryService.getFilenamePrefix();
            }
        }
        return null;
    }

    private boolean isNotFull( Filename filename) {
        return filename.getMaxTransactionCount() - filename.getTransactionCount() > 0;
    }

    public FilenameServer getFilenameServer() {
        return filenameServer;
    }

    public void writePDS( PrintWriter out,
                          List<MastercardPDSDTO> pdsList ) {
        for (MastercardPDSDTO pds : pdsList ) {
            String s =
                    format("" + pds.getTxnSeqNumber(), 12, ' ', Justification.LEFT) +
                    format("" + pds.getPdsNumber(),    4, ' ', Justification.LEFT) +
                    format("" + pds.getPdsLen(),       3, ' ', Justification.LEFT) +
                    format("" + pds.getPdsData().trim().replace("-", "").replace(".", ""),      100, ' ', Justification.LEFT);
            out.println(s);
        }
    }
}
