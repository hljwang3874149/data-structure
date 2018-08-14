package com.company.set;

public interface Set<E> {
    int getSize();

    boolean isEmpty();

    boolean contains(E e);

    void add(E e);
}
