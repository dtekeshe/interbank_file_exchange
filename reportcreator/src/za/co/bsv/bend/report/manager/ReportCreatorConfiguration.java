/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.bend.report.manager;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class loads transformers from a configuration file and returns an instance
 * of the ReportCreator used to transform documents
 * 
 * @author setumo rankapole setumor@bankservafrica.com
 */
public class ReportCreatorConfiguration {
    
    /**
     * Reads a configuration file and creates an instance of ReportCreator
     * based on that file
     * @param configFile configuration file
     * @return reportCreator 
     * @throws ReportCreatorException 
     */
    public ReportCreator loadConfigurationfile(String configFile) throws ReportCreatorException {
        ReportCreator reportCreator = null;
        
        Properties config = new Properties();
        
        try {
            config.load(new FileInputStream(configFile));
        }
        catch (Exception ex){
            throw new ReportCreatorException("Couldn't load configuration file", ex);
        }
        
        reportCreator = new ReportCreator(config);       
        return reportCreator;
    }
    
    public ReportCreator loadConfigurationfile(Properties configFile) throws ReportCreatorException {
        
        return new ReportCreator(configFile);
    }
    
    public ReportCreator loadConfigurationfile(InputStream configFile) throws ReportCreatorException {
        ReportCreator reportCreator = null;
        
        Properties config = new Properties();
        
        try {
            config.load(configFile);
        }
        catch (Exception ex){
            throw new ReportCreatorException("Couldn't load configuration file", ex);
        }
        
        reportCreator = new ReportCreator(config);       
        return reportCreator;
    }
}
