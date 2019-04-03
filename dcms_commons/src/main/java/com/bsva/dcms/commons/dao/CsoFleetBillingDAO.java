package com.bsva.dcms.commons.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import com.bsva.dao.CsoFleetBillingDao;
import com.bsva.dcms.commons.dto.CsoFleetBillingDTO;
import com.bsva.dcms.commons.dto.CsoFleetBindResolvedDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoFleetBilling;

/**
 * @author AugustineA
 *
 */

public class CsoFleetBillingDAO {

	private Map<String,Object> map = new HashMap<String, Object>();
	private CsoFleetBillingDao csofleetBillingDao = new CsoFleetBillingDao();

	public CsoFleetBillingDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public void create(CsoFleetBillingDTO bean) throws DAOException {
		try {
			
			CsoFleetBilling csoFleetBilling = new CsoFleetBilling();
			
			csoFleetBilling.setIss((short)bean.getIss());
			csoFleetBilling.setAcq((short)bean.getAcq());			
			csoFleetBilling.setTxCde((short)bean.getTxCde());
			csoFleetBilling.setTxDateTime(bean.getTxDateTime());
			csoFleetBilling.setService(bean.getService());
			csoFleetBilling.setSubService(bean.getSubService());
			
			csoFleetBilling.setAccNo(bean.getAccNo());
			csoFleetBilling.setAmount(bean.getAmount());
			csoFleetBilling.setAcqRefNo(bean.getAcqRefNo());
			csoFleetBilling.setCardType(bean.getCardType());							
			//csoFleetBilling.setProduct(bean.getProduct());
			csoFleetBilling.setTranSystemSeqNumber(bean.getTranSystemSeqNumber());
			csoFleetBilling.setTxCnt((short)bean.getTxCnt());
			csoFleetBilling.setFileRefNumber(bean.getFileRefNumber());

			csofleetBillingDao.create(csoFleetBilling);

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_FLEET_BILLING, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public CsoFleetBillingDTO retrieve(CsoFleetBillingDTO bean) throws DAOException {
	try {
		CsoFleetBillingDTO csoFleetBilling = new CsoFleetBillingDTO();
		
		String sql = "SELECT c FROM CsoFleetBilling c "+ buildWhereClause(bean,true);
		CsoFleetBilling csoFleetBillings = csofleetBillingDao.executeQueryParametersSingleDate(sql, map);
		
		csoFleetBilling.setIss(csoFleetBillings.getIss());
		csoFleetBilling.setAcq(csoFleetBillings.getAcq());			
		csoFleetBilling.setTxCde(csoFleetBillings.getTxCde());
		csoFleetBilling.setTxDateTime(csoFleetBillings.getTxDateTime());
		csoFleetBilling.setService(csoFleetBillings.getService());
		csoFleetBilling.setSubService(csoFleetBillings.getSubService());
		csoFleetBilling.setAccNo(csoFleetBillings.getAccNo());
		csoFleetBilling.setAmount(csoFleetBillings.getAmount());
		csoFleetBilling.setAcqRefNo(csoFleetBillings.getAcqRefNo());
		csoFleetBilling.setCardType(csoFleetBillings.getCardType());				
		csoFleetBilling.setProduct(csoFleetBillings.getProduct());
		csoFleetBilling.setSubProduct(csoFleetBillings.getSubProduct());
		csoFleetBilling.setTxCnt(csoFleetBillings.getTxCnt());
		csoFleetBilling.setFileRefNumber(csoFleetBillings.getFileRefNumber());
		csoFleetBilling.setTranSystemSeqNumber(csoFleetBillings.getTranSystemSeqNumber());
			
			return csoFleetBilling;
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_FLEET_BILLING, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public List<CsoFleetBillingDTO> retrieveRelated(CsoFleetBillingDTO csoFleetBillingDTO) throws DAOException {
		try {
			
			List<CsoFleetBillingDTO> csoFleetBillingList = new LinkedList<CsoFleetBillingDTO>();
			
			String sql = "SELECT c FROM CsoFleetBilling c "+ buildWhereClause(csoFleetBillingDTO,true);
			List<CsoFleetBilling> csoFleetBillingLists = csofleetBillingDao.executeQueryParametersDate(sql, map);
			for (CsoFleetBilling csoFleetBill : csoFleetBillingLists) {
				
				CsoFleetBillingDTO csoFleetBillingDTOs = new CsoFleetBillingDTO();
				
				csoFleetBillingDTOs.setIss(csoFleetBill.getIss());
				csoFleetBillingDTOs.setAcq(csoFleetBill.getAcq());			
				csoFleetBillingDTOs.setTxCde(csoFleetBill.getTxCde());
				csoFleetBillingDTOs.setTxDateTime(csoFleetBill.getTxDateTime());
				csoFleetBillingDTOs.setService(csoFleetBill.getService());
				csoFleetBillingDTOs.setSubService(csoFleetBill.getSubService());
				csoFleetBillingDTOs.setAccNo(csoFleetBill.getAccNo());
				csoFleetBillingDTOs.setAmount(csoFleetBill.getAmount());
				csoFleetBillingDTOs.setAcqRefNo(csoFleetBill.getAcqRefNo());
				csoFleetBillingDTOs.setCardType(csoFleetBill.getCardType());				
				csoFleetBillingDTOs.setProduct(csoFleetBill.getProduct());
				csoFleetBillingDTOs.setSubProduct(csoFleetBill.getSubProduct());
				csoFleetBillingDTOs.setTxCnt(csoFleetBill.getTxCnt());
				csoFleetBillingDTOs.setFileRefNumber(csoFleetBill.getFileRefNumber());                                
				csoFleetBillingDTOs.setTranSystemSeqNumber(csoFleetBill.getTranSystemSeqNumber());                                			
				csoFleetBillingList.add(csoFleetBillingDTOs);
			}
			map.clear();
			return csoFleetBillingList;
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_FLEET_BILLING, cause: "+ ex.getMessage(), ex);
		}
	}
	
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */
	public void update(CsoFleetBillingDTO bean) throws DAOException {
		try{
			
			CsoFleetBilling csoFleetBilling = new CsoFleetBilling();
			
			csoFleetBilling.setIss((short)bean.getIss());
			csoFleetBilling.setAcq((short)bean.getAcq());			
			csoFleetBilling.setTxCde((short)bean.getTxCde());
			csoFleetBilling.setTxDateTime(bean.getTxDateTime());
			csoFleetBilling.setService(bean.getService());
			csoFleetBilling.setSubService(bean.getSubService());
			
			
			csoFleetBilling.setAccNo(bean.getAccNo());
			csoFleetBilling.setAmount(bean.getAmount());
			csoFleetBilling.setAcqRefNo(Long.valueOf(bean.getAcqRefNo()));
			csoFleetBilling.setCardType(bean.getCardType());				
			csoFleetBilling.setProduct(bean.getProduct());
			csoFleetBilling.setSubProduct(bean.getSubProduct());
			csoFleetBilling.setTxCnt((short)bean.getTxCnt());
			csoFleetBilling.setFileRefNumber(bean.getFileRefNumber());
			csoFleetBilling.setTranSystemSeqNumber(bean.getTranSystemSeqNumber());

			csofleetBillingDao.update(csoFleetBilling);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_FLEET_BILLING, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */
	public void delete(CsoFleetBindResolvedDTO bean) throws DAOException {
		try {
			
			csofleetBillingDao.deleteBulk("Delete from CsoFleetBilling");

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSO_FLEET_BILLING, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsoFleetBillingDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {
/*
		if (bean.getIss() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.csoFleetBillingPK.iss = :iss");
			 map.put("iss",bean.getIss());
		}
		if (bean.getAcq() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.csoFleetBillingPK.acq = :acq");
			 map.put("acq",bean.getAcq());
		}
		if (bean.getCardType() != null && !bean.getCardType().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.cardType =:cardType");
			 map.put("cardType",bean.getCardType());
		}
		if (bean.getAcqRefNo() != null && !bean.getAcqRefNo().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.acqRefNo =:acqRefNo");
			 map.put("acqRefNo",bean.getAcqRefNo());
		   }*/
		
			if (bean.getIss() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.csoFleetBillingPK.iss =:iss");
				 map.put("iss",bean.getIss());
			}
			if (bean.getAcq() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.csoFleetBillingPK.acq =:acq");
				 map.put("acq",bean.getAcq());
			}
			if (bean.getAcqRefNo() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.acqRefNo = :acqRefNo");
				 map.put("acqRefNo",bean.getAcqRefNo());
			}
			if (bean.getAccNo() != null && !bean.getAccNo().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.accNo =:accNo");
				 map.put("accNo",bean.getAccNo());
			}
			if (bean.getAmount() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.amount = :amount");
				 map.put("amount",bean.getAmount());
			}
			if (bean.getTxCde() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.csoFleetBillingPK.txCde =:txCde");
				 map.put("txCde",bean.getTxCde());
			}
			
			if (bean.getTxDateTime() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.csoFleetBillingPK.txDateTime =:txDateTime");
				 map.put("txDateTime",bean.getTxDateTime());
			}
			if (bean.getProduct() != null && !bean.getProduct().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.product =:product");
				 map.put("product",bean.getProduct());
			}
			if (bean.getSubProduct() != null && !bean.getSubProduct().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.subProduct =:subProduct");
				 map.put("subProduct",bean.getSubProduct());
			}
			/*if (bean.getTxCnt() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.txCnt =:txCnt");
				 map.put("txCnt",bean.getTxCnt());
			}*/
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.service = :service");
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
				 buff.append("c.subService = :subService");
				 map.put("subService",bean.getSubService());
			}
			if (bean.getFileRefNumber() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.fileRefNumber = :fileRefNumber");
				 map.put("fileRefNumber",bean.getFileRefNumber());
			}
			if (bean.getTranSystemSeqNumber() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.tranSystemSeqNumber = :tranSystemSeqNumber");
				 map.put("tranSystemSeqNumber",bean.getTranSystemSeqNumber());
			}
			
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_FLEET_BILLING");
		}
	
		return buff.toString();
	}

	public void delete() throws DAOException {
		csofleetBillingDao.deleteBulk("Delete from CsoFleetBilling");
	}
	
}
