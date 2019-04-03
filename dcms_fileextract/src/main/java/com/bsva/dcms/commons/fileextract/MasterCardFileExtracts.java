package com.bsva.dcms.commons.fileextract;

import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dao.CsoPaymentInstructionsMcardDAO;
import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMasterCardRecord;
import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMcardDTO;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
import com.bsva.dcms.commons.dto.file.FileEOS98RecordDTO;
import com.bsva.dcms.commons.dto.file.FileTrailer91_92RecordDTO;
import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
import com.bsva.dcms.commons.dto.file.MastercardFileDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

/**
 *
 * @author SimphiweT
 */
public class MasterCardFileExtracts extends FileExtracter {

    private static String logPGM = "EXTRACT";
    private static Logger log = Logger.getLogger(MasterCardFileExtracts.class);
    private CSOTransactionDTO csoTransaction;
    private MastercardFileDTO mastercardFileDTO;
    private CsoPaymentInstructionsMcardDTO csoPaymentInstructionMcardDTO;
    private List<FileTrailer91_92RecordDTO> fileTrailer91_92RecordList;
    private List<FileTransactionRecordDTO> fileTransactionRecordDtoList;
    private CsoOutputControlsDTO csoOutputControlsDTO;
    private CsoScheduledProcessesDTO csoScheduledProcessesDTO;
    private static final String EOD_PROCESS_NAME = "EOD";
    private int maxLines = 0;
    private List<CsoPaymentInstructionsMcardDTO> paymentInstructionList = new ArrayList<>();

    MasterCardFileExtracts() {
        this.csoTransaction = new CSOTransactionDTO();
        this.mastercardFileDTO = new MastercardFileDTO();
        this.csoPaymentInstructionMcardDTO = new CsoPaymentInstructionsMcardDTO();
        this.fileTrailer91_92RecordList = new ArrayList<>();
        this.fileTransactionRecordDtoList = new ArrayList<>();
        this.csoOutputControlsDTO = new CsoOutputControlsDTO();
        this.csoScheduledProcessesDTO = new CsoScheduledProcessesDTO();
    }

    private boolean isEndOfDay() throws DAOException {

        CsoScheduledProcessesDAO csoScheduledProcessesDAO = new CsoScheduledProcessesDAO();
        CsoScheduledProcessesDTO csoScheduledProcessesDto = new CsoScheduledProcessesDTO();
        csoScheduledProcessesDto.setProcessName(EOD_PROCESS_NAME);
        List<CsoScheduledProcessesDTO> csoScheduledProcessesDTOList = csoScheduledProcessesDAO.retrieveRelated(csoScheduledProcessesDto);

        for (CsoScheduledProcessesDTO csoScheduledProcessesDTO : csoScheduledProcessesDTOList) {
            String processName = csoScheduledProcessesDTO.getProcessName();
            String activeIndicator = csoScheduledProcessesDTO.getActiveIndicator();

            if (processName.equals(EOD_PROCESS_NAME) && activeIndicator.equals("Y")) {
                return true;
            } else {
                return false;
            }

        }

        return false;
    }

    public void buildMasterCard(List<CsoInputFileControlsDTO> csoInputFCList) throws DAOException, Exception, ParseException {

        for (CsoInputFileControlsDTO csoInputFC : csoInputFCList) {
            try {
                CsoOutputControlsDAO csoOutputControlsDAO = new CsoOutputControlsDAO();
                CsoOutputControlsDTO csoOutputControlsDtos = new CsoOutputControlsDTO();
                csoOutputControlsDtos.setFullFileInd(isEndOfDay() ? "N" : "F");
                csoOutputControlsDtos.setSubService("MASTERCARD");
                List<CsoOutputControlsDTO> csoOutputControlsDTOList = csoOutputControlsDAO.retrieveRelated(csoOutputControlsDtos);
                if (csoOutputControlsDTOList.size() > 0) {
                    //get transactions for csoInputFC file
                   // FileAXSHeaderRecordDTO header01 = createAXSHeaderRecord(csoInputFC,mastercardFileDTO);
                    //mastercardFileDTO.setFileAXSHeaderRecordDto(header01);
                    //IPMTrailer1644
                    // IPMFileTrailorDTO ipmFileTrailor = createTrailer1644(csoInputFC);
                    // mastercardFileDTO.setIpmFileTrailorDto(ipmFileTrailor);
                    // 98 Record
                    FileEOS98RecordDTO oS98RecordDto = createEOS98Record(csoInputFC);
                    mastercardFileDTO.setFileEOS98RecordDto(oS98RecordDto);

                    //End Of File 99
                    FileAXSTrailorRecordDTO eof99 = createEOF99Record(csoInputFC);
                    mastercardFileDTO.setFileAxsTrailorRecordDto(eof99);

                    String value = csoInputFC.getFileRefNumber();
                    String fileName = value.substring(0, 8);

                    try {
                        createExtractionFiles(csoOutputControlsDTOList, csoInputFC);
                        Utils.updateProcess(logPGM, fileName, csoInputFC.getService(), csoInputFC.getSubService(), Status.C.getSymbol());
                    } catch (Exception ex) {
                        Utils.updateProcess(logPGM, fileName, csoInputFC.getService(), csoInputFC.getSubService(), Status.F.getSymbol());
                    }
                }
            } catch (Exception ex) {
                ex.getMessage();                
            }
        }
    }

