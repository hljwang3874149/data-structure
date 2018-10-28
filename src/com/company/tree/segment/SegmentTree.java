package com.company.tree.segment;


/**
 * 扩展内容:
 *  RMQ range minimum Query
 *  树状数组 BIT  Binary index Tree
 *
 * @param <E>
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] data, Merger<E> merger) {
        this.data = data;
        this.merger = merger;
        tree = (E[]) new Object[4 * data.length];
        buildSegmentTree(0, 0, data.length - 1);

    }

    private void buildSegmentTree(int i, int l, int r) {
        System.out.println("i= " + i + " l = " + l + " r = " + r);

        if (l == r) {
            tree[i] = data[l];
            return;
        }
        int left = leftChild(i);
        int right = rightChild(i);

        int mid = l + (r - l) / 2;

        buildSegmentTree(left, l, mid);
        buildSegmentTree(right, mid + 1, r);

        tree[i] = merger.merge(tree[left], tree[right]);
    }

    public E query(int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex || rightIndex > data.length || leftIndex < 0)
            throw new IllegalArgumentException("query index range error");
        return query(0, 0, data.length - 1, leftIndex, rightIndex);

    }

    private E query(int index, int left, int right, int leftIndex, int rightIndex) {
        if (left == leftIndex && right == rightIndex) {
            return tree[index];
        }
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        int mid = left + (right - left) / 2;
        if (leftIndex >= mid + 1) {
            return query(rightChild, mid + 1, right, leftIndex, rightIndex);
        } else if (rightIndex <= mid) {
            return query(leftChild, left, mid, leftIndex, rightIndex);

        }
        E leftValue = query(leftChild, left, mid, leftIndex, mid);
        E rightValue = query(rightChild, mid + 1, right, mid + 1, rightIndex);
        return merger.merge(leftValue, rightValue);

    }

    private int leftChild(int k) {
        return k * 2 + 1;
    }

    private int rightChild(int k) {
        return (k + 1) * 2;
    }

    public void set(int index, E e) {
        if (index < 0 || index > data.length) throw new IllegalArgumentException("");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);

    }

    /**
     *  o(logn)
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                builder.append(tree[i]);
            } else {
                builder.append("null");
            }
            builder.append(" , ");

        }
        builder.append("]");
        return builder.toString();
    }
}
