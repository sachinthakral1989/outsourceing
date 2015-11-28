package com.property.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.property.constants.ApplicationConstants;

public class AsyncExecutor {

	private static int corePoolSize;
	private static int maximumPoolSize;
	private static int keepAliveTime;
	private static BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
	private static ExecutorService exec;
	private static final Logger logger = Logger.getLogger(AsyncExecutor.class);
	static {
		
		try{
			corePoolSize = Integer.parseInt(PropertiesReader.getPropertyValue(ApplicationConstants.CORE_THREAD_POOL_SIZE));
			maximumPoolSize = Integer.parseInt(PropertiesReader.getPropertyValue(ApplicationConstants.MAX_THREAD_POOL_SIZE));
			keepAliveTime = Integer.parseInt(PropertiesReader.getPropertyValue(ApplicationConstants.THREAD_KEEP_ALIVE_MINUTE));
		}catch(Exception e){
			String errMsg = "Error occurred in initializing Thread-Pool." + e.getMessage();
			logger.error(errMsg,e);
			throw new ExceptionInInitializerError(errMsg);
			
		}
		exec = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
				keepAliveTime, TimeUnit.MINUTES, workQueue);
		
	}

	public static void queueAndExecute(Runnable asyncTask) {
		exec.execute(asyncTask);
	}

	public static <V> Future<V> queueAndExecute(Callable<V> asyncTask) {
		Future<V> asyncResult = exec.submit(asyncTask);
		return asyncResult;
	}

}
