package com.soses.audit.config;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CacheEventLogger implements CacheEventListener<Object, Object> {

     private static final Logger log = LogManager.getLogger(CacheEventLogger.class);


	@Override
	public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
		 log.info("Cache event "+cacheEvent.getType()+" for item with key " + cacheEvent.getKey() + ". Old value = " + cacheEvent.getOldValue() + ", New value = "+cacheEvent.getNewValue());
		
	}
}