    public void extractFilesAtEOD(List<CsoPaymentInstructionsMcardDTO> paymentInstructionList, CsoInputFileControlsDTO csoInputFC, List<CsoOutputControlsDTO> csoOutputControlsDTOList) throws DAOException, IOException {

        CsoScheduledProcessesDAO csoScheduledProcessesDAO = new CsoScheduledProcessesDAO();
        List<CsoScheduledProcessesDTO> csoScheduledProcessesDTOList = csoScheduledProcessesDAO.retrieveRelated(csoScheduledProcessesDTO);

        for (CsoScheduledProcessesDTO csoScheduledProcessesDTO : csoScheduledProcessesDTOList) {

            String processName = csoScheduledProcessesDTO.getProcessName();
            String activeIndicator = csoScheduledProcessesDTO.getActiveIndicator();

            if (processName.equals("EOD") && activeIndicator.equals("Y")) {

                if (csoPaymentInstructionMcardDTO != null) {
                    createExtractionFiles(csoOutputControlsDTOList, csoInputFC);
                }
            }
        }
    }

    public void createExtractionFiles(List<CsoOutputControlsDTO> csoOutputControlsDTOList, CsoInputFileControlsDTO csoInputFC) throws DAOException, FileNotFoundException, IOException {
        
        CsoPaymentInstructionsMasterCardRecord instructionsMasterCard = new CsoPaymentInstructionsMasterCardRecord();

        for (CsoOutputControlsDTO controlsDTO : csoOutputControlsDTOList) {            
                CsoPaymentInstructionsMcardDTO csoPaymentInstructionsMcardDto = new CsoPaymentInstructionsMcardDTO();
                CsoPaymentInstructionsMcardDAO dao = new CsoPaymentInstructionsMcardDAO();
                csoPaymentInstructionsMcardDto.setFilenameDescription(controlsDTO.getFilenameDescription());                
                List<CsoPaymentInstructionsMcardDTO> csoPaymentInstructionsMcardList = dao.retrieveRelated(csoPaymentInstructionsMcardDto);
                if(csoPaymentInstructionsMcardList.size() > 0){
                String fileName = controlsDTO.getFilenameDescription();
                Utils.logSpolog("Writing MasterCard File ",EOD_PROCESS_NAME);

                InputStream is = new FileInputStream(BsvTableLookup.getInstance().getAppsDir() + File.separator + "dcms-pattern-mapping.xml");
                StreamFactory factory = StreamFactory.newInstance();
                factory.load(is);

                BeanWriter beanWriter = factory.createWriter("dmcsTransactionStream", new File(BsvTableLookup.getInstance().getSendDir() + File.separator + fileName));
                File outputFileName = new File(BsvTableLookup.getInstance().getSendDir() + File.separator + fileName);

                writeHeader(beanWriter);
                writeBody(csoPaymentInstructionsMcardList, beanWriter, instructionsMasterCard, outputFileName.getName());
                mastercardFileDTO.getFileAxsTrailorRecordDto().setNumberOfRecords(String.valueOf(controlsDTO.getRecordCount()));
                mastercardFileDTO.getFileAxsTrailorRecordDto().setMacOfHashTotal(String.valueOf(controlsDTO.getRecordCount()));
                mastercardFileDTO.getFileAxsTrailorRecordDto().setHashtotalOfAccountNumbers(String.valueOf(controlsDTO.getHashTotal99()));
                writeTrailer(beanWriter);
                is.close();
                log.debug(controlsDTO.getFilenameDescription() + "Extracted Successfully");

                csoTransaction.setExtractInd("E");
                Utils.logSpolog(fileName + " Updated Extract Indicator to:  " + csoTransaction.getExtractInd() + " after successful extract ",EOD_PROCESS_NAME);
                controlsDTO.setStatusCode("C");
                Utils.logSpolog(fileName + "Updated status to " + controlsDTO.getStatusCode() + " on cso Output  file control",EOD_PROCESS_NAME);
                Utils.logSpolog("Log extracted file to Delivery",EOD_PROCESS_NAME);
                Utils.logDelDelivery(controlsDTO.getFilenameDescription(), "O", controlsDTO.getBankCode(), Status.Y.getSymbol());
                Utils.logSpolog("Successfully extracted MasterCard with FileName: " + fileName,EOD_PROCESS_NAME);   
               }
        }
    }

