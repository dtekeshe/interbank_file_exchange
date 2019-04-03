package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import com.bsva.dao.DelDeliveryFilesCccDao;
import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.DelDeliveryFilesCcc;
import com.bsva.entities.DelDeliveryFilesCccPK;



public class DelDeliveryFilesCCCDAO {


	//private DelDeliveryFilesCccRepository delDeliveryFilesCccDao = DaoFactory.cDelDeliveryFilesCccInstance();
	private Map<String,Object>map = new HashMap<String,Object>();
	private DelDeliveryFilesCccDao deliveryDao = new DelDeliveryFilesCccDao();
	public DelDeliveryFilesCCCDAO(){

	}

	/**
	 * Creates an entry in the DEL_DELIVERY_FILES_CCC table
	 *
	 * @param DEL_DELIVERY_FILES_CCC the table entry to create
	 * @throws DAOException if a database exception occurs
	 */

	public void create(DelDeliveryFilesCCCDTO delDeliveryFilesCCCDTO) throws DAOException {
       try{
    	   System.out.println("Saving to DelDelivery ");
		
		
		DelDeliveryFilesCccPK elDeliveryFilesCccPK = new DelDeliveryFilesCccPK();	
		
		elDeliveryFilesCccPK.setPosition(delDeliveryFilesCCCDTO.getPosition());
		elDeliveryFilesCccPK.setFilename(delDeliveryFilesCCCDTO.getFileName());		
		elDeliveryFilesCccPK.setQueueFileName(delDeliveryFilesCCCDTO.getQueueFileName());
		
		DelDeliveryFilesCcc delDeliveryFilesCcc = new DelDeliveryFilesCcc();
		delDeliveryFilesCcc.setDelDeliveryFilesCccPK(elDeliveryFilesCccPK);
		
		delDeliveryFilesCcc.setXmitInd(delDeliveryFilesCCCDTO.getXmitInd());
		delDeliveryFilesCcc.setPrdDate(delDeliveryFilesCCCDTO.getPrddate());
		delDeliveryFilesCcc.setMember((short) delDeliveryFilesCCCDTO.getMember());
		delDeliveryFilesCcc.setDeliveryTime(delDeliveryFilesCCCDTO.getDeliveryTime());
		deliveryDao.create(delDeliveryFilesCcc);
		
		System.out.println("Saved ---------->");
       }catch(Exception ex){
    	   throw new DAOException( "Cannot Save to DelDeliveryFilesCcc Table" + ex.getMessage());
       }

	}

