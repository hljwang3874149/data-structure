package com.company.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    public class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

    }

    Node root;
    int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    public BSTMap(Node root, int size) {
        this.root = root;
        this.size = size;
    }

    @Override
    public void add(K key, V value) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V value) {

    }

    @Override
    public V remove(K key) {
        return null;
    }
}
