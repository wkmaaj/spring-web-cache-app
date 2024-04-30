package org.pdbcorp.spring.configs;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculationCacheLogger implements CacheEventListener<Object, Object> {

    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        log.info("Key: {} | Event type: {} | Old value: {} | New value: {}", cacheEvent.getKey(), cacheEvent.getType(),
                cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
