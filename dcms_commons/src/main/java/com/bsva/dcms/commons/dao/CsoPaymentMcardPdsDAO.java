package com.bsva.dcms.commons.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoPaymentMcardPdsDao;
import com.bsva.dcms.commons.dto.CsoPaymentMcardPdsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoPaymentMcardPds;
import com.bsva.entities.CsoPaymentMcardPdsPK;


public class CsoPaymentMcardPdsDAO{

	//private CsoPaymentMcardPdsRepository csoPaymentMcardPdsRepoDao = DaoFactory.csoPaymentMcardPdsInstance();
	private CsoPaymentMcardPdsDao csoPaymentMcardPdsDao = new CsoPaymentMcardPdsDao();
	private Map<String,Object>map = new HashMap<String, Object>();

	public CsoPaymentMcardPdsDAO() {

	}

	public void create(CsoPaymentMcardPdsDTO bean) throws DAOException {

                CsoPaymentMcardPdsPK csoPaymentMcardPdsPK = new CsoPaymentMcardPdsPK();
                csoPaymentMcardPdsPK.setSystemSeqNumber(bean.getSystemSeqNumber());
                
		CsoPaymentMcardPds csoPaymentMcardPds = new CsoPaymentMcardPds();  
                csoPaymentMcardPds.setCsoPaymentMcardPdsPK(csoPaymentMcardPdsPK);

		csoPaymentMcardPds.getCsoPaymentMcardPdsPK().setPdsNumber( (short) bean.getPdsNumber());		
                csoPaymentMcardPds.setPdsLength((short) bean.getPdsLength());
		csoPaymentMcardPds.setPdsData(bean.getPdsData());
		

		csoPaymentMcardPdsDao.create(csoPaymentMcardPds);

	}

	public CsoPaymentMcardPdsDTO retrieve(CsoPaymentMcardPdsDTO bean) throws DAOException {
		CsoPaymentMcardPdsDTO dto = new CsoPaymentMcardPdsDTO();
		
		try{
			
			String sql = "SELECT c FROM CsoPaymentMcardPds c "+buildWhereClause(bean,true);
			
			CsoPaymentMcardPds csoPaymentMcardPds = csoPaymentMcardPdsDao.executeQueryParametersSingle(sql,map);

			dto.setPdsNumber(csoPaymentMcardPds.getCsoPaymentMcardPdsPK().getPdsNumber());
			dto.setSystemSeqNumber(csoPaymentMcardPds.getCsoPaymentMcardPdsPK().getSystemSeqNumber());
			dto.setPdsData(csoPaymentMcardPds.getPdsData());
			dto.setPdsLength(csoPaymentMcardPds.getPdsLength());
			

		}catch(Exception ex){
			ex.getMessage();
		}
		map.clear();
		return dto;
	}



	@SuppressWarnings("unchecked")
	public List<CsoPaymentMcardPdsDTO> retrieveRelated(CsoPaymentMcardPdsDTO bean) throws DAOException {
		List<CsoPaymentMcardPdsDTO> dtoList = new LinkedList<CsoPaymentMcardPdsDTO>();

		String sql = "SELECT c  FROM CsoPaymentMcardPds c "  + buildWhereClause(bean,true);

		List<CsoPaymentMcardPds> csoPaymentMcardPdsretrieveRelated = csoPaymentMcardPdsDao.executeQueryParameters(sql,map);

		for (CsoPaymentMcardPds csoPaymentMcardPdsRelated : csoPaymentMcardPdsretrieveRelated) {

			CsoPaymentMcardPdsDTO csoPaymentMcardPdsDTO = new CsoPaymentMcardPdsDTO();
			csoPaymentMcardPdsDTO.setPdsNumber((short) csoPaymentMcardPdsRelated.getCsoPaymentMcardPdsPK().getPdsNumber());
			csoPaymentMcardPdsDTO.setSystemSeqNumber(csoPaymentMcardPdsRelated.getCsoPaymentMcardPdsPK().getSystemSeqNumber());
			csoPaymentMcardPdsDTO.setPdsData(csoPaymentMcardPdsRelated.getPdsData());
			csoPaymentMcardPdsDTO.setPdsLength(csoPaymentMcardPdsRelated.getPdsLength());

			dtoList.add(csoPaymentMcardPdsDTO);
		}
		map.clear();
		return dtoList;
	}

	private String buildWhereClause(CsoPaymentMcardPdsDTO bean, boolean select)throws DAOException  {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		if (select == true) {
		if (bean.getSystemSeqNumber() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.systemSeqNumber =:systemSeqNumber");
			map.put("systemSeqNumber",String.valueOf(bean.getSystemSeqNumber()));
		}

		if (bean.getPdsNumber() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.pdsNumber =:pdsNumber");
			map.put("pdsNumber",String.valueOf(bean.getPdsNumber()));
		}
		if (bean.getPdsLength() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.pdsLength =:pdsLength");
			map.put("pdsLength",String.valueOf(bean.getPdsLength()));
		}
		if (bean.getPdsData() != null && !bean.getPdsData().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.pdsData =:pdsData");
			map.put("pdsData",bean.getPdsData());
		}
		
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot Build where clause in CsoPaymentMcardPds");
		}
		return buff.toString();
	}

	public void update(CsoPaymentMcardPdsDTO bean) throws DAOException {
		try {
		CsoPaymentMcardPds csoPaymentMcardPds = new CsoPaymentMcardPds();
		csoPaymentMcardPds.getCsoPaymentMcardPdsPK().setPdsNumber((short) bean.getPdsNumber());
		csoPaymentMcardPds.getCsoPaymentMcardPdsPK().setSystemSeqNumber(bean.getSystemSeqNumber());
		csoPaymentMcardPds.setPdsData(bean.getPdsData());
		csoPaymentMcardPds.setPdsLength((short) bean.getPdsLength());		
		csoPaymentMcardPdsDao.update(csoPaymentMcardPds);

		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
     public void delete()throws DAOException {
		try{
    	 csoPaymentMcardPdsDao.deleteTruncate("TRUNCATE TABLE CSO_PAYMENT_MCARD_PDS");
		}catch(Exception ex){
			ex.getMessage();
		}
	}

}
