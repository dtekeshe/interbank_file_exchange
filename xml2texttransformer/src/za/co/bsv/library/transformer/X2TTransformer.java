/*
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.library.transformer;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Bongani Hlope <bonganih@bankservafrica.com>
 */
public abstract class X2TTransformer {
    public abstract void transform(InputStream source,  OutputStream result) throws X2TTransformerException;
}
