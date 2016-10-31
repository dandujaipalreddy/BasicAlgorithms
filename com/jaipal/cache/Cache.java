package com.jaipal.cache;

/**
 * Created by dreddy on 10/31/2016.
 */
public interface Cache<K, V> {

    V get(K key);

    boolean has(K key);

    void put(K key, V value);

}
