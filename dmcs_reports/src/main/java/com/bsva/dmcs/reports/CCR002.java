//package com.bsva.dmcs.reports;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import com.bsva.dcms.commons.dao.CSFSubServicesDAO;
//import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
//import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
//import com.bsva.dcms.commons.dto.views.CsvCcr002ViewDto;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.views.CsvCcr002View;
//
//
//
//
//public class CCR002 implements DMCSReportInterface {
//
//	private ReportUtils ru = null;
//	private BsvTableLookup bsvTableInstance = BsvTableLookup.getInstance();
//	private List<String> reportNames;
//	private List<CsvCcr002ViewDto> dtoList = null;
//	private List<CSFMemberServiceDTO> csfMemberServiceList = null;
//
//	public CCR002(){
//
//		this.ru = ReportUtils.getInstance();
//		this.reportNames = new ArrayList<String>();
//		this.dtoList = new ArrayList<CsvCcr002ViewDto>();
//		this.csfMemberServiceList = BsvTableLookup.getInstance().getCsfMemberService();
//	}
//
//	public void getSubService() throws Exception{
//
//		try {
//
//			CSFSubServicesDTO subServiceDto = new CSFSubServicesDTO();
//			CSFSubServicesDAO csfSubServicesdao = new CSFSubServicesDAO();
//			List<CSFSubServicesDTO> subServiceList = csfSubServicesdao.retrieveRelated(subServiceDto);
//
//			for(CSFSubServicesDTO serviceDto : subServiceList){
//
//				if (serviceDto!=null){
//					String subService = serviceDto.getSubservice();
//
//					if (subService.equals("VISA CARD") || subService.equals("MASTERCARD") && serviceDto.getActiveIndicator().equals("Y")) {
//						build(subService);
//					}
//
//				}
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//
//	public void build(String subService) throws Exception{
//
//		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
//		Document doc = docBuilder.newDocument();
//
//		Transformer trans = TransformerFactory.newInstance().newTransformer();
//		trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//		trans.setOutputProperty(OutputKeys.INDENT, "yes");
//
//		String companyName = bsvTableInstance.getCompanyName();
//		String companyRegNo = bsvTableInstance.getRegistrationNumber();
//
//		String procDate = bsvTableInstance.getProcessDate();
//		String procDateStr = procDate.substring(0,4) + '/' + procDate.substring(4,6) +  '/' + procDate.substring(6);
//
//		Date dNow;
//		SimpleDateFormat ft = new SimpleDateFormat ("hhmmssSS");
//
//		String fileName = null;
//
//		String acqName = null;
//		int issCode = 0;
//		int currIss = 0;
//		double issFees = 0;
//		double acqFees = 0;
//		double nettFee = 0;
//		double total = 0;
//		long invoiceNumber = 0;
//		Element issEl = null;
//		Element reportContentEl = null;
//		Element fromBankEl = null;
//		Element procDateEl = null;
//		Element totalFeeEl = null;
//
//
//		CsvCcr002View csvCCR002View = new CsvCcr002View();
//		dtoList = csvCCR002View.execute();
//
//		for (CsvCcr002ViewDto dto : dtoList){
//
//			if (dto !=null){
//
//				issCode = dto.getIssuerBankCode();
//				acqName = dto.getAcquirerMember();
//				issFees = dto.getIssuerFees();
//				acqFees = dto.getAcquirerFees();
//				nettFee = dto.getNettFees();
//				invoiceNumber = dto.getInvoiceNumber();
//
//				if (issCode != currIss) {
//					if (issEl != null) {
//						totalFeeEl = doc.createElement("totalFee");
//						totalFeeEl.appendChild(ru.getTextEl(doc, Utils.formatAmount(total,15)));
//						reportContentEl.appendChild(totalFeeEl);
//						total = 0;
//						issEl.appendChild(reportContentEl);
//						doc.appendChild(issEl);
//						dNow = new Date();
//						/* fileName = "CCR002" + subService.charAt(0) + "." +
//	                                Utils.padZeroLeft(currIss + "", 4) + "." +
//	                                ft.format(dNow) + ".xml";*/
//						fileName = "CCR002."  + subService.charAt(0) + procDate + "." + Utils.padZeroLeft(currIss + "", 4) +  ft.format(dNow) + ".xml";
//						reportNames = ru.writeReport(doc, reportContentEl, fileName, reportNames);
//						// ru.writeReport(doc,issEl,fileName,reportNames);
//						doc = null;
//						issEl = null;
//						reportContentEl = null;
//					}
//					doc = docBuilder.newDocument();
//					issEl = ru.getNewEl(doc, issEl, "toBank");
//					Element issDetails = getBankDetails(doc, issCode, "TO", subService);
//					issEl.appendChild(issDetails);
//
//					Element compName = doc.createElement("companyName");
//					compName.appendChild(ru.getTextEl(doc,companyName));
//
//					Element compRegNo = doc.createElement("CompanyRegNumber");
//					compRegNo.appendChild(ru.getTextEl(doc,companyRegNo));
//
//					Element subServEl = doc.createElement("subService");
//					subServEl.appendChild(ru.getTextEl(doc,subService));
//
//					Element invEl = doc.createElement("invoiceNumber");
//					invEl.appendChild(ru.getTextEl(doc,invoiceNumber + ""));
//
//
//					procDateEl = doc.createElement("processDate");
//					procDateEl.appendChild(ru.getTextEl(doc,procDateStr));
//
//					issEl.appendChild(compName);
//					issEl.appendChild(compRegNo);
//					issEl.appendChild(procDateEl);
//					issEl.appendChild(invEl);
//					issEl.appendChild(subServEl);
//
//					reportContentEl = ru.getNewEl(doc,reportContentEl,"reportContent");
//					currIss = issCode;
//
//					doc.appendChild(reportContentEl);
//				}
//
//				fromBankEl = ru.getNewEl(doc, fromBankEl, "fromBank");
//				Element fromBankNameEl = doc.createElement("fromBankName");
//
//				fromBankNameEl.appendChild(ru.getTextEl(doc, acqName));
//				Element fromBankAcqFeeEl = doc.createElement("fromAcqFee");
//
//				fromBankAcqFeeEl.appendChild(ru.getTextEl(doc, Utils.formatAmount(acqFees,15)));
//				Element fromBankIssFeeEl = doc.createElement("fromIssFee");
//
//				fromBankIssFeeEl.appendChild(ru.getTextEl(doc, Utils.formatAmount(issFees,15)));
//				Element fromBankNettFeeEl = doc.createElement("fromNettFee");
//
//				fromBankNettFeeEl.appendChild(ru.getTextEl(doc, Utils.formatAmount(nettFee,15)));
//				total = total + nettFee;
//				fromBankEl.appendChild(fromBankNameEl);
//				fromBankEl.appendChild(fromBankAcqFeeEl);
//				fromBankEl.appendChild(fromBankIssFeeEl);
//				fromBankEl.appendChild(fromBankNettFeeEl);
//				reportContentEl.appendChild(fromBankEl);
//				fromBankEl = null;
//			}
//
//		}
//
//		if (issEl != null) {
//			totalFeeEl = doc.createElement("totalFee");
//			totalFeeEl.appendChild(ru.getTextEl(doc, Utils.formatAmount(total,15)));
//			reportContentEl.appendChild(totalFeeEl);
//			total = 0;
//			issEl.appendChild(reportContentEl);
//			doc.appendChild(issEl);
//			dNow = new Date();
//			/* fileName = "CCR002" + subService.charAt(0) + "." +
//                            Utils.padZeroLeft(currIss + "", 4) + "." +
//                            ft.format(dNow) + ".xml";*/
//			fileName = "CCR002."  + subService.charAt(0) + procDate + "." + Utils.padZeroLeft(currIss + "", 4) +  ft.format(dNow) + ".xml";
//			reportNames = ru.writeReport(doc, reportContentEl, fileName, reportNames);
//			//     ru.writeReport(doc,issEl,fileName,reportNames);
//			doc = null;
//			issEl = null;
//			reportContentEl = null;
//		}
//
//	}
//
//	public Element getBankDetails(Document doc,int bankCode,String toFromBank,String subService) {
//
//		Element returnEl = doc.createElement("TO");
//		try {
//
//			HashMap<?, ?> memDets = getBankAddres();
//
//
//			Element branchCode = doc.createElement("Branch");
//			branchCode.appendChild(ru.getTextEl(doc, (String)memDets.get("branch_code")));
//			returnEl.appendChild(branchCode);
//
//
//			Element accNo = doc.createElement("AccountNo");
//			accNo.appendChild(ru.getTextEl(doc, (String)memDets.get("account_no")));
//			returnEl.appendChild(accNo);
//
//			Element contactName = doc.createElement("contactName");
//			contactName.appendChild(ru.getTextEl(doc, (String)memDets.get("contact_name")));
//			returnEl.appendChild(contactName);
//
//
//			Element add1 = doc.createElement("Address1");
//			add1.appendChild(ru.getTextEl(doc, (String)memDets.get("mem_address1")));
//			returnEl.appendChild(add1);
//
//
//			Element add2 = doc.createElement("Address2");
//			add2.appendChild(ru.getTextEl(doc, (String)memDets.get("mem_address2")));
//			returnEl.appendChild(add2);
//
//
//			Element add3 = doc.createElement("Address3");
//			add3.appendChild(ru.getTextEl(doc, (String)memDets.get("mem_address3")));
//			returnEl.appendChild(add3);
//
//
//			Element add4 = doc.createElement("Address4");
//			add4.appendChild(ru.getTextEl(doc, (String)memDets.get("mem_address4")));
//			returnEl.appendChild(add4);
//
//
//			Element vatReg = doc.createElement("VatRegNo");
//			vatReg.appendChild(ru.getTextEl(doc, (String)memDets.get("vat_reg_no")));
//			returnEl.appendChild(vatReg);
//
//			doc.appendChild(returnEl);
//
//			memDets = null;
//
//		} catch (Exception ex) {
//
//			return null;
//		}
//		return returnEl;
//	}
//
//	public HashMap<String, String> getBankAddres() throws Exception {
//
//		HashMap<String,String> retHM = new HashMap<String,String>();
//
//		List<CSFMemberServiceDTO> dtolist = buildBankAddresReference();
//
//		for(CSFMemberServiceDTO dto : dtolist){
//
//			if (dto!=null) {
//				retHM.put("branch_code",  dto.getBranchCode());
//				retHM.put("account_no", dto.getAccountNumber());
//				retHM.put("contact_name", dto.getContactName());
//				retHM.put("mem_address1", dto.getMemberAddress1());
//				retHM.put("mem_address2", dto.getMemberAddress2());
//				retHM.put("mem_address3", dto.getMemberAddress3());
//				retHM.put("mem_address4", dto.getMemberAddress4());
//				retHM.put("vat_reg_no",   dto.getVatRegNumber());
//
//			} else {
//				retHM.put("branch_code", " ");
//				retHM.put("account_no", " ");
//				retHM.put("contact_name", " ");
//				retHM.put("mem_address1", " ");
//				retHM.put("mem_address2", " ");
//				retHM.put("mem_address3", " ");
//				retHM.put("mem_address4", " ");
//				retHM.put("vat_reg_no", " ");
//			}
//		}
//
//		return retHM;
//	}
//
//	public List<CSFMemberServiceDTO> buildBankAddresReference() throws DAOException{
//
//		for(CSFMemberServiceDTO csfMemberService : csfMemberServiceList){
//
//			if (csfMemberService!=null){
//
//				csfMemberService.getBankCode();
//				csfMemberService.getBranchCode();
//				csfMemberService.getAccountNumber();
//				csfMemberService.getContactName();
//				csfMemberService.getMemberAddress1();
//				csfMemberService.getMemberAddress2();
//				csfMemberService.getMemberAddress3();
//				csfMemberService.getMemberAddress4();
//				csfMemberService.getVatRegNumber();
//			}
//		}
//		return csfMemberServiceList;
//
//	}
//
//	@Override
//	public void printTextFile() throws Exception {
//		DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);
//		new Thread(xml2txtLst).start();
//	}
//
//	@Override
//	public List<String> getListOfReportNames() {
//		// TODO Auto-generated method stub
//		return reportNames;
//	}
//}