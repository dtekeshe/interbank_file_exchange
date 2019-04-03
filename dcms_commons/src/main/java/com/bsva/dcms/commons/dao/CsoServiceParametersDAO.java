package com.bsva.dcms.commons.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;





import java.util.Map;

import com.bsva.dao.CsoServiceParametersDao;
import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoServiceParameters;
import com.bsva.entities.CsoServiceParametersPK;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoServiceParametersDAO {

	private Map<String, Object> map = new HashMap<>();
	public CsoServiceParametersDAO() {

	}

	//private CsoServiceParametersRepository csoServiceParametersRepoDao = DaoFactory.csoServiceParametersInstance();
	
	private CsoServiceParametersDao csoServiceParametersDao = new CsoServiceParametersDao();


	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public void create(CsoServiceParametersDTO bean) throws DAOException {

		CsoServiceParameters csoServiceParameters = new CsoServiceParameters();
		CsoServiceParametersPK csoServiceParametersPK = new CsoServiceParametersPK();
		
		csoServiceParametersPK.setProcessDate(bean.getProcessDate());
		csoServiceParametersPK.setService(bean.getService());
		csoServiceParametersPK.setSubService(bean.getSubService());
		
		csoServiceParameters.setInputRequestClose(bean.getInputRequestClose());
		csoServiceParameters.setInwardStatus(bean.getInwardStatus());
		csoServiceParameters.setOutwardStatus(bean.getOutwardStatus());
		csoServiceParameters.setProcessActiveInd(bean.getProcessActiveInd());
		csoServiceParameters.setCsoServiceParametersPK(csoServiceParametersPK);
		csoServiceParametersDao.create(csoServiceParameters);

	}

	public CsoServiceParametersDTO retrieve(CsoServiceParametersDTO bean) throws DAOException {
		CsoServiceParametersDTO dto = null;
		try {
			String sql = "SELECT c  FROM CsoServiceParameters c "+buildWhereClause(bean,true);
			CsoServiceParameters csoServiceParameters = csoServiceParametersDao.executeQueryParametersSingleDate(sql, map);
					dto = new CsoServiceParametersDTO();
					if(csoServiceParameters == null){
						map.clear();
						return null;
					}else{
				if(csoServiceParameters.getInputRequestClose()!=null){
					dto.setInputRequestClose(csoServiceParameters.getInputRequestClose());
				}
				if(csoServiceParameters.getInwardStatus()!=null){
					dto.setInwardStatus(csoServiceParameters.getInwardStatus());
				}
				if(csoServiceParameters.getOutwardStatus()!=null){
					dto.setOutwardStatus(csoServiceParameters.getOutwardStatus());
				}
				if(csoServiceParameters.getProcessActiveInd()!=null){
					dto.setProcessActiveInd(csoServiceParameters.getProcessActiveInd());
				}
				if(csoServiceParameters.getCsoServiceParametersPK().getService()!=null){
					dto.setService(csoServiceParameters.getCsoServiceParametersPK().getService());
				}
				if(csoServiceParameters.getCsoServiceParametersPK().getSubService()!=null){
					dto.setSubService(csoServiceParameters.getCsoServiceParametersPK().getSubService());
				}
				if(csoServiceParameters.getCsoServiceParametersPK().getProcessDate()!=null){
					dto.setProcessDate(csoServiceParameters.getCsoServiceParametersPK().getProcessDate());
				}
				map.clear();
				return dto;
			}
		}
		catch(Exception ex) {
			throw new DAOException( "Cannot Pull Data from CsoServiceParameters "+ ex.getMessage());
		}
		
		
	}

	@SuppressWarnings("unchecked")
	public List<CsoServiceParametersDTO> retrieveRelated(CsoServiceParametersDTO bean) throws DAOException {
		List<CsoServiceParametersDTO> dtoList = new LinkedList<CsoServiceParametersDTO>();
		CsoServiceParametersDTO dto = null;

		try {
			String sql = "SELECT c  FROM CsoServiceParameters c "+ buildWhereClause(bean,true);

			List<CsoServiceParameters> csoServiceParametersretrieveRelated = csoServiceParametersDao.executeQueryParameters(sql, map);

			for (CsoServiceParameters csoServiceParametersRelated : csoServiceParametersretrieveRelated) {

				dto = new CsoServiceParametersDTO();
				if(csoServiceParametersRelated.getInputRequestClose()!=null){
					dto.setInputRequestClose(csoServiceParametersRelated.getInputRequestClose());
				}
				if(csoServiceParametersRelated.getInwardStatus()!=null){
					dto.setInwardStatus(csoServiceParametersRelated.getInwardStatus());
				}
				if(csoServiceParametersRelated.getOutwardStatus()!=null){
					dto.setOutwardStatus(csoServiceParametersRelated.getOutwardStatus());
				}
				if(csoServiceParametersRelated.getProcessActiveInd()!=null){
					dto.setProcessActiveInd(csoServiceParametersRelated.getProcessActiveInd());
				}
				if(csoServiceParametersRelated.getCsoServiceParametersPK().getService()!=null){
					dto.setService(csoServiceParametersRelated.getCsoServiceParametersPK().getService());
				}
				if(csoServiceParametersRelated.getCsoServiceParametersPK().getSubService()!=null){
					dto.setSubService(csoServiceParametersRelated.getCsoServiceParametersPK().getSubService());
				}
				if(csoServiceParametersRelated.getCsoServiceParametersPK().getProcessDate()!=null){
					dto.setProcessDate(csoServiceParametersRelated.getCsoServiceParametersPK().getProcessDate());
				}
				map.clear();
				dtoList.add(dto);
			}
		}
		catch(Exception ex) {
			throw new DAOException( "Cannot Pull Data from CsoServiceParameters"+ ex.getMessage());
		}

		return dtoList;
	}

	/**
	 * Retrieve a list of records based on rowcountfrom Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	//public List<CsoServiceParametersDTO> retrieveRelatedCount(CsoServiceParametersDTO bean, int startRow, int endRow) throws DAOException {
	public int retrieveRelatedCount(CsoServiceParametersDTO bean) throws DAOException {	
		try {
			String sql = "SELECT COUNT(*) AS count FROM CsoServiceParameters ";
			int count = (int) csoServiceParametersDao.executeCountQuery(sql);

			return count;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsoServiceParameters, cause: "+ ex.getMessage(), ex);
		}
	}

	private String buildWhereClause(CsoServiceParametersDTO bean, boolean select)throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		
		if (select == true) {
				
		if (bean.getProcessDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			buff.append("c.csoServiceParametersPK.processDate =:processDate");
			map.put("processDate",bean.getProcessDate());
		}
		if (bean.getService() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.csoServiceParametersPK.service  =:service ");
			map.put("service",bean.getService());
		}
		if (bean.getSubService() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.csoServiceParametersPK.subService =:subService");
			map.put("subService",bean.getSubService());
		}

		if (bean.getProcessActiveInd() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.processActiveInd =:processActiveInd");
			map.put("processActiveInd",bean.getProcessActiveInd());
		}
		if (bean.getInwardStatus() != null && !bean.getInwardStatus().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.inwardStatus =:inwardStatus");
			map.put("inwardStatus",bean.getInwardStatus());
		}
		if (bean.getOutwardStatus() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.outwardStatus =:outwardStatus");
			map.put("outwardStatus",bean.getOutwardStatus());
		}
		if (bean.getInputRequestClose() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.inputRequestClose =:inputRequestClose");
			map.put("inputRequestClose",bean.getInputRequestClose());
		}
		
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot build where clause in CsoServiceParameters");
		}

		return buff.toString();
	}


	public void update(CsoServiceParametersDTO bean) throws DAOException {
		try{
			CsoServiceParameters csoServiceParameters = new CsoServiceParameters();
			CsoServiceParametersPK csoServiceParametersPK = new CsoServiceParametersPK();			
			csoServiceParametersPK.setProcessDate(bean.getProcessDate());
			csoServiceParametersPK.setService(bean.getService());
			csoServiceParametersPK.setSubService(bean.getSubService());			
			csoServiceParameters.setInputRequestClose(bean.getInputRequestClose());
			csoServiceParameters.setInwardStatus(bean.getInwardStatus());
			csoServiceParameters.setOutwardStatus(bean.getOutwardStatus());
			csoServiceParameters.setProcessActiveInd(bean.getProcessActiveInd());
			csoServiceParameters.setCsoServiceParametersPK(csoServiceParametersPK);
			
			csoServiceParametersDao.update(csoServiceParameters);
		} catch (Exception ex) {
			ex.getMessage();
		} 
	}
	
	public void delete()throws DAOException {
		
    	csoServiceParametersDao.deleteBulk("Delete from CsoServiceParameters");
	}
}
