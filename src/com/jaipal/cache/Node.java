package com.jaipal.cache;

/**
 * Created by dreddy on 10/31/2016.
 */
public class Node<K, V> {

    public V value;
    public K key;
    public Node next;
    public Node previous;

    public Node(K key, V value, Node next, Node previous) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
