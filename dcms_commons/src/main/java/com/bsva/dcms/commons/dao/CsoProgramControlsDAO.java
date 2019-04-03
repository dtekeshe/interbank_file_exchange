package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoProgramControlsDao;
import com.bsva.dcms.commons.dto.CsoProgramControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoProgramControls;
import com.bsva.entities.CsoProgramControlsPK;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoProgramControlsDAO{
	//private List<String> map = new ArrayList<String>();
	private Map<String,Object>map = new HashMap<String, Object>();
	//private CsoProgramControlsRepository csoProgramControlsRepositoryDao = DaoFactory.csoProgramControlsInstance();
	
	private CsoProgramControlsDao csoProgramControlsDao = new CsoProgramControlsDao();

	public CsoProgramControlsDAO() {

	}

	public void create(CsoProgramControlsDTO bean) throws DAOException {

		try{
		CsoProgramControls csoProgramControls = new CsoProgramControls();
		
		CsoProgramControlsPK csoProgramControlsPK = new CsoProgramControlsPK();
		csoProgramControlsPK.setArbData(bean.getArbData());
		csoProgramControlsPK.setProgramName(bean.getProgramName());
		
		csoProgramControls.setCsoProgramControlsPK(csoProgramControlsPK);
		csoProgramControls.setEndTime(bean.getEndTime());
		csoProgramControls.setExecutionAverage(BigDecimal.valueOf(bean.getExecutionAverage()));
		csoProgramControls.setPaymentStream(bean.getPaymentStream());
		csoProgramControls.setSeqNo((short) bean.getSeqNo());
		csoProgramControls.setServiceCode(bean.getServiceCode());
		csoProgramControls.setStartTime(bean.getStartTime());
		csoProgramControls.setStatus(bean.getStatus());
		csoProgramControls.setSubServiceCode(bean.getSubServiceCode());

		csoProgramControlsDao.create(csoProgramControls);
		}catch(Exception ex){
			ex.getMessage();
		}
	}


	public CsoProgramControlsDTO retrieve(CsoProgramControlsDTO bean) throws DAOException {

		CsoProgramControlsDTO dto = new CsoProgramControlsDTO();

		try {

			String sql = "SELECT c FROM CsoProgramControls c "+buildWhereClause(bean,true);
			CsoProgramControls csoProgramControls = csoProgramControlsDao.executeQueryParametersSingle(sql,map);
            System.out.println("After query executed");
			if(csoProgramControls.getCsoProgramControlsPK()!=null){
				dto.setArbData(csoProgramControls.getCsoProgramControlsPK().getArbData());
			}
			if(csoProgramControls.getCsoProgramControlsPK()!=null){
				dto.setProgramName(csoProgramControls.getCsoProgramControlsPK().getProgramName());
			}
			if(csoProgramControls.getEndTime()!=null){
				dto.setEndTime(csoProgramControls.getEndTime());
			}
			if(csoProgramControls.getExecutionAverage()!=null){
				dto.setExecutionAverage(csoProgramControls.getExecutionAverage().doubleValue());
			}
			if(csoProgramControls.getPaymentStream()!=null){
				dto.setPaymentStream(csoProgramControls.getPaymentStream());
			}
			if(csoProgramControls.getSeqNo()!=null){
				dto.setSeqNo(csoProgramControls.getSeqNo().intValue());
			}
			if(csoProgramControls.getServiceCode()!=null){
				dto.setServiceCode(csoProgramControls.getServiceCode());
			}
			if(csoProgramControls.getStartTime()!=null){
				dto.setStartTime(csoProgramControls.getStartTime());
			}
			if(csoProgramControls.getStatus()!=null){
				dto.setStatus(csoProgramControls.getStatus());
			}
			if(csoProgramControls.getSubServiceCode()!=null){
				dto.setSubServiceCode(csoProgramControls.getSubServiceCode());
			}
			map.clear();
			return dto;
		}
		catch(Exception ex) {
			ex.getMessage();
			return null;
		}

	}

	public List<CsoProgramControlsDTO> retrieveRelated(CsoProgramControlsDTO bean) throws DAOException {

		List<CsoProgramControlsDTO> dtoList = new LinkedList<CsoProgramControlsDTO>();
		CsoProgramControlsDTO dto = null;
		try {
			String sql = "SELECT c  FROM CsoProgramControls c "  + buildWhereClause(bean,true);

			List<CsoProgramControls> csoProgramControlsRetrieveRelated = csoProgramControlsDao.executeQueryParameters(sql,map);

			for (CsoProgramControls csoProgramControlsRelated : csoProgramControlsRetrieveRelated) {

				dto = new CsoProgramControlsDTO();
				if(csoProgramControlsRelated.getCsoProgramControlsPK().getArbData()!=null){
					dto.setArbData(csoProgramControlsRelated.getCsoProgramControlsPK().getArbData());
				}
				if(csoProgramControlsRelated.getCsoProgramControlsPK().getProgramName()!=null){
					dto.setProgramName(csoProgramControlsRelated.getCsoProgramControlsPK().getProgramName());
				}
				if(csoProgramControlsRelated.getEndTime()!=null){
					dto.setEndTime(csoProgramControlsRelated.getEndTime());
				}
				if(csoProgramControlsRelated.getExecutionAverage()!=null){
					dto.setExecutionAverage(csoProgramControlsRelated.getExecutionAverage().doubleValue());
				}
				if(csoProgramControlsRelated.getPaymentStream()!=null){
					dto.setPaymentStream(csoProgramControlsRelated.getPaymentStream());
				}
				if(csoProgramControlsRelated.getSeqNo()!=null){
					dto.setSeqNo(csoProgramControlsRelated.getSeqNo().intValue());
				}
				if(csoProgramControlsRelated.getServiceCode()!=null){
					dto.setServiceCode(csoProgramControlsRelated.getServiceCode());
				}
				if(csoProgramControlsRelated.getStartTime()!=null){
					dto.setStartTime(csoProgramControlsRelated.getStartTime());
				}
				if(csoProgramControlsRelated.getStatus()!=null){
					dto.setStatus(csoProgramControlsRelated.getStatus());
				}
				if(csoProgramControlsRelated.getSubServiceCode()!=null){
					dto.setSubServiceCode(csoProgramControlsRelated.getSubServiceCode());
				}

				dtoList.add(dto);
			}
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		map.clear();
		return dtoList;
	}

	private String buildWhereClause(CsoProgramControlsDTO bean, boolean select)throws DAOException  {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
			
		if (bean.getProgramName() != null && !bean.getProgramName().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.csoProgramControlsPK.programName =:programName");
			map.put("programName",bean.getProgramName());
		}
		
		if (bean.getArbData() != null && !bean.getArbData().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.csoProgramControlsPK.arbData =:arbData");
			map.put("arbData",bean.getArbData());
		}
		
		if (bean.getServiceCode() != null && !bean.getServiceCode().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.serviceCode =:serviceCode");
			map.put("serviceCode",bean.getServiceCode());
		}
		if (bean.getSeqNo() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.seqNo =:seqNo");
			map.put("seqNo",String.valueOf(bean.getSeqNo()));
		}
		
		if (bean.getSubServiceCode() != null && !bean.getSubServiceCode().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.subServiceCode =:subServiceCode");
			map.put("subServiceCode",bean.getSubServiceCode());
		}
		if (bean.getPaymentStream() != null && !bean.getPaymentStream().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.paymentStream =:paymentStream");
			map.put("paymentStream",bean.getPaymentStream());
		}
		if (bean.getStartTime() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.startTime =:startTime");
			map.put("startTime",String.valueOf(bean.getStartTime()));
		}
		if (bean.getEndTime() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.endTime =:endTime");
			map.put("endTime",String.valueOf(bean.getEndTime()));
		}
		if (bean.getStatus() != null && !bean.getStatus().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.status =:status");
			map.put("status",bean.getStatus());
		}
		if (bean.getExecutionAverage() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.executionAverage =:executionAverage");
			map.put("executionAverage",String.valueOf(bean.getExecutionAverage()));
		}
		if (bean.getExecutionLast() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.executionLast =:executionLast");
			map.put("executionLast",String.valueOf(bean.getExecutionLast()));
		}
		
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot Build where clause in CsoProgramControls");
		}

		return buff.toString();
	}

	public void update(CsoProgramControlsDTO bean) throws DAOException {
		try {

		CsoProgramControls csoProgramControls = new CsoProgramControls();
		CsoProgramControlsPK csoProgramControlsPK = new CsoProgramControlsPK();
		csoProgramControlsPK.setArbData(bean.getArbData());
		csoProgramControlsPK.setProgramName(bean.getProgramName());
		csoProgramControls.setCsoProgramControlsPK(csoProgramControlsPK);		
		csoProgramControls.setEndTime(bean.getEndTime());
		csoProgramControls.setExecutionAverage(BigDecimal.valueOf(bean.getExecutionAverage()));
		csoProgramControls.setPaymentStream(bean.getPaymentStream());
		csoProgramControls.setSeqNo((short) bean.getSeqNo());
		csoProgramControls.setServiceCode(bean.getServiceCode());
		csoProgramControls.setStartTime(bean.getStartTime());
		csoProgramControls.setStatus(bean.getStatus());
		csoProgramControls.setSubServiceCode(bean.getSubServiceCode());
		csoProgramControlsDao.update(csoProgramControls);

		} catch (Exception ex) {
			ex.getMessage();
		} 
	}
	public void delete(CsoProgramControlsDTO bean) throws DAOException {
		try {

		CsoProgramControls csoProgramControls = new CsoProgramControls();
		CsoProgramControlsPK csoProgramControlsPK = new CsoProgramControlsPK();
		csoProgramControlsPK.setArbData(bean.getArbData());
		csoProgramControlsPK.setProgramName(bean.getProgramName());
		csoProgramControls.setCsoProgramControlsPK(csoProgramControlsPK);		
		csoProgramControls.setEndTime(bean.getEndTime());
		csoProgramControls.setExecutionAverage(BigDecimal.valueOf(bean.getExecutionAverage()));
		csoProgramControls.setPaymentStream(bean.getPaymentStream());
		csoProgramControls.setSeqNo((short) bean.getSeqNo());
		csoProgramControls.setServiceCode(bean.getServiceCode());
		csoProgramControls.setStartTime(bean.getStartTime());
		csoProgramControls.setStatus(bean.getStatus());
		csoProgramControls.setSubServiceCode(bean.getSubServiceCode());
		csoProgramControlsDao.delete(csoProgramControls);

		} catch (Exception ex) {
			ex.getMessage();
		} 
	}
	public void delete() throws DAOException {
		
		csoProgramControlsDao.deleteBulk("Delete from CsoProgramControls");
	}
}
