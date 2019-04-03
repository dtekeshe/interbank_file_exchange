package com.bsva.dcms.commons.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsvFleetBillViewDao;
import com.bsva.dcms.commons.dto.CsvFleetBillViewDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsvFleetBillView;

public class CsvFleetBillViewDAO {

	private String SQL_SELECT = "";
	private Map<String,Object>map = new HashMap<String, Object>();
	private CsvFleetBillViewDao csvFleetBillViewDao = new CsvFleetBillViewDao();
	public CsvFleetBillViewDAO(){

	}

	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsvFleetBillViewDTO retrieve(CsvFleetBillViewDTO bean) throws DAOException {

		CsvFleetBillViewDTO dto = new CsvFleetBillViewDTO();
		try {
			SQL_SELECT = "SELECT  c  FROM CsvFleetBillView c "+ buildWhereClause(bean,true);

			CsvFleetBillView csvFleetBillView = csvFleetBillViewDao.executeQueryParametersSingle(SQL_SELECT,map);
			
			
			if(csvFleetBillView == null){
				return null;				
			}else{
			
				
			map.clear();
			return dto;
			}

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsvFleetBillView" + ", cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsvFleetBillViewDTO> retrieveRelated() throws DAOException {
		List<CsvFleetBillViewDTO> dtoList = new ArrayList<CsvFleetBillViewDTO>();
		
		try {
				
            String  sql = "select c from  CsvFleetBillView c";
			
			List<CsvFleetBillView> csvFleetBillViewViewList = csvFleetBillViewDao.executeQueryParametersNative(sql);	
			
			for (CsvFleetBillView csvFleetBillView : csvFleetBillViewViewList) {			

				CsvFleetBillViewDTO dto = new CsvFleetBillViewDTO();
			
				dto.setCardDescription(csvFleetBillView.getCsvFleetBillViewPK().getCardDescription());
				dto.setCardType(csvFleetBillView.getCsvFleetBillViewPK().getCardType());
				dto.setCost(csvFleetBillView.getCost());
				dto.setIssuer(csvFleetBillView.getCsvFleetBillViewPK().getIssuer());
				dto.setAcquirer(csvFleetBillView.getCsvFleetBillViewPK().getAcquirer());
				dto.setNettAmount(csvFleetBillView.getNettAmount());
				dto.setPercCost(csvFleetBillView.getPercCost());
				dto.setReportSortSequence(csvFleetBillView.getCsvFleetBillViewPK().getReportSortSequence());
				dto.setService(csvFleetBillView.getCsvFleetBillViewPK().getService());
				dto.setSubService(csvFleetBillView.getCsvFleetBillViewPK().getSubService());
				dto.setTotalCharge(csvFleetBillView.getTotalCharge());
				dto.setTransactionCode(csvFleetBillView.getCsvFleetBillViewPK().getTransactionCode());
				dto.setTransactionDescription(csvFleetBillView.getCsvFleetBillViewPK().getTransactionDescription());
				dto.setValue(csvFleetBillView.getValue());
				dto.setVat(csvFleetBillView.getValue());
				dto.setVolume(csvFleetBillView.getVolume());
				
				dtoList.add(dto);			
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsvFleetBillView, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsvFleetBillViewDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getIssuerMember() != null && !bean.getIssuerMember().isEmpty()) {
	
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("issuerMember =?");
		}
		
		if (select == true) {
			/*if (bean.getIssuerBankCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("issuerCode=?");
			}*/
			if (bean.getAcquirerMember() != null && !bean.getAcquirerMember().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("acquirerMember=?");
			}
			
			/*if (bean.getAcquirerBankCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("acquirerCode=?");
			}*/
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("service=?");
			}
			
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("subService=?");
			}
			
			if (bean.getCardType() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("cardType =?");
			}
			
			if (bean.getCardDescription() != null && !bean.getCardDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("cardDescription =?");
			}
			if (bean.getTransactionCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("transactionCode =?");
			}
			if (bean.getTransactionDescription() != null && !bean.getTransactionDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("transactionDescription =?");
			}
			
			if (bean.getVolume() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("volume =?");
			}
			/*if (bean.getTransactionValue() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("tranValue =?");
			}
			if (bean.getBillingFee() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("billingFee =?");
			}
			if (bean.getBillingFeeAmount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("billingFeeAmount =?");
			}
			if (bean.getBillingVat() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("billingVat =?");
			}
			if (bean.getReportSortSequence() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("reportSortSequence =?");
			}*/
			
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CsvFleetBillView");
		}
		return buff.toString();
	}

}

