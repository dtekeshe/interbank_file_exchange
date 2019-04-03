package com.bsva.dcms.commons.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoScheduleTimesDao;
import com.bsva.dcms.commons.dto.CsoScheduleTimesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoScheduleTimes;
import com.bsva.entities.CsoScheduleTimesPK;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoScheduleTimesDAO{

                //private CsoScheduleTimesRepository csoScheduleTimesRepoDao = DaoFactory.csoScheduleTimesInstance();
                
                private CsoScheduleTimesDao csoScheduleTimesDao = new CsoScheduleTimesDao();
                private Map<String,Object> map = new HashMap<String,Object>();
                public CsoScheduleTimesDAO() {

                }

                /**
                * Create a new record in Database.
                *
                * @param bean The Object to be inserted.
                * @exception SQLException if something is wrong.
                */

                public void create(CsoScheduleTimesDTO bean) throws DAOException {
                 try{

                                CsoScheduleTimes csoScheduleTimes = new CsoScheduleTimes();
                                csoScheduleTimes.setActiveInd(bean.getActiveInd());
                                csoScheduleTimes.setBusyInd(bean.getBusyInd());
                                csoScheduleTimes.setCheckPoint(bean.getCheckPoint());
                                csoScheduleTimes.setEndTime(bean.getEndTime());
                                csoScheduleTimes.setLastRunTime(bean.getLastRunTime());
                                csoScheduleTimes.setStartTime(bean.getStartTime());
                                csoScheduleTimes.setProcessDate(bean.getProcessDate());
                                
                                CsoScheduleTimesPK csoScheduleTimesPK = new CsoScheduleTimesPK();
                                csoScheduleTimesPK.setProcess(bean.getProcess());
                                csoScheduleTimesPK.setService(bean.getService());
                                csoScheduleTimesPK.setSubService(bean.getSubService());
                                csoScheduleTimes.setCsoScheduleTimesPK(csoScheduleTimesPK);
                                csoScheduleTimesDao.create(csoScheduleTimes);
                 }catch(Exception ex){
                	 ex.getMessage();
                 }


                }

                
                public CsoScheduleTimesDTO retrieve(CsoScheduleTimesDTO bean) throws DAOException {
                                CsoScheduleTimesDTO dto = new CsoScheduleTimesDTO();

                                try {
                                                String sql = "SELECT c  FROM CsoScheduleTimes c "+ buildWhereClause(bean,true);
                                                CsoScheduleTimes csoScheduleTimes = csoScheduleTimesDao.executeQueryParametersSingle(sql,map);

                                                if(csoScheduleTimes.getActiveInd()!=null){
                                                                dto.setActiveInd(csoScheduleTimes.getActiveInd());
                                                }
                                                if(csoScheduleTimes.getBusyInd()!=null){
                                                                dto.setBusyInd(csoScheduleTimes.getBusyInd());
                                                }
                                                if(csoScheduleTimes.getCheckPoint()!=null){
                                                                dto.setCheckPoint(csoScheduleTimes.getCheckPoint());
                                                }
                                                if(csoScheduleTimes.getEndTime()!=null){
                                                                dto.setEndTime(csoScheduleTimes.getEndTime());
                                                }
                                                if(csoScheduleTimes.getLastRunTime()!=null){
                                                                dto.setLastRunTime(csoScheduleTimes.getLastRunTime());
                                                }
                                                if(csoScheduleTimes.getStartTime()!=null){
                                                                dto.setStartTime(csoScheduleTimes.getStartTime());
                                                }
                                                if(csoScheduleTimes.getCsoScheduleTimesPK().getProcess()!=null){
                                                                dto.setProcess(csoScheduleTimes.getCsoScheduleTimesPK().getProcess());
                                                }
                                                if(csoScheduleTimes.getCsoScheduleTimesPK().getSubService()!=null){
                                                                dto.setService(csoScheduleTimes.getCsoScheduleTimesPK().getSubService());
                                                }
                                                if(csoScheduleTimes.getCsoScheduleTimesPK().getService()!=null){
                                                                dto.setSubService(csoScheduleTimes.getCsoScheduleTimesPK().getService());
                                                }
                                                if(csoScheduleTimes.getProcessDate()!=null){
                                                				dto.setProcessDate(csoScheduleTimes.getProcessDate());	
                                                }

                                }
                                catch(Exception ex) {
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

                @SuppressWarnings("unchecked")
                public List<CsoScheduleTimesDTO> retrieveRelated(CsoScheduleTimesDTO bean) throws DAOException {
                                List<CsoScheduleTimesDTO> dtoList = new ArrayList<CsoScheduleTimesDTO>();
                                CsoScheduleTimesDTO dto = null;
                                try{
                                                String sql = "SELECT c  FROM CsoScheduleTimes c "+ buildWhereClause(bean,true);
                                                List<CsoScheduleTimes> csoScheduleTimesretrieveRelated = csoScheduleTimesDao.executeQueryParametersDate(sql,map);
                                                for (CsoScheduleTimes CsoScheduleTimesRelated : csoScheduleTimesretrieveRelated) {

                                                                dto = new CsoScheduleTimesDTO();
                                                                if(CsoScheduleTimesRelated.getActiveInd()!=null){
                                                                                dto.setActiveInd(CsoScheduleTimesRelated.getActiveInd());
                                                                }
                                                                if(CsoScheduleTimesRelated.getBusyInd()!=null){
                                                                                dto.setBusyInd(CsoScheduleTimesRelated.getBusyInd());
                                                                }
                                                                if(CsoScheduleTimesRelated.getCheckPoint()!=null){
                                                                                dto.setCheckPoint(CsoScheduleTimesRelated.getCheckPoint());
                                                                }
                                                                if(CsoScheduleTimesRelated.getCheckPointName()!=null){
                                                                    dto.setCheckPoint(CsoScheduleTimesRelated.getCheckPointName());
                                                    }
                                                                if(CsoScheduleTimesRelated.getEndTime()!=null){
                                                                                dto.setEndTime(CsoScheduleTimesRelated.getEndTime());
                                                                }
                                                                if(CsoScheduleTimesRelated.getLastRunTime()!=null){
                                                                                dto.setLastRunTime(CsoScheduleTimesRelated.getLastRunTime());
                                                                }
                                                                if(CsoScheduleTimesRelated.getStartTime()!=null){
                                                                                dto.setStartTime(CsoScheduleTimesRelated.getStartTime());
                                                                }
                                                                if(CsoScheduleTimesRelated.getCsoScheduleTimesPK().getProcess()!=null){
                                                                                dto.setProcess(CsoScheduleTimesRelated.getCsoScheduleTimesPK().getProcess());
                                                                }
                                                                if(CsoScheduleTimesRelated.getCsoScheduleTimesPK().getSubService()!=null){
                                                                                dto.setService(CsoScheduleTimesRelated.getCsoScheduleTimesPK().getSubService());
                                                                }
                                                                if(CsoScheduleTimesRelated.getCsoScheduleTimesPK().getService()!=null){
                                                                                dto.setSubService(CsoScheduleTimesRelated.getCsoScheduleTimesPK().getService());
                                                                }
                                                                if(CsoScheduleTimesRelated.getProcessDate()!=null){
                                                                                dto.setProcessDate(CsoScheduleTimesRelated.getProcessDate());
                                                                }

                                                                dtoList.add(dto);
                                                }

                                }catch(Exception ex){
                                                ex.getMessage();            
                                }
                                map.clear();
                                return dtoList;
                }

                private String buildWhereClause(CsoScheduleTimesDTO bean,boolean select) throws DAOException {
                                if(bean == null) {
                                                return "";
                                }
                                StringBuilder buff = new StringBuilder();
                                boolean whereClause = false;
                                
                                if (select == true) {

                                if (bean.getProcess() != null && !bean.getProcess().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.csoScheduleTimesPK.process = :process");
                                                map.put("process",bean.getProcess());
                                }
                                if (bean.getService() != null && !bean.getService().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.csoScheduleTimesPK.service = :service");
                                                map.put("service",bean.getService());
                                }
                                if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.csoScheduleTimesPK.subService = :subService");
                                                map.put("subService",bean.getSubService());
                                }
                                if (bean.getCheckPoint() != null && !bean.getCheckPoint().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }

                                                buff.append("c.checkPoint = :checkPoint");
                                                map.put("checkPoint",bean.getCheckPoint());
                                }
                                if (bean.getCheckPointName() != null && !bean.getCheckPointName().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.checkPointName = :checkPointName");
                                                map.put("checkPointName",bean.getCheckPointName());
                                }
                                if (bean.getStartTime() != null && !bean.getStartTime().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.startTime = :startTime");
                                                map.put("startTime",bean.getStartTime());
                                }
                                if (bean.getEndTime() != null && !bean.getEndTime().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.endTime = :endTime");
                                                map.put("endTime",bean.getEndTime());
                                }
                                if (bean.getLastRunTime() != null && !bean.getEndTime().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.lastRunTime = :lastRunTime");
                                                map.put("lastRunTime",String.valueOf(bean.getLastRunTime()));
                                }
                                if (bean.getActiveInd() != null && !bean.getActiveInd().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.activeInd = :activeInd");
                                                map.put("activeInd",bean.getActiveInd());
                                }
                                if (bean.getBusyInd() != null && !bean.getBusyInd().isEmpty()) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.busyInd = :busyInd");
                                                map.put("busyInd",bean.getBusyInd());
                                }
                                if (bean.getProcessDate() != null) {
                                                if(!whereClause) {
                                                                whereClause = true;
                                                                buff.append(" WHERE ");
                                                }
                                                else {
                                                                buff.append(" AND ");
                                                }
                                                buff.append("c.processDate = :processDate");
                                                map.put("processDate",bean.getProcessDate());
                                }
                                }
                                if(!whereClause && select == false) {
                                                throw new DAOException( "Cannot Build where clause in CsoScheduleTimes");
                                }

                                return buff.toString();
                }


                public void update(CsoScheduleTimesDTO obj) throws DAOException {
                	try {
                                CsoScheduleTimes csoScheduleTimes = new CsoScheduleTimes();
                                csoScheduleTimes.setActiveInd(obj.getActiveInd());
                                csoScheduleTimes.setBusyInd(obj.getBusyInd());
                                csoScheduleTimes.setCheckPoint(obj.getCheckPoint());
                                csoScheduleTimes.setEndTime(obj.getEndTime());
                                csoScheduleTimes.setLastRunTime(obj.getLastRunTime());
                                csoScheduleTimes.setStartTime(obj.getStartTime());
                                csoScheduleTimes.setProcessDate(obj.getProcessDate());
                                CsoScheduleTimesPK csoScheduleTimesPK = new CsoScheduleTimesPK(obj.getProcess(),obj.getService(),obj.getSubService());
                               // csoScheduleTimesPK.setProcess(obj.getProcess());
                               // csoScheduleTimesPK.setService(obj.getService());
                                //csoScheduleTimesPK.setSubService(obj.getSubService());
                                csoScheduleTimes.setCsoScheduleTimesPK(csoScheduleTimesPK);
                                csoScheduleTimesDao.update(csoScheduleTimes);

                                } catch (Exception ex) {
                                                ex.getMessage();
                                } 
                }
                public void delete() throws DAOException {
                
                                csoScheduleTimesDao.deleteBulk("Delete from CsoScheduleTimes");
                }
        
}
