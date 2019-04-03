package com.bsva.dcms.commons.dao;



import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfSubServicesDao;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfSubServices;
import com.bsva.entities.CsfSubServicesPK;
import com.bsva.entities.CsfSystemService;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CSFSubServicesDAO{


	//private CsfSubServicesRepository  csfsubServiceDao = DaoFactory.csfSubServicesInstance();
	private CsfSubServicesDao  csfsubServiceDao = new CsfSubServicesDao();
	private Map<String,Object> map = new HashMap<String, Object>();

	public CSFSubServicesDAO() {
	}


	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CSFSubServicesDTO create(CSFSubServicesDTO bean) throws DAOException {

		try {
			CsfSubServices csfSubServices= new CsfSubServices();
			CsfSubServicesPK csfSubServicesPK = new CsfSubServicesPK();
			
			csfSubServicesPK.setService(bean.getService());
			csfSubServicesPK.setSubService(bean.getSubservice());
			
			csfSubServices.setCsfSubServicesPK(csfSubServicesPK);
			csfSubServices.setActiveIndicator(bean.getActiveIndicator());
			csfSubServices.setPaymentStream(bean.getPaymentStream());
			csfSubServices.setDescription(bean.getDescription());
			csfSubServices.setCreatedBy(bean.getCreatedBy());
			csfSubServices.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
			csfSubServices.setModifiedBy(bean.getModifiedBy());
			csfSubServices.setModifiedDate(new Date(bean.getModifiedDate().getTime()));
			csfSubServices.setInputSla((short) bean.getInputSla());
			csfSubServices.setSettleSla((short) bean.getSettleSla());
			csfSubServices.setOutputSla((short) bean.getOutputSla());
			csfSubServices.setDisplayName(bean.getDisplayName());
			csfSubServices.setSettlementName(bean.getSettlementName());
			this.csfsubServiceDao.create(csfSubServices);
			return bean;

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_SUB_SERVICES, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CSFSubServicesDTO retrieve(CSFSubServicesDTO bean) throws DAOException {
		CSFSubServicesDTO csfSubServicesDTO = new CSFSubServicesDTO();
		try {
				String sql = "SELECT c FROM CsfSubServices c " +buildWhereClause(bean, true);

			CsfSubServices csfSubServices = csfsubServiceDao.executeQueryParametersSingle(sql, map);
			
			if(csfSubServices.getActiveIndicator() != null){
                csfSubServicesDTO.setActiveIndicator(csfSubServices.getActiveIndicator());
			    }
				if(csfSubServices.getCreatedBy() != null){
                csfSubServicesDTO.setCreatedBy(csfSubServices.getCreatedBy());
				}
                if(csfSubServices.getCreatedDate() != null){
                csfSubServicesDTO.setCreatedDate(csfSubServices.getCreatedDate());
                }
                if(csfSubServices.getDescription() != null){
                csfSubServicesDTO.setDescription(csfSubServices.getDescription());
                }
                if(csfSubServices.getInputSla() != null){
                csfSubServicesDTO.setInputSla(csfSubServices.getInputSla().intValue());
                }    
                if(csfSubServices.getModifiedBy() != null){
                csfSubServicesDTO.setModifiedBy(csfSubServices.getModifiedBy());
                }
                if(csfSubServices.getModifiedDate() != null){
                csfSubServicesDTO.setModifiedDate(csfSubServices.getModifiedDate());
                }
                if(csfSubServices.getOutputSla() != null){
                csfSubServicesDTO.setOutputSla(csfSubServices.getOutputSla().intValue());
                }
                if(csfSubServices.getPaymentStream() != null){
                csfSubServicesDTO.setPaymentStream(csfSubServices.getPaymentStream());
                }
                if(csfSubServices.getCsfSubServicesPK().getService() != null){
                csfSubServicesDTO.setService(csfSubServices.getCsfSubServicesPK().getService());
                }
                if(csfSubServices.getSettlementName() != null){
                csfSubServicesDTO.setSettlementName(csfSubServices.getSettlementName());
                }
                if(csfSubServices.getSettleSla() != null){
                csfSubServicesDTO.setSettleSla(csfSubServices.getSettleSla().intValue());
                }
                if(csfSubServices.getCsfSubServicesPK().getSubService() != null){
                csfSubServicesDTO.setSubservice(csfSubServices.getCsfSubServicesPK().getSubService());
                }
                if(csfSubServices.getDisplayName() != null){
                csfSubServicesDTO.setDisplayName(csfSubServices.getDisplayName());
                }

                map.clear();
			return csfSubServicesDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving SubService, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to bH retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CSFSubServicesDTO> retrieveRelated(CSFSubServicesDTO bean) throws DAOException {
		List<CSFSubServicesDTO> dtoList = new LinkedList<>();
		CSFSubServicesDTO csfSubServicesDTO = null;
		try {
		        String sql = "SELECT c FROM CsfSubServices c "+buildWhereClause(bean, true);
			List<CsfSubServices> subservices = csfsubServiceDao.executeQueryParameters(sql,map);
			for (CsfSubServices csfSubServices : subservices) {
				
				csfSubServicesDTO = new CSFSubServicesDTO();
				if(csfSubServices.getActiveIndicator() != null){
                csfSubServicesDTO.setActiveIndicator(csfSubServices.getActiveIndicator());
			    }
				if(csfSubServices.getCreatedBy() != null){
                csfSubServicesDTO.setCreatedBy(csfSubServices.getCreatedBy());
				}
                if(csfSubServices.getCreatedDate() != null){
                csfSubServicesDTO.setCreatedDate(csfSubServices.getCreatedDate());
                }
                if(csfSubServices.getDescription() != null){
                csfSubServicesDTO.setDescription(csfSubServices.getDescription());
                }
                if(csfSubServices.getInputSla() != null){
                csfSubServicesDTO.setInputSla(csfSubServices.getInputSla().intValue());
                }    
                if(csfSubServices.getModifiedBy() != null){
                csfSubServicesDTO.setModifiedBy(csfSubServices.getModifiedBy());
                }
                if(csfSubServices.getModifiedDate() != null){
                csfSubServicesDTO.setModifiedDate(csfSubServices.getModifiedDate());
                }
                if(csfSubServices.getOutputSla() != null){
                csfSubServicesDTO.setOutputSla(csfSubServices.getOutputSla().intValue());
                }
                if(csfSubServices.getPaymentStream() != null){
                csfSubServicesDTO.setPaymentStream(csfSubServices.getPaymentStream());
                }
                if(csfSubServices.getCsfSubServicesPK().getService() != null){
                csfSubServicesDTO.setService(csfSubServices.getCsfSubServicesPK().getService());
                }
                if(csfSubServices.getSettlementName() != null){
                csfSubServicesDTO.setSettlementName(csfSubServices.getSettlementName());
                }
                if(csfSubServices.getSettleSla() != null){
                csfSubServicesDTO.setSettleSla(csfSubServices.getSettleSla().intValue());
                }
                if(csfSubServices.getCsfSubServicesPK().getSubService() != null){
                csfSubServicesDTO.setSubservice(csfSubServices.getCsfSubServicesPK().getSubService());
                }
                if(csfSubServices.getDisplayName() != null){
                csfSubServicesDTO.setDisplayName(csfSubServices.getDisplayName());
                }
				dtoList.add(csfSubServicesDTO);
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related SubService, cause: "
					+ ex.getMessage());
		} 
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CSFSubServicesDTO bean) throws DAOException {

		CsfSubServices csfSubServices= new CsfSubServices();
		CsfSubServicesPK csfSubServicesPK = new CsfSubServicesPK();
		
		csfSubServicesPK.setService(bean.getService());
		csfSubServicesPK.setSubService(bean.getSubservice());
		
		csfSubServices.setCsfSubServicesPK(csfSubServicesPK);
		csfSubServices.setActiveIndicator(bean.getActiveIndicator());
		csfSubServices.setPaymentStream(bean.getPaymentStream());
		csfSubServices.setDescription(bean.getDescription());
		csfSubServices.setCreatedBy(bean.getCreatedBy());
		csfSubServices.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
		csfSubServices.setModifiedBy(bean.getModifiedBy());
		csfSubServices.setModifiedDate(new Date(bean.getModifiedDate().getTime()));
		csfSubServices.setInputSla((short) bean.getInputSla());
		csfSubServices.setSettleSla((short) bean.getSettleSla());
		csfSubServices.setOutputSla((short) bean.getOutputSla());
		csfSubServices.setDisplayName(bean.getDisplayName());
		csfSubServices.setSettlementName(bean.getSettlementName());
		csfsubServiceDao.update(csfSubServices);

	}
	
	public void delete(CSFSubServicesDTO bean) throws DAOException {
		
		try{
			CsfSubServices csfSubServices= new CsfSubServices();
			CsfSubServicesPK csfSubServicesPK = new CsfSubServicesPK();
			
			csfSubServicesPK.setService(bean.getService());
			csfSubServicesPK.setSubService(bean.getSubservice());
			
			csfSubServices.setCsfSubServicesPK(csfSubServicesPK);
			csfSubServices.setActiveIndicator(bean.getActiveIndicator());
			csfSubServices.setPaymentStream(bean.getPaymentStream());
			csfSubServices.setDescription(bean.getDescription());
			csfSubServices.setCreatedBy(bean.getCreatedBy());
			csfSubServices.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
			csfSubServices.setModifiedBy(bean.getModifiedBy());
			csfSubServices.setModifiedDate(new Date(bean.getModifiedDate().getTime()));
			csfSubServices.setInputSla((short) bean.getInputSla());
			csfSubServices.setSettleSla((short) bean.getSettleSla());
			csfSubServices.setOutputSla((short) bean.getOutputSla());
			csfSubServices.setDisplayName(bean.getDisplayName());
			csfSubServices.setSettlementName(bean.getSettlementName());;
			csfsubServiceDao.delete(csfSubServices);

			} catch (Exception ex) {
				throw new DAOException("Error Deleting SubService, cause: "+ ex.getMessage(), ex);
			} 

		}

/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	//public int retrieveRowCount(CSFSubServicesDTO bean) throws DAOException {
	public int retrieveRowCount(CSFSubServicesDTO bean) throws DAOException {	
		try {
			String sql = "SELECT COUNT(*) AS count FROM CsfSubServices ";
			int count = (int) csfsubServiceDao.executeCountQuery(sql);

			return count;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving SubService, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CSFSubServicesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {

		if (bean.getService() != null && !bean.getService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			CsfSystemService csfSystemService = new CsfSystemService();
			csfSystemService.setServiceCode(bean.getService());
			buff.append("c.csfSubServicesPK.service =:service");
			map.put("service",csfSystemService.getServiceCode());
		}
		if (bean.getSubservice() != null && !bean.getSubservice().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.csfSubServicesPK.subService =:subService");
			map.put("subService",bean.getSubservice());
		}
		
			if (bean.getActiveIndicator() != null && !bean.getActiveIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.activeIndicator =:activeIndicator");
				map.put("activeIndicator",bean.getActiveIndicator());
			}
			if (bean.getPaymentStream() != null && !bean.getPaymentStream().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.paymentStream =:paymentStream");
				map.put("paymentStream",bean.getPaymentStream());
			}
			if (bean.getDescription() != null && !bean.getDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.description =:description");
				map.put("description",bean.getDescription());
			}
			if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.createdBy =:createdBy");
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
				
				buff.append("c.createdDate =:createdDate");
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
			if (bean.getInputSla() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.inputSla =:modifiedDate");
				map.put("modifiedDate",String.valueOf(bean.getInputSla()));
			}
			if (bean.getSettleSla() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.settleSla =:settleSla");
				map.put("settleSla",String.valueOf(bean.getSettleSla()));
			}
			if (bean.getOutputSla() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.outputSla =:outputSla");
				map.put("outputSla",String.valueOf(bean.getOutputSla()));
			}
			if (bean.getDisplayName() != null && !bean.getDisplayName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.displayName =:displayName");
				map.put("displayName",bean.getDisplayName());
			}
			if (bean.getSettlementName() != null && !bean.getSettlementName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.settlementName =:settlementName");
				map.put("settlementName",bean.getSettlementName());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CsfSubServices");
		}
		return buff.toString();
	}

	/**
	 * Build a Dynamic Parameter Class.
	 *
	 * @param bean The Object to be inserted.
	 * @param ps The Prepared Statement.
	 * @param pos offset for parameters.
	 * @param select Is parameters for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private void setParameters(CSFSubServicesDTO bean,int pos, boolean select) throws DAOException {
		StringBuilder sb = new StringBuilder();
		if(bean == null) {
			return;
		}
		try {
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				sb.append(bean.getService());
				sb.append(",");
			}
			if (bean.getSubservice() != null && !bean.getSubservice().isEmpty()) {
				sb.append(bean.getSubservice());
				sb.append(",");
			}
			if (select == true) {
				if (bean.getActiveIndicator() != null && !bean.getActiveIndicator().isEmpty()) {
					sb.append(bean.getActiveIndicator());
					sb.append(",");
				}
				if (bean.getPaymentStream() != null && !bean.getPaymentStream().isEmpty()) {
					sb.append(bean.getPaymentStream());
					sb.append(",");
				}
				if (bean.getDescription() != null && !bean.getDescription().isEmpty()) {
					sb.append(bean.getDescription());
					sb.append(",");
				}
				if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
					sb.append(bean.getCreatedBy());
					sb.append(",");
				}
				if (bean.getCreatedDate() != null) {
					sb.append(bean.getCreatedDate());
					sb.append(",");
				}
				if (bean.getModifiedBy() != null && !bean.getModifiedBy().isEmpty()) {
					sb.append(bean.getModifiedBy());
					sb.append(",");
				}
				if (bean.getModifiedDate() != null) {
					sb.append(bean.getModifiedDate());
					sb.append(",");
				}
				if (bean.getInputSla() > 0) {
					sb.append(bean.getInputSla());
					sb.append(",");
				}
				if (bean.getSettleSla() > 0) {
					sb.append(bean.getSettleSla());
					sb.append(",");
				}
				if (bean.getOutputSla() > 0) {
					sb.append(bean.getOutputSla());
					sb.append(",");
				}
				if (bean.getDisplayName() != null && !bean.getDisplayName().isEmpty()) {
					sb.append(bean.getDisplayName());
					sb.append(",");
				}
				if (bean.getSettlementName() != null && !bean.getSettlementName().isEmpty()) {
					sb.append(bean.getSettlementName());
				
				}
			}
			
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSF_SUB_SERVICES, cause: "
					+ ex.getMessage(), ex);
		} finally {
		}
	}


}
