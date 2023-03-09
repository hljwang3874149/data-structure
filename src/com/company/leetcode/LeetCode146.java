package com.company.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode146 {
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static class LRUCache extends LinkedHashMap<Integer, Integer> {

        private final int capacity;
        private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        private Integer head, tail;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);

        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


}

class LRUCache {
    static class Node {
        Node pre;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    Map<Integer, Node> cache = new HashMap<>();
    Node head, tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    private void move2Head(Node value) {
        removeNode(value);
        add2Head(value);
    }

    private void add2Head(Node value) {
        value.pre = head;
        value.next = head.next;
        head.next.pre = value;
        head.next = value;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            move2Head(node);
        } else {
            Node newNode = new Node(key, value);
            add2Head(newNode);
            if (cache.size() > capacity-1) {
                Node tailPre = tail.pre;
                removeNode(tailPre);
                cache.remove(tailPre.key);
            }
            cache.put(key, newNode);
        }
    }
}

