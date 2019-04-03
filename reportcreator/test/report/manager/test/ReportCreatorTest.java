/*
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package report.manager.test;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import junit.framework.TestCase;
import za.co.bsv.bend.report.manager.ReportCreator;
import za.co.bsv.bend.report.manager.ReportCreatorConfiguration;
import za.co.bsv.bend.report.manager.ReportCreatorException;
import za.co.bsv.bend.transformer.TransformerException;

/**
 *
 * @author Setumo Rankapole <setumor@bankservafrica.com>
 */
public class ReportCreatorTest extends TestCase {
    
    public ReportCreatorTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testReportCreator() throws ReportCreatorException, TransformerException {
        byte [] results;
        ReportCreator reportCreator;
        
        //File xmlFile = new File("/home/setumor/servingxml-1.1.2/target/servingxml/samples/xml2flat/data/books.xml");
        //File xslFile = new File("/home/setumor/servingxml-1.1.2/target/servingxml/samples/xml2flat/resources-books2pos.xml");
        //File xmlFile = new File("/home/setumor/Tango_Batch/XSL_XML_tut/Files/SX/r15001.xml");
        //File xslFile = new File("/home/setumor/Tango_Batch/XSL_XML_tut/Files/SX/SX_r15001.xml");
        //File xmlFile = new File("C:\\CCCS\\REPORTS\\CCR009.0001.050402804.xml");
        File xmlFile = new File("C:\\CCCS\\REPORTS\\CCR001V.0001.031540927.xml");
        //File xslFile = new File("C:\\CCCS\\REPORTS\\ccr001_report.xml");
        File xslFile = new File("C:\\CCCS\\REPORTS\\ccr001_txt.xsl");
        
        
        ReportCreatorConfiguration reportCreatorConfig = new ReportCreatorConfiguration();
        
        reportCreator = reportCreatorConfig.loadConfigurationfile("C:\\Java\\ReportCreator\\src\\za\\co\\bsv\\bend\\report\\manager\\default.properties");
        
        byte [] xmldoc = getByteArray(xmlFile);
        byte [] xsldoc = getByteArray(xslFile);
        
        results = reportCreator.createDocument(xmldoc, xsldoc, "TXT");
        
        String strFileContent = new String(results);
        
        
        File intermediateXml = new File(xmlFile.getAbsolutePath() + ".txt");
        try {
            PrintWriter pwInput = new PrintWriter(intermediateXml);
            pwInput.print(strFileContent);
            pwInput.close();
        } catch (Exception ex) {
            System.out.println("Error writing intermediate file");
        }
        
        System.out.print(strFileContent);
        
/*        xslFile = intermediateXml;
        xmldoc = null;
        xmldoc = getByteArray(xmlFile);
        xsldoc = null;
        xsldoc = getByteArray(xslFile);
        results = null;
        results = reportCreator.createDocument(xmldoc, xsldoc, "TXT");
        strFileContent = null;
        strFileContent = new String(results);
        
        System.out.print(strFileContent);*/
    
    }
    
    public byte [] getByteArray(File file) {
        byte [] retval = new byte[(int)file.length()];
        
        try {
            FileInputStream fin = new FileInputStream(file);
            
            fin.read(retval, 0, (int)file.length());
            
            fin.close();
            
        }
        catch(FileNotFoundException e) {
            System.out.print("File not found" + e);
        }
        catch(IOException ioe) {
            System.out.print("Exception while reading the file " + ioe);
        }
        
        return retval;
    }
      
}
