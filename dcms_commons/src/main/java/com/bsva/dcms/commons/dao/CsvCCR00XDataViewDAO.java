package com.bsva.dcms.commons.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsvCcr00xDataViewDao;
import com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsvCcr00xDataView;
import com.bsva.entities.CsvCcr00xDataViewPK;

public class CsvCCR00XDataViewDAO {
	
	private String SQL_SELECT = "";
	private Map<String,Object>map = new HashMap<String, Object>();
	private CsvCcr00xDataViewDao csvCcr00xDataViewDao = new CsvCcr00xDataViewDao();
	public CsvCCR00XDataViewDAO(){

	}

	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsvCcr00XDataViewDto retrieve(CsvCcr00XDataViewDto bean) throws DAOException {

		CsvCcr00XDataViewDto dto = new CsvCcr00XDataViewDto();
		try {
			SQL_SELECT = "SELECT  c  FROM CsvCcr00XDataView c "+ buildWhereClause(bean,true);

			CsvCcr00xDataView csvCcr00xDataView = csvCcr00xDataViewDao.executeQueryParametersSingle(SQL_SELECT,map);
			
			
			if(csvCcr00xDataView == null){
				return null;				
			}else{
			
				
			map.clear();
			return dto;
			}

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsvCcr015View" + ", cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsvCcr00XDataViewDto> retrieveRelated() throws DAOException {
		List<CsvCcr00XDataViewDto> dtoList = new ArrayList<CsvCcr00XDataViewDto>();
		
		try {
			//SQL_SELECT = 
					//"SELECT c FROM CsvCcr00xDataView c";
			//SQL_SELECT += this.buildWhereClause(bean, true);		
            String  sql = "from  CsvCcr00xDataView";
			
			List<CsvCcr00xDataView> csvCcr00xDataViewList = csvCcr00xDataViewDao.executeQueryParametersNative(sql);	
			
			for (CsvCcr00xDataView csvCcr00xDataView : csvCcr00xDataViewList) {			

				CsvCcr00XDataViewDto dto = new CsvCcr00XDataViewDto();
				
				dto.setAcquirerBankCode(Integer.valueOf(csvCcr00xDataView.getCsvCcr00xDataViewPK().getAcquirerCode()));
				dto.setAcquirerMember(csvCcr00xDataView.getAcquirerMember());
				dto.setBillingFee(csvCcr00xDataView.getBillingFee());
				dto.setBillingFeeAmount(csvCcr00xDataView.getBillingFeeAmount());
				dto.setBillingVat(csvCcr00xDataView.getBillingVat());
				dto.setCardDescription(csvCcr00xDataView.getCardDescription());
				dto.setCardType(Integer.valueOf(csvCcr00xDataView.getCsvCcr00xDataViewPK().getCardType()));
				dto.setIssuerBankCode(Integer.valueOf(csvCcr00xDataView.getCsvCcr00xDataViewPK().getIssuerCode()));
				dto.setIssuerMember(csvCcr00xDataView.getIssuerMember());
				dto.setReportSortSequence(csvCcr00xDataView.getReportSortSequence());
				dto.setService(csvCcr00xDataView.getService());
				dto.setSubService(csvCcr00xDataView.getSubService());
				dto.setTransactionCode(Integer.valueOf(csvCcr00xDataView.getCsvCcr00xDataViewPK().getTransactionCode()));
				dto.setTransactionDescription(csvCcr00xDataView.getTransactionDescription());
				dto.setTransactionValue(csvCcr00xDataView.getTranValue());
				dto.setVolume(Integer.valueOf(csvCcr00xDataView.getVolume()));
				dtoList.add(dto);			
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsvCcr015View, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsvCcr00XDataViewDto bean, boolean select) throws DAOException {
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
			if (bean.getIssuerBankCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("issuerCode=?");
			}
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
			
			if (bean.getAcquirerBankCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("acquirerCode=?");
			}
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
			if (bean.getTransactionValue() > 0) {
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
			}
			
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSV_CCR00X_DATA_VIEW");
		}
		return buff.toString();
	}
	
	
	
	

}
