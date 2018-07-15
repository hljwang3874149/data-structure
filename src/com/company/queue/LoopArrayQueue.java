package com.company.queue;

import java.util.Arrays;

public class LoopArrayQueue<E> implements Queue<E> {
    private E[] array;
    private int front, tail, size;

    public LoopArrayQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];

    }

    public LoopArrayQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if (front == (tail + 1) % array.length) {
            resize(getCapacity() * 2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;

    }

    private int getCapacity() {
        return array.length - 1;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalArgumentException(" array is empty");
        E e = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        if (size < getCapacity() / 3 && size / 3 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    private void resize(int i) {
        E[] newArray = (E[]) new Object[i + 1];
        for (int x = 0; x < size; x++) {
            newArray[x] = array[(x + front) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size;

    }

    @Override
    public E getFront() {
        return this.array[front];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("LoopArrayQueue { size %d  capacity %d ", size, getCapacity()));
        buffer.append("  front  " + front + " [");
        for (int i = front; i != tail; i = (i+1)%array.length) {
            buffer.append(array[i]);

        }
        buffer.append("]  tail = " + tail);
        buffer.append( " data = " + Arrays.toString(array));

        return buffer.toString();
    }
}
