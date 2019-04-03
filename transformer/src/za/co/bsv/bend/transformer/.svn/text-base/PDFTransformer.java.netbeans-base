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

import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

/**
 *
 * @author Setumo Rankapole <setumor@bankservafrica.com>
 */
public class PDFTransformer implements za.co.bsv.bend.transformer.Transformer {
    
    @Override
    public byte [] transform(byte [] xmldoc, byte [] xsldoc) throws TransformerException {
        // change the byte array into an InputStream
        ByteArrayInputStream xmlIn = new ByteArrayInputStream(xmldoc);
        ByteArrayInputStream xslIn = new ByteArrayInputStream(xsldoc);

        return transform(xmlIn, xslIn);
    }

    @Override
    public byte[] transform(InputStream xmldoc, byte[] xsldoc) throws TransformerException {
        ByteArrayInputStream xslIn = new ByteArrayInputStream(xsldoc);
        return transform(xmldoc, xslIn);
    }

    @Override
    public byte[] transform(byte[] xmldoc, InputStream xsldoc) throws TransformerException {
        ByteArrayInputStream xmlIn = new ByteArrayInputStream(xmldoc);
        return transform(xmlIn, xsldoc);
    }

    @Override
    public byte[] transform(InputStream xmldoc, InputStream xsldoc) throws TransformerException {
        byte [] retval = null;
        
        try {            
            ByteArrayOutputStream res = new ByteArrayOutputStream();

            // read the xml and xsl InputStream
            Source xmlSource = new StreamSource(xmldoc);
            Source xslSource = new StreamSource(xsldoc);
            
            // configure fopFatory desired
            FopFactory fopFactory = FopFactory.newInstance();
            
            // configure foUserFactory as desired
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            
            // construct fop with the desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF,foUserAgent, res);  
            
            // send the results of the transformation to a ByteArrayOutputStream
            Result result = new SAXResult(fop.getDefaultHandler());

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
