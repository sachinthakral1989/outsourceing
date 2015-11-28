package com.property.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockManager {

	private static LockManager instance = new LockManager();
	private Map<String, Lock> lockPool;
	private final Object monitor = new Object();

	private LockManager() {
		lockPool = new HashMap<>();
	}

	public static LockManager getInstance() {
		return instance;
	} 

	public Lock getLock(String key) {
		CustomLock lock;
		synchronized (monitor) {
			lock = (CustomLock) lockPool.get(key);
			if (lock == null) {
				lock = new CustomLock(key);

				lockPool.put(key, lock);
			} else {
				lock.incrementCount();
			}
		}
		return lock;
	}

	public void releaseLock(String key) {
		synchronized (monitor) {
			CustomLock lock = (CustomLock) lockPool.get(key);
			if (lock != null) {
				lock.decrementCount();
				if (lock.getAccessorsCount() == 0) {
					lockPool.remove(key);
				}
			}
		}
	}

	public void releaseLock(Lock lock) {
		if (lock instanceof CustomLock) {
			CustomLock customLock = (CustomLock) lock;
			releaseLock(customLock.getKey());
		}
	}

	public final class CustomLock extends ReentrantLock {

		private static final long serialVersionUID = -4441349584406009807L;
		private int accessor = 0;
		private String key;

		CustomLock(String key) {
			incrementCount();
			this.key = key;
		}

		public int getAccessorsCount() {
			return accessor;
		}

		public void incrementCount() {
			accessor++;
		}

		public void decrementCount() {
			accessor--;
		}

		String getKey() {
			return key;
		}
		
		@Override
		public String toString(){
			return "[Lock-Key = '" + key + "']";
		}
	}
}
