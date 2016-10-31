package com.jaipal.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dreddy on 10/31/2016.
 */
public class LRUCache<K, V> implements Cache<K, V> {


    private final int size;
    private int currentSize;
    private Map<K, Node<K, V>> cache;
    private DoubleLinkedList<K, V> dll;

    private LRUCache(int size) {
        this.size = size;
        this.currentSize = 0;
        cache = new HashMap<K, Node<K, V>>();
        dll = new DoubleLinkedList<K, V>();
    }

    @Override
    public V get(K key) {
        if (cache.containsKey(key)) {
            //if contains,move node to head

            Node node = cache.get(key);
            if (node == dll.tail) {
                node.next = dll.head;
                dll.head.previous = node;
                node.previous.next = null;
                dll.tail = node.previous;
                node.previous = null;
                dll.head = node;
            } else if (node != dll.head) {
                node.previous.next = node.next;
                node.next.previous = node.previous;
                node.next = dll.head.next;
                node.previous = null;
                dll.head = node;
            }

            return (V) node.value;
        }
        return null;
    }

    @Override
    public boolean has(K key) {
        return cache.containsKey(key);
    }

    @Override
    public void put(K key, V value) {
        //if cache contains the key,make it most recently used i.e. move it to head
        if (this.cache.containsKey(key)) {
            return;
        } else if (this.currentSize >= this.size) {
            //remove least recently used
            K removeValue = dll.removeLast();
            this.cache.remove(removeValue);

        } else
            currentSize++;
        this.cache.put(key, dll.addFirst(key, value));

    }

    public void printCache() {
        for (Map.Entry<K, Node<K, V>> entry : cache.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue().value);
        }
    }


    public static LRUCache getInstance(int size) {
        return new LRUCache(size);
    }

    public static void main(String args[]) {
        LRUCache<Integer, String> cache = LRUCache.getInstance(3);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(3);
        cache.put(4, "d");
        cache.get(2);
        cache.get(3);
        cache.put(5, "e");
        System.out.println(cache.cache.entrySet());
    }

}
