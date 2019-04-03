//package com.bsva.dmcs.reports;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import com.bsva.dcms.commons.dto.CSFBINTotalsDTO;
//import com.bsva.dcms.commons.dto.CSFBinsDTO;
//import com.bsva.dcms.commons.dto.SiteControlsDTO;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.DateUtil;
//import com.bsva.dcms.commons.util.Utils;
//import java.io.File;
//
//public class CSRBINS implements DMCSReportInterface{
//
//	private ReportUtils ru = null;
//	private BsvTableLookup bsvTableInstance = BsvTableLookup.getInstance();
//	private List<String> reportNames;
//	private SiteControlsDTO siteControlsDTO = null;
//
//	public CSRBINS(){
//
//		this.ru = ReportUtils.getInstance(bsvTableInstance.getProcessDate());
//		this.reportNames = new ArrayList<String>();
//	}
//
//	public void build() throws Exception{
//
//		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
//        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
//        Document doc = docBuilder.newDocument();
//
//        Transformer trans = TransformerFactory.newInstance().newTransformer();
//        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//        trans.setOutputProperty(OutputKeys.INDENT, "yes");
//
//        String companyName = bsvTableInstance.getCompanyName();
//        String companyReportName = bsvTableInstance.getFullReportName();
//        String companyRegNo = bsvTableInstance.getRegistrationNumber();
//
//        siteControlsDTO = bsvTableInstance.getSiteControls().get("CCCD");
//
//        String siteName = siteControlsDTO.getSiteName();
//
//        String procDate = bsvTableInstance.getProcessDate();
//        String procDateStr = procDate.substring(0,4) + File.separator + procDate.substring(4,6) +  File.separator + procDate.substring(6);
//
//        String fileName = null;
//
//        String binNo = "";
//        String binDescription = "";
//        int bankCode = 0;
//        int currBankCode = 0;
//        String bankName = "";
//        String cardType = "";
//        String cardDescription = "";
//        String delDate = "";
//        String finalDelDate = "";
//        int daysToFirstDel = 0;
//        int daysToFinalDel = 0;
//        String binActiveInd = "";
//        long limit1 = 0;
//        long limit2 = 0;
//        long floorLimit = 0;
//        String acqIssBoth = "";
//        int monthUntilDeletion = 0;
//
//        Element compName = doc.createElement("companyName");
//        compName.appendChild(ru.getTextEl(doc,companyName));
//        Element compReportName = doc.createElement("companyReportName");
//        compReportName.appendChild(ru.getTextEl(doc,companyReportName));
//        Element compRegNo = doc.createElement("CompanyRegNumber");
//        compRegNo.appendChild(ru.getTextEl(doc,companyRegNo));
//        Element siteNameEl = doc.createElement("siteName");
//        siteNameEl.appendChild(ru.getTextEl(doc,siteName));
//
//        Element procDateEl = null;
//
//        procDateEl = doc.createElement("processDate");
//        procDateEl.appendChild(ru.getTextEl(doc,procDateStr));
//
//        Element csrbinRootEl = ru.getNewEl(doc, null, "csrbinRoot");
//        csrbinRootEl.appendChild(compName);
//        csrbinRootEl.appendChild(compReportName);
//        csrbinRootEl.appendChild(compRegNo);
//        csrbinRootEl.appendChild(procDateEl);
//        csrbinRootEl.appendChild(siteNameEl);
//
//        Element csrbinTotalEl = ru.getNewEl(doc, null, "csrbinTotals");
//
//        Element binTotNo = ru.getNewEl(doc, null, "totalNumberOfBins");
//        Element binDeleted = ru.getNewEl(doc, null, "numberOfBinsDeleted");
//        Element binDeleteCycle = ru.getNewEl(doc, null, "numberOfBinsInDeleteCycle");
//        Element binSetForDeletion = ru.getNewEl(doc, null, "numberOfBinsSetForDelete");
//        Element binActiveNumber = ru.getNewEl(doc, null, "numberOfBinsActive");
//
//        CSFBINTotalsDTO binTotals = bsvTableInstance.getCsfBinTotals();
//
//        int tempNumber = binTotals.getTotalNumber();
//        binTotNo.appendChild(ru.getTextEl(doc, Utils.formatInteger(tempNumber,8)));
//
//        tempNumber = binTotals.getFinallyDel();
//        binDeleted.appendChild(ru.getTextEl(doc, Utils.formatInteger(tempNumber,8)));
//
//        tempNumber  = binTotals.getDelCycle();
//        binDeleteCycle.appendChild(ru.getTextEl(doc, Utils.formatInteger(tempNumber,8)));
//
//        tempNumber = binTotals.getToBeDeleted();
//        binSetForDeletion.appendChild(ru.getTextEl(doc, Utils.formatInteger(tempNumber,8)));
//
//        tempNumber = binTotals.getActBins();
//        binActiveNumber.appendChild(ru.getTextEl(doc, Utils.formatInteger(tempNumber,8)));
//
//        csrbinTotalEl.appendChild(binTotNo);
//        csrbinTotalEl.appendChild(binDeleted);
//        csrbinTotalEl.appendChild(binDeleteCycle);
//        csrbinTotalEl.appendChild(binSetForDeletion);
//        csrbinTotalEl.appendChild(binActiveNumber);
//        binTotNo = null;
//        binDeleted = null;
//        binDeleteCycle = null;
//        binSetForDeletion = null;
//        binActiveNumber = null;
//
//        csrbinRootEl.appendChild(csrbinTotalEl);
//        csrbinTotalEl = null;
//
//        Element binReportEl = ru.getNewEl(doc, null, "binReport");
//        Element bankBinsEl = null; // = ru.getNewEl(doc, null, "bankBinDetails");
//        Element bankNumberEl = null;
//        Element bankNameEl = null;
//        Element bankMonthToDelEl = null;
//
//        Element binDetailsEl = null;
//        Element binNumberEl = null;
//        Element binDescriptionEl = null;
//        Element binCardType = null;
//        Element binCardDescription = null;
//        Element binDeletionDateEl = null;
//        Element binFinalDelDateEl = null;
//        Element binDaysToFirstDelEl = null;
//        Element binDaysToFinalDelEl = null;
//        Element binActiveIndEl = null;
//        Element binLimit1El = null;
//        Element binLimit2El = null;
//        Element binFloorLimitEl = null;
//        Element binAcqIssBothEl = null;
//
//        Collection<CSFBinsDTO> bins = bsvTableInstance.getCsfBins().values();
//
//
//
//        for(CSFBinsDTO bin : bins){
//
//        	binNo = bin.getBinNo();
//        	binDescription = bin.getBinDescription();
//        	bankCode = bin.getBankCode();
//        	bankName = bin.getBankName();
//        	cardType = bin.getCardType();
//        	cardDescription = bin.getCardDescription();
//        	delDate = DateUtil.formatDate(bin.getFirstDeletionDate(), "YYYYMMDD");
//        	finalDelDate = DateUtil.formatDate(bin.getFinalDeletionDate(),  "YYYYMMDD");
//        	daysToFirstDel = bin.getDaysBeforeFirstDeletionDate();
//        	daysToFinalDel = bin.getDaysBeforeFinalDeletionDate();
//        	binActiveInd = bin.getActiveInd();
//        	limit1 = (long) bin.getLimit1();
//        	limit2 = (long) bin.getLimit2();
//        	floorLimit = (long) bin.getFloorLimit();
//        	acqIssBoth = bin.getAcqIssBoth();
//        	monthUntilDeletion = bin.getMonthUntilDeletion();
//
//        	 if (bankCode != currBankCode) {
//                 if (bankBinsEl != null) {
//                     binReportEl.appendChild(bankBinsEl);
//                     bankBinsEl = null;
//                 }
//
//
//             bankBinsEl = ru.getNewEl(doc, null, "bankBinDetails");
//             bankNumberEl = ru.getNewEl(doc, null, "bankCode");
//             bankNumberEl.appendChild(ru.getTextEl(doc,bankCode + ""));
//             bankBinsEl.appendChild(bankNumberEl);
//             bankNumberEl = null;
//
//             bankNameEl = ru.getNewEl(doc, null, "bankName");
//             bankNameEl.appendChild(ru.getTextEl(doc,bankName));
//             bankBinsEl.appendChild(bankNameEl);
//             bankNameEl = null;
//
//             bankMonthToDelEl = ru.getNewEl(doc, null, "monthsUntilDeletion");
//             bankMonthToDelEl.appendChild(ru.getTextEl(doc,monthUntilDeletion + ""));
//             bankBinsEl.appendChild(bankMonthToDelEl);
//             bankMonthToDelEl = null;
//
//             currBankCode = bankCode;
//        }
//
//             binDetailsEl = ru.getNewEl(doc, null, "binDetails");
//
//             binNumberEl = ru.getNewEl(doc, null, "binNumber");
//             binNumberEl.appendChild(ru.getTextEl(doc,binNo));
//             binDetailsEl.appendChild(binNumberEl);
//             binNumberEl = null;
//
//             binDescriptionEl = ru.getNewEl(doc, null, "binDescription");
//             binDescriptionEl.appendChild(ru.getTextEl(doc,binDescription));
//             binDetailsEl.appendChild(binDescriptionEl);
//             binDescriptionEl = null;
//
//             binCardType = ru.getNewEl(doc, null, "binCardType");
//             binCardType.appendChild(ru.getTextEl(doc,cardType + ""));
//             binDetailsEl.appendChild(binCardType);
//             binCardType = null;
//
//             binCardDescription = ru.getNewEl(doc, null, "binCardDescription");
//             binCardDescription.appendChild(ru.getTextEl(doc,cardDescription));
//             binDetailsEl.appendChild(binCardDescription);
//             binCardDescription = null;
//
//             binDeletionDateEl = ru.getNewEl(doc, null, "binDeletionDate");
//             binDeletionDateEl.appendChild(ru.getTextEl(doc,delDate));
//             binDetailsEl.appendChild(binDeletionDateEl);
//             binDeletionDateEl = null;
//
//             binFinalDelDateEl = ru.getNewEl(doc, null, "binFinalDeletionDate");
//             binFinalDelDateEl.appendChild(ru.getTextEl(doc,finalDelDate));
//             binDetailsEl.appendChild(binFinalDelDateEl);
//             binFinalDelDateEl = null;
//
//             binDaysToFirstDelEl = ru.getNewEl(doc, null, "binDaysToDeletionDate");
//             binDaysToFirstDelEl.appendChild(ru.getTextEl(doc,daysToFirstDel + ""));
//             binDetailsEl.appendChild(binDaysToFirstDelEl);
//             binDaysToFirstDelEl = null;
//
//             binDaysToFinalDelEl = ru.getNewEl(doc, null, "binDaysToFinalDeletionDate");
//             binDaysToFinalDelEl.appendChild(ru.getTextEl(doc,daysToFinalDel + ""));
//             binDetailsEl.appendChild(binDaysToFinalDelEl);
//             binDaysToFinalDelEl = null;
//
//             binActiveIndEl = ru.getNewEl(doc, null, "binActiveIndicator");
//             binActiveIndEl.appendChild(ru.getTextEl(doc,binActiveInd));
//             binDetailsEl.appendChild(binActiveIndEl);
//             binActiveIndEl = null;
//
//
//             binLimit1El = ru.getNewEl(doc, null, "binLimit1");
//             binLimit1El.appendChild(ru.getTextEl(doc, Utils.formatAmount(limit1,10)));
//             binDetailsEl.appendChild(binLimit1El);
//             binLimit1El = null;
//
//             binLimit2El = ru.getNewEl(doc, null, "binLimit2");
//             binLimit2El.appendChild(ru.getTextEl(doc, Utils.formatAmount(limit2,10)));
//             binDetailsEl.appendChild(binLimit2El);
//             binLimit2El = null;
//
//             binFloorLimitEl = ru.getNewEl(doc, null, "binFloorLimit");
//             binFloorLimitEl.appendChild(ru.getTextEl(doc, Utils.formatAmount(floorLimit,10)));
//             binDetailsEl.appendChild(binFloorLimitEl);
//             binFloorLimitEl = null;
//
//             if (acqIssBoth.equals("I")) {
//                 acqIssBoth = "Issuing";
//             }
//             if (acqIssBoth.equals("A")) {
//                 acqIssBoth = "Acquiring";
//             }
//             if (acqIssBoth.equals("B")) {
//                 acqIssBoth = "Both";
//             }
//             binAcqIssBothEl = ru.getNewEl(doc, null, "binIssuerAcquirerBoth");
//             binAcqIssBothEl.appendChild(ru.getTextEl(doc,acqIssBoth));
//             binDetailsEl.appendChild(binAcqIssBothEl);
//             binAcqIssBothEl = null;
//
//             bankBinsEl.appendChild(binDetailsEl);
//             binDetailsEl = null;
//         }
//         csrbinRootEl.appendChild(binReportEl);
//
//         doc.appendChild(csrbinRootEl);
//
//         Date dNow = new Date();
//
//         fileName = "CSRBIN." + procDate + "." + DateUtil.formatDate(dNow, "hhmmss") + ".xml";
//
//         ru.writeReport(doc,csrbinRootEl,fileName,reportNames);
//       }
//
//
//
//	 @Override
//	public void printTextFile() throws Exception {
//		 DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);
//	     new Thread(xml2txtLst).start();
//	}
//
//	@Override
//	public List<String> getListOfReportNames() {
//		// TODO Auto-generated method stub
//		return reportNames;
//	}
//
//}
