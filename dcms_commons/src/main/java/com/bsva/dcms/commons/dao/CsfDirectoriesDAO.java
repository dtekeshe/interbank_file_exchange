package com.bsva.dcms.commons.dao;


import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import com.bsva.dao.CsfDirectoriesDao;
import com.bsva.dcms.commons.dto.CsfDirectoriesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfDirectories;

public class CsfDirectoriesDAO {

	private Map<String,Object> map = new HashMap<>();
	//private CsfDirectoriesRepository csfDirectoriesDao = DaoFactory.csfDirectoriesInstance();
	private CsfDirectoriesDao csfDirectoriesDao = new CsfDirectoriesDao();
	public CsfDirectoriesDAO(){
	}

	/**
	 * Creates an entry in the CSF_DIRECTORIES table
	 *
	 * @param CSF_DIRECTORIES the table entry to create
	 * @throws DAOException if a database exception occurs
	 */

	public void create(CsfDirectoriesDTO csfDirectoriesDTO) throws DAOException {

		try {
			CsfDirectories csfDirectories = new CsfDirectories();
			csfDirectories.setDirectoryName(csfDirectoriesDTO.getDirectoryName());
			csfDirectories.setDirectoryPath(csfDirectoriesDTO.getDirectoryPath());
			csfDirectoriesDao.create(csfDirectories);

		}
		catch(Exception ex){
			throw new DAOException("Error creating CSF_DIRECTORIES entry, cause: " + ex.getMessage(), ex);
		}
	}

	public CsfDirectoriesDTO retrieve(CsfDirectoriesDTO obj) throws DAOException {

		CsfDirectoriesDTO dto = null;
		try {
			String sql = "SELECT c FROM CsfDirectories c "+ buildWhereClause(obj);

			CsfDirectories csfdirectories = csfDirectoriesDao.executeQueryParametersSingle(sql, map);

			dto = new CsfDirectoriesDTO();

			if(csfdirectories.getDirectoryName()!=null){
				dto.setDirectoryName(csfdirectories.getDirectoryName());
			}
			if(csfdirectories.getDirectoryPath()!=null){
				dto.setDirectoryPath(csfdirectories.getDirectoryPath());
			}

		}
		catch(Exception ex) {
			throw new DAOException("Error retrieving CSF_DIRECTORIES entry, cause: " + ex.getMessage(), ex);
		}
		map.clear();
		return dto;
	}

	public List<CsfDirectoriesDTO> retrieveRelated(CsfDirectoriesDTO obj) throws DAOException {

		List<CsfDirectoriesDTO> dtoList = new LinkedList<CsfDirectoriesDTO>();

		CsfDirectoriesDTO dto = null;

		try {
			String sql = "SELECT c FROM CsfDirectories c "  + buildWhereClause(obj);
			List<CsfDirectories> csfDirectoriesDetails = csfDirectoriesDao.executeQueryParameters(sql, map);

			for (CsfDirectories csfdirectories : csfDirectoriesDetails) {
				dto = new CsfDirectoriesDTO();

				if(csfdirectories.getDirectoryName()!=null){
					dto.setDirectoryName(csfdirectories.getDirectoryName());
				}
				if(csfdirectories.getDirectoryPath()!=null){
					dto.setDirectoryPath(csfdirectories.getDirectoryPath());
				}

				dtoList.add(dto);
			}
		}
		catch(Exception ex) {
			throw new DAOException("Error retrieving CSF_DIRECTORIES entries, cause: " + ex.getMessage(), ex);
		}
		map.clear();
		return dtoList;
	}

	private String buildWhereClause(CsfDirectoriesDTO obj) {

		if(obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if(obj.getDirectoryName() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.directoryName =:directoryName");
			map.put("directoryName",obj.getDirectoryName());
		}

		if(obj.getDirectoryPath() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.directoryPath =:directoryPath");
			map.put("directoryPath",obj.getDirectoryPath());
		}
		return buff.toString();
	}

	

	public void update(CsfDirectoriesDTO obj) throws DAOException {

		try {

			CsfDirectoriesDTO csfDirectoriesDTO = new CsfDirectoriesDTO();
			CsfDirectories directories = new CsfDirectories();
			directories.setDirectoryName(csfDirectoriesDTO.getDirectoryName());
			directories.setDirectoryPath(csfDirectoriesDTO.getDirectoryPath());

			csfDirectoriesDao.update(directories);
		}
		catch(Exception ex) {
			throw new DAOException("Error updating CSF_DIRECTORIES entry, cause: " + ex.getMessage(),  ex);
		}
	}
	public void delete(CsfDirectoriesDTO csfDirectoriesDTO) throws DAOException {

		try {
			CsfDirectories csfDirectories = new CsfDirectories();
			csfDirectories.setDirectoryName(csfDirectoriesDTO.getDirectoryName());
			csfDirectories.setDirectoryPath(csfDirectoriesDTO.getDirectoryPath());
			csfDirectoriesDao.delete(csfDirectories);

		}
		catch(Exception ex){
			throw new DAOException("Error deleting CSF_DIRECTORIES entry, cause: " + ex.getMessage(), ex);
		}
	}

}


