/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package com.bsva.dmcs.controller;


import javax.sql.DataSource;

import org.apache.log4j.Logger;

public abstract class AbstractProcess implements Process { 

    private long delay;
    private DataSource dbConn;
    private boolean run = false;
    private boolean kill = false;
    private Logger log = Logger.getLogger(AbstractProcess.class);

    /**
     * This abstract method must be implemented to run the actual processing of
     * the child process.
     */
    public abstract void process();

    /**
     * Start running this process
     */
    @Override
    public void start() {
        this.run = true;
    }

    /**
     * Stop this process from running
     */
    @Override
    public void stop() {
        this.run = false;
    }

    /**
     * Forcibly kill this process in the middle of processing
     */
    @Override
    public void kill() {
        this.run = false;
        this.kill = true;
    }

    /**
     * Indicate whether this process is currently running
     * @return <code>true</code> if this process is running, otherwise returns
     *  <code>false</code>
     */
    @Override
    public boolean isRunning() {
        return run;
    }

    @Override
    public void run() {
      
        while(run) {
            try {
                process();
                Thread.sleep(delay);
            }
            catch(InterruptedException ie) {
               log.warn("Thread interrupted, cause: " +
                        ie.getMessage());
            }
        }
 
    }

    /**
     * Set the amount of time (in milliseconds) that this process should sleep
     * for between processing periods.
     *
     * @param delay the delay to set
     */
    public void setDelay(long delay) {
        this.delay = delay;
    }

    /**
     * Returns the amount of time (in milliseconds) that this process sleeps
     * between processing.
     *
     * @return the amount of time (in milliseconds) that this process sleeps
     */
    public long getDelay() {
        return delay;
    }
    
    /**
     * Set the database connection used by this process
     *
     * @param conn the database connection to use
     */
    @Override
    public void setDatabaseConnection(DataSource conn) {
        this.dbConn = conn;
    }

    /**
     * Returns the database connection used by this process
     *
     * @return the database connection used by this process.
     */
    protected DataSource getDatabaseConnection() {
        return dbConn;
    }

    /**
     * Indicates to a child process whether it's been killed. Child processes
     * must call this method inside their process method especially if their are
     * looping.
     * <P/>
     * If this flag is set to true, the child process must break out of the loop,
     * cleanup and set it's stage to killed.
     *
     * @return <code>true</code> if this process has been killed, otherwise
     *  returns <code>false</code>
     */
    protected boolean isKilled() {
        return kill;
    }
}
