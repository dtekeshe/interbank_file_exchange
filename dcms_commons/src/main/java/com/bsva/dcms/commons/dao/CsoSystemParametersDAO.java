package com.bsva.dcms.commons.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoSystemParametersDao;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoSystemParameters;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoSystemParametersDAO{

	//private CsoSystemParametersRepository csoSystemParametersRepoDao = DaoFactory.csoSystemParametersInstance();
	
	private CsoSystemParametersDao csoSystemParametersDao = new CsoSystemParametersDao();
	
    private Map<String,Object>map = new HashMap<String,Object>();

	public CsoSystemParametersDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CsoSystemParametersDTO bean) throws DAOException {

		CsoSystemParameters csoSystemParameters= new CsoSystemParameters();
		csoSystemParameters.setCccoreInterval((short) bean.getCccoreInterval());
		csoSystemParameters.setCisDownloadInd(bean.getCisDownloadInd());
		csoSystemParameters.setEodDone(bean.getEodDone());
		csoSystemParameters.setLiveTestCode(bean.getLiveTestCode());
		csoSystemParameters.setNextOutputDate(bean.getNextOutputDate());
		csoSystemParameters.setProcessActiveInd(bean.getProcessActiveInd());
		csoSystemParameters.setProcessDate(bean.getProcessDate());
		csoSystemParameters.setRunBatch(bean.getRunBatch());
		csoSystemParameters.setUnixSodDone(bean.getUnixSodDone());

		csoSystemParametersDao.create(csoSystemParameters);

	}
	public void delete(CsoSystemParametersDTO bean) throws DAOException {
		CsoSystemParameters csoSystemParameters= new CsoSystemParameters();
		csoSystemParameters.setCccoreInterval((short) bean.getCccoreInterval());
		csoSystemParameters.setCisDownloadInd(bean.getCisDownloadInd());
		csoSystemParameters.setEodDone(bean.getEodDone());
		csoSystemParameters.setLiveTestCode(bean.getLiveTestCode());
		csoSystemParameters.setNextOutputDate(bean.getNextOutputDate());
		csoSystemParameters.setProcessActiveInd(bean.getProcessActiveInd());
		csoSystemParameters.setProcessDate(bean.getProcessDate());
		csoSystemParameters.setRunBatch(bean.getRunBatch());
		csoSystemParameters.setUnixSodDone(bean.getUnixSodDone());

		csoSystemParametersDao.delete(csoSystemParameters);
	}

	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public CsoSystemParametersDTO retrieve(CsoSystemParametersDTO bean) throws DAOException {
		CsoSystemParametersDTO dto = null;

		try{

			String sql = "SELECT c  FROM CsoSystemParameters c "+ buildWhereClause(bean,true);

			CsoSystemParameters csoSystemParameters = csoSystemParametersDao.executeQueryParametersSingleDate(sql, map);

				if(csoSystemParameters != null){
					dto = new CsoSystemParametersDTO();
					dto.setCccoreInterval(csoSystemParameters.getCccoreInterval());
					
					if(csoSystemParameters.getCisDownloadInd()!=null){
					dto.setCisDownloadInd(csoSystemParameters.getCisDownloadInd());
					}
					if(csoSystemParameters.getEodDone()!=null){
					dto.setEodDone(csoSystemParameters.getEodDone());
					}
					if(csoSystemParameters.getLiveTestCode()!=null){
					dto.setLiveTestCode(csoSystemParameters.getLiveTestCode());
					}
					if(csoSystemParameters.getNextOutputDate()!=null){
					dto.setNextOutputDate(csoSystemParameters.getNextOutputDate());
					}
					if(csoSystemParameters.getProcessActiveInd()!=null){
					dto.setProcessActiveInd(csoSystemParameters.getProcessActiveInd());
					}
					if(csoSystemParameters.getProcessDate()!=null){
					dto.setProcessDate(csoSystemParameters.getProcessDate());
					}
					if(csoSystemParameters.getRunBatch()!=null){
					dto.setRunBatch(csoSystemParameters.getRunBatch());
					}
					if(csoSystemParameters.getUnixSodDone()!=null){
					dto.setUnixSodDone(csoSystemParameters.getUnixSodDone());
					}
			
				}
		}catch(Exception ex){
			ex.getMessage();
		}
		map.clear();
		return dto;

	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsoSystemParametersDTO> retrieveRelated(CsoSystemParametersDTO bean) throws DAOException {
		List<CsoSystemParametersDTO> dtoList = new LinkedList<CsoSystemParametersDTO>();
		CsoSystemParametersDTO dto;
		try{

			String sql = "SELECT c  FROM CsoSystemParameters c "  + buildWhereClause(bean,true);
			List<CsoSystemParameters> csoSystemParametersretrieveRelated = csoSystemParametersDao.executeQueryParameters(sql, map);

			for (CsoSystemParameters csoSystemParametersRelated : csoSystemParametersretrieveRelated) {
				dto = new CsoSystemParametersDTO();
				dto.setCccoreInterval(csoSystemParametersRelated.getCccoreInterval());
				
				if(csoSystemParametersRelated.getCisDownloadInd()!=null){
				dto.setCisDownloadInd(csoSystemParametersRelated.getCisDownloadInd());
				}
				if(csoSystemParametersRelated.getEodDone()!=null){
				dto.setEodDone(csoSystemParametersRelated.getEodDone());
				}
				if(csoSystemParametersRelated.getLiveTestCode()!=null){
				dto.setLiveTestCode(csoSystemParametersRelated.getLiveTestCode());
				}
				if(csoSystemParametersRelated.getNextOutputDate()!=null){
				dto.setNextOutputDate(csoSystemParametersRelated.getNextOutputDate());
				}
				if(csoSystemParametersRelated.getProcessActiveInd()!=null){
				dto.setProcessActiveInd(csoSystemParametersRelated.getProcessActiveInd());
				}
				if(csoSystemParametersRelated.getProcessDate()!=null){
				dto.setProcessDate(csoSystemParametersRelated.getProcessDate());
				}
				if(csoSystemParametersRelated.getRunBatch()!=null){
				dto.setRunBatch(csoSystemParametersRelated.getRunBatch());
				}
				if(csoSystemParametersRelated.getUnixSodDone()!=null){
				dto.setUnixSodDone(csoSystemParametersRelated.getUnixSodDone());
				}
				dtoList.add(dto);
			}

		}catch(Exception ex){
			ex.getMessage();
		}
		map.clear();
		return dtoList;
	}

	private String buildWhereClause(CsoSystemParametersDTO bean,boolean select) throws DAOException {
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
			
			buff.append("c.processDate =:processDate");
			map.put("processDate",bean.getProcessDate());
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
		if (bean.getLiveTestCode() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.liveTestCode =:liveTestCode");
			map.put("liveTestCode",bean.getLiveTestCode());
		}
		if (bean.getCisDownloadInd() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.cisDownloadInd =:cisDownloadInd");
			map.put("cisDownloadInd",bean.getCisDownloadInd());
		}
		if (bean.getEodDone() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.eodDone =:eodDone");
			map.put("eodDone",bean.getEodDone());
		}
		if (bean.getRunBatch() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.runBatch =:runBatch");
			map.put("runBatch",bean.getRunBatch());
		}
		if (bean.getUnixSodDone() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.unixSodDone =:unixSodDone");
			map.put("unixSodDone",bean.getUnixSodDone());
		}
		if (bean.getCccoreInterval() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.cccoreInterval =:cccoreInterval");
			map.put("cccoreInterval",String.valueOf(bean.getCccoreInterval()));
		}
		if (bean.getNextOutputDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.nextOutputDate =:nextOutputDate");
			map.put("nextOutputDate",String.valueOf(bean.getNextOutputDate()));
		}
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot Build where clause in CsoSystemParameters");
		}

		return buff.toString();
	}

/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsoSystemParametersDTO bean) throws DAOException {
			
		CsoSystemParameters csoSystemParametersEntity = new CsoSystemParameters();
		csoSystemParametersEntity.setCccoreInterval((short) bean.getCccoreInterval());
		csoSystemParametersEntity.setCisDownloadInd(bean.getCisDownloadInd());
		csoSystemParametersEntity.setEodDone(bean.getEodDone());
		csoSystemParametersEntity.setLiveTestCode(bean.getLiveTestCode());
		csoSystemParametersEntity.setNextOutputDate(bean.getNextOutputDate());
		csoSystemParametersEntity.setProcessActiveInd(bean.getProcessActiveInd());
		csoSystemParametersEntity.setProcessDate(bean.getProcessDate());
		csoSystemParametersEntity.setRunBatch(bean.getRunBatch());
		csoSystemParametersEntity.setUnixSodDone(bean.getUnixSodDone());

		try {
			
			csoSystemParametersDao.update(csoSystemParametersEntity);

		} catch (Exception ex) {
			ex.getMessage();
		} 
	}
	public void delete()throws DAOException {
		
		csoSystemParametersDao.deleteBulk("Delete from CsoSystemParameters");
	}

}
