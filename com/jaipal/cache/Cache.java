package com.jaipal.cache;

/**
 */
public interface Cache<K, V> {

    V get(K key);

    boolean has(K key);

    void put(K key, V value);

}
