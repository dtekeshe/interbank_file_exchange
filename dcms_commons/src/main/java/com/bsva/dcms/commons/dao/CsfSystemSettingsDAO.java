package com.bsva.dcms.commons.dao;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfSystemSettingsDao;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfSystemSettings;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfSystemSettingsDAO{


	//private CsfSystemSettingsRepository systemSettingsDao = DaoFactory.csfSystemSettingsInstance();
	private CsfSystemSettingsDao systemSettingsDao = new CsfSystemSettingsDao();
	private Map<String,Object> map = new HashMap<>();



	public CsfSystemSettingsDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CsfSystemSettingsDTO bean) throws DAOException {

		try {
			CsfSystemSettings systemsettings = new CsfSystemSettings();
			systemsettings.setSettingCode(bean.getSettingCode());
			systemsettings.setSettingDescription(bean.getSettingDescription());
			systemsettings.setSettingValue(bean.getSettingValue());
			systemSettingsDao.create(systemsettings);

		} catch (Exception ex) {
			throw new DAOException("Error creating CsfSystemSettings, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfSystemSettingsDTO retrieve(CsfSystemSettingsDTO bean) throws DAOException {
		
		CsfSystemSettingsDTO csfSystemSettingsDTO = new CsfSystemSettingsDTO();
		
		try {
			String sql = "SELECT c FROM CsfSystemSettings c "+ buildWhereClause(bean, true);

			CsfSystemSettings systemsettings = systemSettingsDao.executeQueryParametersSingle(sql, map);

			if(systemsettings.getSettingCode()!=null){
				csfSystemSettingsDTO.setSettingCode(systemsettings.getSettingCode());
			}
			if(systemsettings.getSettingDescription()!=null){
				csfSystemSettingsDTO.setSettingDescription(systemsettings.getSettingDescription());
			}
			if(systemsettings.getSettingValue()!=null){
				csfSystemSettingsDTO.setSettingValue(systemsettings.getSettingValue());
			}
			map.clear();
			return csfSystemSettingsDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsfSystemSettings, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsfSystemSettingsDTO> retrieveRelated(CsfSystemSettingsDTO bean) throws DAOException {
		
		List<CsfSystemSettingsDTO> dtoList = new LinkedList<>();
		
		CsfSystemSettingsDTO csfSystemSettingsDTO = null;
		
		try {
			String sql = "SELECT c FROM CsfSystemSettings c "+ buildWhereClause(bean, true);
			List<CsfSystemSettings> systemsettings = (List<CsfSystemSettings>) systemSettingsDao.executeQueryParameters(sql, map);
			for (CsfSystemSettings csfSystemSettings : systemsettings) {

				csfSystemSettingsDTO = new CsfSystemSettingsDTO();
				if(csfSystemSettings.getSettingCode()!=null){
					csfSystemSettingsDTO.setSettingCode(csfSystemSettings.getSettingCode());
				}
				if(csfSystemSettings.getSettingDescription()!=null){
					csfSystemSettingsDTO.setSettingDescription(csfSystemSettings.getSettingDescription());
				}
				if(csfSystemSettings.getSettingValue()!=null){
					csfSystemSettingsDTO.setSettingValue(csfSystemSettings.getSettingValue());
				}

				dtoList.add(csfSystemSettingsDTO);
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsfSystemSettings, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfSystemSettingsDTO bean) throws DAOException {

		CsfSystemSettings systemsettings = new CsfSystemSettings();
		systemsettings.setSettingCode(bean.getSettingCode());
		systemsettings.setSettingDescription(bean.getSettingDescription());
		systemsettings.setSettingValue(bean.getSettingValue());

		try {

			systemSettingsDao.update(systemsettings);

		} catch (Exception ex) {
			throw new DAOException("Error updating CsfSystemSettings, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsfSystemSettingsDTO bean) throws DAOException {

		try {
			String sql = "DELETE FROM CsfSystemSettings";
			sql += this.buildWhereClause(bean, false);
			CsfSystemSettings systemsettings = new CsfSystemSettings();
			systemsettings.setSettingCode(bean.getSettingCode());
			systemsettings.setSettingDescription(bean.getSettingDescription());
			systemsettings.setSettingValue(bean.getSettingValue());
			systemSettingsDao.delete(systemsettings);

		} catch (Exception ex) {
			throw new DAOException("Error deleting CsfSystemSettings, cause: "+ ex.getMessage(), ex);
		}

	}

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsfSystemSettingsDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		if (select == true) {

		if (bean.getSettingCode() != null && !bean.getSettingCode().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			buff.append("c.settingCode =:settingCode");
			map.put("settingCode",bean.getSettingCode());
		}
		
			if (bean.getSettingValue() != null && !bean.getSettingValue().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.settingValue =:settingValue");
				map.put("settingValue",bean.getSettingValue());
			}
			if (bean.getSettingDescription() != null && !bean.getSettingDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.settingDescription =:settingDescription");
				map.put("settingDescription",bean.getSettingDescription());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update all rows in CsfSystemSettings");
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
	private void setParameters(CsfSystemSettingsDTO bean, boolean select) throws DAOException {
		StringBuilder sb = new StringBuilder();
		if(bean == null) {
			return;
		}
		try {
			if (bean.getSettingCode() != null && !bean.getSettingCode().isEmpty()) {
				sb.append(bean.getSettingCode());
				sb.append(",");
			}
			if (select == true) {
				if (bean.getSettingValue() != null && !bean.getSettingValue().isEmpty()) {
					sb.append(bean.getSettingValue());
					sb.append(",");
				}
				if (bean.getSettingDescription() != null && !bean.getSettingDescription().isEmpty()) {
					sb.append(bean.getSettingDescription());
				}
			}

		} catch (Exception ex) {
			throw new DAOException("Error getting results CsfSystemSettings, cause: "
					+ ex.getMessage(), ex);
		} 
	}
}
