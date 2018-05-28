package com.iflytek.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * guava缓存工具类
 */
public class GuavaCacheUtils {
    private static Cache<Object,Object> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(3,TimeUnit.SECONDS)
            .build();

    public static Object get(Object key){
        return cache.getIfPresent(key);
    }

    public static void put(Object key,Object value){
         cache.put(key,value);
    }
}
