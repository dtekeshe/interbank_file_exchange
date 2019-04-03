/*package com.bsva.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.bsva.dmcs.dao.repo.CsfAsciiEbcdicRepository;
import com.bsva.dmcs.entities.CsfAsciiEbcdic;
import com.bsva.dmcs.util.DaoFactory;

public class CsfAsciiEbcdicRepositoryTest {
	
	
	private static final Logger LOGGER = Logger.getLogger(CsfAsciiEbcdicRepositoryTest.class);

	private CsfAsciiEbcdicRepository csfAsciiEbcdicDao = DaoFactory.csfAsciiEbcdicInstance();

	@Test
	public void testCcsfAsciiEbcdicDaoFindAll() {
		List<CsfAsciiEbcdic> csfAsciiEbcdicDetails = (List<CsfAsciiEbcdic>) this.csfAsciiEbcdicDao.findAll();
		
		for (CsfAsciiEbcdic csfAsciiEbcdic : csfAsciiEbcdicDetails) {
			System.out.println("The value is "+ csfAsciiEbcdic.getAsciiChar()+"  "+csfAsciiEbcdic.getEbcdicChar()+"  "+csfAsciiEbcdic.getDecimalVal()+"  "+ csfAsciiEbcdic.getEbcdicInt());
		}
	
	}
	
	@Test
	public void testCcsfAsciiEbcdicDaoFindOne(){
		System.out.println(" finding by ID");
		CsfAsciiEbcdic csfAsciiEbcdicDetails = (CsfAsciiEbcdic)this.csfAsciiEbcdicDao.findById(107l);
	    assertNotNull(csfAsciiEbcdicDetails);
		System.out.println( " The value ID is :" + csfAsciiEbcdicDetails.getDecimalVal() + " The Char is : " + csfAsciiEbcdicDetails.getEbcdicChar() + " The value is : " + csfAsciiEbcdicDetails.getAsciiChar() + " The int is :  " + csfAsciiEbcdicDetails.getEbcdicInt());
	}
	
	
	@Test
	public void testCcsfAsciiEbcdicDaoInsert(){
		CsfAsciiEbcdic CsfAsciiEbcdic = new CsfAsciiEbcdic();
		CsfAsciiEbcdic.setAsciiChar("%");
		CsfAsciiEbcdic.setDecimalVal(257L);
		CsfAsciiEbcdic.setEbcdicChar("*");
		CsfAsciiEbcdic.setEbcdicInt((short) 90);
		
		this.csfAsciiEbcdicDao.save(CsfAsciiEbcdic);
		
	}
	
	@Test
	public void testCcsfAsciiEbcdicDaoUpdate(){
		CsfAsciiEbcdic CsfAsciiEbcdic = new CsfAsciiEbcdic();
		CsfAsciiEbcdic.setAsciiChar("^");
		CsfAsciiEbcdic.setDecimalVal(256L);
		CsfAsciiEbcdic.setEbcdicChar("#");
		CsfAsciiEbcdic.setEbcdicInt((short) 90);
		
		this.csfAsciiEbcdicDao.update(CsfAsciiEbcdic);
		
	}
	
	@Test
	public void testCcsfAsciiEbcdicDaoDelete(){
		CsfAsciiEbcdic CsfAsciiEbcdic = new CsfAsciiEbcdic();
		CsfAsciiEbcdic.setAsciiChar("^");
		CsfAsciiEbcdic.setDecimalVal(256L);
		CsfAsciiEbcdic.setEbcdicChar("^");
		CsfAsciiEbcdic.setEbcdicInt((short) 90);		
		this.csfAsciiEbcdicDao.delete(CsfAsciiEbcdic);
		
	}
	

}
*/