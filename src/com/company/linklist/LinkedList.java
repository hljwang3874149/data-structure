package com.company.linklist;

public class LinkedList<E> {
    private static class Node<E> {
        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        public E e;
        public Node<E> next;

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node<E> dummyHead;

    public LinkedList() {
        dummyHead = new Node<E>((E) null, null);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException("  failed  index error");
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = dummyHead.next;
        }
        prev.next = new Node<E>(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("  failed  index error");
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public boolean contains(E e) {
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException("  failed  index error");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;

    }

    public E remove(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("  failed  index error");
        Node<E> pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node<E> e = pre.next;
        pre.next = e.next;
        e.next = null;
        size--;
        return e.e;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur)
                    .append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
