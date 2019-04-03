package com.bsva.dcms.commons.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoScheduleTimesDTO implements java.io.Serializable, Cloneable {
                private String process;
                private String service;
                private String subService;
                private String startTime;
                private String endTime;
                private String lastRunTime;
                private String activeInd;
                private String busyInd;
                private String checkPoint;
                private String checkPointName;
                private String processDate;

                

                public String getProcess() {
                                return this.process;
                }

                public void setProcess(String process) {
                                this.process=process;
                }

                public String getService() {
                                return this.service;
                }

                public void setService(String service) {
                                this.service=service;
                }

                public String getSubService() {
                                return this.subService;
                }

                public void setSubService(String subService) {
                                this.subService=subService;
                }

                public String getStartTime() {
                                return this.startTime;
                }

                public void setStartTime(String startTime) {
                                this.startTime=startTime;
                }

                public String getEndTime() {
                                return this.endTime;
                }

                public void setEndTime(String endTime) {
                                this.endTime=endTime;
                }

                public String getLastRunTime() {
                                return this.lastRunTime;
                }

                public void setLastRunTime(String lastRunTime) {
                                this.lastRunTime=lastRunTime;
                }

                public String getActiveInd() {
                                return this.activeInd;
                }

                public void setActiveInd(String activeInd) {
                                this.activeInd=activeInd;
                }

                public String getBusyInd() {
                                return this.busyInd;
                }

                public void setBusyInd(String busyInd) {
                                this.busyInd=busyInd;
                }

                public String getCheckPoint() {
                                return this.checkPoint;
                }

                public void setCheckPoint(String checkPoint) {
                                this.checkPoint=checkPoint;
                }

                public String getCheckPointName() {
                                return this.checkPointName;
                }

                public void setCheckPointName(String checkPointName) {
                                this.checkPointName=checkPointName;
                }
                public String getProcessDate() {
                                return processDate;
                }

                public void setProcessDate(String processDate) {
                                this.processDate = processDate;
                }


                /* Creates and returns a copy of this object. */
                public Object clone() {
                                CsoScheduleTimesDTO bean = new CsoScheduleTimesDTO();
                                bean.process = this.process;
                                bean.service = this.service;
                                bean.subService = this.subService;
                                bean.startTime = this.startTime;
                                bean.endTime = this.endTime;
                                bean.lastRunTime = this.lastRunTime;
                                bean.activeInd = this.activeInd;
                                bean.busyInd = this.busyInd;
                                bean.checkPoint = this.checkPoint;
                                bean.checkPointName = this.checkPointName;
                                bean.processDate = this.processDate;
                                return bean;
                }
                /* Returns a string representation of the object. */
                public String toString() {
                                String sep = "\r\n";
                                StringBuffer sb = new StringBuffer();
                                sb.append(this.getClass().getName()).append(sep);
                                sb.append("[").append("this.process").append(" = ").append(this.process).append("]").append(sep);
                                sb.append("[").append("this.service").append(" = ").append(this.service).append("]").append(sep);
                                sb.append("[").append("this.subService").append(" = ").append(this.subService).append("]").append(sep);
                                sb.append("[").append("this.startTime").append(" = ").append(this.startTime).append("]").append(sep);
                                sb.append("[").append("this.endTime").append(" = ").append(this.endTime).append("]").append(sep);
                                sb.append("[").append("this.lastRunTime").append(" = ").append(this.lastRunTime).append("]").append(sep);
                                sb.append("[").append("this.activeInd").append(" = ").append(this.activeInd).append("]").append(sep);
                                sb.append("[").append("this.busyInd").append(" = ").append(this.busyInd).append("]").append(sep);
                                sb.append("[").append("this.checkPoint").append(" = ").append(this.checkPoint).append("]").append(sep);
                                sb.append("[").append("this.checkPointName").append(" = ").append(this.checkPointName).append("]").append(sep);
                                sb.append("[").append("this.processDate").append(" = ").append(this.processDate).append("]").append(sep);
                                return sb.toString();
                }
}
