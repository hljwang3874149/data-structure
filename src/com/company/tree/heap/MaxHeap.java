package com.company.tree.heap;

import com.company.array.Array;

public class MaxHeap<E extends Comparable<E>> {
    Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int leftChild(int k) {
        return k << 1 + 1;
    }

    private int rightChild(int k) {
        return (k + 1) << 1;
    }

    private int parent(int k) {
        if (k == 0) throw new IllegalArgumentException("index 0 donot has parent");
        return (k - 1) >>> 1;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(parent(index), index);
            index = parent(index);
        }
    }

    private void siftDown(int k) {
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            if (j + 1 < size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) break;
            data.swap(j, k);
            k = j;
        }
    }

    public E findMax() {
        if (data.isEmpty()) throw new IllegalArgumentException(" no data");
        return data.get(0);
    }

    public E extractMax() {
        E max = findMax();
        data.swap(0, size() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    /**
     *  o(logn)
     * @param e
     * @return
     */

    public E replace(E e) {
        E max = findMax();
        if (size() > 0) {
            data.setFirstValue(e);
        }
        data.swap(0, size() - 1);
        siftDown(0);
        return max;
    }

    /**
     * heapfy  o(n)
     * @param values
     */
    public MaxHeap(E[] values) {
        if (values.length == 0) throw new IllegalArgumentException("array can not be null");
        data = new Array<>(values);
        for (int i = parent(values.length - 1); i >= 0; i--) {
            siftDown(i);
        }

//        int k = parent(data.getSize());
//        while (k >= 0) {
//            siftDown(k);
//            k -= 1;
//        }
    }

}
