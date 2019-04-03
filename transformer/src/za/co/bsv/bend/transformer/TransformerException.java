/*
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.bend.transformer;

/**
 *
 * @author Setumo Rankapole <setumor@bankservafrica.com>
 */
public class TransformerException extends Exception {
    
    public TransformerException() {
        super();
    }
    
    public TransformerException(String msg) {
        super(msg);
    }
    
    public TransformerException(String msg, Throwable cause) {
        super(msg,cause);
    }
 
    
}
