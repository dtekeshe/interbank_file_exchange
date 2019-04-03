/*
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

import za.co.bsv.library.transformer.X2TTransformer;
import za.co.bsv.library.transformer.X2TTransformerFactory;

/**
 *
 * @author Bongani Hlope <bonganih@bankservafrica.com>
 */
public class XML2TXTTransformer implements Transformer{

    @Override
    public byte[] transform(byte[] xmldoc, byte[] xsldoc) throws TransformerException {
        ByteArrayInputStream xmlSource = new ByteArrayInputStream(xmldoc);
        ByteArrayInputStream xslSource = new ByteArrayInputStream(xsldoc);
        
        return transform(xmlSource, xslSource);
    }

    @Override
    public byte[] transform(InputStream xmldoc, byte[] xsldoc) throws TransformerException {
        ByteArrayInputStream xslSource = new ByteArrayInputStream(xsldoc);
        
        return transform(xmldoc, xslSource);
    }

    @Override
    public byte[] transform(byte[] xmldoc, InputStream xsldoc) throws TransformerException {
        ByteArrayInputStream xmlSource = new ByteArrayInputStream(xmldoc);
        return transform(xmlSource, xmlSource);
    }

    @Override
    public byte[] transform(InputStream xmldoc, InputStream xsldoc) throws TransformerException {
        try {
            X2TTransformerFactory factory = X2TTransformerFactory.newInstance();
            X2TTransformer transformer = factory.newTransformer(xmldoc);
        
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            transformer.transform(xsldoc, result);
            
            return result.toByteArray();
        }
        catch(Exception ex) {
            throw new TransformerException("Error transforming XML to TXT, cause: " + ex.getMessage(), ex);
        }
    }
}
