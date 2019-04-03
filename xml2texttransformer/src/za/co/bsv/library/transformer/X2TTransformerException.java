/*
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.library.transformer;

/**
 *
 * @author Bongani Hlope <bonganih@bankservafrica.com>
 */
public class X2TTransformerException extends Exception{
    
    public X2TTransformerException() {
        super();
    }
    
    public X2TTransformerException(String msg) {
        super(msg);
    }
    
    public X2TTransformerException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
