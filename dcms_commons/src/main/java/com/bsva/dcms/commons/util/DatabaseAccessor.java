/*package com.bsva.dcms.commons.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;



 * This class is to be strictly used by Utility classes that require database connections.NOT DAOs
 * 
 
public class DatabaseAccessor {

	private Connection connection;
	private DataSource datasource;
	private Logger log = Logger.getLogger(DatabaseAccessor.class);
	
	public DatabaseAccessor(){
		initialiseDataSource();
	}
	
	public DatabaseAccessor(Connection conn){
		this.connection = conn;
	}
	
	private void initialiseDataSource(){
		
		 try {
	        	System.out.println("Getting datasource");
	            InitialContext ic = new InitialContext();
	            datasource  = (DataSource) ic.lookup("java:jboss/datasources/DMCSDb");
	        }
	        catch (NamingException ne) {
	            log.error("Could not create initial context");
	        }
		
	}
	
	public Connection requestConnection(){
		
		try {
			
//			if (this.connection != null)
//				return this.connection;
//			else
//				this.connection = this.datasource.getConnection();
			
			String driverClassName = "oracle.jdbc.OracleDriver";
	        String dbURL = "jdbc:oracle:thin:@172.16.163.172:1521:cccd";    
	        Class.forName(driverClassName);
	        Connection conn = DriverManager.getConnection(dbURL, "CCCOWNER", "cccowner");
			
	        connection = conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
		}
		
		
		return this.connection;
	}
	
	public void releaseConnection(){
		if (this.connection != null)
			try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage(), e);
			}
				
	}
	
	public void releaseConnection(Connection conn){
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage(), e);
			}
				
	}
}
*/