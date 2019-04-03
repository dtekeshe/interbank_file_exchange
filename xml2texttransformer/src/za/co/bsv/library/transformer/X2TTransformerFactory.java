/*
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.library.transformer;

import java.io.InputStream;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Bongani Hlope <bonganih@bankservafrica.com>
 */
public class X2TTransformerFactory {

    private X2TTransformerFactory() {
        
    }
    
    /**
     * Returns the default transformer factory class
     *
     * @return the default transformer factory class
     * @throws X2TTransformerException never thrown
     */
    public static X2TTransformerFactory newInstance() throws X2TTransformerException{
        return new X2TTransformerFactory();
    }
    
    /**
     * Create a transformer factory from the specified factory class name. This
     * method makes it easier to select a provide.
     *
     * @param factoryClassName the full qualified factory class name that 
     * @param classLoader the <code>ClassLoader</code> used to load the factory class.
     * if it is null, the current Thread's class loader is used
     * @return a new TransformerFactory
     * @throws X2TTransformerException if the factory class cannot be loaded or
     * of <code>factoryClassName</code> is null.
     */
    public static X2TTransformerFactory newInstance(String factoryClassName, ClassLoader classLoader) throws X2TTransformerException {
        X2TTransformerFactory retval = null;
        
        if(factoryClassName == null) {
            throw new X2TTransformerException("Invalid transformer factory class name");
        }

        if(classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
            
        try {
            Class<? extends X2TTransformerFactory> factoryClass = classLoader.loadClass(factoryClassName).asSubclass(X2TTransformerFactory.class);
                    
            retval = factoryClass.newInstance();
        }
        catch(Exception ex){
            throw new X2TTransformerException("Could not load transformer factory", ex);
        }
        return retval;
    }
    
    /**
     * Returns the transformer implementation for the chosen factory implementation
     * 
     * @param input the input source of the style sheet.
     * @return the transformer implementation for the chosen factory implementation
     * @throws X2TTransformerException never
     */
    public X2TTransformer newTransformer(InputStream input) throws X2TTransformerException {
        return new BSVX2TTransformer(input);
    }
}