	public DelDeliveryFilesCCCDTO retrieve(DelDeliveryFilesCCCDTO obj) throws DAOException {

		DelDeliveryFilesCCCDTO dto = null;
		try {

			String sql = "SELECT c FROM DelDeliveryFilesCcc c "+buildWhereClause(obj,true);
			DelDeliveryFilesCcc delDeliveryFilesCcc = deliveryDao.executeQueryParametersSingle(sql, map);
				dto = new DelDeliveryFilesCCCDTO();
				
				dto.setPosition(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getPosition());
				dto.setFileName(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getFilename());
				dto.setQueueFileName(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getQueueFileName());
				if(delDeliveryFilesCcc.getApplication()!=null){
				dto.setApplication(delDeliveryFilesCcc.getApplication());
				}
				if(delDeliveryFilesCcc.getBackupFormat()!=null){
				dto.setBackupFormat(delDeliveryFilesCcc.getBackupFormat());
				}
				if(delDeliveryFilesCcc.getBlockFactor()!=null){
				dto.setBlockFactor(delDeliveryFilesCcc.getBlockFactor().intValue());
				}
				if(delDeliveryFilesCcc.getCreateTrailer()!=null){
				dto.setCreateTrailer(delDeliveryFilesCcc.getCreateTrailer());
				}
				if(delDeliveryFilesCcc.getDeliveryStatus()!=null){
				dto.setDeliveryStatus(delDeliveryFilesCcc.getDeliveryStatus());
				}
				if(delDeliveryFilesCcc.getDeliveryTime()!=null){
				dto.setDeliveryTime(delDeliveryFilesCcc.getDeliveryTime().intValue());
				}
				
				if(delDeliveryFilesCcc.getHashTotal()!=null){
				dto.setHashTotals(delDeliveryFilesCcc.getHashTotal().intValue());
				}
				if(delDeliveryFilesCcc.getLastFile()!=null){
				dto.setLastFile(delDeliveryFilesCcc.getLastFile());
				}
				if(delDeliveryFilesCcc.getMember()!=null){
				dto.setMember( delDeliveryFilesCcc.getMember().intValue());
				}
				if(delDeliveryFilesCcc.getNoOfCredits()!=null){
				dto.setNoOfCredits(delDeliveryFilesCcc.getNoOfCredits().intValue());
				}
				if(delDeliveryFilesCcc.getNoOfDebits()!=null){
				dto.setNoOfDebits(delDeliveryFilesCcc.getNoOfDebits().intValue());
				}
				if(delDeliveryFilesCcc.getNoOfRecords()!=null){
				dto.setNoOfRecords(delDeliveryFilesCcc.getNoOfRecords().intValue());
				}
				if(delDeliveryFilesCcc.getOutputFormat()!=null){
				dto.setOutputFormat(delDeliveryFilesCcc.getOutputFormat());
				}
				if(delDeliveryFilesCcc.getPrdDate()!=null){
				dto.setPrddate(delDeliveryFilesCcc.getPrdDate().intValue());
				}
				if(delDeliveryFilesCcc.getProgramFrom()!=null){
				dto.setProgramFrom(delDeliveryFilesCcc.getProgramFrom());
				}
				if(delDeliveryFilesCcc.getRecLength()!=null){
				dto.setRecLength(delDeliveryFilesCcc.getRecLength().shortValue());
				}
				if(delDeliveryFilesCcc.getRejectReason()!=null){
				dto.setRejectReason(delDeliveryFilesCcc.getRejectReason());
				}
				if(delDeliveryFilesCcc.getReportName()!=null){
				dto.setReportName(delDeliveryFilesCcc.getReportName());
				}
				if(delDeliveryFilesCcc.getSubApplication()!=null){
				dto.setSubApplication(delDeliveryFilesCcc.getSubApplication());
				}
				if(delDeliveryFilesCcc.getTimeCreated()!=null){
				dto.setTimeCreated(delDeliveryFilesCcc.getTimeCreated().intValue());
				}
				if(delDeliveryFilesCcc.getUserDest()!=null){
				dto.setUserDest(delDeliveryFilesCcc.getUserDest().shortValue());
				}
				if(delDeliveryFilesCcc.getValueCredits()!=null){
				dto.setValueCredits(delDeliveryFilesCcc.getValueCredits().intValue());
				}
				if(delDeliveryFilesCcc.getValueDebits()!=null){
				dto.setValueDebits(delDeliveryFilesCcc.getValueDebits().intValue());
				}
				if(delDeliveryFilesCcc.getWrittenToAxd()!=null){
				dto.setWrittenToAxd(delDeliveryFilesCcc.getWrittenToAxd());
				}
				if(delDeliveryFilesCcc.getXmitInd()!=null){
				dto.setXmitInd(delDeliveryFilesCcc.getXmitInd());
				}

		}
		catch(Exception ex) {
			ex.getMessage();
			return null;
		}
		map.clear();
		return dto;
	}

