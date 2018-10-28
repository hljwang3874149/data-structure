package com.company.array;

import java.util.Arrays;

public class Array<T> {
    private T[] array;
    private int size = 0;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    public void addLast(T t) {
        add(size, t);

    }

    public Array(T[] arr) {
        this.array = (T[]) new Object[arr.length];
        System.arraycopy(arr, 0, this.array, 0, arr.length);
        size = arr.length;
    }

    public void add(int index, T i) {

        for (int y = size; y > index; y--) {
            array[y] = array[y - 1];
        }
        array[index] = i;
        size++;
        if (size >= getCapacity()) {
            resize(getCapacity() * 2);
        }

    }

    private void resize(int size) {
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i < getSize(); i++) {
            newArray[i] = array[i];
        }
        array = newArray;


    }

    public void swap(int a, int b) {
        if (a < 0 || a > size || b < 0 || b > size) throw new IllegalArgumentException("error index ");
        T t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    public void addFirst(T t) {
        add(0, t);

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return array.length;
    }

    public T find(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("index 小于0 或者大于size");

        return array[index];
    }

    public int valueOfIndex(T value) {
        for (int i = 0; i <= size; i++) {
            if (array[i].equals(value))
                return i;
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("index 小于0 或者大于size");
        T value = array[index];
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        if (size < getCapacity() / 3 && getCapacity() / 3 != 0) {
            resize(getCapacity() / 2);
        }

        return value;

    }

    public T removeFirst() {
        return remove(0);
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("index 小于0 或者大于size");
        return array[index];
    }

    public T getLast() {
        return get(size - 1);
    }

    public T getFirst() {
        return get(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public int removeElement(T value) {
        int index = valueOfIndex(value);
        if (index != -1) {
            remove(index);
            return 0;
        }
        return index;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("index 小于0 或者大于size");
        array[index] = value;
    }

    public void setFirstValue(T value) {
        set(0, value);
    }

    public void setLast(T value) {
        set(size - 1, value);
    }


    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", capacity = " + array.length +
                '}';
    }
}
