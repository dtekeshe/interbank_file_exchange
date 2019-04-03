package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfCardFeeBilateralDao;
import com.bsva.dcms.commons.dto.CsfCardFeeBilateralDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfCardFeeBilateral;
import com.bsva.entities.CsfCardFeeBilateralPK;
import com.bsva.entities.CsfCardTypes;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfCardFeeBilateralDAO{
	private String SQL_SELECT = 			"";
	//private List<String> map = new ArrayList<String>();
	private Map<String,Object>map = new HashMap<String, Object>();

	//private CsfCardFeeBilateralRepository csfCardFeeBilateralDao = DaoFactory.csfCardFeeBilateralInstance();
    private CsfCardFeeBilateralDao  CsfCardFeeBilateraldao = new CsfCardFeeBilateralDao();
    
	public CsfCardFeeBilateralDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsfCardFeeBilateralDTO create(CsfCardFeeBilateralDTO bean) throws DAOException {	
		try {			
			CsfCardFeeBilateral csfCardFeeBilateral = new CsfCardFeeBilateral();
			CsfCardTypes csfCardTypes = new CsfCardTypes();
			csfCardTypes.setCardType((short)bean.getCardType());			
			csfCardFeeBilateral.setCardType(csfCardTypes);
			csfCardFeeBilateral.setInterchangeFee(new BigDecimal(bean.getInterchangeFee()));
			csfCardFeeBilateral.setInterchangeFeeAmount(new BigDecimal(bean.getInterchangeFeeAmount()));
			csfCardFeeBilateral.setInputVat(new BigDecimal(bean.getInputVat()));
			csfCardFeeBilateral.setBillIndicator(bean.getBillIndicator());
			csfCardFeeBilateral.setActiveIndicator(bean.getActiveIndicator());
			csfCardFeeBilateral.setCreatedBy(bean.getCreatedBy());
			csfCardFeeBilateral.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
			csfCardFeeBilateral.setModifiedBy(bean.getModifiedBy());
			csfCardFeeBilateral.setModifiedDate(bean.getModifiedDate());
			csfCardFeeBilateral.setCountryCode(bean.getCountryCode());
			CsfCardFeeBilateralPK cardFeeBilateralPK = new CsfCardFeeBilateralPK();
			cardFeeBilateralPK.setAcquiringMember(String.valueOf(bean.getIssuingMember()));
			cardFeeBilateralPK.setIssuingMember(String.valueOf(bean.getAcquiringMember()));
			cardFeeBilateralPK.setTransactionCode(String.valueOf(bean.getTransactionCode()));
			csfCardFeeBilateral.setCsfCardFeeBilateralPK(cardFeeBilateralPK);
			csfCardFeeBilateral.setAmountDirection((short) bean.getAmountDirection());
			csfCardFeeBilateral.setDestReport(bean.getDestReport());
			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CsfCardFeeBilateral, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfCardFeeBilateralDTO retrieve(CsfCardFeeBilateralDTO bean) throws DAOException {

		CsfCardFeeBilateralDTO dto = new CsfCardFeeBilateralDTO();
		try {
			SQL_SELECT = "SELECT  c  FROM CsfCardFeeBilateral c "+ buildWhereClause(bean,true);

			CsfCardFeeBilateral csfCardFeeBilateral = CsfCardFeeBilateraldao.executeQueryParametersSingleDate(SQL_SELECT,map);
			
			if(csfCardFeeBilateral == null){
				return null;				
			}else{
			//CsfCardTypes card = new CsfCardTypes();			

			//if(card.getCardType()!=null){
			dto.setCardType(csfCardFeeBilateral.getCardType().getCardType());
			//}
			//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getTransactionCode()!=null){
			dto.setTransactionCode(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getTransactionCode()));
			//}
			if(csfCardFeeBilateral.getInterchangeFee()!=null){
				dto.setInterchangeFee(csfCardFeeBilateral.getInterchangeFee().doubleValue());
			}
			if(csfCardFeeBilateral.getInterchangeFeeAmount()!=null){
				dto.setInterchangeFeeAmount(csfCardFeeBilateral.getInterchangeFeeAmount().doubleValue());
			}
			if(csfCardFeeBilateral.getInputVat()!=null){
				dto.setInputVat(csfCardFeeBilateral.getInputVat().doubleValue());
			}
			if(csfCardFeeBilateral.getBillIndicator()!=null){
				dto.setBillIndicator(csfCardFeeBilateral.getBillIndicator());
			}
			if(csfCardFeeBilateral.getActiveIndicator()!=null){
				dto.setActiveIndicator(csfCardFeeBilateral.getActiveIndicator());
			}
			if(csfCardFeeBilateral.getCreatedBy()!=null){
				dto.setCreatedBy(csfCardFeeBilateral.getCreatedBy());
			}
			if(csfCardFeeBilateral.getCreatedDate()!=null){
				dto.setCreatedDate(csfCardFeeBilateral.getCreatedDate());
			}
			if(csfCardFeeBilateral.getModifiedBy()!=null){
				dto.setModifiedBy(csfCardFeeBilateral.getModifiedBy());
			}
			if(csfCardFeeBilateral.getModifiedDate()!=null){
				dto.setModifiedDate(csfCardFeeBilateral.getModifiedDate());
			}
			if(csfCardFeeBilateral.getCountryCode()!=null){
				dto.setCountryCode(csfCardFeeBilateral.getCountryCode());
			}
			//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getIssuingMember()!=null){
			dto.setIssuingMember(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getIssuingMember()));
			//}
			//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getAcquiringMember()!=null){
			dto.setAcquiringMember(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getAcquiringMember()));
			//}
			//if(csfCardFeeBilateral.getAmountDirection()!=null){
			dto.setAmountDirection(csfCardFeeBilateral.getAmountDirection());
			//}
			if(csfCardFeeBilateral.getDestReport()!=null){
				dto.setDestReport(csfCardFeeBilateral.getDestReport());
			}
			map.clear();
			return dto;
			}

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsfCardFeeBilateral" + ", cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsfCardFeeBilateralDTO> retrieveRelated(CsfCardFeeBilateralDTO bean) throws DAOException {
		List<CsfCardFeeBilateralDTO> dtoList = new ArrayList<CsfCardFeeBilateralDTO>();
		
		try {
			SQL_SELECT = 
					"SELECT c FROM CsfCardFeeBilateral c "+  this.buildWhereClause(bean, true);		

			List<CsfCardFeeBilateral> csfCardFeeBilateralList = CsfCardFeeBilateraldao.executeQueryParameters(SQL_SELECT,map);			
			for (CsfCardFeeBilateral csfCardFeeBilateral : csfCardFeeBilateralList) {			

				CsfCardFeeBilateralDTO dto = new CsfCardFeeBilateralDTO();
				
				dto.setCardType(csfCardFeeBilateral.getCardType().getCardType());
				
				//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getTransactionCode()!=null){
				dto.setTransactionCode(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getTransactionCode()));
				//}
				if(csfCardFeeBilateral.getInterchangeFee()!=null){
					dto.setInterchangeFee(csfCardFeeBilateral.getInterchangeFee().doubleValue());
				}
				if(csfCardFeeBilateral.getInterchangeFeeAmount()!=null){
					dto.setInterchangeFeeAmount(csfCardFeeBilateral.getInterchangeFeeAmount().doubleValue());
				}
				if(csfCardFeeBilateral.getInputVat()!=null){
					dto.setInputVat(csfCardFeeBilateral.getInputVat().doubleValue());
				}
				if(csfCardFeeBilateral.getBillIndicator()!=null){
					dto.setBillIndicator(csfCardFeeBilateral.getBillIndicator());
				}
				if(csfCardFeeBilateral.getActiveIndicator()!=null){
					dto.setActiveIndicator(csfCardFeeBilateral.getActiveIndicator());
				}
				if(csfCardFeeBilateral.getCreatedBy()!=null){
					dto.setCreatedBy(csfCardFeeBilateral.getCreatedBy());
				}
				if(csfCardFeeBilateral.getCreatedDate()!=null){
					dto.setCreatedDate(csfCardFeeBilateral.getCreatedDate());
				}
				if(csfCardFeeBilateral.getModifiedBy()!=null){
					dto.setModifiedBy(csfCardFeeBilateral.getModifiedBy());
				}
				if(csfCardFeeBilateral.getModifiedDate()!=null){
					dto.setModifiedDate(csfCardFeeBilateral.getModifiedDate());
				}
				if(csfCardFeeBilateral.getCountryCode()!=null){
					dto.setCountryCode(csfCardFeeBilateral.getCountryCode());
				}
				//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getIssuingMember()!=null){
				dto.setIssuingMember(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getIssuingMember()));
				//}
				//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getAcquiringMember()!=null){
				dto.setAcquiringMember(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getAcquiringMember()));
				//}
				//if(csfCardFeeBilateral.getAmountDirection()!=null){
				dto.setAmountDirection(csfCardFeeBilateral.getAmountDirection());
				//}
				if(csfCardFeeBilateral.getDestReport()!=null){
					dto.setDestReport(csfCardFeeBilateral.getDestReport());
				}		
				dtoList.add(dto);			
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsfCardFeeBilateral, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a list of records based on rowcountfrom Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	@SuppressWarnings("unchecked")
	public List<CsfCardFeeBilateralDTO> retrieveRelated(CsfCardFeeBilateralDTO bean, int startRow, int endRow) throws DAOException {
		List<CsfCardFeeBilateralDTO> dtoList = new LinkedList<>();
		CsfCardFeeBilateralDTO dto = new CsfCardFeeBilateralDTO();
		try {
			// Oracle specific 
			SQL_SELECT = 
					"SELECT * from CsfCardFeeBilateral ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			SQL_SELECT += ") WHERE rn > " + startRow;
			if( endRow > 0 ) {
				SQL_SELECT += " AND rn <= " + endRow;
			}
			List<CsfCardFeeBilateral> csfCardFeeBilateralList = CsfCardFeeBilateraldao.executeQueryParameters(SQL_SELECT,map);	
			for (CsfCardFeeBilateral csfCardFeeBilateral : csfCardFeeBilateralList) {			
				CsfCardTypes card = new CsfCardTypes();			
				if(card.getCardType()!=null){
					dto.setCardType(Integer.valueOf(card.getCardType()));
				}
				//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getTransactionCode()!=null){
				dto.setTransactionCode(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getTransactionCode()));
				//}
				if(csfCardFeeBilateral.getInterchangeFee()!=null){
					dto.setInterchangeFee(csfCardFeeBilateral.getInterchangeFee().doubleValue());
				}
				if(csfCardFeeBilateral.getInterchangeFeeAmount()!=null){
					dto.setInterchangeFeeAmount(csfCardFeeBilateral.getInterchangeFeeAmount().doubleValue());
				}
				if(csfCardFeeBilateral.getInputVat()!=null){
					dto.setInputVat(csfCardFeeBilateral.getInputVat().doubleValue());
				}
				if(csfCardFeeBilateral.getBillIndicator()!=null){
					dto.setBillIndicator(csfCardFeeBilateral.getBillIndicator());
				}
				if(csfCardFeeBilateral.getActiveIndicator()!=null){
					dto.setActiveIndicator(csfCardFeeBilateral.getActiveIndicator());
				}
				if(csfCardFeeBilateral.getCreatedBy()!=null){
					dto.setCreatedBy(csfCardFeeBilateral.getCreatedBy());
				}
				if(csfCardFeeBilateral.getCreatedDate()!=null){
					dto.setCreatedDate(csfCardFeeBilateral.getCreatedDate());
				}
				if(csfCardFeeBilateral.getModifiedBy()!=null){
					dto.setModifiedBy(csfCardFeeBilateral.getModifiedBy());
				}
				if(csfCardFeeBilateral.getModifiedDate()!=null){
					dto.setModifiedDate(csfCardFeeBilateral.getModifiedDate());
				}
				if(csfCardFeeBilateral.getCountryCode()!=null){
					dto.setCountryCode(csfCardFeeBilateral.getCountryCode());
				}
				//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getIssuingMember()!=null){
				dto.setIssuingMember(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getIssuingMember()));
				//}
				//if(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getAcquiringMember()!=null){
				dto.setAcquiringMember(Integer.valueOf(csfCardFeeBilateral.getCsfCardFeeBilateralPK().getAcquiringMember()));
				//}
				//if(csfCardFeeBilateral.getAmountDirection()!=null){
				dto.setAmountDirection(csfCardFeeBilateral.getAmountDirection());
				//}
				if(csfCardFeeBilateral.getDestReport()!=null){
					dto.setDestReport(csfCardFeeBilateral.getDestReport());
				}				
				dtoList.add(bean);			
			}
			map.clear();
			return dtoList;
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsfCardFeeBilateral, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfCardFeeBilateralDTO bean) throws DAOException {
		try{
			CsfCardFeeBilateral csfCardFeeBilateral = new CsfCardFeeBilateral();		
			CsfCardTypes csfCardTypes = new CsfCardTypes();
			csfCardTypes.setCardType((short) bean.getCardType());			
			csfCardFeeBilateral.setCardType(csfCardTypes);
			csfCardFeeBilateral.setInterchangeFee(new BigDecimal(bean.getInterchangeFee()));
			csfCardFeeBilateral.setInterchangeFeeAmount(new BigDecimal(bean.getInterchangeFeeAmount()));
			csfCardFeeBilateral.setInputVat(new BigDecimal(bean.getInputVat()));
			csfCardFeeBilateral.setBillIndicator(bean.getBillIndicator());
			csfCardFeeBilateral.setActiveIndicator(bean.getActiveIndicator());
			csfCardFeeBilateral.setCreatedBy(bean.getCreatedBy());
			csfCardFeeBilateral.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
			csfCardFeeBilateral.setModifiedBy(bean.getModifiedBy());
			csfCardFeeBilateral.setModifiedDate(bean.getModifiedDate());
			csfCardFeeBilateral.setCountryCode(bean.getCountryCode());
			CsfCardFeeBilateralPK cardFeeBilateralPK = new CsfCardFeeBilateralPK();
			cardFeeBilateralPK.setAcquiringMember(String.valueOf(bean.getIssuingMember()));
			cardFeeBilateralPK.setIssuingMember(String.valueOf(bean.getAcquiringMember()));
			cardFeeBilateralPK.setTransactionCode(String.valueOf(bean.getTransactionCode()));
			csfCardFeeBilateral.setCsfCardFeeBilateralPK(cardFeeBilateralPK);
			csfCardFeeBilateral.setAmountDirection((short) bean.getAmountDirection());
			csfCardFeeBilateral.setDestReport(bean.getDestReport());
			CsfCardFeeBilateraldao.update(csfCardFeeBilateral);
		} catch (Exception ex) {
			throw new DAOException("Error updating CsfCardFeeBilateral, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsfCardFeeBilateralDTO bean) throws DAOException {
		try {
			CsfCardFeeBilateral csfCardFeeBilateral = new CsfCardFeeBilateral();
			CsfCardTypes csfCardTypes = new CsfCardTypes();
			csfCardTypes.setCardType((short) bean.getCardType());			
			csfCardFeeBilateral.setCardType(csfCardTypes);
			csfCardFeeBilateral.setInterchangeFee(new BigDecimal(bean.getInterchangeFee()));
			csfCardFeeBilateral.setInterchangeFeeAmount(new BigDecimal(bean.getInterchangeFeeAmount()));
			csfCardFeeBilateral.setInputVat(new BigDecimal(bean.getInputVat()));
			csfCardFeeBilateral.setBillIndicator(bean.getBillIndicator());
			csfCardFeeBilateral.setActiveIndicator(bean.getActiveIndicator());
			csfCardFeeBilateral.setCreatedBy(bean.getCreatedBy());
			csfCardFeeBilateral.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
			csfCardFeeBilateral.setModifiedBy(bean.getModifiedBy());
			csfCardFeeBilateral.setModifiedDate(bean.getModifiedDate());
			csfCardFeeBilateral.setCountryCode(bean.getCountryCode());
			CsfCardFeeBilateralPK cardFeeBilateralPK = new CsfCardFeeBilateralPK();
			cardFeeBilateralPK.setAcquiringMember(String.valueOf(bean.getIssuingMember()));
			cardFeeBilateralPK.setIssuingMember(String.valueOf(bean.getAcquiringMember()));
			cardFeeBilateralPK.setTransactionCode(String.valueOf(bean.getTransactionCode()));
			csfCardFeeBilateral.setCsfCardFeeBilateralPK(cardFeeBilateralPK);
			csfCardFeeBilateral.setAmountDirection((short) bean.getAmountDirection());
			csfCardFeeBilateral.setDestReport(bean.getDestReport());
			CsfCardFeeBilateraldao.delete(csfCardFeeBilateral);

		}  catch (Exception ex) {
			throw new DAOException("Error Deleting CsfCardFeeBilateral, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public int retrieveRowCount(CsfCardFeeBilateralDTO bean) throws DAOException {
			try {
			/*SQL_SELECT_COUNT = 
					"SELECT COUNT(*) AS count FROM CsfCardFeeBilateral ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);*/

			String query = "SELECT Count(*) FROM CsfAsciiEbcdic ";
			Integer inte = (Integer)this.CsfCardFeeBilateraldao.executeCountQuery(query);	

			return inte;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsfCardFeeBilateral, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsfCardFeeBilateralDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		if (select == true) {
			
			if (bean.getTransactionCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.csfCardFeeBilateralPK.transactionCode = :transactionCode");
				map.put("transactionCode",String.valueOf(bean.getTransactionCode()));
			}
			if (bean.getIssuingMember() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.csfCardFeeBilateralPK.issuingMember = :issuingMember");
				map.put("issuingMember",String.valueOf(bean.getIssuingMember()));
			}
			if (bean.getAcquiringMember() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.csfCardFeeBilateralPK.acquiringMember = :acquiringMember");
				map.put("acquiringMember",String.valueOf(bean.getAcquiringMember()));
			}
		
			if (bean.getInterchangeFee() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.interchangeFee = :interchangeFee");
				map.put("interchangeFee",String.valueOf(bean.getInterchangeFee()));
			}
			if (bean.getInterchangeFeeAmount() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.interchangeFeeAmount = :interchangeFeeAmount");
				map.put("interchangeFeeAmount",String.valueOf(bean.getInterchangeFeeAmount()));
			}
			if (bean.getInputVat() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.inputVat = :inputVat");
				map.put("inputVat",String.valueOf(bean.getInputVat()));
			}
			if (bean.getBillIndicator() != null && !bean.getBillIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.billIndicator = :billIndicator" );
				map.put("billIndicator",bean.getBillIndicator());
			}
			if (bean.getActiveIndicator() != null && !bean.getActiveIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.activeIndicator = :activeIndicator");
				map.put("activeIndicator",bean.getActiveIndicator());
			}
			if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.createdBy = :createdBy" );
				map.put("createdBy",bean.getCreatedBy());
			}
			if (bean.getCreatedDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.createdDate = :createdDate" );
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

				buff.append("c.modifiedBy =:modifiedBy");
				map.put("modifiedBy",bean.getModifiedBy());
			}
			if (bean.getModifiedDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.modifiedDate =:modifiedDate");
				map.put("modifiedDate",String.valueOf(bean.getModifiedDate()));
			}
			if (bean.getCountryCode() != null && !bean.getCountryCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.countryCode =:countryCode");
				map.put("countryCode",bean.getCountryCode());
			}
			
			if (bean.getAmountDirection() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.amountDirection = :amountDirection");
				map.put("amountDirection",String.valueOf(bean.getAmountDirection()));
			}
			if (bean.getDestReport() != null && !bean.getDestReport().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.destReport = :destReport");
				map.put("destReport",bean.getDestReport());
			}
			if (bean.getCardType() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
	           
				buff.append("c.cardType.cardType = :cardType") ;
				map.put("cardType",(short)bean.getCardType());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_CARD_FEE_BILATERAL");
		}
		return buff.toString();
	}

}