	@SuppressWarnings("unchecked")
	public List<DelDeliveryFilesCCCDTO> retrieveRelated(DelDeliveryFilesCCCDTO obj) throws DAOException {
		List<DelDeliveryFilesCCCDTO> dtoList = new ArrayList<DelDeliveryFilesCCCDTO>();
		DelDeliveryFilesCCCDTO dto = null;
		try {
			String sql = "SELECT c  FROM DelDeliveryFilesCcc c "+ buildWhereClause(obj,true);
			List<DelDeliveryFilesCcc> delDeliveryFilesCcccretrieveRelated = deliveryDao.executeQueryParametersDate(sql,map);
			for (DelDeliveryFilesCcc delDeliveryFilesCcc : delDeliveryFilesCcccretrieveRelated) {
				    dto = new DelDeliveryFilesCCCDTO();
					dto.setPosition(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getPosition());
					dto.setFileName(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getFilename());
					dto.setQueueFileName(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getQueueFileName());					
			
					if(delDeliveryFilesCcc.getApplication()!=null){
					dto.setApplication(delDeliveryFilesCcc.getApplication());
					}
					if(delDeliveryFilesCcc.getBackupFormat()!=null){
					dto.setBackupFormat(delDeliveryFilesCcc.getBackupFormat());
					}
					if(delDeliveryFilesCcc.getBlockFactor()!=null){
					dto.setBlockFactor(delDeliveryFilesCcc.getBlockFactor().intValue());
					}
					if(delDeliveryFilesCcc.getCreateTrailer()!=null){
					dto.setCreateTrailer(delDeliveryFilesCcc.getCreateTrailer());
					}
					if(delDeliveryFilesCcc.getDeliveryStatus()!=null){
					dto.setDeliveryStatus(delDeliveryFilesCcc.getDeliveryStatus());
					}
					if(delDeliveryFilesCcc.getDeliveryTime()!=null){
					dto.setDeliveryTime(delDeliveryFilesCcc.getDeliveryTime().intValue());
					}
					
					if(delDeliveryFilesCcc.getHashTotal()!=null){
					dto.setHashTotals(delDeliveryFilesCcc.getHashTotal().intValue());
					}
					if(delDeliveryFilesCcc.getLastFile()!=null){
					dto.setLastFile(delDeliveryFilesCcc.getLastFile());
					}
					if(delDeliveryFilesCcc.getMember()!=null){
					dto.setMember( delDeliveryFilesCcc.getMember().intValue());
					}
					if(delDeliveryFilesCcc.getNoOfCredits()!=null){
					dto.setNoOfCredits(delDeliveryFilesCcc.getNoOfCredits().intValue());
					}
					if(delDeliveryFilesCcc.getNoOfDebits()!=null){
					dto.setNoOfDebits(delDeliveryFilesCcc.getNoOfDebits().intValue());
					}
					if(delDeliveryFilesCcc.getNoOfRecords()!=null){
					dto.setNoOfRecords(delDeliveryFilesCcc.getNoOfRecords().intValue());
					}
					if(delDeliveryFilesCcc.getOutputFormat()!=null){
					dto.setOutputFormat(delDeliveryFilesCcc.getOutputFormat());
					}
					if(delDeliveryFilesCcc.getPrdDate()!=null){
					dto.setPrddate(delDeliveryFilesCcc.getPrdDate().intValue());
					}
					if(delDeliveryFilesCcc.getProgramFrom()!=null){
					dto.setProgramFrom(delDeliveryFilesCcc.getProgramFrom());
					}
					if(delDeliveryFilesCcc.getRecLength()!=null){
					dto.setRecLength(delDeliveryFilesCcc.getRecLength().shortValue());
					}
					if(delDeliveryFilesCcc.getRejectReason()!=null){
					dto.setRejectReason(delDeliveryFilesCcc.getRejectReason());
					}
					if(delDeliveryFilesCcc.getReportName()!=null){
					dto.setReportName(delDeliveryFilesCcc.getReportName());
					}
					if(delDeliveryFilesCcc.getSubApplication()!=null){
					dto.setSubApplication(delDeliveryFilesCcc.getSubApplication());
					}
					if(delDeliveryFilesCcc.getTimeCreated()!=null){
					dto.setTimeCreated(delDeliveryFilesCcc.getTimeCreated().intValue());
					}
					if(delDeliveryFilesCcc.getUserDest()!=null){
					dto.setUserDest(delDeliveryFilesCcc.getUserDest().shortValue());
					}
					if(delDeliveryFilesCcc.getValueCredits()!=null){
					dto.setValueCredits(delDeliveryFilesCcc.getValueCredits().intValue());
					}
					if(delDeliveryFilesCcc.getValueDebits()!=null){
					dto.setValueDebits(delDeliveryFilesCcc.getValueDebits().intValue());
					}
					if(delDeliveryFilesCcc.getWrittenToAxd()!=null){
					dto.setWrittenToAxd(delDeliveryFilesCcc.getWrittenToAxd());
					}
					if(delDeliveryFilesCcc.getXmitInd()!=null){
					dto.setXmitInd(delDeliveryFilesCcc.getXmitInd());
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

	public List<DelDeliveryFilesCCCDTO> retrieveRelatedCount(DelDeliveryFilesCCCDTO obj) throws DAOException {
		List<DelDeliveryFilesCCCDTO> dtoList = new LinkedList<DelDeliveryFilesCCCDTO>();
		DelDeliveryFilesCCCDTO dto = null;

		try {
			String sql = "SELECT c FROM DelDeliveryFilesCcc  c " + buildWhereClause(obj,true);

			List<DelDeliveryFilesCcc> delDeliveryFilesCcccretrieveRelated = (List<DelDeliveryFilesCcc>) this.deliveryDao.executeQueryParameters(sql,map);

			for (DelDeliveryFilesCcc delDeliveryFilesCcc : delDeliveryFilesCcccretrieveRelated) {

					dto = new DelDeliveryFilesCCCDTO();
				
				if(delDeliveryFilesCcc.getDelDeliveryFilesCccPK()!=null){
					dto.setPosition(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getPosition());
					dto.setFileName(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getFilename());
					dto.setQueueFileName(delDeliveryFilesCcc.getDelDeliveryFilesCccPK().getQueueFileName());
					}
			
					if(delDeliveryFilesCcc.getApplication()!=null){
					dto.setApplication(delDeliveryFilesCcc.getApplication());
					}
					if(delDeliveryFilesCcc.getBackupFormat()!=null){
					dto.setBackupFormat(delDeliveryFilesCcc.getBackupFormat());
					}
					if(delDeliveryFilesCcc.getBlockFactor()!=null){
					dto.setBlockFactor(delDeliveryFilesCcc.getBlockFactor().intValue());
					}
					if(delDeliveryFilesCcc.getCreateTrailer()!=null){
					dto.setCreateTrailer(delDeliveryFilesCcc.getCreateTrailer());
					}
					if(delDeliveryFilesCcc.getDeliveryStatus()!=null){
					dto.setDeliveryStatus(delDeliveryFilesCcc.getDeliveryStatus());
					}
					if(delDeliveryFilesCcc.getDeliveryTime()!=null){
					dto.setDeliveryTime(delDeliveryFilesCcc.getDeliveryTime().intValue());
					}
					
					if(delDeliveryFilesCcc.getHashTotal()!=null){
					dto.setHashTotals(delDeliveryFilesCcc.getHashTotal().intValue());
					}
					if(delDeliveryFilesCcc.getLastFile()!=null){
					dto.setLastFile(delDeliveryFilesCcc.getLastFile());
					}
					if(delDeliveryFilesCcc.getMember()!=null){
					dto.setMember( delDeliveryFilesCcc.getMember().intValue());
					}
					if(delDeliveryFilesCcc.getNoOfCredits()!=null){
					dto.setNoOfCredits(delDeliveryFilesCcc.getNoOfCredits().intValue());
					}
					if(delDeliveryFilesCcc.getNoOfDebits()!=null){
					dto.setNoOfDebits(delDeliveryFilesCcc.getNoOfDebits().intValue());
					}
					if(delDeliveryFilesCcc.getNoOfRecords()!=null){
					dto.setNoOfRecords(delDeliveryFilesCcc.getNoOfRecords().intValue());
					}
					if(delDeliveryFilesCcc.getOutputFormat()!=null){
					dto.setOutputFormat(delDeliveryFilesCcc.getOutputFormat());
					}
					if(delDeliveryFilesCcc.getPrdDate()!=null){
					dto.setPrddate(delDeliveryFilesCcc.getPrdDate().intValue());
					}
					if(delDeliveryFilesCcc.getProgramFrom()!=null){
					dto.setProgramFrom(delDeliveryFilesCcc.getProgramFrom());
					}
					if(delDeliveryFilesCcc.getRecLength()!=null){
					dto.setRecLength(delDeliveryFilesCcc.getRecLength().shortValue());
					}
					if(delDeliveryFilesCcc.getRejectReason()!=null){
					dto.setRejectReason(delDeliveryFilesCcc.getRejectReason());
					}
					if(delDeliveryFilesCcc.getReportName()!=null){
					dto.setReportName(delDeliveryFilesCcc.getReportName());
					}
					if(delDeliveryFilesCcc.getSubApplication()!=null){
					dto.setSubApplication(delDeliveryFilesCcc.getSubApplication());
					}
					if(delDeliveryFilesCcc.getTimeCreated()!=null){
					dto.setTimeCreated(delDeliveryFilesCcc.getTimeCreated().intValue());
					}
					if(delDeliveryFilesCcc.getUserDest()!=null){
					dto.setUserDest(delDeliveryFilesCcc.getUserDest().shortValue());
					}
					if(delDeliveryFilesCcc.getValueCredits()!=null){
					dto.setValueCredits(delDeliveryFilesCcc.getValueCredits().intValue());
					}
					if(delDeliveryFilesCcc.getValueDebits()!=null){
					dto.setValueDebits(delDeliveryFilesCcc.getValueDebits().intValue());
					}
					if(delDeliveryFilesCcc.getWrittenToAxd()!=null){
					dto.setWrittenToAxd(delDeliveryFilesCcc.getWrittenToAxd());
					}
					if(delDeliveryFilesCcc.getXmitInd()!=null){
					dto.setXmitInd(delDeliveryFilesCcc.getXmitInd());
					}

				dtoList.add(dto);
			}

		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return dtoList;
	}

	public int getNextPositionByQueueFileName(DelDeliveryFilesCCCDTO obj) throws DAOException{
		try {
			String sql = "SELECT COUNT(*) AS count FROM DelDeliveryFilesCcc ";
			//String sql = "SELECT MAX(*) FROM DelDeliveryFilesCcc " + buildWhereClause(obj,true);
			int count = (int) deliveryDao.executeCountQuery(sql);

			return count;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving DelDeliveryFilesCcc, cause: "+ ex.getMessage(), ex);
    	}
	}


	private String buildWhereClause(DelDeliveryFilesCCCDTO obj ,boolean select)throws DAOException {

		if(obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {

		if(obj.getPosition() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.delDeliveryFilesCccPK.position =:position");      
			map.put("position",String.valueOf(obj.getPosition()));

		}

		if(obj.getQueueFileName() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.delDeliveryFilesCccPK.queueFileName =:queueFileName");
			map.put("queueFileName",obj.getQueueFileName());

		}
		if(obj.getFileName() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.delDeliveryFilesCccPK.filename =:filename");
			map.put("filename",obj.getFileName());

		}

		if(obj.getPrddate() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.prdDate =:prdDate");
			map.put("prdDate",obj.getPrddate());

		}

		if(obj.getMember() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.member =:member");
			map.put("member",String.valueOf(obj.getMember()));
		}

		if(obj.getUserDest() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.userDest =:userDest");
			map.put("userDest",String.valueOf(obj.getUserDest()));
		}
		if(obj.getApplication() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.application =:application");
			map.put("application",obj.getApplication());
		}
		if(obj.getSubApplication() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.subApplication =:subApplication");
			map.put("subApplication",obj.getSubApplication());
		}
		if(obj.getLastFile()!= null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.lastFile =:lastFile");
			map.put("lastFile",obj.getLastFile());
		}
		if(obj.getXmitInd() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.xmitInd =:xmitInd");
			map.put("xmitInd",obj.getXmitInd());
		}
		if(obj.getProgramFrom() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.programFrom =:programFrom");
			map.put("programFrom",obj.getProgramFrom());
		}
		if(obj.getTimeCreated() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.timeCreated = :timeCreated");
			map.put("timeCreated",String.valueOf(obj.getTimeCreated()));
		}
		if(obj.getOutputFormat() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.outputFormat = :outputFormat");
			map.put("outputFormat",obj.getOutputFormat());
		}
		if(obj.getBackupFormat() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.backupFormat = :backupFormat");
			map.put("backupFormat",obj.getBackupFormat());
		}
		if(obj.getCreateTrailer()!= null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.createTrailer = :createTrailer");
			map.put("createTrailer",obj.getCreateTrailer());
		}
		if(obj.getNoOfRecords() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.noOfRecords = :noOfRecords");
			map.put("noOfRecords",String.valueOf(obj.getNoOfRecords()));
		}
		if(obj.getNoOfDebits() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.noOfDebits = :noOfDebits");
			map.put("noOfDebits",String.valueOf(obj.getNoOfDebits()));
		}
		if(obj.getNoOfCredits() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.noOfCredits = :noOfCredits");
			map.put("noOfCredits",String.valueOf(obj.getNoOfCredits()));
		}
		if(obj.getValueDebits() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.valueDebits = :valueDebits");
			map.put("valueDebits",String.valueOf(obj.getValueDebits()));
		}
		if(obj.getValueCredits() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.valueCredits = :valueCredits");
			map.put("valueCredits",String.valueOf(obj.getValueCredits()));
		}
		if(obj.getHashTotals() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.hashTotal = :hashTotal");
			map.put("hashTotal",String.valueOf(obj.getDeliveryStatus()));
		}
		if(obj.getRecLength() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.recLength = :recLength");
			map.put("recLength",String.valueOf(obj.getRecLength()));
		}
		if(obj.getBlockFactor() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.blockFactor =:blockFactor");
			map.put("blockFactor",String.valueOf(obj.getBlockFactor()));
		}
		if(obj.getDeliveryStatus() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.deliveryStatus =:deliveryStatus");
			map.put("deliveryStatus",obj.getDeliveryStatus());
		}
		if(obj.getDeliveryTime() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.deliveryTime =:deliveryTime");
			map.put("deliveryTime",String.valueOf(obj.getDeliveryTime()));
		}
		if(obj.getWrittenToAxd() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.writtenToAxd =:writtenToAxd");
			map.put("writtenToAxd",obj.getWrittenToAxd());
		}
		if(obj.getRejectReason() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.rejectReason =:rejectReason");
			map.put("rejectReason",obj.getRejectReason());
		}
		if(obj.getReportName() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.reportName =:reportName");
			map.put("reportName",obj.getReportName());
		}
		
		/*if (map != null && !map.isEmpty()) {
	          for (Map.Entry<String,Object> entry : map.entrySet()) {
	        	  System.out.println("The DelDeliveryFilesCcc Key is : "+entry.getKey() +" The DelDeliveryFilesCcc Value is " + entry.getValue().toString());
	          }
	      }*/
	}
	if(!whereClause && select == false) {
		throw new DAOException( "Cannot Build where clause in DelDeliveryFilesCcc");
	}
		


		return buff.toString();
	}

	public void update(DelDeliveryFilesCCCDTO delDeliveryFilesCCCDTO) throws DAOException {
		try {
			
		DelDeliveryFilesCccPK elDeliveryFilesCccPK = new DelDeliveryFilesCccPK();	
		elDeliveryFilesCccPK.setPosition(delDeliveryFilesCCCDTO.getPosition());
		
		elDeliveryFilesCccPK.setFilename(delDeliveryFilesCCCDTO.getFileName());		
		
		elDeliveryFilesCccPK.setQueueFileName(delDeliveryFilesCCCDTO.getQueueFileName());
		
		
		DelDeliveryFilesCcc delDeliveryFilesCcc = new DelDeliveryFilesCcc();		
		delDeliveryFilesCcc.setDelDeliveryFilesCccPK(elDeliveryFilesCccPK);
		if(delDeliveryFilesCCCDTO.getApplication() != null){
		delDeliveryFilesCcc.setApplication(delDeliveryFilesCCCDTO.getApplication());
		}
		if(delDeliveryFilesCCCDTO.getBackupFormat() != null){
		delDeliveryFilesCcc.setBackupFormat(delDeliveryFilesCCCDTO.getBackupFormat());
		}
		if(delDeliveryFilesCCCDTO.getBlockFactor() != 0){
		delDeliveryFilesCcc.setBlockFactor((short) delDeliveryFilesCCCDTO.getBlockFactor());
		}
		if(delDeliveryFilesCCCDTO.getCreateTrailer() != null){
		delDeliveryFilesCcc.setCreateTrailer(delDeliveryFilesCCCDTO.getCreateTrailer());
		}
		if(delDeliveryFilesCCCDTO.getDeliveryStatus() != null){
		delDeliveryFilesCcc.setDeliveryStatus(delDeliveryFilesCCCDTO.getDeliveryStatus());
		}
		if(delDeliveryFilesCCCDTO.getDeliveryTime() != 0){
		delDeliveryFilesCcc.setDeliveryTime(delDeliveryFilesCCCDTO.getDeliveryTime());
		}
		if(delDeliveryFilesCCCDTO.getHashTotals() != 0){
		delDeliveryFilesCcc.setHashTotal((long) delDeliveryFilesCCCDTO.getHashTotals());
		}
		if(delDeliveryFilesCCCDTO.getLastFile() != null){
		delDeliveryFilesCcc.setLastFile(delDeliveryFilesCCCDTO.getLastFile());
		}
		if(delDeliveryFilesCCCDTO.getMember() != 0){
		delDeliveryFilesCcc.setMember((short) delDeliveryFilesCCCDTO.getMember());
		}
		if(delDeliveryFilesCCCDTO.getNoOfCredits() > 0){
		delDeliveryFilesCcc.setNoOfCredits(delDeliveryFilesCCCDTO.getNoOfCredits());
		}
		if(delDeliveryFilesCCCDTO.getNoOfDebits() > 0){
		delDeliveryFilesCcc.setNoOfDebits(delDeliveryFilesCCCDTO.getNoOfDebits());
		}
		if(delDeliveryFilesCCCDTO.getNoOfRecords() > 0){
		delDeliveryFilesCcc.setNoOfRecords(delDeliveryFilesCCCDTO.getNoOfRecords());
		}
		if(delDeliveryFilesCCCDTO.getOutputFormat() != null){
		delDeliveryFilesCcc.setOutputFormat(delDeliveryFilesCCCDTO.getOutputFormat());
		}
		if(delDeliveryFilesCCCDTO.getPrddate() > 0){
		delDeliveryFilesCcc.setPrdDate(delDeliveryFilesCCCDTO.getPrddate());
		}
		if(delDeliveryFilesCCCDTO.getProgramFrom() != null){
		delDeliveryFilesCcc.setProgramFrom(delDeliveryFilesCCCDTO.getProgramFrom());
		}
		if(delDeliveryFilesCCCDTO.getRecLength() > 0){
		delDeliveryFilesCcc.setRecLength((short) delDeliveryFilesCCCDTO.getRecLength());
		}
		if(delDeliveryFilesCCCDTO.getRejectReason() != null){
		delDeliveryFilesCcc.setRejectReason(delDeliveryFilesCCCDTO.getRejectReason());
		}
		if(delDeliveryFilesCCCDTO.getReportName() != null){
		delDeliveryFilesCcc.setReportName(delDeliveryFilesCCCDTO.getReportName());
		}
		if(delDeliveryFilesCCCDTO.getSubApplication() != null){
		delDeliveryFilesCcc.setSubApplication(delDeliveryFilesCCCDTO.getSubApplication());
		}
		if(delDeliveryFilesCCCDTO.getTimeCreated() > 0){
		delDeliveryFilesCcc.setTimeCreated(delDeliveryFilesCCCDTO.getTimeCreated());
		}
		if(delDeliveryFilesCCCDTO.getUserDest() > 0){
		delDeliveryFilesCcc.setUserDest((short) delDeliveryFilesCCCDTO.getUserDest());
		}
		if(delDeliveryFilesCCCDTO.getValueCredits() > 0){
		delDeliveryFilesCcc.setValueCredits(BigDecimal.valueOf(delDeliveryFilesCCCDTO.getValueCredits()));
		}
		if(delDeliveryFilesCCCDTO.getValueDebits() > 0){
		delDeliveryFilesCcc.setValueDebits(BigDecimal.valueOf(delDeliveryFilesCCCDTO.getValueDebits()));
		}
		if(delDeliveryFilesCCCDTO.getWrittenToAxd() != null){
		delDeliveryFilesCcc.setWrittenToAxd(delDeliveryFilesCCCDTO.getWrittenToAxd());
		}
		if(delDeliveryFilesCCCDTO.getXmitInd() != null){
		delDeliveryFilesCcc.setXmitInd(delDeliveryFilesCCCDTO.getXmitInd());
		}


		
			
		deliveryDao.update(delDeliveryFilesCcc);

		}
		catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	public void delete(DelDeliveryFilesCCCDTO delDeliveryFilesCCCDTO)throws DAOException{
		
		DelDeliveryFilesCccPK elDeliveryFilesCccPK = new DelDeliveryFilesCccPK();	
		
		elDeliveryFilesCccPK.setPosition(delDeliveryFilesCCCDTO.getPosition());
		elDeliveryFilesCccPK.setFilename(delDeliveryFilesCCCDTO.getFileName());		
		elDeliveryFilesCccPK.setQueueFileName(delDeliveryFilesCCCDTO.getQueueFileName());
		
		DelDeliveryFilesCcc delDeliveryFilesCcc = new DelDeliveryFilesCcc();
		delDeliveryFilesCcc.setDelDeliveryFilesCccPK(elDeliveryFilesCccPK);
		
		delDeliveryFilesCcc.setApplication(delDeliveryFilesCCCDTO.getApplication());
		delDeliveryFilesCcc.setBackupFormat(delDeliveryFilesCCCDTO.getBackupFormat());
		delDeliveryFilesCcc.setBlockFactor((short) delDeliveryFilesCCCDTO.getBlockFactor());
		delDeliveryFilesCcc.setCreateTrailer(delDeliveryFilesCCCDTO.getCreateTrailer());
		delDeliveryFilesCcc.setDeliveryStatus(delDeliveryFilesCCCDTO.getDeliveryStatus());
		delDeliveryFilesCcc.setDeliveryTime(delDeliveryFilesCCCDTO.getDeliveryTime());
		delDeliveryFilesCcc.setHashTotal((long) delDeliveryFilesCCCDTO.getHashTotals());
		delDeliveryFilesCcc.setLastFile(delDeliveryFilesCCCDTO.getLastFile());
		delDeliveryFilesCcc.setMember((short) delDeliveryFilesCCCDTO.getMember());
		delDeliveryFilesCcc.setNoOfCredits(delDeliveryFilesCCCDTO.getNoOfCredits());
		delDeliveryFilesCcc.setNoOfDebits(delDeliveryFilesCCCDTO.getNoOfDebits());
		delDeliveryFilesCcc.setNoOfRecords(delDeliveryFilesCCCDTO.getNoOfRecords());
		delDeliveryFilesCcc.setOutputFormat(delDeliveryFilesCCCDTO.getOutputFormat());
		delDeliveryFilesCcc.setPrdDate(delDeliveryFilesCCCDTO.getPrddate());
		delDeliveryFilesCcc.setProgramFrom(delDeliveryFilesCCCDTO.getProgramFrom());
		delDeliveryFilesCcc.setRecLength((short) delDeliveryFilesCCCDTO.getRecLength());
		delDeliveryFilesCcc.setRejectReason(delDeliveryFilesCCCDTO.getRejectReason());
		delDeliveryFilesCcc.setReportName(delDeliveryFilesCCCDTO.getReportName());
		delDeliveryFilesCcc.setSubApplication(delDeliveryFilesCCCDTO.getSubApplication());
		delDeliveryFilesCcc.setTimeCreated(delDeliveryFilesCCCDTO.getTimeCreated());
		delDeliveryFilesCcc.setUserDest((short) delDeliveryFilesCCCDTO.getUserDest());
		delDeliveryFilesCcc.setValueCredits(BigDecimal.valueOf(delDeliveryFilesCCCDTO.getValueCredits()));
		delDeliveryFilesCcc.setValueDebits(BigDecimal.valueOf(delDeliveryFilesCCCDTO.getValueDebits()));
		delDeliveryFilesCcc.setWrittenToAxd(delDeliveryFilesCCCDTO.getWrittenToAxd());
		delDeliveryFilesCcc.setXmitInd(delDeliveryFilesCCCDTO.getXmitInd());

		deliveryDao.delete(delDeliveryFilesCcc);


	}
	
	public void delete()throws DAOException{
		deliveryDao.deleteBulk("Delete from DelDeliveryFilesCcc");
	}


}