    public void writeHeader(BeanWriter writer) {
        getFileDto().getFileAXSHeaderRecordDto().setSubServiceType("MASTERCARD");
        mastercardFileDTO.getFileAXSHeaderRecordDto().setSubServiceType("MASTERCARD");

        writer.write("fileAXSHeaderRecordDTOX", getFileDto().getFileAXSHeaderRecordDto());
        log.debug(getFileDto().getFileAXSHeaderRecordDto());
    }

    public void writeBody(List<CsoPaymentInstructionsMcardDTO> paymentInstructionList, BeanWriter writer, CsoPaymentInstructionsMasterCardRecord instructionsMasterCard, String fileName) throws DAOException {
    	CsoPaymentInstructionsMcardDAO payMcardDao = new CsoPaymentInstructionsMcardDAO();
        Integer recordCounter = 0;

        for (int x = 0; x < paymentInstructionList.size(); x++) {
            //record counter value used for the total number of extracted transactions
            recordCounter++;
            instructionsMasterCard.setFilerefnumber1("05");
            instructionsMasterCard.setSeqno(paymentInstructionList.get(x).getRecordId());
            instructionsMasterCard.setServicecode(paymentInstructionList.get(x).getServiceCode());
            instructionsMasterCard.setPrimarybitmap(paymentInstructionList.get(x).getPrimaryBitmap());
            instructionsMasterCard.setSecondarybitmap(paymentInstructionList.get(x).getPrimaryBitmap());
            instructionsMasterCard.setMessagetypeindicator(paymentInstructionList.get(x).getMessageTypeIndicator()); //MTI 
            instructionsMasterCard.setTransactionamount(paymentInstructionList.get(x).getP4TransactionAmount());
            instructionsMasterCard.setAcquirermember(paymentInstructionList.get(x).getAcquirerMember());
            instructionsMasterCard.setIssuermember(paymentInstructionList.get(x).getIssuerMember());
            instructionsMasterCard.setMessagereasoncode(paymentInstructionList.get(x).getP25MessageReasonCode());
            instructionsMasterCard.setRetrievalrefnumber(paymentInstructionList.get(x).getP37RetrievalRefNumber());
            instructionsMasterCard.setCardacceptorbuscode(paymentInstructionList.get(x).getP26CardAcceptorBusCode());
            instructionsMasterCard.setApprovalcode(paymentInstructionList.get(x).getP38ApprovalCode());
            instructionsMasterCard.setRecordid(paymentInstructionList.get(x).getRecordId());
            instructionsMasterCard.setTransactioncode(paymentInstructionList.get(x).getTransactionCode());
            instructionsMasterCard.setCardtype(Integer.valueOf(paymentInstructionList.get(x).getCardType()));
            instructionsMasterCard.setIcclength(paymentInstructionList.get(x).getP55IccLength());
            instructionsMasterCard.setIccsystemrelateddata(paymentInstructionList.get(x).getP55IccSystemRelatedData());
            instructionsMasterCard.setPanlength(paymentInstructionList.get(x).getP2PanLength());
            instructionsMasterCard.setPan(paymentInstructionList.get(x).getP2Pan());
            instructionsMasterCard.setLocaldate(String.valueOf(paymentInstructionList.get(x).getP12LocalDate()));
            instructionsMasterCard.setLocaltime(String.valueOf(paymentInstructionList.get(x).getP13LocalTime()));
            instructionsMasterCard.setPointofsaledata(paymentInstructionList.get(x).getP22PointOfSaleData());
            instructionsMasterCard.setCardacceptorterminalid(paymentInstructionList.get(x).getP41CardAcceptorTerminalId());
            instructionsMasterCard.setCardacceptorid(paymentInstructionList.get(x).getP42CardAcceptorId());
            instructionsMasterCard.setForwardinginstlength(String.valueOf(paymentInstructionList.get(x).getP33ForwardingInstLength()));
            instructionsMasterCard.setForwardinginstcode(String.valueOf(paymentInstructionList.get(x).getP33ForwardingInstCode()));
            instructionsMasterCard.setFunctioncode(String.valueOf(paymentInstructionList.get(x).getP24FunctionCode()));
            instructionsMasterCard.setAcquirerreflength(String.valueOf(paymentInstructionList.get(x).getP31AcquirerRefLength()));
            instructionsMasterCard.setAcquirerrefdata(paymentInstructionList.get(x).getP31AcquirerRefData());
            instructionsMasterCard.setCode(String.valueOf(paymentInstructionList.get(x).getP40ServiceCode()));
            instructionsMasterCard.setCardacceptorlength(String.valueOf(paymentInstructionList.get(x).getP43CardAcceptorLength()));
            instructionsMasterCard.setCardacceptorname(paymentInstructionList.get(x).getP43CardAcceptorName());
            instructionsMasterCard.setAdditionaldatalength(String.valueOf(paymentInstructionList.get(x).getP48AdditionalDataLength()));
            instructionsMasterCard.setAdditionaldata(paymentInstructionList.get(x).getP48AdditionalData());
            instructionsMasterCard.setCurrencycode(String.valueOf(paymentInstructionList.get(x).getP49CurrencyCode()));
            instructionsMasterCard.setReconcilliationcode(String.valueOf(paymentInstructionList.get(x).getP50ReconcilliationCode()));
            instructionsMasterCard.setMessagenumber(String.valueOf(paymentInstructionList.get(x).getS71MessageNumber()));
            instructionsMasterCard.setCashbackpurchaseamnt(4100);
            instructionsMasterCard.setSubservicename("MASTERCARD");
            instructionsMasterCard.setFileid(paymentInstructionList.get(x).getFilenameDescription());
            instructionsMasterCard.setS127networkdata(paymentInstructionList.get(x).getS127NetworkData());
            //instructionsMasterCard.setS127_ADD_LEN();
            instructionsMasterCard.setS125addlen(paymentInstructionList.get(x).getS125AddLen());
            instructionsMasterCard.setS125additionaldata(paymentInstructionList.get(x).getS125AdditionalData());
            instructionsMasterCard.setS124addlen(paymentInstructionList.get(x).getS124AddLen());
            instructionsMasterCard.setS124additionaldata(paymentInstructionList.get(x).getS124AdditionalData());
            instructionsMasterCard.setS123addlen(paymentInstructionList.get(x).getS123AddLen());
            instructionsMasterCard.setS123additionaldata(paymentInstructionList.get(x).getS123AdditionalData());
            instructionsMasterCard.setS111amtcurrencyconversion(paymentInstructionList.get(x).getS111AmtCurrencyConversion());
            instructionsMasterCard.setS111len(paymentInstructionList.get(x).getS111Length());
            instructionsMasterCard.setS99settlementinstidcode(paymentInstructionList.get(x).getS99SettlementInstIdCode());
            instructionsMasterCard.setS98payee(paymentInstructionList.get(x).getS98Payee());
            instructionsMasterCard.setS97netsettlementamount(paymentInstructionList.get(x).getS97NetSettlementAmount());
            instructionsMasterCard.setS96messagesecuritycode(paymentInstructionList.get(x).getS96MessageSecurityCode());
            /*instructionsMasterCard.setS95_CARD_ISSUER_REF_DATA(Integer.valueOf(paymentInstructionList.get(x).getS95CardIssuerRefData()));
             instructionsMasterCard.setS95_CARD_ISS_REF_DATA_LENGTH(paymentInstructionList.get(x).getS95CardIssRefDataLength());
             instructionsMasterCard.setS94_LENGTH(paymentInstructionList.get(x).getS94Length());
             instructionsMasterCard.setS94_TRANSACTION_ORIG_INST_ID(Long.valueOf(paymentInstructionList.get(x).getS94TransactionOrigInstId()));
             instructionsMasterCard.setS93_LENGTH(paymentInstructionList.get(x).getS93Length());
             instructionsMasterCard.setS93_TRANSACTION_DEST_INST_ID(paymentInstructionList.get(x).getS93TransactionDestInstId());*/
            instructionsMasterCard.setS92filessecuritycode(paymentInstructionList.get(x).getS92FilesSecurityCode());
            instructionsMasterCard.setS91fileupdatecode(paymentInstructionList.get(x).getS91FileUpdateCode());
            instructionsMasterCard.setS90originatingdataelements(paymentInstructionList.get(x).getS90OriginatingDataElements());
            instructionsMasterCard.setS89reversalamountdebits(paymentInstructionList.get(x).getS89ReversalAmountDebits());
            instructionsMasterCard.setS88amountdebits(paymentInstructionList.get(x).getS88AmountDebits());
            instructionsMasterCard.setS87reversalamountcredits(paymentInstructionList.get(x).getS87ReversalAmountCredits());
            instructionsMasterCard.setS86amountcredits(String.valueOf(paymentInstructionList.get(x).getS86AmountCredits()));
            instructionsMasterCard.setS85transctionfeeamounts(String.valueOf(paymentInstructionList.get(x).getS85TransctionFeeAmounts()));
            instructionsMasterCard.setS84processingfeedebits(String.valueOf(paymentInstructionList.get(x).getS84ProcessingFeeDebits()));
            instructionsMasterCard.setS83transactionfeecredits(String.valueOf(paymentInstructionList.get(x).getS83TransactionFeeCredits()));
            instructionsMasterCard.setS82processingfeecredits(String.valueOf(paymentInstructionList.get(x).getS82ProcessingFeeCredits()));
            instructionsMasterCard.setS81numberauthorisations(String.valueOf(paymentInstructionList.get(x).getS81NumberAuthorisations()));
            instructionsMasterCard.setS80numberenquiries(String.valueOf(paymentInstructionList.get(x).getS80NumberEnquiries()));
            instructionsMasterCard.setS79reversalnumbertransfers(String.valueOf(paymentInstructionList.get(x).getS79ReversalNumberTransfers()));
            instructionsMasterCard.setS78numbertransfers(String.valueOf(paymentInstructionList.get(x).getS78NumberTransfers()));
            instructionsMasterCard.setS77reversalnoofdebits(String.valueOf(paymentInstructionList.get(x).getS77ReversalNoOfDebits()));
            instructionsMasterCard.setS76noofdebits(String.valueOf(paymentInstructionList.get(x).getS76NoOfDebits()));
            instructionsMasterCard.setS75reversalnoofcredits(String.valueOf(paymentInstructionList.get(x).getS75ReversalNoOfCredits()));
            instructionsMasterCard.setS74noofcredits(String.valueOf(paymentInstructionList.get(x).getS74NoOfCredits()));
            instructionsMasterCard.setS73actiondate(String.valueOf(paymentInstructionList.get(x).getS73ActionDate()));
            instructionsMasterCard.setS72datalen(paymentInstructionList.get(x).getS72DataLen());
            instructionsMasterCard.setS72datarecord(paymentInstructionList.get(x).getS72DataRecord());
            //nstructionsMasterCard.setS70_NETWORK_MAN_COUNTRY_CODE(paymentInstructionList.get(x).getS70NetworkManCountryCode());
            writer.write(instructionsMasterCard);
            paymentInstructionList.get(x).setProcessStatus(Status.C.getSymbol());
            payMcardDao.update((CsoPaymentInstructionsMcardDTO) paymentInstructionList);

        }
       
        mastercardFileDTO.getFileAxsTrailorRecordDto().setNumberOfRecords(String.valueOf(recordCounter));
        CsoOutputControlsDTO csoOutputControlsdtos = new CsoOutputControlsDTO();
        csoOutputControlsdtos.setFilenameDescription(fileName);
        CsoOutputControlsDTO csoOutputControl = new CsoOutputControlsDAO().retrieve(csoOutputControlsdtos);

        if (csoOutputControl != null) {
            csoOutputControl.setFullFileInd(Status.C.getSymbol());
            csoOutputControl.setStatusCode(Status.C.getSymbol());
            new CsoOutputControlsDAO().update(csoOutputControl);
        }
        
    }

    public void writeTrailer(BeanWriter writer) {

        writer.write("fileEOS98RecordTrailerX", mastercardFileDTO.getFileEOS98RecordDto());
        log.debug(mastercardFileDTO.getFileEOS98RecordDto());
        writer.write("fileAXSTrailorRecordDTOX", mastercardFileDTO.getFileAxsTrailorRecordDto());
        log.debug(mastercardFileDTO.getFileAxsTrailorRecordDto());

        writer.close();
    }

    public List<CsoPaymentInstructionsMcardDTO> getPaymentInstructionList() {
        return paymentInstructionList;
    }

    public void setPaymentInstructionList(List<CsoPaymentInstructionsMcardDTO> paymentInstructionList) {
        this.paymentInstructionList = paymentInstructionList;
    }

}
