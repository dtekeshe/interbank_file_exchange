/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package com.bsva.dmcs.controller;

public class ProcessControllerException extends Exception {

    public ProcessControllerException() {
        super();
    }

    public ProcessControllerException(String msg) {
        super(msg);
    }

    public ProcessControllerException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
