/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.bend.transformer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Setumo Rankapole <setumor@bankservafrica.com>
 */
public class XSLTransformer implements za.co.bsv.bend.transformer.Transformer {
    
    @Override
    public byte [] transform(byte [] xmldoc, byte [] xsldoc) throws TransformerException{
        ByteArrayInputStream xmlFile = new ByteArrayInputStream(xmldoc);
        ByteArrayInputStream xslFile = new ByteArrayInputStream(xsldoc);
        
        return transform(xmlFile, xslFile);
    }

    @Override
    public byte[] transform(InputStream xmldoc, byte[] xsldoc) throws TransformerException {
        ByteArrayInputStream xslFile = new ByteArrayInputStream(xsldoc);
        return transform(xmldoc, xslFile);
    }

    @Override
    public byte[] transform(byte[] xmldoc, InputStream xsldoc) throws TransformerException {
        ByteArrayInputStream xmlFile = new ByteArrayInputStream(xmldoc);
        return transform(xmlFile, xsldoc);
    }

    @Override
    public byte[] transform(InputStream xmldoc, InputStream xsldoc) throws TransformerException {
        byte [] retval = null;
        
        try {            
            ByteArrayOutputStream res = new ByteArrayOutputStream();

            // read the xml and xsl InputStream
            Source xmlSource = new StreamSource(xmldoc);
            Source xslSource = new StreamSource(xsldoc);
            
            // send the results of the transformation to a ByteArrayOutputStream
            Result result = new StreamResult(res);

            TransformerFactory transFact = TransformerFactory.newInstance();
            Transformer trans = transFact.newTransformer(xslSource);

            // actual transformation 
            trans.transform(xmlSource, result);

            // change OutputStream to byte array
            retval = res.toByteArray() ;
        }
        catch (Exception ex) {
            throw new TransformerException(" Transformer failed to tranform the given document ", ex);
        }
        return retval;
    }
}
