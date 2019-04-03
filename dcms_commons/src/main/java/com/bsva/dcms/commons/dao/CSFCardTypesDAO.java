package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfCardTypesDao;
import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfCardTypes;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CSFCardTypesDAO {
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";
	private CsfCardTypesDao csfCardTypeDao = new CsfCardTypesDao();
	private Map<String,Object>map = new HashMap<String, Object>();

	public CSFCardTypesDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CSFCardTypesDTO create(CSFCardTypesDTO bean) throws DAOException {
		try {
			CsfCardTypes card = new CsfCardTypes();
			card.setCardDescription( String.valueOf(bean.getCardType()));
			card.setCardType((short)bean.getCardType());
			card.setCreatedBy(bean.getCreatedBy());
			card.setCreatedDate(bean.getCreatedDate());
			card.setModifiedBy(bean.getModifiedBy());
			card.setModifiedDate(bean.getModifiedDate());
			card.setPasaPaymentLimit(new BigDecimal(bean.getPasaPaymentLimit()));
			card.setSubService(bean.getSubService());
			csfCardTypeDao.create(card);
			return bean;			
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_CARD_TYPES, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CSFCardTypesDTO retrieve(CSFCardTypesDTO bean) throws DAOException {
		CSFCardTypesDTO csfCardtypesDTO = new CSFCardTypesDTO();
		try {
			String sql =  "SELECT c  FROM CsfCardTypes c " +buildWhereClause(bean, true);
			CsfCardTypes csfCardRelated = csfCardTypeDao.executeQueryParametersSingle(sql,map);

			if(csfCardRelated.getCardDescription()!=null){
				csfCardtypesDTO.setCardDescription(csfCardRelated.getCardDescription());
			}
			if(csfCardRelated.getCardType()!=null){
				csfCardtypesDTO.setCardType(Integer.valueOf(csfCardRelated.getCardType()));
			}
			if(csfCardRelated.getCreatedBy()!=null){
				csfCardtypesDTO.setCreatedBy(csfCardRelated.getCreatedBy());
			}
			if(csfCardRelated.getCreatedDate()!=null){
				csfCardtypesDTO.setCreatedDate(csfCardRelated.getCreatedDate());
			}
			if(csfCardRelated.getModifiedBy()!=null){
				csfCardtypesDTO.setModifiedBy(csfCardRelated.getModifiedBy());
			}
			if(csfCardRelated.getModifiedDate()!=null){
				csfCardtypesDTO.setModifiedDate(csfCardRelated.getModifiedDate());
			}
			if(csfCardRelated.getPasaPaymentLimit()!=null){
				csfCardtypesDTO.setPasaPaymentLimit(csfCardRelated.getPasaPaymentLimit().doubleValue());
			}
			if(csfCardRelated.getSubService()!=null){
				csfCardtypesDTO.setSubService(csfCardRelated.getSubService());
			}

			map.clear();
			return csfCardtypesDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_CARD_TYPES, cause: "+ ex.getMessage(), ex);
		}


	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CSFCardTypesDTO> retrieveRelated(CSFCardTypesDTO bean) throws DAOException {

		List<CSFCardTypesDTO> dtoList2 = new LinkedList<CSFCardTypesDTO>();

		CSFCardTypesDTO csfCardtypesDTO = null;

		try {
			String sql =  "SELECT c  FROM CsfCardTypes c "+buildWhereClause(bean, true);

			List<CsfCardTypes> csfCardTypeRetrieveRelated = csfCardTypeDao.executeQueryParameters(sql,map);    		

			for (CsfCardTypes csfCardRelated : csfCardTypeRetrieveRelated) {
				
				csfCardtypesDTO = new CSFCardTypesDTO();
				if(csfCardRelated.getCardDescription()!=null){
					csfCardtypesDTO.setCardDescription(csfCardRelated.getCardDescription());
				}
				
				csfCardtypesDTO.setCardType(Integer.valueOf(csfCardRelated.getCardType()));
				
				if(csfCardRelated.getCreatedBy()!=null){
					csfCardtypesDTO.setCreatedBy(csfCardRelated.getCreatedBy());
				}
				if(csfCardRelated.getCreatedDate()!=null){
					csfCardtypesDTO.setCreatedDate(csfCardRelated.getCreatedDate());
				}
				if(csfCardRelated.getModifiedBy()!=null){
					csfCardtypesDTO.setModifiedBy(csfCardRelated.getModifiedBy());
				}
				if(csfCardRelated.getModifiedDate()!=null){
					csfCardtypesDTO.setModifiedDate(csfCardRelated.getModifiedDate());
				}
				if(csfCardRelated.getPasaPaymentLimit()!=null){
					csfCardtypesDTO.setPasaPaymentLimit(csfCardRelated.getPasaPaymentLimit().doubleValue());
				}
				if(csfCardRelated.getSubService()!=null){
					csfCardtypesDTO.setSubService(csfCardRelated.getSubService());
				}


				dtoList2.add(csfCardtypesDTO);
			}
			map.clear();
			return  dtoList2;


		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSF_CARD_TYPES, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a list of records based on rowcountfrom Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CSFCardTypesDTO> retrieveRelated(CSFCardTypesDTO bean, int startRow) throws DAOException {

		List<CSFCardTypesDTO> dtoList2 = new LinkedList<CSFCardTypesDTO>();

		CSFCardTypesDTO csfCardtypesDTO = new CSFCardTypesDTO();

		try {
			// Oracle specific 
			String sql =  "SELECT c FROM CsfCardTypes c " + this.buildWhereClause(bean, true);

			List<CsfCardTypes> csfCardTypeRetrieveRelated = csfCardTypeDao.executeQueryParameters(sql,map);

			for (CsfCardTypes csfCardRelated : csfCardTypeRetrieveRelated) {
				if(csfCardRelated.getCardDescription()!=null){
					csfCardtypesDTO.setCardDescription(csfCardRelated.getCardDescription());
				}
				if(csfCardRelated.getCardType()!=null){
					csfCardtypesDTO.setCardType(Integer.valueOf(csfCardRelated.getCardType()));
				}
				if(csfCardRelated.getCreatedBy()!=null){
					csfCardtypesDTO.setCreatedBy(csfCardRelated.getCreatedBy());
				}
				if(csfCardRelated.getCreatedDate()!=null){
					csfCardtypesDTO.setCreatedDate(csfCardRelated.getCreatedDate());
				}
				if(csfCardRelated.getModifiedBy()!=null){
					csfCardtypesDTO.setModifiedBy(csfCardRelated.getModifiedBy());
				}
				if(csfCardRelated.getModifiedDate()!=null){
					csfCardtypesDTO.setModifiedDate(csfCardRelated.getModifiedDate());
				}
				if(csfCardRelated.getPasaPaymentLimit()!=null){
					csfCardtypesDTO.setPasaPaymentLimit(csfCardRelated.getPasaPaymentLimit().doubleValue());
				}
				if(csfCardRelated.getSubService()!=null){
					csfCardtypesDTO.setSubService(csfCardRelated.getSubService());
				}


				dtoList2.add(csfCardtypesDTO);
			}
			map.clear();
			return dtoList2;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSF_CARD_TYPES, cause: "
					+ ex.getMessage(), ex);
		}
	}
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CSFCardTypesDTO bean) throws DAOException {
		try{
			CsfCardTypes card = new CsfCardTypes();
			card.setCardDescription( String.valueOf(bean.getCardType()));
			card.setCardType((short)bean.getCardType());
			card.setCreatedBy(bean.getCreatedBy());
			card.setCreatedDate(bean.getCreatedDate());
			card.setModifiedBy(bean.getModifiedBy());
			card.setModifiedDate(bean.getModifiedDate());
			card.setPasaPaymentLimit(new BigDecimal(bean.getPasaPaymentLimit()));
			card.setSubService(bean.getSubService());
			csfCardTypeDao.update(card);		

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSF_CARD_TYPES, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CSFCardTypesDTO bean) throws DAOException {
	try{
		CsfCardTypes card = new CsfCardTypes();
		card.setCardDescription( String.valueOf(bean.getCardType()));
		card.setCardType((short)bean.getCardType());
		card.setCreatedBy(bean.getCreatedBy());
		card.setCreatedDate(bean.getCreatedDate());
		card.setModifiedBy(bean.getModifiedBy());
		card.setModifiedDate(bean.getModifiedDate());
		card.setPasaPaymentLimit(new BigDecimal(bean.getPasaPaymentLimit()));
		card.setSubService(bean.getSubService());
		csfCardTypeDao.delete(card);
	}catch(Exception ex){
		throw new DAOException("Delete not supported - If you need this functionality uncomment code below and remove throw above");
	}
	}
	/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	//TODO  
	public int retrieveRowCount(CSFCardTypesDTO bean) throws DAOException {

		try {
			/*SQL_SELECT_COUNT = 
					"SELECT COUNT(*) AS count FROM CsfCardTypes ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);*/
			String sql = "SELECT COUNT(*) AS count FROM CsfCardTypes";
			int count = (int) csfCardTypeDao.executeCountQuery(sql);

			return count;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_CARD_TYPES, cause: "
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
	private String buildWhereClause(CSFCardTypesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getCardType()>0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.cardType= :cardType");
			map.put("cardType",bean.getCardType());
		}
		if (bean.getPasaPaymentLimit() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.pasaPaymentLimit= :pasaPaymentLimit");
			map.put("pasaPaymentLimit",String.valueOf(bean.getPasaPaymentLimit()));
		}

		if (select == true) {
			if (bean.getCardDescription() != null && !bean.getCardDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.cardDescription= :cardDescription");
				map.put("cardDescription",bean.getCardDescription());
			}
			if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.createdBy= :");
				map.put("",bean.getCreatedBy());
			}
			if (bean.getCreatedDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.createdDate= :createdDate");
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

				buff.append("c.modifiedBy= :modifiedBy");
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

				buff.append("c.modifiedDate= :modifiedDate");
				map.put("modifiedDate",String.valueOf(bean.getModifiedDate()));
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

		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_CARD_TYPES");
		}
		return buff.toString();
	}


}
