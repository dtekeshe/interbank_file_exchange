package com.bsva.dcms.commons.dao;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import com.bsva.dao.CsfServicesDao;
import com.bsva.dcms.commons.dto.CSFServicesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfServices;
import com.bsva.entities.CsfServicesPK;

/**
 *
 * @author Nombuyiselo Mbangula <nombuyiselom@bankservafrica.com>
 */

public class CSFServicesDAO {



	//private CsfServicesRepository csfServiceDao = DaoFactory.csfServicesInstance();
	private CsfServicesDao csfServiceDao = new CsfServicesDao();

	private Map<String,Object> map = new HashMap<String, Object>();

	public CSFServicesDAO() {

	}

	/**
	 * Creating CSF_CARD_SERVICES Table entries
	 */

	public void create(CSFServicesDTO csfServicesDTO) throws DAOException {

		try {
			CsfServices csfServices = new CsfServices();
			CsfServicesPK csfServicesPK = new CsfServicesPK();
			csfServicesPK.setServiceCode(csfServicesDTO.getServiceCode());
			csfServicesPK.setServiceName(csfServicesDTO.getServiceName());
			
			csfServices.setCsfServicesPK(csfServicesPK);
			csfServices.setActiveIndicator(csfServicesDTO.getActiveIndicator());
			csfServices.setCreatedBy(csfServicesDTO.getCreatedBy());
			csfServices.setCreatedDate(csfServicesDTO.getCreatedDate());
			csfServices.setModifiedBy(csfServicesDTO.getModifiedBy());
			csfServices.setModifiedDate(csfServicesDTO.getModifiedDate());
			csfServices.setInputSla((short) csfServicesDTO.getInputSla());
			csfServices.setSettleSla((short) csfServicesDTO.getSettleSla());
			csfServices.setOutputSla((short) csfServicesDTO.getOutputSla());

			csfServiceDao.create(csfServices);


		} catch (Exception ex) {
			throw new DAOException("Error creating CSF_SERVICES entry, cause: "
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving CSF_SERVICES entries
	 */

	public CSFServicesDTO retrieve(CSFServicesDTO obj) throws DAOException {
		CSFServicesDTO dto = new CSFServicesDTO();
		try {

			String sql = "SELECT c FROM CsfServices c "+ buildWhereClause(obj,true);
			CsfServices csfService = csfServiceDao.executeQueryParametersSingle(sql, map);

			if(csfService.getCsfServicesPK().getServiceCode()!=null){
				dto.setServiceCode(csfService.getCsfServicesPK().getServiceCode());
			}
			if(csfService.getCsfServicesPK().getServiceName()!=null){
				dto.setServiceName(csfService.getCsfServicesPK().getServiceName());
			}
			if(csfService.getActiveIndicator()!=null){
				dto.setActiveIndicator(csfService.getActiveIndicator());
			}
			if(csfService.getCreatedBy()!=null){
				dto.setCreatedBy(csfService.getCreatedBy());
			}
			if(csfService.getCreatedDate()!=null){
				dto.setCreatedDate(csfService.getCreatedDate());
			}
			if(csfService.getModifiedBy()!=null){
				dto.setModifiedBy(csfService.getModifiedBy());
			}
			if(csfService.getModifiedDate()!=null){
				dto.setModifiedDate(csfService.getModifiedDate());
			}
			if(csfService.getInputSla()!=null){
				dto.setInputSla(csfService.getInputSla().intValue());
			}
			if(csfService.getSettleSla()!=null){
				dto.setSettleSla(csfService.getSettleSla().intValue());
			}
			if(csfService.getOutputSla()!=null){
				dto.setOutputSla(csfService.getOutputSla().intValue());
			}

			map.clear();
			return dto;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CSF_SERVICES entry, cause: "+ ex.getMessage(), ex);
		}

	}

	public List<CSFServicesDTO> retrieveRelated(CSFServicesDTO obj)throws DAOException {
		
		List<CSFServicesDTO> dtoList = new LinkedList<CSFServicesDTO>();
		
		CSFServicesDTO dto = null;
		
		try {
			String sql = "SELECT c FROM CsfServices c "+ buildWhereClause(obj,true);
			List<CsfServices> csfServices = csfServiceDao.executeQueryParameters(sql, map);

			for (CsfServices csfService : csfServices) {
				
				dto = new CSFServicesDTO();
				dto.setServiceCode(csfService.getCsfServicesPK().getServiceCode());
				dto.setServiceName(csfService.getCsfServicesPK().getServiceName());
				if(csfService.getActiveIndicator()!=null){
					dto.setActiveIndicator(csfService.getActiveIndicator());
				}
				if(csfService.getCreatedBy()!=null){
					dto.setCreatedBy(csfService.getCreatedBy());
				}
				if(csfService.getCreatedDate()!=null){
					dto.setCreatedDate(csfService.getCreatedDate());
				}
				if(csfService.getModifiedBy()!=null){
					dto.setModifiedBy(csfService.getModifiedBy());
				}
				if(csfService.getModifiedDate()!=null){
					dto.setModifiedDate(csfService.getModifiedDate());
				}
				if(csfService.getInputSla()!=null){
					dto.setInputSla(csfService.getInputSla().intValue());
				}
				if(csfService.getSettleSla()!=null){
					dto.setSettleSla(csfService.getSettleSla().intValue());
				}
				if(csfService.getOutputSla()!=null){
					dto.setOutputSla(csfService.getOutputSla().intValue());
				}

				map.clear();
				dtoList.add(dto);
			}			
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CSF_SERVICES entries, cause: "+ ex.getMessage(), ex);
		}

	}


	/**
	 * Updating CSF_SERVICES table
	 */

	public void update(CSFServicesDTO obj) throws DAOException {

		CsfServices csfServices = new CsfServices();
		CsfServicesPK csfServicesPK = new CsfServicesPK();
		csfServicesPK.setServiceCode(obj.getServiceCode());
		csfServicesPK.setServiceName(obj.getServiceName());
		
		csfServices.setCsfServicesPK(csfServicesPK);
		csfServices.setActiveIndicator(obj.getActiveIndicator());
		csfServices.setCreatedBy(obj.getCreatedBy());
		csfServices.setCreatedDate(obj.getCreatedDate());
		csfServices.setModifiedBy(obj.getModifiedBy());
		csfServices.setModifiedDate(obj.getModifiedDate());
		csfServices.setInputSla((short) obj.getInputSla());
		csfServices.setSettleSla((short) obj.getSettleSla());
		csfServices.setOutputSla((short) obj.getOutputSla());

		try {

			csfServiceDao.update(csfServices);

		} catch (Exception ex) {
			throw new DAOException("Error updating CSF_SERVICES entry, cause: "+ ex.getMessage(), ex);
		}
	}


	private String buildWhereClause(CSFServicesDTO obj, boolean select)throws DAOException  {

		if (obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		if (select == true) {
		if (obj.getServiceCode() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.serviceCode =:serviceCode");
			map.put("serviceCode",obj.getServiceCode());
		}

		if (obj.getServiceName() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.serviceName =:serviceName" );
			map.put("serviceName",obj.getServiceName());
		}

		if (obj.getActiveIndicator() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.activeIndicator =:activeIndicator" );
			map.put("activeIndicator",obj.getActiveIndicator());
		}

		if (obj.getCreatedBy() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.createdBy =:createdBy" );
			map.put("createdBy",obj.getCreatedBy());
		}

		if (obj.getCreatedDate() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.createdDate =:createdDate" );
			map.put("createdDate",String.valueOf(obj.getCreatedDate()));
		}

		if (obj.getModifiedBy() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.modifiedBy =:modifiedBy" );
			map.put("modifiedBy",obj.getModifiedBy());
		}

		if (obj.getModifiedDate() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.modifiedDate =:modifiedDate" );
			map.put("modifiedDate",String.valueOf(obj.getModifiedDate()));
		}

		if (obj.getInputSla() != 0) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.inputSla =:inputSla" );
			map.put("inputSla",String.valueOf(obj.getInputSla()));
		}

		if (obj.getSettleSla() != 0) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.settleSla =:settleSla" );
			map.put("settleSla",String.valueOf(obj.getSettleSla()));
		}

		if (obj.getOutputSla() != 0) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.outputSla =:outputSla" );
			map.put("outputSla",String.valueOf(obj.getOutputSla()));
		}
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot update delete all rows in CsfServices");
		}


		return buff.toString();
	}


}
