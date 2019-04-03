/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package com.bsva.dmcs.controller;


import javax.sql.DataSource;


public interface Process extends Runnable {
    /**
     * Start running this process
     */
    public void start();

    /**
     * Stop running this process.
     */
    public void stop();

    /**
     * Forcibly kill this process in the middle of processing
     */
    public void kill();

    /**
     * Indicates whether this process is running.
     * @return <code>true</code> if this process is running, otherwise returns
     *  <code>false</code>
     */
    public boolean isRunning();

    /**
     * Set the database connection used by this process
     * @param datasource the database connection to use
     */
    public void setDatabaseConnection(DataSource datasource);

    /**
     * Set the amount of time (in milliseconds) that this process should sleep
     * for between processing periods.
     *
     * @param delay the delay to set
     */
    public void setDelay(long delay);

    /**
     * Returns the amount of time (in milliseconds) that this process sleeps
     * between processing.
     *
     * @return the amount of time (in milliseconds) that this process sleeps
     */
    public long getDelay();
    /**
     * Allow processes to initialize before we start running them
     */
    public void init();
}
