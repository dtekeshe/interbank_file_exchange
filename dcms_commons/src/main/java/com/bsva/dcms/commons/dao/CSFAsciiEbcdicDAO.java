package com.bsva.dcms.commons.dao;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.Logger;

import sun.rmi.runtime.Log;

import com.bsva.dao.CsfAsciiEbcdicDao;
import com.bsva.dcms.commons.dto.CSFAsciiEbcdicDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfAsciiEbcdic;

/**
 * @author AugustineA
 *
 */
public class CSFAsciiEbcdicDAO {
	private Map<String,Object> map = new HashMap<String, Object>();
    private CsfAsciiEbcdicDao csfAsciiEbcdicdao = new CsfAsciiEbcdicDao(); 
    //private static Logger log = Logger.getLogger(CSFAsciiEbcdicDAO.class);
    
	public CSFAsciiEbcdicDAO(){

	}

	/**
	 * Creates an entry in the CSF_ASCII_EBCDIC table
	 *
	 * @param CSF_ASCII_EBCDIC the table entry to create
	 * @throws DAOException if a database exception occurs
	 */

	public void create(CSFAsciiEbcdicDTO csfAsciiEbcdicDTO) throws DAOException {
		CsfAsciiEbcdic CsfAsciiEbcdic  = new CsfAsciiEbcdic();
		CsfAsciiEbcdic.setDecimalVal((short) csfAsciiEbcdicDTO.getDecimalVal());
		CsfAsciiEbcdic.setAsciiChar(csfAsciiEbcdicDTO.getAsciiChar());
		CsfAsciiEbcdic.setEbcdicChar(csfAsciiEbcdicDTO.getEbcdicChar());
		CsfAsciiEbcdic.setEbcdicInt((short) csfAsciiEbcdicDTO.getEbcdicInt());

		csfAsciiEbcdicdao.create(CsfAsciiEbcdic);	
	}

	public CSFAsciiEbcdicDTO retrieve(CSFAsciiEbcdicDTO obj) throws DAOException {
		CSFAsciiEbcdicDTO dto = null;
		try {
			String sql = "SELECT c FROM CsfAsciiEbcdic c "+ buildWhereClause(obj,true);

			CsfAsciiEbcdic csfAsciiEbcdic = csfAsciiEbcdicdao.executeQueryParametersSingle(sql,map);

			dto = new CSFAsciiEbcdicDTO();

			if(csfAsciiEbcdic.getDecimalVal()!=null){
				dto.setDecimalVal(csfAsciiEbcdic.getDecimalVal());
			}
			if(csfAsciiEbcdic.getAsciiChar()!=null){
				dto.setAsciiChar(csfAsciiEbcdic.getAsciiChar());
			}
			if(csfAsciiEbcdic.getEbcdicChar()!=null){
				dto.setEbcdicChar(csfAsciiEbcdic.getEbcdicChar());
			}
			if(csfAsciiEbcdic.getEbcdicInt()!=null){
				dto.setEbcdicInt(csfAsciiEbcdic.getEbcdicInt());
			}

		}
		catch(Exception ex) {
			ex.getMessage();
		}
		map.clear();
		return dto;
	}

	@SuppressWarnings("unchecked")
	public List<CSFAsciiEbcdicDTO> retrieveRelated(CSFAsciiEbcdicDTO dto) throws DAOException {
		List<CSFAsciiEbcdicDTO> dtoList = new LinkedList<CSFAsciiEbcdicDTO>();
		CSFAsciiEbcdicDTO cSFAsciiEbcdicDTO = null;
		try {
			String sql = "SELECT c  FROM CsfAsciiEbcdic c "+ buildWhereClause(dto,true);

			List<CsfAsciiEbcdic> csfAsciiEbcdicretrieveRelated = csfAsciiEbcdicdao.executeQueryParameters(sql, map);

			for (CsfAsciiEbcdic csfAsciiEbcdicRelated : csfAsciiEbcdicretrieveRelated) {
				cSFAsciiEbcdicDTO = new CSFAsciiEbcdicDTO();

				if(csfAsciiEbcdicRelated.getDecimalVal()!=null){
					dto.setDecimalVal(csfAsciiEbcdicRelated.getDecimalVal());
				}
				if(csfAsciiEbcdicRelated.getAsciiChar()!=null){
					dto.setAsciiChar(csfAsciiEbcdicRelated.getAsciiChar());
				}
				if(csfAsciiEbcdicRelated.getEbcdicChar()!=null){
					dto.setEbcdicChar(csfAsciiEbcdicRelated.getEbcdicChar());
				}
				if(csfAsciiEbcdicRelated.getEbcdicInt()!=null){
					dto.setEbcdicInt(csfAsciiEbcdicRelated.getEbcdicInt());
				}

				dtoList.add(cSFAsciiEbcdicDTO);
			}
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		map.clear();
		return dtoList;
	}

	public void update(CSFAsciiEbcdicDTO obj) throws DAOException {

		CsfAsciiEbcdic csfAsciiEbcdic  = new CsfAsciiEbcdic();
		csfAsciiEbcdic.setDecimalVal((short) obj.getDecimalVal());
		csfAsciiEbcdic.setAsciiChar(obj.getAsciiChar());
		csfAsciiEbcdic.setEbcdicChar(obj.getEbcdicChar());
		csfAsciiEbcdic.setEbcdicInt((short) obj.getEbcdicInt());

		csfAsciiEbcdicdao.update(csfAsciiEbcdic);


	}

	private String buildWhereClause(CSFAsciiEbcdicDTO obj,boolean select) {

		if(obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if(obj.getDecimalVal() != -1) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			buff.append("c.decimalVal =:decimalVal");
			map.put("decimalVal",String.valueOf(obj.getDecimalVal()));
		}

		if(obj.getAsciiChar() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			buff.append("c.asciiChar =:asciiChar");
			map.put("asciiChar",obj.getAsciiChar());
		}

		if(obj.getEbcdicChar() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			buff.append("c.ebcdicChar =:ebcdicChar");
			map.put("ebcdicChar",obj.getEbcdicChar());
		}

		if(obj.getEbcdicInt() != -1) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			buff.append("c.ebcdicInt =:ebcdicInt");
			map.put("ebcdicInt",String.valueOf(obj.getEbcdicInt()));
		}

		return buff.toString();
	}

	
}


