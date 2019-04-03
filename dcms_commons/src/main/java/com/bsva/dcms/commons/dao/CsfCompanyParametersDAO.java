package com.bsva.dcms.commons.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfCompanyParametersDao;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfCompanyParameters;

/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfCompanyParametersDAO {
	
	private CsfCompanyParametersDao csfCompanyParametersDao = new CsfCompanyParametersDao();
	private Map<String,Object>map = new HashMap<String, Object>();

	public CsfCompanyParametersDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CsfCompanyParametersDTO bean) throws DAOException {

		try {

			CsfCompanyParameters csfCompanyParameters = new CsfCompanyParameters();

			csfCompanyParameters.setCompanyName(bean.getCompanyName());
			csfCompanyParameters.setCompanyNameAbrev(bean.getCompanyNameAbrev());
			csfCompanyParameters.setFullReportName(bean.getFullReportName());
			csfCompanyParameters.setAddress1(bean.getAddress1());
			csfCompanyParameters.setAddress2(bean.getAddress2());
			csfCompanyParameters.setAddress3(bean.getAddress3());
			csfCompanyParameters.setDiallingCode(bean.getDiallingCode());
			csfCompanyParameters.setTelephoneNumber1(bean.getTelephoneNumber1());
			csfCompanyParameters.setFaxCode(bean.getFaxCode());
			csfCompanyParameters.setFaxNumber(bean.getFaxNumber());
			csfCompanyParameters.setEmailAddress(bean.getEmailAddress());
			csfCompanyParameters.setRegistrationNumber(bean.getRegistrationNumber());
			csfCompanyParameters.setVatNumber(bean.getVatNumber());
			csfCompanyParameters.setContactName(bean.getContactName());
			csfCompanyParameters.setInvoiceNumber(bean.getInvoiceNumber());
			csfCompanyParameters.setInvoiceDate(bean.getInvoiceDate());
			csfCompanyParameters.setPreviousInvoiceNumber(bean.getPreviousInvoiceNumber());
			csfCompanyParameters.setVatPercent((short) bean.getVatPercent());
			csfCompanyParameters.setTestLiveIndicator(bean.getTestLiveIndicator());
			csfCompanyParameters.setCreatedBy(bean.getCreatedBy());
			csfCompanyParameters.setCreatedDate(bean.getCreatedDate());
			csfCompanyParameters.setModifiedBy(bean.getModifiedBy());
			csfCompanyParameters.setModifiedDate(bean.getModifiedDate());
			csfCompanyParameters.setValidationCode(bean.getValidationCode());
			csfCompanyParameters.setInstitutionCode(bean.getInstitutionCode());
			csfCompanyParameters.setCurrencyCode(bean.getCurrencyCode());
			csfCompanyParameters.setInputRecordLength((short) bean.getInputRecordLength());
			csfCompanyParameters.setInputId(bean.getInputId());
			csfCompanyParameters.setPrepCode((short) bean.getPrepCode());
			csfCompanyParameters.setSeqNo(bean.getSeqNo());
			csfCompanyParameters.setCurrencyCodeNumber((short) bean.getCurrencyCodeNumber());
			csfCompanyParameters.setFleetTxBindTime((short) bean.getFleetTxBindTime());
			csfCompanyParameters.setTieredCutOff(bean.getTieredCutOff());

			csfCompanyParametersDao.create(csfCompanyParameters);


		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_COMPANY_PARAMETERS, cause: "
					+ ex.getMessage(), ex);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfCompanyParametersDTO retrieve(CsfCompanyParametersDTO bean) throws DAOException {
		try{
			CsfCompanyParametersDTO csfCompanyParametersd;
			String sql = "SELECT c FROM CsfCompanyParameters c "+ buildWhereClause(bean, true);
			CsfCompanyParameters csfCompanyParameters =  csfCompanyParametersDao.executeQueryParametersSingle(sql,map);
			csfCompanyParametersd = new CsfCompanyParametersDTO();

			if(csfCompanyParameters.getCompanyName() != null){
				csfCompanyParametersd.setCompanyName(csfCompanyParameters.getCompanyName());
			}
			if(csfCompanyParameters.getCompanyNameAbrev() != null){
				csfCompanyParametersd.setCompanyNameAbrev(csfCompanyParameters.getCompanyNameAbrev());
			}
			if(csfCompanyParameters.getFullReportName() != null){
				csfCompanyParametersd.setFullReportName(csfCompanyParameters.getFullReportName());
			}
			if(csfCompanyParameters.getAddress1() != null){
				csfCompanyParametersd.setAddress1(csfCompanyParameters.getAddress1());
			}
			if(csfCompanyParameters.getAddress2() != null){
				csfCompanyParametersd.setAddress2(csfCompanyParameters.getAddress2());
			}
			if(csfCompanyParameters.getAddress3() != null){
				csfCompanyParametersd.setAddress3(csfCompanyParameters.getAddress3());
			}
			if(csfCompanyParameters.getDiallingCode() != null){
				csfCompanyParametersd.setDiallingCode(csfCompanyParameters.getDiallingCode());
			}
			if(csfCompanyParameters.getTelephoneNumber1() != null){
				csfCompanyParametersd.setTelephoneNumber1(csfCompanyParameters.getTelephoneNumber1());
			}
			if(csfCompanyParameters.getFaxCode() != null){
				csfCompanyParametersd.setFaxCode(csfCompanyParameters.getFaxCode());
			}
			if(csfCompanyParameters.getFaxNumber() != null){
				csfCompanyParametersd.setFaxNumber(csfCompanyParameters.getFaxNumber());
			}
			if(csfCompanyParameters.getEmailAddress() != null){
				csfCompanyParametersd.setEmailAddress(csfCompanyParameters.getEmailAddress());
			}
			if(csfCompanyParameters.getRegistrationNumber() != null){
				csfCompanyParametersd.setRegistrationNumber(csfCompanyParameters.getRegistrationNumber());
			}
			if(csfCompanyParameters.getVatNumber() != null){
				csfCompanyParametersd.setVatNumber(csfCompanyParameters.getVatNumber());
			}
			if(csfCompanyParameters.getContactName() != null){
				csfCompanyParametersd.setContactName(csfCompanyParameters.getContactName());
			}
			if(csfCompanyParameters.getInvoiceNumber() != null){
				csfCompanyParametersd.setInvoiceNumber(csfCompanyParameters.getInvoiceNumber());
			}
			if(csfCompanyParameters.getInvoiceDate() != null){
				csfCompanyParametersd.setInvoiceDate(csfCompanyParameters.getInvoiceDate());
			}
			if(csfCompanyParameters.getPreviousInvoiceNumber() != null){
				csfCompanyParametersd.setPreviousInvoiceNumber(csfCompanyParameters.getPreviousInvoiceNumber());
			}
			csfCompanyParametersd.setVatPercent(csfCompanyParameters.getVatPercent());
			if(csfCompanyParameters.getTestLiveIndicator() != null){
				csfCompanyParametersd.setTestLiveIndicator(csfCompanyParameters.getTestLiveIndicator());
			}
			if(csfCompanyParameters.getCreatedBy() != null){
				csfCompanyParametersd.setCreatedBy(csfCompanyParameters.getCreatedBy());
			}
			if(csfCompanyParameters.getCreatedDate() != null){
				csfCompanyParametersd.setCreatedDate(csfCompanyParameters.getCreatedDate());
			}
			if(csfCompanyParameters.getModifiedBy() != null){
				csfCompanyParametersd.setModifiedBy(csfCompanyParameters.getModifiedBy());
			}
			if(csfCompanyParameters.getModifiedDate() != null){
				csfCompanyParametersd.setModifiedDate(csfCompanyParameters.getModifiedDate());
			}
			if(csfCompanyParameters.getValidationCode() != null){
				csfCompanyParametersd.setValidationCode(csfCompanyParameters.getValidationCode());
			}
			if(csfCompanyParameters.getInstitutionCode() != null){
				csfCompanyParametersd.setInstitutionCode(csfCompanyParameters.getInstitutionCode());
			}
			if(csfCompanyParameters.getCurrencyCode() != null){
				csfCompanyParametersd.setCurrencyCode(csfCompanyParameters.getCurrencyCode());
			}
			csfCompanyParametersd.setInputRecordLength(csfCompanyParameters.getInputRecordLength());
			if(csfCompanyParameters.getInputId() != null){
				csfCompanyParametersd.setInputId(csfCompanyParameters.getInputId());
			}
			if(csfCompanyParameters.getPrepCode() != null){
				csfCompanyParametersd.setPrepCode(csfCompanyParameters.getPrepCode());
			}
			if(csfCompanyParameters.getSeqNo()  != null){
				csfCompanyParametersd.setSeqNo(csfCompanyParameters.getSeqNo());
			}
			if(csfCompanyParameters.getCurrencyCodeNumber()  != null){
				csfCompanyParametersd.setCurrencyCodeNumber(csfCompanyParameters.getCurrencyCodeNumber());
			}
			if(csfCompanyParameters.getFleetTxBindTime() != null){
				csfCompanyParametersd.setFleetTxBindTime(csfCompanyParameters.getFleetTxBindTime());
			}
			if(csfCompanyParameters.getTieredCutOff()  != null){
				csfCompanyParametersd.setTieredCutOff(csfCompanyParameters.getTieredCutOff());
			}
			map.clear();
			return csfCompanyParametersd;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsfCompanyParameters, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsfCompanyParametersDTO> retrieveRelated(CsfCompanyParametersDTO bean) throws DAOException {
		List<CsfCompanyParametersDTO> dtoList = new LinkedList<CsfCompanyParametersDTO>();
		CsfCompanyParametersDTO csfCompanyParametersd = null;
		try {
			String sql = "SELECT c FROM CsfCompanyParameters c "+ buildWhereClause(bean, true);
			List<CsfCompanyParameters> csfCompanyParametersRelated = csfCompanyParametersDao.executeQueryParameters(sql,map);

			for (CsfCompanyParameters csfCompanyParameters : csfCompanyParametersRelated) {
				
				csfCompanyParametersd = new CsfCompanyParametersDTO();

				if(csfCompanyParameters.getCompanyName() != null){
					csfCompanyParametersd.setCompanyName(csfCompanyParameters.getCompanyName());
				}
				if(csfCompanyParameters.getCompanyNameAbrev() != null){
					csfCompanyParametersd.setCompanyNameAbrev(csfCompanyParameters.getCompanyNameAbrev());
				}
				if(csfCompanyParameters.getFullReportName() != null){
					csfCompanyParametersd.setFullReportName(csfCompanyParameters.getFullReportName());
				}
				if(csfCompanyParameters.getAddress1() != null){
					csfCompanyParametersd.setAddress1(csfCompanyParameters.getAddress1());
				}
				if(csfCompanyParameters.getAddress2() != null){
					csfCompanyParametersd.setAddress2(csfCompanyParameters.getAddress2());
				}
				if(csfCompanyParameters.getAddress3() != null){
					csfCompanyParametersd.setAddress3(csfCompanyParameters.getAddress3());
				}
				if(csfCompanyParameters.getDiallingCode() != null){
					csfCompanyParametersd.setDiallingCode(csfCompanyParameters.getDiallingCode());
				}
				if(csfCompanyParameters.getTelephoneNumber1() != null){
					csfCompanyParametersd.setTelephoneNumber1(csfCompanyParameters.getTelephoneNumber1());
				}
				if(csfCompanyParameters.getFaxCode() != null){
					csfCompanyParametersd.setFaxCode(csfCompanyParameters.getFaxCode());
				}
				if(csfCompanyParameters.getFaxNumber() != null){
					csfCompanyParametersd.setFaxNumber(csfCompanyParameters.getFaxNumber());
				}
				if(csfCompanyParameters.getEmailAddress() != null){
					csfCompanyParametersd.setEmailAddress(csfCompanyParameters.getEmailAddress());
				}
				if(csfCompanyParameters.getRegistrationNumber() != null){
					csfCompanyParametersd.setRegistrationNumber(csfCompanyParameters.getRegistrationNumber());
				}
				if(csfCompanyParameters.getVatNumber() != null){
					csfCompanyParametersd.setVatNumber(csfCompanyParameters.getVatNumber());
				}
				if(csfCompanyParameters.getContactName() != null){
					csfCompanyParametersd.setContactName(csfCompanyParameters.getContactName());
				}
				if(csfCompanyParameters.getInvoiceNumber() != null){
					csfCompanyParametersd.setInvoiceNumber(csfCompanyParameters.getInvoiceNumber());
				}
				if(csfCompanyParameters.getInvoiceDate() != null){
					csfCompanyParametersd.setInvoiceDate(csfCompanyParameters.getInvoiceDate());
				}
				if(csfCompanyParameters.getPreviousInvoiceNumber() != null){
					csfCompanyParametersd.setPreviousInvoiceNumber(csfCompanyParameters.getPreviousInvoiceNumber());
				}
				csfCompanyParametersd.setVatPercent(csfCompanyParameters.getVatPercent());
				if(csfCompanyParameters.getTestLiveIndicator() != null){
					csfCompanyParametersd.setTestLiveIndicator(csfCompanyParameters.getTestLiveIndicator());
				}
				if(csfCompanyParameters.getCreatedBy() != null){
					csfCompanyParametersd.setCreatedBy(csfCompanyParameters.getCreatedBy());
				}
				if(csfCompanyParameters.getCreatedDate() != null){
					csfCompanyParametersd.setCreatedDate(csfCompanyParameters.getCreatedDate());
				}
				if(csfCompanyParameters.getModifiedBy() != null){
					csfCompanyParametersd.setModifiedBy(csfCompanyParameters.getModifiedBy());
				}
				if(csfCompanyParameters.getModifiedDate() != null){
					csfCompanyParametersd.setModifiedDate(csfCompanyParameters.getModifiedDate());
				}
				if(csfCompanyParameters.getValidationCode() != null){
					csfCompanyParametersd.setValidationCode(csfCompanyParameters.getValidationCode());
				}
				if(csfCompanyParameters.getInstitutionCode() != null){
					csfCompanyParametersd.setInstitutionCode(csfCompanyParameters.getInstitutionCode());
				}
				if(csfCompanyParameters.getCurrencyCode() != null){
					csfCompanyParametersd.setCurrencyCode(csfCompanyParameters.getCurrencyCode());
				}
				csfCompanyParametersd.setInputRecordLength(csfCompanyParameters.getInputRecordLength());
				if(csfCompanyParameters.getInputId() != null){
					csfCompanyParametersd.setInputId(csfCompanyParameters.getInputId());
				}
				if(csfCompanyParameters.getPrepCode() != null){
					csfCompanyParametersd.setPrepCode(csfCompanyParameters.getPrepCode());
				}
				if(csfCompanyParameters.getSeqNo()  != null){
					csfCompanyParametersd.setSeqNo(csfCompanyParameters.getSeqNo());
				}
				if(csfCompanyParameters.getCurrencyCodeNumber()  != null){
					csfCompanyParametersd.setCurrencyCodeNumber(csfCompanyParameters.getCurrencyCodeNumber());
				}
				if(csfCompanyParameters.getFleetTxBindTime() != null){
					csfCompanyParametersd.setFleetTxBindTime(csfCompanyParameters.getFleetTxBindTime());
				}
				if(csfCompanyParameters.getTieredCutOff()  != null){
					csfCompanyParametersd.setTieredCutOff(csfCompanyParameters.getTieredCutOff());
				}

				dtoList.add(csfCompanyParametersd);
			}
		}
		catch(Exception ex) {
			throw new DAOException("Error retrieving CSF_COMPANY_PARAMETERS entries, cause: " + ex.getMessage(), ex);
		}
		map.clear();
		return dtoList;

	}


	public void update(CsfCompanyParametersDTO bean) throws DAOException {
		try{

			CsfCompanyParameters csfCompanyParameters = new CsfCompanyParameters();

			csfCompanyParameters.setCompanyName(bean.getCompanyName());
			csfCompanyParameters.setCompanyNameAbrev(bean.getCompanyNameAbrev());
			csfCompanyParameters.setFullReportName(bean.getFullReportName());
			csfCompanyParameters.setAddress1(bean.getAddress1());
			csfCompanyParameters.setAddress2(bean.getAddress2());
			csfCompanyParameters.setAddress3(bean.getAddress3());
			csfCompanyParameters.setDiallingCode(bean.getDiallingCode());
			csfCompanyParameters.setTelephoneNumber1(bean.getTelephoneNumber1());
			csfCompanyParameters.setFaxCode(bean.getFaxCode());
			csfCompanyParameters.setFaxNumber(bean.getFaxNumber());
			csfCompanyParameters.setEmailAddress(bean.getEmailAddress());
			csfCompanyParameters.setRegistrationNumber(bean.getRegistrationNumber());
			csfCompanyParameters.setVatNumber(bean.getVatNumber());
			csfCompanyParameters.setContactName(bean.getContactName());
			csfCompanyParameters.setInvoiceNumber(bean.getInvoiceNumber());
			csfCompanyParameters.setInvoiceDate(bean.getInvoiceDate());
			csfCompanyParameters.setPreviousInvoiceNumber(bean.getPreviousInvoiceNumber());
			csfCompanyParameters.setVatPercent((short) bean.getVatPercent());
			csfCompanyParameters.setTestLiveIndicator(bean.getTestLiveIndicator());
			csfCompanyParameters.setCreatedBy(bean.getCreatedBy());
			csfCompanyParameters.setCreatedDate(bean.getCreatedDate());
			csfCompanyParameters.setModifiedBy(bean.getModifiedBy());
			csfCompanyParameters.setModifiedDate(bean.getModifiedDate());
			csfCompanyParameters.setValidationCode(bean.getValidationCode());
			csfCompanyParameters.setInstitutionCode(bean.getInstitutionCode());
			csfCompanyParameters.setCurrencyCode(bean.getCurrencyCode());
			csfCompanyParameters.setInputRecordLength((short) bean.getInputRecordLength());
			csfCompanyParameters.setInputId(bean.getInputId());
			csfCompanyParameters.setPrepCode((short) bean.getPrepCode());
			csfCompanyParameters.setSeqNo(bean.getSeqNo());
			csfCompanyParameters.setCurrencyCodeNumber((short) bean.getCurrencyCodeNumber());
			csfCompanyParameters.setFleetTxBindTime((short) bean.getFleetTxBindTime());
			csfCompanyParameters.setTieredCutOff(bean.getTieredCutOff());

			csfCompanyParametersDao.update(csfCompanyParameters);

		} catch (Exception ex) {
			throw new DAOException( "Error updating CCCOWNER.CSF_COMPANY_PARAMETERS, cause: "
					+ ex.getMessage(), ex);
		} 
	}


	private String buildWhereClause(CsfCompanyParametersDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return " ";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {
			
			if (bean.getSeqNo() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.seqNo = :seqNo");	 
				map.put("seqNo", String.valueOf(bean.getSeqNo()));

			}
			if (bean.getCompanyName() != null && !bean.getCompanyName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.companyName = :companyName");
				map.put("companyName", bean.getCompanyName());

			}
			if (bean.getCompanyNameAbrev() != null && !bean.getCompanyNameAbrev().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.companyNameAbrev = :companyNameAbrev");
				map.put("companyNameAbrev",bean.getCompanyNameAbrev());

			}
			if (bean.getFullReportName() != null && !bean.getFullReportName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.fullReportName = :fullReportName");
				map.put("fullReportName", bean.getFullReportName());

			}
			if (bean.getAddress1() != null && !bean.getAddress1().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.address1 = :address1");
				map.put("address1",bean.getAddress1());


			}
			if (bean.getAddress2() != null && !bean.getAddress2().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.address2 = :address2");
				map.put("address2", bean.getAddress2());

			}
			if (bean.getAddress3() != null && !bean.getAddress3().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.address3 = :address3");
				map.put("address3", bean.getAddress3());

			}
			if (bean.getDiallingCode() != null && !bean.getDiallingCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.diallingCode = :diallingCode");
				map.put("diallingCode", bean.getDiallingCode());

			}
			if (bean.getTelephoneNumber1() != null && !bean.getTelephoneNumber1().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.telephoneNumber1 = :telephoneNumber1");
				map.put("telephoneNumber1", bean.getTelephoneNumber1());

			}
			if (bean.getFaxCode() != null && !bean.getFaxCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.faxCode = :faxCode");
				map.put("faxCode",bean.getFaxCode());

			}
			if (bean.getFaxNumber() != null && !bean.getFaxNumber().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.faxNumber = :faxNumber");
				map.put("faxNumber", bean.getFaxNumber());

			}
			if (bean.getEmailAddress() != null && !bean.getEmailAddress().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.emailAddress = :emailAddress");
				map.put("emailAddress", bean.getEmailAddress());
			}
			if (bean.getRegistrationNumber() != null && !bean.getRegistrationNumber().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.registrationNumber = :registrationNumber");
				map.put("registrationNumber", bean.getRegistrationNumber());

			}
			if (bean.getVatNumber() != null && !bean.getVatNumber().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.vatNumber = :vatNumber");
				map.put("vatNumber", bean.getVatNumber());
			}
			if (bean.getContactName() != null && !bean.getContactName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.contactName = :contactName");
				map.put("contactName", bean.getContactName());

			}
			if (bean.getInvoiceNumber() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.invoiceNumber = :invoiceNumber");
				map.put("invoiceNumber", String.valueOf(bean.getInvoiceNumber()));
			}
			if (bean.getInvoiceDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.invoiceDate = :invoiceDate");
				map.put("invoiceDate", String.valueOf(bean.getInvoiceDate()));

			}
			if (bean.getPreviousInvoiceNumber() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.previousInvoiceNumber = :previousInvoiceNumber");
				map.put("previousInvoiceNumber", String.valueOf(bean.getPreviousInvoiceNumber()));
			}
			if (bean.getVatPercent() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.vatPercent = :vatPercent");
				map.put("vatPercent", String.valueOf(bean.getVatPercent()));

			}
			if (bean.getTestLiveIndicator() != null && !bean.getTestLiveIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.testLiveIndicator = :testLiveIndicator");
				map.put("testLiveIndicator", bean.getTestLiveIndicator());
			}
			if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.createdBy=:"+bean.getCreatedBy());

			}
			if (bean.getCreatedDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.createdDate = :createdDate");
				map.put("createdDate",String.valueOf(bean.getCreatedDate()));

			}
			if (bean.getModifiedBy() != null && !bean.getModifiedBy().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.modifiedBy = :modifiedBy");
				map.put("modifiedBy", bean.getModifiedBy());

			}
			if (bean.getModifiedDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.modifiedDate = :modifiedDate");
				map.put("modifiedDate", String.valueOf(bean.getModifiedDate()));
			}
			if (bean.getValidationCode() != null && !bean.getValidationCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.validationCode = :validationCode");
				map.put("validationCode", bean.getValidationCode());

			}
			if (bean.getInstitutionCode() != null && !bean.getInstitutionCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.institutionCode = :institutionCode");
				map.put("institutionCode", bean.getInstitutionCode());
			}
			if (bean.getCurrencyCode() != null && !bean.getCurrencyCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.currencyCode = :currencyCode");
				map.put("currencyCode", bean.getCurrencyCode());
			}
			if (bean.getInputRecordLength() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.inputRecordLength = :inputRecordLength");
				map.put("inputRecordLength", String.valueOf(bean.getInputRecordLength()));

			}
			if (bean.getInputId() != null && !bean.getInputId().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.inputId = :inputId");
				map.put("inputId", bean.getInputId());
			}
			if (bean.getPrepCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.prepCode = :prepCode");
				map.put("prepCode", String.valueOf(bean.getPrepCode()));
			}
			if (bean.getCurrencyCodeNumber() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.currencyCodeNumber = :currencyCodeNumber");
				map.put("currencyCodeNumber", String.valueOf(bean.getCurrencyCodeNumber()));

			}
			if (bean.getFleetTxBindTime() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.fleetTxBindTime = :fleetTxBindTime");
				map.put("fleetTxBindTime", String.valueOf(bean.getFleetTxBindTime()));
			}
			/*if (bean.getTieredCutOff().doubleValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.tieredCutOff = :tieredCutOff");
				map.put("tieredCutOff", String.valueOf(bean.getTieredCutOff()));
			}*/
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot update delete all rows in CsoCompanyParameters");
		}
		return buff.toString();
	}

}
