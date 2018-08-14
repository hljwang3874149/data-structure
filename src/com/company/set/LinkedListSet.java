package com.company.set;

import com.company.linklist.LinkedList;

public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();

    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public void add(E e) {
        if (!contains(e)) {
            linkedList.addFirst(e);
        }

    }
}
