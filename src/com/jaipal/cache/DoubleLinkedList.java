package com.jaipal.cache;

/**
 *
 */
public class DoubleLinkedList<K, V> {
    public Node<K, V> head;
    public Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public static void main(String args[]) {

    }

    public Node addFirst(K key, V data) {
        Node node = new Node(key, data, null, null);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
            node.previous = null;
            head = node;
        }
        return node;
    }

    public Node<K, V> addLast(K key, V data) {
        Node<K, V> node = new Node<>(key, data, null, null);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            node.next = null;
            tail = node;
        }
        return node;
    }

    public K removeFirst() {
        if (isEmpty()) return null;
        Node<K, V> node = head;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        return node.key;
    }

    public K removeLast() {
        if (isEmpty()) return null;
        Node<K, V> node = tail;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        return node.key;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node iter;
            for (iter = head; iter != null; iter = iter.next) {
                System.out.println(iter.value);
            }
        }
    }

}
