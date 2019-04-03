/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.bend.transformer;

import java.io.InputStream;


/**
 * Interface defining the transformer
 * @author setumor
 */
public interface Transformer {    
    
    /**
     * Takes the XML and XSL strings and produces a byte array of results
     * of the results of the transformation
     * @param xmldoc the xml document to transform
     * @param xsldoc the stylesheet used to transform the given xml
     * @return byte array of the transformation  
     */
    public byte [] transform(byte [] xmldoc, byte [] xsldoc) throws TransformerException; 
    
    public byte [] transform(InputStream xmldoc, byte [] xsldoc) throws TransformerException; 
    
    public byte [] transform(byte [] xmldoc, InputStream xsldoc) throws TransformerException; 
    
    public byte [] transform(InputStream xmldoc, InputStream xsldoc) throws TransformerException; 
    
}

