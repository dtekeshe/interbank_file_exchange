package com.bsva.dcms.commons.dao;



import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfDeliveryServicesDao;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfDeliveryServices;
import com.bsva.entities.CsfSystemService;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfDeliveryServicesDAO{

	private Map<String,Object>map = new HashMap<String,Object>();
	private CsfDeliveryServicesDao deliveryServicesDao = new CsfDeliveryServicesDao();

	public CsfDeliveryServicesDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsfDeliveryServicesDTO create(CsfDeliveryServicesDTO bean) throws DAOException {

		try {
			CsfDeliveryServices delivery = new CsfDeliveryServices();            
			delivery.setFilenamePrefix(bean.getFilenamePrefix());
			delivery.setMediaType(bean.getMediaType());
			delivery.setInwardOutwardInd(bean.getInwardOutwardInd());
			delivery.setDescription(bean.getDescription());
			CsfSystemService csfSystemService = new CsfSystemService();
			csfSystemService.setServiceCode(bean.getService());
			delivery.setService(csfSystemService);
			delivery.setSubService(bean.getSubService());
			delivery.setFormat(bean.getFormat());
			delivery.setDestinationCode((short) bean.getDestinationCode());
			delivery.setBackupFormat(bean.getBackupFormat());
			delivery.setActiveIndicator(bean.getActiveIndicator());
			delivery.setCreatedBy(bean.getCreatedBy());
			delivery.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
			delivery.setModifiedBy(bean.getModifiedBy());
			delivery.setModifiedDate(new Date(bean.getModifiedDate().getTime()));
			delivery.setHeaderReference(bean.getHeaderReference());
			delivery.setFileFormat(bean.getFileFormat());
			
			deliveryServicesDao.create(delivery);            

			return bean;

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_DELIVERY_SERVICES, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfDeliveryServicesDTO retrieve(CsfDeliveryServicesDTO bean) throws DAOException {
		try {
			CsfDeliveryServicesDTO csfDeliveryServicesDTO ;

			String sql = "select c FROM CsfDeliveryServices c " + this.buildWhereClause(bean, true);

			CsfDeliveryServices csfDelivcery = deliveryServicesDao.executeQueryParametersSingleDate(sql,map);
			if(csfDelivcery != null){
			csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
			
			if(csfDelivcery.getFilenamePrefix()!=null){
				csfDeliveryServicesDTO.setFilenamePrefix(csfDelivcery.getFilenamePrefix());
			}
			if(csfDelivcery.getMediaType()!=null){
				csfDeliveryServicesDTO.setMediaType(csfDelivcery.getMediaType());
			}
			if(csfDelivcery.getInwardOutwardInd()!=null){
				csfDeliveryServicesDTO.setInwardOutwardInd(csfDelivcery.getInwardOutwardInd());
			}
			if(csfDelivcery.getDescription()!=null){
				csfDeliveryServicesDTO.setDescription(csfDelivcery.getDescription());
			}
			
			//if(csfDelivcery.getService().getServiceCode()!=null){
				csfDeliveryServicesDTO.setService(csfDelivcery.getService().getServiceCode());
			//}
			if(csfDelivcery.getSubService()!=null){
				csfDeliveryServicesDTO.setSubService(csfDelivcery.getSubService());
			}
			if(csfDelivcery.getFormat()!=null){
				csfDeliveryServicesDTO.setFormat(csfDelivcery.getFormat());
			}
			//if(csfDelivcery.getDestinationCode()!=null){
			csfDeliveryServicesDTO.setDestinationCode(csfDelivcery.getDestinationCode());
			//}
			if(csfDelivcery.getBackupFormat()!=null){
				csfDeliveryServicesDTO.setBackupFormat(csfDelivcery.getBackupFormat());
			}
			if(csfDelivcery.getActiveIndicator()!=null){
				csfDeliveryServicesDTO.setActiveIndicator(csfDelivcery.getActiveIndicator());
			}
			if(csfDelivcery.getCreatedBy()!=null){
				csfDeliveryServicesDTO.setCreatedBy(csfDelivcery.getCreatedBy());
			}
			if(csfDelivcery.getCreatedDate()!=null){
				csfDeliveryServicesDTO.setCreatedDate(csfDelivcery.getCreatedDate());
			}
			if(csfDelivcery.getModifiedBy()!=null){
				csfDeliveryServicesDTO.setModifiedBy(csfDelivcery.getModifiedBy());
			}
			if(csfDelivcery.getModifiedDate()!=null){
				csfDeliveryServicesDTO.setModifiedDate(csfDelivcery.getModifiedDate());
			}
			if(csfDelivcery.getHeaderReference()!=null){
				csfDeliveryServicesDTO.setHeaderReference(csfDelivcery.getHeaderReference());
			}
			if(csfDelivcery.getFileFormat()!=null){
				csfDeliveryServicesDTO.setFileFormat(csfDelivcery.getFileFormat());
			}
			if(csfDelivcery.getId() !=null){
				csfDeliveryServicesDTO.setId(csfDelivcery.getId().intValue());
			}
			map.clear();
			
			return csfDeliveryServicesDTO;
			}else{
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOException("Error retrieving CsfDeliveryServices, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsfDeliveryServicesDTO> retrieveRelated(CsfDeliveryServicesDTO bean) throws DAOException {
		List<CsfDeliveryServicesDTO> dtoList2 = new LinkedList<CsfDeliveryServicesDTO>();

		CsfDeliveryServicesDTO csfDeliveryServicesDTO = null;

		try {
			String sql = "select c FROM CsfDeliveryServices c " +this.buildWhereClause(bean, true);

			List<CsfDeliveryServices> csfDeliveryServicesQuery = deliveryServicesDao.executeQueryParameters(sql,map);
			for (CsfDeliveryServices csfDelivcery : csfDeliveryServicesQuery) {
				
				csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
				
				if(csfDelivcery.getFilenamePrefix()!=null){
					csfDeliveryServicesDTO.setFilenamePrefix(csfDelivcery.getFilenamePrefix());
				}
				if(csfDelivcery.getMediaType()!=null){
					csfDeliveryServicesDTO.setMediaType(csfDelivcery.getMediaType());
				}
				if(csfDelivcery.getInwardOutwardInd()!=null){
					csfDeliveryServicesDTO.setInwardOutwardInd(csfDelivcery.getInwardOutwardInd());
				}
				if(csfDelivcery.getDescription()!=null){
					csfDeliveryServicesDTO.setDescription(csfDelivcery.getDescription());
				}
				//CsfSystemService csfSystemService = new CsfSystemService();
				//if(csfDelivcery.getService().getServiceCode()!=null){
					csfDeliveryServicesDTO.setService(csfDelivcery.getService().getServiceCode());
				//}
				if(csfDelivcery.getSubService()!=null){
					csfDeliveryServicesDTO.setSubService(csfDelivcery.getSubService());
				}
				if(csfDelivcery.getFormat()!=null){
					csfDeliveryServicesDTO.setFormat(csfDelivcery.getFormat());
				}
				//if(csfDelivcery.getDestinationCode()!=null){
				csfDeliveryServicesDTO.setDestinationCode(csfDelivcery.getDestinationCode());
				//}
				if(csfDelivcery.getBackupFormat()!=null){
					csfDeliveryServicesDTO.setBackupFormat(csfDelivcery.getBackupFormat());
				}
				if(csfDelivcery.getActiveIndicator()!=null){
					csfDeliveryServicesDTO.setActiveIndicator(csfDelivcery.getActiveIndicator());
				}
				if(csfDelivcery.getCreatedBy()!=null){
					csfDeliveryServicesDTO.setCreatedBy(csfDelivcery.getCreatedBy());
				}
				if(csfDelivcery.getCreatedDate()!=null){
					csfDeliveryServicesDTO.setCreatedDate(csfDelivcery.getCreatedDate());
				}
				if(csfDelivcery.getModifiedBy()!=null){
					csfDeliveryServicesDTO.setModifiedBy(csfDelivcery.getModifiedBy());
				}
				if(csfDelivcery.getModifiedDate()!=null){
					csfDeliveryServicesDTO.setModifiedDate(csfDelivcery.getModifiedDate());
				}
				if(csfDelivcery.getHeaderReference()!=null){
					csfDeliveryServicesDTO.setHeaderReference(csfDelivcery.getHeaderReference());
				}
				if(csfDelivcery.getFileFormat()!=null){
					csfDeliveryServicesDTO.setFileFormat(csfDelivcery.getFileFormat());
				}
				if(csfDelivcery.getId() !=null){
					csfDeliveryServicesDTO.setId(csfDelivcery.getId().intValue());
				}
				dtoList2.add(csfDeliveryServicesDTO);
			}
			map.clear();
			return dtoList2;
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsfDeliveryServices, cause: "
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfDeliveryServicesDTO bean) throws DAOException {
		try{
			CsfDeliveryServices delivery = new CsfDeliveryServices();            
			delivery.setFilenamePrefix(bean.getFilenamePrefix());
			delivery.setMediaType(bean.getMediaType());
			delivery.setInwardOutwardInd(bean.getInwardOutwardInd());
			delivery.setDescription(bean.getDescription());
			CsfSystemService csfSystemService = new CsfSystemService();
			csfSystemService.setServiceCode(bean.getService());
			delivery.setService(csfSystemService);
			delivery.setSubService(bean.getSubService());
			delivery.setFormat(bean.getFormat());
			delivery.setDestinationCode((short) bean.getDestinationCode());
			delivery.setBackupFormat(bean.getBackupFormat());
			delivery.setActiveIndicator(bean.getActiveIndicator());
			delivery.setCreatedBy(bean.getCreatedBy());
			delivery.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
			delivery.setModifiedBy(bean.getModifiedBy());
			delivery.setModifiedDate(new Date(bean.getModifiedDate().getTime()));
			delivery.setHeaderReference(bean.getHeaderReference());
			delivery.setFileFormat(bean.getFileFormat());		
			delivery.setId(new BigDecimal(bean.getId()));
			deliveryServicesDao.update(delivery);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSF_DELIVERY_SERVICES, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsfDeliveryServicesDTO bean) throws DAOException {
		try{
			CsfDeliveryServices delivery = new CsfDeliveryServices();            
			delivery.setFilenamePrefix(bean.getFilenamePrefix());
			delivery.setMediaType(bean.getMediaType());
			delivery.setInwardOutwardInd(bean.getInwardOutwardInd());
			delivery.setDescription(bean.getDescription());
			CsfSystemService csfSystemService = new CsfSystemService();
			csfSystemService.setServiceCode(bean.getService());
			delivery.setService(csfSystemService);
			delivery.setSubService(bean.getSubService());
			delivery.setFormat(bean.getFormat());
			delivery.setDestinationCode((short) bean.getDestinationCode());
			delivery.setBackupFormat(bean.getBackupFormat());
			delivery.setActiveIndicator(bean.getActiveIndicator());
			delivery.setCreatedBy(bean.getCreatedBy());
			delivery.setCreatedDate(new Date(bean.getCreatedDate().getTime()));
			delivery.setModifiedBy(bean.getModifiedBy());
			delivery.setModifiedDate(new Date(bean.getModifiedDate().getTime()));
			delivery.setHeaderReference(bean.getHeaderReference());
			delivery.setFileFormat(bean.getFileFormat());
			delivery.setId(new BigDecimal(bean.getId()));
			deliveryServicesDao.delete(delivery);

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSF_DELIVERY_SERVICES, cause: "+ ex.getMessage(), ex);
		} 

	}

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsfDeliveryServicesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getFilenamePrefix() != null && !bean.getFilenamePrefix().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.filenamePrefix =:filenamePrefix");
			map.put("filenamePrefix",bean.getFilenamePrefix());	
		}
		if (bean.getService() != null && !bean.getService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			buff.append("c.service.serviceCode =:service");		
			map.put("service",String.valueOf(bean.getService()));	
		}
		if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.subService =:subService");
			
			map.put("subService",bean.getSubService());	
		}
		if (select == true) {
			if (bean.getMediaType() != null && !bean.getMediaType().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.mediaType =:mediaType");
				map.put("mediaType",bean.getMediaType());
			}
			if (bean.getInwardOutwardInd() != null && !bean.getInwardOutwardInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.inwardOutwardInd =:inwardOutwardInd");
				map.put("inwardOutwardInd",bean.getInwardOutwardInd());
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
			if (bean.getFormat() != null && !bean.getFormat().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.format =:format");
				map.put("format",bean.getFormat());
			}
			if (bean.getDestinationCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.destinationCode =:destinationCode");
				map.put("destinationCode",String.valueOf(bean.getDestinationCode()));
			}
			if (bean.getBackupFormat() != null && !bean.getBackupFormat().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.backupFormat =:backupFormat");
				map.put("backupFormat",bean.getBackupFormat());
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
			if (bean.getHeaderReference() != null && !bean.getHeaderReference().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.headerReference =:headerReference");
				map.put("headerReference",bean.getHeaderReference());
			}
			if (bean.getFileFormat() != null && !bean.getFileFormat().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.fileFormat =:fileFormat");
				map.put("fileFormat",bean.getFileFormat());
			}
			if (bean.getId() != 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.id =:id");
				map.put("id",bean.getId());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CsfDeliveryServices");
		}
		return buff.toString();
	}


}
