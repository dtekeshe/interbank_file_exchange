package com.bsva.dmcs.ccreports02;
import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
/**
 *
 * @author RinusE
 */
public class WriteCVSfromSQL  {
    private static String logPGM="WriteCSVfromSQL";
    private static int pgmVersion = 1;
    //private static WriteSpo logger = new WriteSpo(logPGM,pgmVersion);
    //private static WriteSpo logger = WriteSpo.getSpoWriter(logPGM,pgmVersion);

    String eolStr = System.getProperty("line.separator");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            //logger.fatal("Syntax: WriteCSVfromSQL <sqlStatement> <outputFileName>");
            return;
        }
        File outFile = new File(args[1]);
        try {
            WriteCVSfromSQL myself = new WriteCVSfromSQL(args[0],outFile);
        } catch (Exception ex) {
           // logger.fatal("Error creating CSV file from SQL");
            //logger.fatal(ex.getMessage());
        }
    }
    
    public WriteCVSfromSQL(String sqlStatement,String outputFileName,Connection cNection) throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException
                                                                              ,Exception
    {
        File outputFile = new File(outputFileName);
        writeOutCVSfromSQL(sqlStatement,outputFile,cNection);
    }    
    public WriteCVSfromSQL(String sqlStatement,String outputFileName) throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException
                                                                              ,Exception
    {
        File outputFile = new File(outputFileName);
        writeOutCVSfromSQL(sqlStatement,outputFile);
    }    
    public WriteCVSfromSQL(String sqlStatement,File outputFile) throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException
                                                                              ,Exception
    {
        writeOutCVSfromSQL(sqlStatement,outputFile);
    }
    public WriteCVSfromSQL(String sqlStatement,File outputFile,Connection cNection) throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException
                                                                              ,Exception
    {
        writeOutCVSfromSQL(sqlStatement,outputFile,cNection);
    }
    
    
    public WriteCVSfromSQL() {
        
    }
    
    public void writeOutCVSfromSQL(String sqlStatement,String outputFileName) throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException
                                                                              ,Exception {
        File outputFile = new File(outputFileName);
        writeOutCVSfromSQL(sqlStatement,outputFile);        
    }
    public void writeOutCVSfromSQL(String sqlStatement,String outputFileName,Connection cNect) 
                                                                        throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException
                                                                              ,Exception {
        File outputFile = new File(outputFileName);
        writeOutCVSfromSQL(sqlStatement,outputFile,cNect);
    }
    
    public void writeOutCVSfromSQL(String sqlStatement,File outputFile) throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException
                                                                              ,Exception{
        //super.getConnection("cccops","cccops");
        //super.getConnection();
        //ResultSet sqlRS = getSelectData(sqlStatement,connection);
        //if (sqlRS == null) {
            //logger.error("Error getting resultset using SQL:" + sqlStatement);
            throw new SQLException("Error getting resultset using SQL:" + sqlStatement);
        //}
       // writeCSVfromResultSet(sqlRS,outputFile);
    }
    
    public void writeOutCVSfromSQL(String sqlStatement,File outputFile,Connection cNect) throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException
                                                                              ,Exception{
    
        //ResultSet sqlRS = getSelectData(sqlStatement,cNect);
       // if (sqlRS == null) {
           // logger.error("Error getting resultset using SQL:" + sqlStatement);
            throw new SQLException("Error getting resultset using SQL:" + sqlStatement);
        //}
        //writeCSVfromResultSet(sqlRS,outputFile);
    }

    public void writeCSVfromResultSet(ResultSet inRS,File outputFile) throws SQLException
                                                                              ,FileNotFoundException
                                                                              ,IOException {
        ResultSetMetaData rsmd = inRS.getMetaData();
        int colCount = rsmd.getColumnCount();
        OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile.getAbsolutePath()));
        
        boolean  firstCol = true;
        int thisColType[] = new int[colCount + 1];
        int thisColScale[] = new int[colCount + 1];
        for (int cc=1;cc<colCount + 1;cc++) {
            if (firstCol) {
                firstCol = false;
            } else {
                output.write(',');
            }
            output.write('\"');
            output.write(rsmd.getColumnName(cc).getBytes());
            output.write('\"');
            thisColType[cc] = rsmd.getColumnType(cc);
            if (thisColType[cc] == Types.NUMERIC) {
                thisColScale[cc] = rsmd.getPrecision(cc);
            }
        }
        output.write(eolStr.getBytes());
        
        while (inRS.next()) {
            firstCol = true;
            for (int xx=1;xx<colCount + 1;xx++) {
                if (firstCol) {
                    firstCol = false;
                } else {
                    output.write(',');
                }
                if (thisColType[xx] == Types.DATE) {
                    output.write('\"');
                    output.write(inRS.getDate(xx).toString().getBytes());
                    output.write('\"');
                    continue;
                }
                if (thisColType[xx] == Types.VARCHAR ||
                    thisColType[xx] == Types.CHAR ) {
                    output.write('\"');
                    output.write(inRS.getString(xx).getBytes());
                    output.write('\"');
                    continue;
                }
                if (thisColType[xx] == Types.TIME) {
                    output.write('\"');
                    output.write(inRS.getTime(xx).toString().getBytes());
                    output.write('\"');
                    continue;
                }
                if (thisColType[xx] == Types.TIMESTAMP) {
                    output.write('\"');
                    output.write(inRS.getTimestamp(xx).toString().getBytes());
                    output.write('\"');
                    continue;
                }
                if (thisColType[xx] == Types.INTEGER) {
                    output.write((inRS.getInt(xx) + "").getBytes());
                    continue;
                }
                if (thisColType[xx] == Types.NUMERIC) {
                    BigDecimal dbval = inRS.getBigDecimal(xx);
                    output.write((dbval + "").getBytes());
                    continue;
                }
            }
            output.write(eolStr.getBytes());
        }
        output.close();
        inRS.close();
        inRS = null;
    }
    
}
