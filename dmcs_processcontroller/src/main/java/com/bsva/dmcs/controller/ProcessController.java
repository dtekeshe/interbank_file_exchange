package com.bsva.dmcs.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;

public class ProcessController implements Runnable{
	
	private long delay;
	private Map<String, Process> processesMap;
	private CsoScheduledProcessesDAO dao;
	@Resource(lookup = "java:jboss/datasources/DMCSDb")
    private DataSource datasource;
	private ScheduledExecutorService scheduledExecutorService;
	private Logger log = Logger.getLogger(ProcessController.class);
	
	public ProcessController(){
		
	}
	public ProcessController(DataSource dataSource){
		this(dataSource , 60000);//3600000
	}
	public ProcessController(DataSource dataSource , long delay){
		
		this.datasource = dataSource;
		this.delay = delay;
		this.processesMap = new HashMap<>();
		/**
			Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
			 At any point, at most nThreads threads will be active processing tasks. 
			 If additional tasks are submitted when all threads are active, 
			 they will wait in the queue until a thread is available.
			  If any thread terminates due to a failure during execution prior to shutdown, 
			  a new one will take its place if needed 
		  */
		scheduledExecutorService = Executors.newScheduledThreadPool(10);
		
		
		 Runtime.getRuntime().addShutdownHook(new ShutDownThread());
	}

	//For testing purposes only
//     public ProcessController(Connection dataSource , long delay){
//		
////		this.dataSource = dataSource;
//		this.delay = delay;
//		this.processesMap = new HashMap<>();
//		scheduledExecutorService = Executors.newScheduledThreadPool(5);
//		
//		
//			this.connection = dataSource;
//		
//	}
	@Override
	public void run() {
		while (true){
			try{
				
				try{
					ProcessControllerDAO processController = new ProcessControllerDAO();
					List<CsoScheduledProcessesDTO> list = processController.getSchedulesProccesses();
					for(CsoScheduledProcessesDTO scheduledProcess : list){
						Process proc = processesMap.get(scheduledProcess.getProcessName());
						
						log.debug("Reading data for process " + scheduledProcess.getProcessName());
						// if this process is not running
						if (proc == null){
							
							if (scheduledProcess.getActiveIndicator().equalsIgnoreCase("Y")){
								String className = scheduledProcess.getClassPath();
								proc = createProcess(className);
								
								proc.setDelay(scheduledProcess.getProcessFrequency());
								
								 try {				
							         proc.setDatabaseConnection(datasource);
									 //proc.setDatabaseConnection(this.connection); // for testing
							     }catch(Exception ex) {
							            throw new ProcessControllerException("Error creating database " +
							                    "connection for process, cause: " + ex.getMessage(), ex);
							        }
								 
								 processesMap.put(scheduledProcess.getProcessName(), proc);
				
									proc.start();
									ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(proc,5,TimeUnit.SECONDS);
									log.info("Starting process " + scheduledProcess.getClassPath());
							}
							
						}else{  // if process is already running, check wether the active ind is still a Y or has been changed to N
							
							log.debug("Active indicator = " + scheduledProcess.getActiveIndicator()  + " for process " + scheduledProcess.getClassPath());
							if (scheduledProcess.getActiveIndicator().equalsIgnoreCase("Y")){
								
								proc.setDelay(scheduledProcess.getProcessFrequency());
								
								if (!proc.isRunning()){
									proc.start();
									ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(proc,5,TimeUnit.SECONDS);
									log.debug("Restarting process " + scheduledProcess.getClassPath() );
								}
							}else{
								if (proc.isRunning()){
									proc.stop();
									log.debug("Stopping process " + scheduledProcess.getClassPath() );
								}
								
							}
						}
						
					}
				}catch(ProcessControllerException e){
					log.error("Error managing processes." , e);
				}
				
				Thread.sleep(this.delay);
			}catch(InterruptedException e){
				log.warn("Thread interrupted." , e);
			}
		}
	}

	 /**
     * Returns an instance of a class with the given class name.
     *
     * @param className the name of the class to instantiate
     * @return an instance of a class with the given name
     * @throws ProcessControllerException if an error occurs
     */
    private Process createProcess(String className) throws ProcessControllerException {
        try {
            Class<? extends Process> clazz = Class.forName(className).asSubclass(Process.class);
            Process process = clazz.newInstance();
            return process;
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new ProcessControllerException("Error creating a process, cause: " +
                    ex.getMessage(), ex);
        }
    }

    /**
     * This thread is called when the VM is shutting down, it will stop all
     * controlled process.
     */
    class ShutDownThread extends Thread {

        public ShutDownThread() {
            super("ShutDownThread");
        }

        @Override
        public void run() {
  
            synchronized(processesMap) {
                log.info("Shutting down processes");
                
                for(Process proc : processesMap.values()) {
                    proc.stop();
                }
                scheduledExecutorService.shutdown();
            }
            try {
                Thread.sleep(10000);
            }
            catch(InterruptedException ie) {
            }
        }
    }

}
