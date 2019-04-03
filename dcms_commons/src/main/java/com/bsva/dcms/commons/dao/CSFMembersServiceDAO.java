package com.bsva.dcms.commons.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfMemberServiceDao;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfMemberService;
import com.bsva.entities.CsfMemberServicePK;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CSFMembersServiceDAO{

	private Map<String,Object> map = new HashMap<>();

	//private CsfMemberServiceRepository memberServiceDao = DaoFactory.csfMemberServiceInstance();
	private CsfMemberServiceDao memberServiceDao = new CsfMemberServiceDao();

	
	public CSFMembersServiceDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CSFMemberServiceDTO bean) throws DAOException {

		try {
			CsfMemberService memberService = new CsfMemberService();
			
			CsfMemberServicePK csfMemberServicePK = new CsfMemberServicePK();
			csfMemberServicePK.setBankCode(String.valueOf(bean.getBankCode()));
			csfMemberServicePK.setService(bean.getService());
			csfMemberServicePK.setSubService(bean.getSubService());		
			
			memberService.setCsfMemberServicePK(csfMemberServicePK);
			memberService.setMemberNo(bean.getMemberNo());;
			memberService.setOutputInd(bean.getOutputInd());
			memberService.setMaxSizeTransFile(bean.getMaxSizeTransFile());
			memberService.setMemberTapeId(bean.getMemberTapeid());
			memberService.setAcquirerInd(bean.getAcquirerInd());
			memberService.setIssuerInd(bean.getIssuerInd());
			memberService.setContactName(bean.getContactName());
			memberService.setTitle(bean.getTitle());
			memberService.setBranchCode(bean.getBranchCode());
			memberService.setAccountNumber(bean.getAccountNumber());
			memberService.setMemberAddress1(bean.getMemberAddress1());
			memberService.setMemberAddress2(bean.getMemberAddress2());
			memberService.setMemberAddress3(bean.getMemberAddress3());
			memberService.setMemberAddress4(bean.getMemberAddress4());
			memberService.setCountry(bean.getCountry());
			memberService.setVatRegNumber(bean.getVatRegNumber());
			memberService.setExceptionReportInd(bean.getExceptionReportInd());
			memberService.setCurrencyCodeValidationReq(bean.getCurrencyCodeValidationReq());
			memberService.setInputCharset(bean.getInputCharset());
			memberService.setOutputCharset(bean.getOutputCharset());
			memberService.setHeader01RecordLength(bean.getHeader01RecordLength());
			memberService.setTrailer98RecordLength(bean.getTrailer98RecordLength());
			memberService.setTrailer99RecordLength(bean.getTrailer99RecordLength());
			memberService.setInvoiceNoCcr001(bean.getInvoiceNoCCR001());

			memberServiceDao.create(memberService);

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_MEMBER_SERVICE, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CSFMemberServiceDTO retrieve(CSFMemberServiceDTO bean) throws DAOException {
		CSFMemberServiceDTO cSFMemberServiceDTO = new CSFMemberServiceDTO();
		try {
			String sql = "SELECT c FROM CsfMemberService c "+ buildWhereClause(bean, true);

			CsfMemberService memberService =  memberServiceDao.executeQueryParametersSingleDate(sql, map);
            if(memberService != null){
			if(memberService.getAccountNumber()!=null){
				cSFMemberServiceDTO.setAccountNumber(memberService.getAccountNumber());
			}
			if(memberService.getAcquirerInd()!=null){
				cSFMemberServiceDTO.setAcquirerInd(memberService.getAcquirerInd());
			}
			//	if(memberService.getCsfMemberServicePK().getBankCode()!=null){
			cSFMemberServiceDTO.setBankCode(Integer.valueOf(memberService.getCsfMemberServicePK().getBankCode()));
			//}
			if(memberService.getBranchCode() != null){
				cSFMemberServiceDTO.setBranchCode(memberService.getBranchCode());
			}
			if(memberService.getContactName()!=null){
				cSFMemberServiceDTO.setContactName(memberService.getContactName());
			}
			if(memberService.getCurrencyCodeValidationReq()!=null){
				cSFMemberServiceDTO.setCurrencyCodeValidationReq(memberService.getCurrencyCodeValidationReq());
			}
			if(memberService.getExceptionReportInd()!=null){
				cSFMemberServiceDTO.setExceptionReportInd(memberService.getExceptionReportInd());
			}
			//if(memberService.getHeader01RecordLength()!=null){
			cSFMemberServiceDTO.setHeader01RecordLength(memberService.getHeader01RecordLength());
			//}
			if(memberService.getInputCharset()!=null){
				cSFMemberServiceDTO.setInputCharset(memberService.getInputCharset());
			}
			if(memberService.getInvoiceNoCcr001()!=null){		
				cSFMemberServiceDTO.setInvoiceNoCCR001(memberService.getInvoiceNoCcr001().intValue());
			}
			if(memberService.getIssuerInd()!=null){
				cSFMemberServiceDTO.setIssuerInd(memberService.getIssuerInd());
			}
			if(memberService.getMaxSizeTransFile()!=null){
				cSFMemberServiceDTO.setMaxSizeTransFile(memberService.getMaxSizeTransFile());
			}
			if(memberService.getMemberAddress1()!=null){
				cSFMemberServiceDTO.setMemberAddress1(memberService.getMemberAddress1());
			}
			if(memberService.getMemberAddress2()!=null){
				cSFMemberServiceDTO.setMemberAddress2(memberService.getMemberAddress2());
			}
			if(memberService.getMemberAddress3()!=null){
				cSFMemberServiceDTO.setMemberAddress3(memberService.getMemberAddress3());
			}
			if(memberService.getMemberAddress4()!=null){
				cSFMemberServiceDTO.setMemberAddress4(memberService.getMemberAddress4());
			}
			if(memberService.getMemberNo()!=null){
				cSFMemberServiceDTO.setMemberNo(memberService.getMemberNo());
			}
			if(memberService.getMemberTapeId()!=null){
				cSFMemberServiceDTO.setMemberTapeid(memberService.getMemberTapeId());
			}
			if(memberService.getOutputCharset()!=null){
				cSFMemberServiceDTO.setOutputCharset(memberService.getOutputCharset());
			}
			if(memberService.getOutputInd()!=null){
				cSFMemberServiceDTO.setOutputInd(memberService.getOutputInd());
			}
			if(memberService.getCsfMemberServicePK().getService()!=null){
				cSFMemberServiceDTO.setService(memberService.getCsfMemberServicePK().getService());
			}
			if(memberService.getCsfMemberServicePK().getSubService()!=null){
				cSFMemberServiceDTO.setSubService(memberService.getCsfMemberServicePK().getSubService());
			}
			if(memberService.getTitle()!=null){
				cSFMemberServiceDTO.setTitle(memberService.getTitle());
			}
			//if(memberService.getTrailer98RecordLength()!=null){
			cSFMemberServiceDTO.setTrailer98RecordLength(memberService.getTrailer98RecordLength());
			//}
			//if(memberService.getTrailer99RecordLength()!=null){
			cSFMemberServiceDTO.setTrailer99RecordLength(memberService.getTrailer99RecordLength());
			//}
			if(memberService.getVatRegNumber()!=null){
				cSFMemberServiceDTO.setVatRegNumber(memberService.getVatRegNumber());
			}

			map.clear();
			return cSFMemberServiceDTO;
            }else{
            	return null;
            }

		} catch (Exception ex) {
			throw new DAOException("Error retrieving MemberService, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CSFMemberServiceDTO> retrieveRelated(CSFMemberServiceDTO bean) throws DAOException {
		List<CSFMemberServiceDTO> dtoList = new LinkedList<CSFMemberServiceDTO>();
		CSFMemberServiceDTO cSFMemberServiceDTO = null;
		try {
			String sql = "SELECT c FROM CsfMemberService c "+ buildWhereClause(bean, true);
			List<CsfMemberService> csfmemberService = (List<CsfMemberService>) memberServiceDao.executeQueryParameters(sql,map);

			for (CsfMemberService memberService : csfmemberService) {
				
				cSFMemberServiceDTO = new CSFMemberServiceDTO();
				if(memberService.getAccountNumber()!=null){
					cSFMemberServiceDTO.setAccountNumber(memberService.getAccountNumber());
				}
				if(memberService.getAcquirerInd()!=null){
					cSFMemberServiceDTO.setAcquirerInd(memberService.getAcquirerInd());
				}
				//	if(memberService.getCsfMemberServicePK().getBankCode()!=null){
				cSFMemberServiceDTO.setBankCode(Integer.valueOf(memberService.getCsfMemberServicePK().getBankCode()));
				//}
				if(memberService.getContactName()!=null){
					cSFMemberServiceDTO.setContactName(memberService.getContactName());
				}
				if(memberService.getCurrencyCodeValidationReq()!=null){
					cSFMemberServiceDTO.setCurrencyCodeValidationReq(memberService.getCurrencyCodeValidationReq());
				}
				if(memberService.getExceptionReportInd()!=null){
					cSFMemberServiceDTO.setExceptionReportInd(memberService.getExceptionReportInd());
				}
				//if(memberService.getHeader01RecordLength()!=null){
				cSFMemberServiceDTO.setHeader01RecordLength(memberService.getHeader01RecordLength());
				//}
				if(memberService.getInputCharset()!=null){
					cSFMemberServiceDTO.setInputCharset(memberService.getInputCharset());
				}
				if(memberService.getInvoiceNoCcr001()!=null){		
					cSFMemberServiceDTO.setInvoiceNoCCR001(memberService.getInvoiceNoCcr001().intValue());
				}
				if(memberService.getIssuerInd()!=null){
					cSFMemberServiceDTO.setIssuerInd(memberService.getIssuerInd());
				}
				if(memberService.getMaxSizeTransFile()!=null){
					cSFMemberServiceDTO.setMaxSizeTransFile(memberService.getMaxSizeTransFile());
				}
				if(memberService.getMemberAddress1()!=null){
					cSFMemberServiceDTO.setMemberAddress1(memberService.getMemberAddress1());
				}
				if(memberService.getMemberAddress2()!=null){
					cSFMemberServiceDTO.setMemberAddress2(memberService.getMemberAddress2());
				}
				if(memberService.getMemberAddress3()!=null){
					cSFMemberServiceDTO.setMemberAddress3(memberService.getMemberAddress3());
				}
				if(memberService.getMemberAddress4()!=null){
					cSFMemberServiceDTO.setMemberAddress4(memberService.getMemberAddress4());
				}
				if(memberService.getMemberNo()!=null){
					cSFMemberServiceDTO.setMemberNo(memberService.getMemberNo());
				}
				if(memberService.getMemberTapeId()!=null){
					cSFMemberServiceDTO.setMemberTapeid(memberService.getMemberTapeId());
				}
				if(memberService.getOutputCharset()!=null){
					cSFMemberServiceDTO.setOutputCharset(memberService.getOutputCharset());
				}
				if(memberService.getOutputInd()!=null){
					cSFMemberServiceDTO.setOutputInd(memberService.getOutputInd());
				}
				if(memberService.getCsfMemberServicePK().getService()!=null){
					cSFMemberServiceDTO.setService(memberService.getCsfMemberServicePK().getService());
				}
				if(memberService.getCsfMemberServicePK().getSubService()!=null){
					cSFMemberServiceDTO.setSubService(memberService.getCsfMemberServicePK().getSubService());
				}
				if(memberService.getTitle()!=null){
					cSFMemberServiceDTO.setTitle(memberService.getTitle());
				}
				//if(memberService.getTrailer98RecordLength()!=null){
				cSFMemberServiceDTO.setTrailer98RecordLength(memberService.getTrailer98RecordLength());
				//}
				//if(memberService.getTrailer99RecordLength()!=null){
				cSFMemberServiceDTO.setTrailer99RecordLength(memberService.getTrailer99RecordLength());
				//}
				if(memberService.getVatRegNumber()!=null){
					cSFMemberServiceDTO.setVatRegNumber(memberService.getVatRegNumber());
				}
				dtoList.add(cSFMemberServiceDTO);
			}

			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related MemberService, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CSFMemberServiceDTO bean) throws DAOException {

		CsfMemberService memberService = new CsfMemberService();
		CsfMemberServicePK csfMemberServicePK = new CsfMemberServicePK();

		csfMemberServicePK.setBankCode(String.valueOf(bean.getBankCode()));
		csfMemberServicePK.setService(bean.getService());
		csfMemberServicePK.setSubService(bean.getSubService());		
		
		memberService.setCsfMemberServicePK(csfMemberServicePK);
		memberService.setMemberNo(bean.getMemberNo());;
		memberService.setOutputInd(bean.getOutputInd());
		memberService.setMaxSizeTransFile(bean.getMaxSizeTransFile());
		memberService.setMemberTapeId(bean.getMemberTapeid());
		memberService.setAcquirerInd(bean.getAcquirerInd());
		memberService.setIssuerInd(bean.getIssuerInd());
		memberService.setContactName(bean.getContactName());
		memberService.setTitle(bean.getTitle());
		memberService.setBranchCode(bean.getBranchCode());
		memberService.setAccountNumber(bean.getAccountNumber());
		memberService.setMemberAddress1(bean.getMemberAddress1());
		memberService.setMemberAddress2(bean.getMemberAddress2());
		memberService.setMemberAddress3(bean.getMemberAddress3());
		memberService.setMemberAddress4(bean.getMemberAddress4());
		memberService.setCountry(bean.getCountry());
		memberService.setVatRegNumber(bean.getVatRegNumber());
		memberService.setExceptionReportInd(bean.getExceptionReportInd());
		memberService.setCurrencyCodeValidationReq(bean.getCurrencyCodeValidationReq());
		memberService.setInputCharset(bean.getInputCharset());
		memberService.setOutputCharset(bean.getOutputCharset());
		memberService.setHeader01RecordLength(bean.getHeader01RecordLength());
		memberService.setTrailer98RecordLength(bean.getTrailer98RecordLength());
		memberService.setTrailer99RecordLength(bean.getTrailer99RecordLength());
		memberService.setInvoiceNoCcr001(bean.getInvoiceNoCCR001());

		try {

			memberServiceDao.update(memberService);

		} catch (Exception ex) {
			throw new DAOException( "Error updating MemberService, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CSFMemberServiceDTO bean) throws DAOException {

		try {
			CsfMemberService memberService = new CsfMemberService();
			CsfMemberServicePK csfMemberServicePK = new CsfMemberServicePK();
			csfMemberServicePK.setBankCode(String.valueOf(bean.getBankCode()));
			csfMemberServicePK.setService(bean.getService());
			csfMemberServicePK.setSubService(bean.getSubService());	
			memberService.setCsfMemberServicePK(csfMemberServicePK);
			memberService.setMemberNo(bean.getMemberNo());;
			memberService.setOutputInd(bean.getOutputInd());
			memberService.setMaxSizeTransFile(bean.getMaxSizeTransFile());
			memberService.setMemberTapeId(bean.getMemberTapeid());
			memberService.setAcquirerInd(bean.getAcquirerInd());
			memberService.setIssuerInd(bean.getIssuerInd());
			memberService.setContactName(bean.getContactName());
			memberService.setTitle(bean.getTitle());
			memberService.setBranchCode(bean.getBranchCode());
			memberService.setAccountNumber(bean.getAccountNumber());
			memberService.setMemberAddress1(bean.getMemberAddress1());
			memberService.setMemberAddress2(bean.getMemberAddress2());
			memberService.setMemberAddress3(bean.getMemberAddress3());
			memberService.setMemberAddress4(bean.getMemberAddress4());
			memberService.setCountry(bean.getCountry());
			memberService.setVatRegNumber(bean.getVatRegNumber());
			memberService.setExceptionReportInd(bean.getExceptionReportInd());
			memberService.setCurrencyCodeValidationReq(bean.getCurrencyCodeValidationReq());
			memberService.setInputCharset(bean.getInputCharset());
			memberService.setOutputCharset(bean.getOutputCharset());
			memberService.setHeader01RecordLength(bean.getHeader01RecordLength());
			memberService.setTrailer98RecordLength(bean.getTrailer98RecordLength());
			memberService.setTrailer99RecordLength(bean.getTrailer99RecordLength());
			memberService.setInvoiceNoCcr001(bean.getInvoiceNoCCR001());

			memberServiceDao.delete(memberService);

		} catch (Exception ex) {
			throw new DAOException("Error creating MemberService, cause: "
					+ ex.getMessage(), ex);
		} 
		 
	}

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CSFMemberServiceDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {

		if (bean.getBankCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.csfMemberServicePK.bankCode =:bankCode");
			map.put("bankCode",String.valueOf(bean.getBankCode()));
		}
		if (bean.getService() != null && !bean.getService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.csfMemberServicePK.service =:service");
			map.put("service",bean.getService());
		}
		if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.csfMemberServicePK.subService =:subService");
			map.put("subService",bean.getSubService());
		}
		if (bean.getMemberTapeid() != null && !bean.getMemberTapeid().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.memberTapeId =:memberTapeId");
			map.put("memberTapeId",bean.getMemberTapeid());
		}
		
			if (bean.getMemberNo() != null && !bean.getMemberNo().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.memberNo =:memberNo");
				map.put("memberNo",bean.getMemberNo());
			}
			if (bean.getOutputInd() != null && !bean.getOutputInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.outputInd =:outputInd");
				map.put("outputInd",bean.getOutputInd());
			}
			if (bean.getMaxSizeTransFile() != null && !bean.getMaxSizeTransFile().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.maxSizeTransFile =:maxSizeTransFile");
				map.put("maxSizeTransFile",bean.getMaxSizeTransFile());
			}
			if (bean.getAcquirerInd() != null && !bean.getAcquirerInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.acquirerInd =:acquirerInd");
				map.put("acquirerInd",bean.getAcquirerInd());
			}
			if (bean.getIssuerInd() != null && !bean.getIssuerInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.issuerInd =:issuerInd");
				map.put("issuerInd",bean.getIssuerInd());
			}
			if (bean.getContactName() != null && !bean.getContactName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.contactName =:contactName");
				map.put("contactName",bean.getContactName());
			}
			if (bean.getTitle() != null && !bean.getTitle().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.title =:title");
				map.put("title",bean.getTitle());
			}
			if (bean.getBranchCode() != null && !bean.getBranchCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.branchCode =:branchCode");
				map.put("branchCode",bean.getBranchCode());
			}
			if (bean.getAccountNumber() != null && !bean.getAccountNumber().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.accountNumber =:accountNumber");
				map.put("accountNumber",bean.getAccountNumber());
			}
			if (bean.getMemberAddress1() != null && !bean.getMemberAddress1().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.memberAddress1 =:memberAddress1");
				map.put("memberAddress1",bean.getMemberAddress1());
			}
			if (bean.getMemberAddress2() != null && !bean.getMemberAddress2().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.memberAddress2 =:memberAddress2");
				map.put("memberAddress2",bean.getMemberAddress2());
			}
			if (bean.getMemberAddress3() != null && !bean.getMemberAddress3().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.memberAddress3 =:memberAddress3");
				map.put("memberAddress3",bean.getMemberAddress3());
			}
			if (bean.getMemberAddress4() != null && !bean.getMemberAddress4().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.memberAddress4 =:memberAddress4");
				map.put("memberAddress4",bean.getMemberAddress4());
			}
			if (bean.getCountry() != null && !bean.getCountry().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.country =:country");
				map.put("country",bean.getCountry());
			}
			if (bean.getVatRegNumber() != null && !bean.getVatRegNumber().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.vatRegNumber =:vatRegNumber");
				map.put("vatRegNumber",bean.getVatRegNumber());
			}
			if (bean.getExceptionReportInd() != null && !bean.getExceptionReportInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.exceptionReportInd =:exceptionReportInd");
				map.put("exceptionReportInd",bean.getExceptionReportInd());
			}
			if (bean.getCurrencyCodeValidationReq() != null && !bean.getCurrencyCodeValidationReq().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.currencyCodeValidationReq =:currencyCodeValidationReq");
				map.put("currencyCodeValidationReq",bean.getCurrencyCodeValidationReq());
			}
			if (bean.getInputCharset() != null && !bean.getInputCharset().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.inputCharset =:inputCharset");
				map.put("inputCharset",bean.getInputCharset());
			}
			if (bean.getOutputCharset() != null && !bean.getOutputCharset().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.outputCharset =:outputCharset");
				map.put("outputCharset",bean.getOutputCharset());
			}
			if (bean.getHeader01RecordLength() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.header01RecordLength =:header01RecordLength");
				map.put("header01RecordLength",String.valueOf(bean.getHeader01RecordLength()));
			}
			if (bean.getTrailer98RecordLength() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.trailer98RecordLength =:trailer98RecordLength");
				map.put("trailer98RecordLength",String.valueOf(bean.getTrailer98RecordLength()));
			}
			if (bean.getTrailer99RecordLength() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.trailer99RecordLength =:trailer99RecordLength");
				map.put("trailer99RecordLength",String.valueOf(bean.getTrailer99RecordLength()));
			}
			if (bean.getInvoiceNoCCR001() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.invoiceNoCcr001 =:invoiceNoCcr001");
				map.put("invoiceNoCcr001",String.valueOf(bean.getInvoiceNoCCR001()));
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows  MemberService");
		}
		return buff.toString();
	}

}
