package com.bsva.dcms.commons.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfDistributionParametersDao;
import com.bsva.dcms.commons.dto.CSFDistributionParametersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfDistributionParameters;
import com.bsva.entities.CsfDistributionParametersPK;
import com.bsva.entities.CsfSystemService;


public class CSFDistributionParametersDAO {
	private Map<String,Object> map = new HashMap<>();
	//private CsfDistributionParametersRepository csfDistributionParamDao = DaoFactory.csfDistributionParametersInstance();
	private CsfDistributionParametersDao csfDistributionParamDao = new CsfDistributionParametersDao();

	public CSFDistributionParametersDAO() {

	}

	/**
	 * Creating CSF_CARD_SERVICES Table entries
	 */

	public void create(CSFDistributionParametersDTO csfDistributionParametersDTO)
			throws DAOException {
		try {
			CsfDistributionParameters csfDistribution = new CsfDistributionParameters();	
			
			CsfDistributionParametersPK csfDistributionParametersPK = new CsfDistributionParametersPK();			
			csfDistributionParametersPK.setBankCode((short) csfDistributionParametersDTO.getBankCode());
			csfDistributionParametersPK.setReportName(csfDistributionParametersDTO.getReportName());	
			
			csfDistribution.setCsfDistributionParametersPK(csfDistributionParametersPK);
			csfDistribution.setMediaType(csfDistributionParametersDTO.getMediaType());
			CsfSystemService csfSystemService = new CsfSystemService();
			csfSystemService.setServiceCode(csfDistributionParametersDTO.getService());
			csfDistribution.setService(csfSystemService);
			csfDistribution.setStatusCode(csfDistributionParametersDTO.getStatusCode());
			csfDistribution.setBankDestination(csfDistributionParametersDTO.getBankDestination());
			csfDistribution.setCreatedBy(csfDistributionParametersDTO.getCreatedBy());
			csfDistribution.setCreatedDate((Date) csfDistributionParametersDTO.getCreatedDate());
			csfDistribution.setModifiedBy(csfDistributionParametersDTO.getModifiedBy());
			csfDistribution.setModifiedDate((Date) csfDistributionParametersDTO.getModifiedDate());
			csfDistribution.setInwardOutwardInd(csfDistributionParametersDTO.getInwardOutwardInd());
			csfDistributionParamDao.create(csfDistribution);						

		} catch (Exception ex) {
			throw new DAOException("Error creating CSF_DISTRIBUTION_PARAMETERS entry, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving CSF_DISTRIBUTION_PARAMETERS entries
	 */
	//CSFDistributionParameters
	public CSFDistributionParametersDTO retrieve(CSFDistributionParametersDTO obj) throws DAOException {
		CSFDistributionParametersDTO dto = new CSFDistributionParametersDTO();
		try {

			String sql = "SELECT c FROM CsfDistributionParameters c WHERE c.BANK_CODE = ?";


			CsfDistributionParameters  csfDistribution  = csfDistributionParamDao.executeQueryParametersSingle(sql, map);

			//if(csfDistribution.getCsfDistributionParametersPK().getBankCode()!=null){
			dto.setBankCode((short) csfDistribution.getCsfDistributionParametersPK().getBankCode());
			//}
			if(csfDistribution.getCsfDistributionParametersPK().getReportName()!=null){
				dto.setReportName(csfDistribution.getCsfDistributionParametersPK().getReportName());	
			}
			if(csfDistribution.getMediaType()!=null){
				dto.setMediaType(csfDistribution.getMediaType());
			}
			if(csfDistribution.getService().getServiceCode()!=null){
				dto.setService(csfDistribution.getService().getServiceCode());
			}
			if(csfDistribution.getSubService()!=null){
				dto.setSubService(csfDistribution.getSubService());
			}
			if(csfDistribution.getStatusCode()!=null){
				dto.setStatusCode(csfDistribution.getStatusCode());
			}
			if(csfDistribution.getBankDestination()!=null){
				dto.setBankDestination(csfDistribution.getBankDestination());
			}
			if(csfDistribution.getCreatedBy()!=null){
				dto.setCreatedBy(csfDistribution.getCreatedBy());
			}
			if(csfDistribution.getCreatedDate()!=null){
				dto.setCreatedDate(csfDistribution.getCreatedDate());
			}
			if(csfDistribution.getModifiedBy()!=null){
				dto.setModifiedBy(csfDistribution.getModifiedBy());
			}
			if(csfDistribution.getModifiedDate()!=null){
				dto.setModifiedDate(csfDistribution.getModifiedDate());
			}
			if(csfDistribution.getInwardOutwardInd()!=null){
				dto.setInwardOutwardInd(csfDistribution.getInwardOutwardInd());
			}


		} catch (Exception ex) {
			throw new DAOException(
					"Error retrieving CSF_DISTRIBUTION_PARAMETERS entry, cause: "
							+ ex.getMessage(), ex);
		}
		map.clear();
		return dto;
	}

	public List<CSFDistributionParametersDTO> retrieveRelated(CSFDistributionParametersDTO obj) throws DAOException {

		List<CSFDistributionParametersDTO> dtoList = new LinkedList<CSFDistributionParametersDTO>();
		CSFDistributionParametersDTO dto = null;
		try {
			String sql = "SELECT c FROM CsfDistributionParameters c" + buildWhereClause(obj);

			List<CsfDistributionParameters> distributionParameters =  csfDistributionParamDao.executeQueryParameters(sql, map);

			for (CsfDistributionParameters csfDistribution : distributionParameters) {
				dto = new CSFDistributionParametersDTO();
				
				//if(csfDistribution.getCsfDistributionParametersPK().getBankCode()!=null){
				dto.setBankCode((short) csfDistribution.getCsfDistributionParametersPK().getBankCode());
				//}
				if(csfDistribution.getCsfDistributionParametersPK().getReportName()!=null){
					dto.setReportName(csfDistribution.getCsfDistributionParametersPK().getReportName());	
				}
				if(csfDistribution.getMediaType()!=null){
					dto.setMediaType(csfDistribution.getMediaType());
				}
				if(csfDistribution.getService().getServiceCode()!=null){
					dto.setService(csfDistribution.getService().getServiceCode());
				}
				if(csfDistribution.getSubService()!=null){
					dto.setSubService(csfDistribution.getSubService());
				}
				if(csfDistribution.getStatusCode()!=null){
					dto.setStatusCode(csfDistribution.getStatusCode());
				}
				if(csfDistribution.getBankDestination()!=null){
					dto.setBankDestination(csfDistribution.getBankDestination());
				}
				if(csfDistribution.getCreatedBy()!=null){
					dto.setCreatedBy(csfDistribution.getCreatedBy());
				}
				if(csfDistribution.getCreatedDate()!=null){
					dto.setCreatedDate(csfDistribution.getCreatedDate());
				}
				if(csfDistribution.getModifiedBy()!=null){
					dto.setModifiedBy(csfDistribution.getModifiedBy());
				}
				if(csfDistribution.getModifiedDate()!=null){
					dto.setModifiedDate(csfDistribution.getModifiedDate());
				}
				if(csfDistribution.getInwardOutwardInd()!=null){
					dto.setInwardOutwardInd(csfDistribution.getInwardOutwardInd());
				}
				map.clear();
				dtoList.add(dto);
			}

		} catch (Exception ex) {
			throw new DAOException(
					"Error retrieving CSF_DISTRIBUTION_PARAMETERS entries, cause: "
							+ ex.getMessage(), ex);
		}
		return dtoList;
	}

	private String buildWhereClause(CSFDistributionParametersDTO obj) {

		if (obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (obj.getBankCode() != -1) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.bankCode  =:bankCode");
			map.put("bankCode",String.valueOf(obj.getBankCode()));
		}

		if (obj.getReportName() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.reportName  =:reportName");
			map.put("reportName",obj.getReportName());
		}

		if (obj.getMediaType() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.mediaType  =:mediaType");
			map.put("mediaType",obj.getMediaType());
		}
		if (obj.getService() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.service  =:service");
			map.put("service",obj.getService());
		}
		if (obj.getSubService() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.subService  =:subService");
			map.put("subService",obj.getSubService());
		}
		if (obj.getStatusCode() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.statusCode  =:statusCode");
			map.put("statusCode",obj.getStatusCode());
		}
		if (obj.getBankDestination() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.bankDestination  =:bankDestination");
			map.put("bankDestination",obj.getBankDestination());
		}

		if (obj.getCreatedBy() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.createdBy  =:createdBy");
			map.put("createdBy",obj.getCreatedBy());
		}

		if (obj.getCreatedDate() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.createdDate  =:createdDate");
			map.put("createdDate",String.valueOf(obj.getCreatedDate()));
		}

		if (obj.getModifiedBy() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.modifiedBy  =:modifiedBy");
			map.put("modifiedBy",obj.getModifiedBy());
		}

		if (obj.getModifiedDate() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.modifiedDate  =:modifiedDate");
			map.put("modifiedDate",String.valueOf(obj.getModifiedDate()));
		}

		if (obj.getInwardOutwardInd() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.inwardOutwardInd  =:inwardOutwardInd");
			map.put("inwardOutwardInd",obj.getInwardOutwardInd());
		}

		return buff.toString();
	}

	/**
	 * Updating CSF_DISTRIBUTION_PARAMETERS table
	 */

	public void update(CSFDistributionParametersDTO csfDistributionParametersDTO) throws DAOException {

		try{

			CsfDistributionParameters csfDistribution = new CsfDistributionParameters();			
			CsfDistributionParametersPK csfDistributionParametersPK = new CsfDistributionParametersPK();			
			csfDistributionParametersPK.setBankCode((short) csfDistributionParametersDTO.getBankCode());
			csfDistributionParametersPK.setReportName(csfDistributionParametersDTO.getReportName());	
			csfDistribution.setCsfDistributionParametersPK(csfDistributionParametersPK);
			csfDistribution.setMediaType(csfDistributionParametersDTO.getMediaType());
			CsfSystemService csfSystemService = new CsfSystemService();
			csfSystemService.setServiceCode(csfDistributionParametersDTO.getService());
			csfDistribution.setService(csfSystemService);
			csfDistribution.setStatusCode(csfDistributionParametersDTO.getStatusCode());
			csfDistribution.setBankDestination(csfDistributionParametersDTO.getBankDestination());
			csfDistribution.setCreatedBy(csfDistributionParametersDTO.getCreatedBy());
			csfDistribution.setCreatedDate((Date) csfDistributionParametersDTO.getCreatedDate());
			csfDistribution.setModifiedBy(csfDistributionParametersDTO.getModifiedBy());
			csfDistribution.setModifiedDate((Date) csfDistributionParametersDTO.getModifiedDate());
			csfDistribution.setInwardOutwardInd(csfDistributionParametersDTO.getInwardOutwardInd());
			csfDistributionParamDao.update(csfDistribution);

		} catch (Exception ex) {
			throw new DAOException(
					"Error updating CSF_DISTRIBUTION_PARAMETERS entry, cause: "
							+ ex.getMessage(), ex);
		}
	}
	public void delete(CSFDistributionParametersDTO csfDistributionParametersDTO)
			throws DAOException {
		try {
			CsfDistributionParameters csfDistribution = new CsfDistributionParameters();			
			CsfDistributionParametersPK csfDistributionParametersPK = new CsfDistributionParametersPK();			
			csfDistributionParametersPK.setBankCode((short) csfDistributionParametersDTO.getBankCode());
			csfDistributionParametersPK.setReportName(csfDistributionParametersDTO.getReportName());	
			csfDistribution.setCsfDistributionParametersPK(csfDistributionParametersPK);
			csfDistribution.setMediaType(csfDistributionParametersDTO.getMediaType());
			CsfSystemService csfSystemService = new CsfSystemService();
			csfSystemService.setServiceCode(csfDistributionParametersDTO.getService());
			csfDistribution.setService(csfSystemService);
			csfDistribution.setStatusCode(csfDistributionParametersDTO.getStatusCode());
			csfDistribution.setBankDestination(csfDistributionParametersDTO.getBankDestination());
			csfDistribution.setCreatedBy(csfDistributionParametersDTO.getCreatedBy());
			csfDistribution.setCreatedDate((Date) csfDistributionParametersDTO.getCreatedDate());
			csfDistribution.setModifiedBy(csfDistributionParametersDTO.getModifiedBy());
			csfDistribution.setModifiedDate((Date) csfDistributionParametersDTO.getModifiedDate());
			csfDistribution.setInwardOutwardInd(csfDistributionParametersDTO.getInwardOutwardInd());
			csfDistributionParamDao.delete(csfDistribution);						

		} catch (Exception ex) {
			throw new DAOException("Error deleting CSF_DISTRIBUTION_PARAMETERS entry, cause: "+ ex.getMessage(), ex);
		}
	}


}
