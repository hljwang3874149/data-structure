package com.company.queue;

import com.company.array.Array;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);

    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int i = 0; i < getSize(); i++) {
            buffer.append(array.get(i)).append(",");
        }
        buffer.append("]");

        return "ArrayQueue{ " +
                buffer.toString()
                + " size = " + getSize() + '}';
    }
}
