/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package com.bsva.dcms.commons.exceptions;

/**
 * Thrown by DAO's when an error occurs
 *
 */
public class DAOException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     *
     */
    public DAOException() {
        super();
    }

    /**
     *
     * @param msg
     */
    public DAOException(String msg) {
        super(msg);
    }

    /**
     *
     * @param msg
     * @param cause
     */
    public DAOException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
