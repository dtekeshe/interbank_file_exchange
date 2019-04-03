/*package com.bsva.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.bsva.dcms.commons.dto.CSFAsciiEbcdicDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.dao.repo.CsfAsciiEbcdicRepository;
import com.bsva.dmcs.entities.CsfAsciiEbcdic;
import com.bsva.dmcs.util.DaoFactory;

public class AsciiEbdcdic {

	
	private CsfAsciiEbcdicRepository csfAsciiEbcdicDao = DaoFactory.csfAsciiEbcdicInstance();
	
	
	 @SuppressWarnings("unchecked")
	 @Test
	 public void retrieve() {
	        try {
	            String sql = "SELECT c FROM CsfAsciiEbcdic c WHERE c.ebcdicChar = ?0" ;

	            List<CsfAsciiEbcdic> csfAsciiEbcdicDetails = this.csfAsciiEbcdicDao.findByAsciiEbcdic(sql,"Y");
	    		
	    		for (CsfAsciiEbcdic csfAsciiEbcdic : csfAsciiEbcdicDetails) {
	            	System.out.println(csfAsciiEbcdic.getDecimalVal().toString());
	            	System.out.println(csfAsciiEbcdic.getAsciiChar().toString());
	            	System.out.println(csfAsciiEbcdic.getEbcdicChar().toString());
	            	System.out.println(csfAsciiEbcdic.getEbcdicInt());
	            	System.out.println();
	            	System.out.println();
	    		}
	        }
	        catch(Exception ex) {
	        	ex.getMessage();
	        }
	}
	 //Ctreate start
	 @Test
	 public void createData(){
		 
		 CSFAsciiEbcdicDTO cSFAsciiEbcdicDTO = new CSFAsciiEbcdicDTO();
		 cSFAsciiEbcdicDTO.setAsciiChar("n");
		 cSFAsciiEbcdicDTO.setEbcdicChar("m");
		 cSFAsciiEbcdicDTO.setEbcdicInt(911);
		 cSFAsciiEbcdicDTO.setDecimalVal(257);
		 
		 CsfAsciiEbcdic csfAsciiEbcdic  = new CsfAsciiEbcdic();
		 csfAsciiEbcdic.setDecimalVal((short) cSFAsciiEbcdicDTO.getDecimalVal());
		 csfAsciiEbcdic.setAsciiChar(cSFAsciiEbcdicDTO.getAsciiChar());
		 csfAsciiEbcdic.setEbcdicChar(cSFAsciiEbcdicDTO.getEbcdicChar());
		 csfAsciiEbcdic.setEbcdicInt((short) cSFAsciiEbcdicDTO.getEbcdicInt());
		 
		 this.csfAsciiEbcdicDao.save(csfAsciiEbcdic);
		 
		 
	 }
	 public void create(CSFAsciiEbcdicDTO csfAsciiEbcdicDTO) throws DAOException {
		 
		         
         CsfAsciiEbcdic CsfAsciiEbcdic  = new CsfAsciiEbcdic();
         CsfAsciiEbcdic.setDecimalVal((short) csfAsciiEbcdicDTO.getDecimalVal());
         CsfAsciiEbcdic.setAsciiChar(csfAsciiEbcdicDTO.getAsciiChar());
         CsfAsciiEbcdic.setEbcdicChar(csfAsciiEbcdicDTO.getEbcdicChar());
         CsfAsciiEbcdic.setEbcdicInt((short) csfAsciiEbcdicDTO.getEbcdicInt());
         
         csfAsciiEbcdicDao.save(CsfAsciiEbcdic);
     }//Create stop.
	 
	 
	 //Update start
	 @SuppressWarnings("unchecked")
	 @Test
	 public void updater() {
		 
		 CSFAsciiEbcdicDTO cSFAsciiEbcdicDTO = new CSFAsciiEbcdicDTO();
		 cSFAsciiEbcdicDTO.setAsciiChar("R");
		 cSFAsciiEbcdicDTO.setEbcdicChar("Y");
		 cSFAsciiEbcdicDTO.setEbcdicInt(911);
		 cSFAsciiEbcdicDTO.setDecimalVal(257);
		 
		 try {
			 
			update(cSFAsciiEbcdicDTO);
			
		} catch (DAOException e) {
			e.getMessage();
		}
		 
	 }
	 
	 public void update(CSFAsciiEbcdicDTO obj) throws DAOException {
	    	
	        boolean first = true;
	        
	        CsfAsciiEbcdic csfAsciiEbcdicEntity = new CsfAsciiEbcdic();
	        csfAsciiEbcdicEntity.setAsciiChar(obj.getAsciiChar());
	        csfAsciiEbcdicEntity.setEbcdicChar(obj.getEbcdicChar());
	        csfAsciiEbcdicEntity.setEbcdicInt((short) obj.getEbcdicInt());
	        csfAsciiEbcdicEntity.setDecimalVal((short) obj.getDecimalVal());
	        
	        try {
	            String sql = "UPDATE CCCOWNER.CSF_ASCII_EBCDIC u SET ";

	            if(obj.getAsciiChar() != null) {
	                if(!first) {
	                   sql = sql + ", ";
	                }
	                else {
	                   first = false;
	                }
	                sql = sql + "u.ASCII_CHAR =:"+csfAsciiEbcdicEntity.getAsciiChar();
	            }

	            if(obj.getEbcdicChar() != null) {
	                if(!first) {
	                   sql = sql + ", ";
	                }
	                else {
	                   first = false;
	                }
	                sql = sql + "u.EBCDIC_CHAR =:"+csfAsciiEbcdicEntity.getEbcdicChar();
	            }

	            if(obj.getEbcdicInt()!= -1) {
	                if(!first) {
	                   sql = sql + ", ";
	                }
	                else {
	                   first = false;
	                }
	                sql = sql + "u.EBCDIC_INT =:"+csfAsciiEbcdicEntity.getEbcdicInt();
	            }

	            sql = sql + "WHERE u.DECIMAL_VAL =:"+csfAsciiEbcdicEntity.getDecimalVal();
	            
	            this.csfAsciiEbcdicDao.update(csfAsciiEbcdicEntity);
	        }
	        catch(Exception ex) {
	            ex.getMessage();
	        }
	   }//Update Ends
	 
	 
	//Retrieve Related starts 
	@SuppressWarnings("unchecked")
	 @Test
	public void retrievRelated() {
			 
			 CSFAsciiEbcdicDTO cSFAsciiEbcdicDTO = new CSFAsciiEbcdicDTO();
			 cSFAsciiEbcdicDTO.setAsciiChar(" ");
			 cSFAsciiEbcdicDTO.setEbcdicChar("|");
			 cSFAsciiEbcdicDTO.setEbcdicInt(911);
			 cSFAsciiEbcdicDTO.setDecimalVal(254);
			 
			 try {
				 
				List<CSFAsciiEbcdicDTO> retrieve = retrieveRelated(cSFAsciiEbcdicDTO);
				for (CSFAsciiEbcdicDTO csfAsciiEbcdicDTO2 : retrieve) {
					System.out.println(csfAsciiEbcdicDTO2.getAsciiChar());
	        		System.out.println(csfAsciiEbcdicDTO2.getDecimalVal());
	        		System.out.println(csfAsciiEbcdicDTO2.getEbcdicChar());
	        		System.out.println(csfAsciiEbcdicDTO2.getEbcdicInt());
				}
				
			} catch (DAOException e) {
				e.getMessage();
			}
			 
		 }
	 // THIS RETRIEVES A LIST OF OBJECTS
	 public List<CSFAsciiEbcdicDTO> retrieveRelated(CSFAsciiEbcdicDTO obj) throws DAOException {
	        List<CSFAsciiEbcdicDTO> dtoList = new LinkedList<CSFAsciiEbcdicDTO>();
	        try {
	            String sql = "SELECT c FROM CCCOWNER.CSF_ASCII_EBCDIC c "  + buildWhereClause(obj);
	            System.out.println("The sql is " + sql);
	            
             List<CsfAsciiEbcdic> csfAsciiEbcdicretrieveRelated = this.csfAsciiEbcdicDao.executeTypeQuery(sql);
	    		
	    		for (CsfAsciiEbcdic csfAsciiEbcdicRelated : csfAsciiEbcdicretrieveRelated) {
	    			
	            	CSFAsciiEbcdicDTO csfAsciiEbcdicDTO = new CSFAsciiEbcdicDTO();
	            	csfAsciiEbcdicDTO.setDecimalVal(csfAsciiEbcdicRelated.getDecimalVal());
	            	csfAsciiEbcdicDTO.setAsciiChar(csfAsciiEbcdicRelated.getAsciiChar());
	            	csfAsciiEbcdicDTO.setEbcdicChar(csfAsciiEbcdicRelated.getEbcdicChar());
	            	csfAsciiEbcdicDTO.setEbcdicInt(csfAsciiEbcdicRelated.getEbcdicInt());
	               

	            	dtoList.add(csfAsciiEbcdicDTO);
	            	
	            	for (CSFAsciiEbcdicDTO csfAsciiEbcdic : dtoList) {
						
	            		System.out.println(csfAsciiEbcdic.getAsciiChar());
	            		System.out.println(csfAsciiEbcdic.getDecimalVal());
	            		System.out.println(csfAsciiEbcdic.getEbcdicChar());
	            		System.out.println(csfAsciiEbcdic.getEbcdicInt());
					}
	            }
	        }
	        catch(Exception ex) {
	            ex.getMessage();
	        }
	        return dtoList;
	    }

	    private String buildWhereClause(CSFAsciiEbcdicDTO obj) {

	        if(obj == null) {
	            return "";
	        }
	        StringBuilder buff = new StringBuilder();
	        boolean whereClause = false;
	       
	        if((obj.getDecimalVal() != -1 ) || (obj.getDecimalVal() != 0)) {
	            if(!whereClause) {
	                whereClause = true;
	                buff.append(" WHERE ");
	            }
	            else {
	                buff.append(" AND ");
	            }
	            buff.append("c.DECIMAL_VAL =?"+obj.getDecimalVal());
	        }

	        if(obj.getAsciiChar() != " ") {
	            if(!whereClause) {
	                whereClause = true;
	                buff.append(" WHERE ");
	            }
	            else {
	                buff.append(" AND ");
	            }
	            buff.append("c.ASCII_CHAR =?"+obj.getAsciiChar());
	        }

	        if(obj.getEbcdicChar() != " ") {
	            if(!whereClause) {
	                whereClause = true;
	                buff.append(" WHERE ");
	            }
	            else {
	                buff.append(" AND ");
	            }
	            buff.append("c.EBCDIC_CHAR =?"+obj.getEbcdicChar());
	        }

	        if(obj.getEbcdicInt() != -1 || obj.getEbcdicInt() != 0) {
	            if(!whereClause) {
	                whereClause = true;
	                buff.append(" WHERE ");
	            }
	            else {
	                buff.append(" AND ");
	            }
	            buff.append("c.EBCDIC_INT =?"+obj.getEbcdicInt());
	        }

	            return buff.toString();
	    }
	 	 
}
*/