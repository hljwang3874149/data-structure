package com.company.set;

import com.company.tree.bst.BinarySearchTree;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> binarySearchTree;

    public BSTSet() {
        this(new BinarySearchTree());
    }

    public BSTSet(BinarySearchTree<E> binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }

    @Override
    public int getSize() {
        return binarySearchTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }

    @Override
    public void add(E e) {
        binarySearchTree.addNode(e);

    }
}
