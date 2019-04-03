/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.bend.report.manager;

import java.io.InputStream;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import za.co.bsv.bend.transformer.Transformer;
import za.co.bsv.bend.transformer.TransformerException;

/**
 * The main class that does the work of transforming XML and XSL document
 * to the requested output format
 * @author setumo rankapole setumor@bankservafrica.com
 * @param Map<String,Transformer> transformers
 */
public class ReportCreator {
    
    private Map<String,Transformer> transformers;
    
    protected ReportCreator(Properties param) {
        Enumeration props = param.keys();
        transformers = new HashMap<String, Transformer>();
        
        while(props.hasMoreElements()) {
            
            String transType = (String)props.nextElement();
            String className = param.getProperty(transType);
            try {
                Transformer transformer = null;
                Class<? extends Transformer> transformerClass = Class.forName(className).asSubclass(Transformer.class);
                transformer = transformerClass.newInstance();
                
                transformers.put(transType, transformer);
            }
            catch (Exception ex){
            }    
        
        }            
        
    }
    /**
     * Takes the byte array of XML and XSL document plus the output format, and
     * generates the desired output document. the output document is returned
     * as a byte array
     * @param xmldoc the xml document to transform
     * @param xsldoc the stylesheet used to transform the given xml
     * @param outputType
     * @return byte array of output document
     */
    public byte[] createDocument(byte [] xmldoc,byte [] xsldoc,String outputType)  throws ReportCreatorException, TransformerException {
        
        byte [] retval = null;
        
        Transformer transformer = getTransformer(outputType);
        if (transformer == null) {
            throw new ReportCreatorException("Transformer for output type : " + outputType + " not found");
        }
        
        retval = transformer.transform(xmldoc, xsldoc);
               
        
        return retval;
       
    }
    
    public byte[] createDocument(InputStream xmldoc,byte [] xsldoc,String outputType)  throws ReportCreatorException, TransformerException {
        
        byte [] retval = null;
        
        Transformer transformer = getTransformer(outputType);
        if (transformer == null) {
            throw new ReportCreatorException("Transformer for output type : " + outputType + " not found");
        }
        
        retval = transformer.transform(xmldoc, xsldoc);
               
        
        return retval;
       
    }
    
    public byte[] createDocument(InputStream xmldoc, InputStream xsldoc,String outputType)  throws ReportCreatorException, TransformerException {
        
        byte [] retval = null;
        
        Transformer transformer = getTransformer(outputType);
        if (transformer == null) {
            throw new ReportCreatorException("Transformer for output type : " + outputType + " not found");
        }
        
        retval = transformer.transform(xmldoc, xsldoc);
               
        
        return retval;
       
    }
    
    public byte[] createDocument(byte [] xmldoc, InputStream xsldoc,String outputType)  throws ReportCreatorException, TransformerException {
        
        byte [] retval = null;
        
        Transformer transformer = getTransformer(outputType);
        if (transformer == null) {
            throw new ReportCreatorException("Transformer for output type : " + outputType + " not found");
        }
        
        retval = transformer.transform(xmldoc, xsldoc);
               
        
        return retval;
       
    }
    /**
     * Gets all Transformer instances 
     * @return Transformers
     */
    public Collection<Transformer> getTransfomers() {
        
        return transformers.values();
    }
    /**
     * Gets a Transformer instances of the given output type
     * @param outputType
     * @return Transformer
     */
    Transformer getTransformer(String outputType) {
     
        return transformers.get(outputType);
    }
    

}
