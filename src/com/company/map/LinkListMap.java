package com.company.map;


public class LinkListMap<K, V> implements Map<K, V> {

    class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.next = null;
        }

    }

    private Node dumpNode;
    private int size ;

    public LinkListMap() {
        this.dumpNode = new Node();
        size = 0;
    }

    private Node getNode(K key) {
        Node tempNode = dumpNode;
        while (tempNode.next != null) {
            if (tempNode.next.key.equals(key)) {
                return tempNode.next;
            }
            tempNode = tempNode.next;
        }
        return null;

    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dumpNode.next = new Node(key, value, dumpNode.next);

            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) throw new IllegalArgumentException(key + " key not exist");
        else node.value = value;

    }

    @Override
    public V remove(K key) {
        Node preNode = dumpNode;
        while (preNode.next != null) {
            if (preNode.next.key.equals(key))
                break;
            preNode = preNode.next;
        }
        if (preNode.next != null) {
            Node delNode = preNode.next;
            preNode.next = delNode.next;
            delNode.next =null;
            size--;
            return delNode.value;
        }
        return null;


    }
}
