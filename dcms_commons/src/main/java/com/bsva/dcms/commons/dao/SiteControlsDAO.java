package com.bsva.dcms.commons.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.SiteControlsDao;
import com.bsva.dcms.commons.dto.SiteControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.SiteControls;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class SiteControlsDAO{

	private Map<String,Object> map = new HashMap<>();
	//private SiteControlsRepository siteControlDao = DaoFactory.siteControlsInstance();
	
	private SiteControlsDao siteControlDao = new SiteControlsDao();
	public SiteControlsDAO() {
    }

	public void create(SiteControlsDTO bean) throws DAOException {
	
		try {
			
			SiteControls siteControls = new SiteControls();
			siteControls.setSiteCode(bean.getSiteCode());
			siteControls.setSiteName(bean.getSiteName()); 
			siteControls.setDbName(bean.getDbName());
			siteControls.setMenuEod(bean.getMenuEod());
			siteControls.setSpolog(bean.getSpolog()); 
			siteControls.setReports(bean.getReports());
			siteControls.setApps(bean.getApps());
			siteControls.setReceive(bean.getReceive());
			siteControls.setSend(bean.getSend()); 
			siteControls.setPrev(bean.getPrev());
			siteControls.setRestore(bean.getRestore());
			siteControls.setSystemStatus(bean.getSystemStatus());
			siteControls.setDefaultCentre(bean.getDefaultCentre());
			
			siteControlDao.create(siteControls);
			 
 
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.SITE_CONTROLS, cause: "
					+ ex.getMessage(), ex);
		} 
	}
		
	public SiteControlsDTO retrieve(SiteControlsDTO bean) throws DAOException {
		SiteControlsDTO siteControlsDTO = new SiteControlsDTO();
		try {
			String sql = "SELECT s FROM SiteControls s "+ buildWhereClause(bean,true);
	        SiteControls siteControls = siteControlDao.executeQueryParametersSingle(sql,map);
	        if(siteControls.getSiteCode() != null){
	        siteControlsDTO.setSiteCode(siteControls.getSiteCode());
	        }
	        if(siteControls.getSiteName() != null){
	        siteControlsDTO.setSiteName(siteControls.getSiteName()); 
	        }
	        if(siteControls.getDbName() != null){
	        siteControlsDTO.setDbName(siteControls.getDbName());
	        }
	        if(siteControls.getMenuEod() != null){
	        siteControlsDTO.setMenuEod(siteControls.getMenuEod());
	        }
	        if(siteControls.getSpolog() != null){
	        siteControlsDTO.setSpolog(siteControls.getSpolog()); 
	        }
	        if(siteControls.getReports() != null){
	        siteControlsDTO.setReports(siteControls.getReports());
	        }
	        if(siteControls.getApps() != null){
	        siteControlsDTO.setApps(siteControls.getApps());
	        }
	        if(siteControls.getReceive() != null){
	        siteControlsDTO.setReceive(siteControls.getReceive());
	        }
	        if(siteControls.getSend() != null){
	        siteControlsDTO.setSend(siteControls.getSend()); 
	        }
	        if(siteControls.getPrev() != null){
	        siteControlsDTO.setPrev(siteControls.getPrev());
	        }
	        if(siteControls.getRestore() != null){
	        siteControlsDTO.setRestore(siteControls.getRestore());
	        }
	        if(siteControls.getSystemStatus() != null){
	        siteControlsDTO.setSystemStatus(siteControls.getSystemStatus());
	        }
	        if(siteControls.getDefaultCentre() != null){
	        siteControlsDTO.setDefaultCentre(siteControls.getDefaultCentre());
	        }
	        map.clear();
			return siteControlsDTO;
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.SITE_CONTROLS, cause: "+ ex.getMessage(), ex);
		} 
		
	}


	@SuppressWarnings("unchecked")
	public List<SiteControlsDTO> retrieveRelated(SiteControlsDTO bean) throws DAOException {
		 List<SiteControlsDTO> dtoList = new LinkedList<SiteControlsDTO>();
		 SiteControlsDTO siteControlsDTO;
	        try {
	          String sql = "select c from SiteControls c " +buildWhereClause(bean,true);
	          List<SiteControls> siteControlsRelated = siteControlDao.executeQueryParameters(sql,map);
	    		for (SiteControls siteControls : siteControlsRelated) {
	    			siteControlsDTO = new SiteControlsDTO();
	    			if(siteControls.getSiteCode() != null){
	    		        siteControlsDTO.setSiteCode(siteControls.getSiteCode());
	    		        }
	    		        if(siteControls.getSiteName() != null){
	    		        siteControlsDTO.setSiteName(siteControls.getSiteName()); 
	    		        }
	    		        if(siteControls.getDbName() != null){
	    		        siteControlsDTO.setDbName(siteControls.getDbName());
	    		        }
	    		        if(siteControls.getMenuEod() != null){
	    		        siteControlsDTO.setMenuEod(siteControls.getMenuEod());
	    		        }
	    		        if(siteControls.getSpolog() != null){
	    		        siteControlsDTO.setSpolog(siteControls.getSpolog()); 
	    		        }
	    		        if(siteControls.getReports() != null){
	    		        siteControlsDTO.setReports(siteControls.getReports());
	    		        }
	    		        if(siteControls.getApps() != null){
	    		        siteControlsDTO.setApps(siteControls.getApps());
	    		        }
	    		        if(siteControls.getReceive() != null){
	    		        siteControlsDTO.setReceive(siteControls.getReceive());
	    		        }
	    		        if(siteControls.getSend() != null){
	    		        siteControlsDTO.setSend(siteControls.getSend()); 
	    		        }
	    		        if(siteControls.getPrev() != null){
	    		        siteControlsDTO.setPrev(siteControls.getPrev());
	    		        }
	    		        if(siteControls.getRestore() != null){
	    		        siteControlsDTO.setRestore(siteControls.getRestore());
	    		        }
	    		        if(siteControls.getSystemStatus() != null){
	    		        siteControlsDTO.setSystemStatus(siteControls.getSystemStatus());
	    		        }
	    		        if(siteControls.getDefaultCentre() != null){
	    		        siteControlsDTO.setDefaultCentre(siteControls.getDefaultCentre());
	    		        }
	            	dtoList.add(siteControlsDTO);
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.SITE_CONTROLS, cause: "
				+ ex.getMessage(), ex);
		} 
	        map.clear();
		 return dtoList;
	}
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */
	
	public void update(SiteControlsDTO bean) throws DAOException {
		try {
			SiteControls siteControls = new SiteControls();
			siteControls.setSiteCode(bean.getSiteCode());
			siteControls.setSiteName(bean.getSiteName()); 
			siteControls.setDbName(bean.getDbName());
			siteControls.setMenuEod(bean.getMenuEod());
			siteControls.setSpolog(bean.getSpolog()); 
			siteControls.setReports(bean.getReports());
			siteControls.setApps(bean.getApps());
			siteControls.setReceive(bean.getReceive());
			siteControls.setSend(bean.getSend()); 
			siteControls.setPrev(bean.getPrev());
			siteControls.setRestore(bean.getRestore());
			siteControls.setSystemStatus(bean.getSystemStatus());
			siteControls.setDefaultCentre(bean.getDefaultCentre());
			siteControlDao.update(siteControls);
		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.SITE_CONTROLS, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	private String buildWhereClause(SiteControlsDTO bean, boolean select)throws DAOException  {
		
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		
		if (select == true) {
			if (bean.getSiteCode() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.siteCode =:siteCode");
				 map.put("siteCode", bean.getSiteCode());
			}
			if (bean.getSiteName() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.siteName =:siteName");
				 map.put("siteName",bean.getSiteName());
			}
			if (bean.getDbName() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.dbName =:dbName");
				 map.put("dbName",bean.getDbName());
			}
			if (bean.getMenuEod() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.menuEod =:menuEod");
				 map.put("menuEod",bean.getMenuEod());
			}
			if (bean.getSpolog() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.spolog =:spolog");
				 map.put("spolog",bean.getSpolog());
			}
			if (bean.getReports() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.reports =:reports");
				 map.put("reports",bean.getReports());
			}
			if (bean.getApps() != null ) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.apps =:apps");
				 map.put("apps",bean.getApps());
			}
			if (bean.getReceive() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.receive =:receive");
				 map.put("receive",bean.getReceive());
			}
			if (bean.getSend() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.send =:send");
				 map.put("send",bean.getSend());
			}
			if (bean.getPrev() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.prev=:prev");
				 map.put("prev",bean.getPrev());
			}
			if (bean.getRestore() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.restore =:restore");
				 map.put("restore",bean.getRestore());
			}
			if (bean.getSystemStatus() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.systemStatus =:systemStatus");
				 map.put("systemStatus",bean.getSystemStatus());
			}
			if (bean.getDefaultCentre() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("s.defaultCentre =:defaultCentre");
				 map.put("defaultCentre",bean.getDefaultCentre());
			}
		
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot Build where clause in SiteControls");
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
	private void setParameters(SiteControlsDTO bean, PreparedStatement ps) throws SQLException { 
		
		if(bean == null) {
			return ;
		}
		int pos = 1;

				if (bean.getSiteCode() != null) {
					bean.getSiteCode();
				}
				if (bean.getSiteName() != null) {
					 bean.getSiteName();
				}
				if (bean.getDbName() != null) {
					 bean.getDbName();
				}
				if (bean.getMenuEod() != null) {
					 bean.getMenuEod();
				}
				if (bean.getSpolog() != null) {
					bean.getSpolog();
				}
				if (bean.getReports() != null) {
					bean.getReports();
				}
				if (bean.getApps() != null) {
					bean.getApps();
				}
				if (bean.getReceive() != null) {
					bean.getReceive();
				}
				if (bean.getSend() != null) {
					bean.getSend();
				}
				if (bean.getPrev() != null) {
					bean.getPrev();
				}
				if (bean.getRestore() != null) {
					bean.getRestore();
				}
				if (bean.getSystemStatus() != null) {
					bean.getSystemStatus();
				}
				if (bean.getDefaultCentre() != null) {
					bean.getDefaultCentre();
				}
			
	}

	
}
