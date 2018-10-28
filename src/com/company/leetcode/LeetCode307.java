package com.company.leetcode;

public class LeetCode307 {

//    class NumArray {
//        private int[] data;
//        private int[] sum;
//
//        public NumArray(int[] nums) {
//            data = nums;
//            sum = new int[data.length + 1];
//            sum[0] = 0;
//            for (int i = 1; i < sum.length; i++) {
//                sum[i] = data[i - 1] + sum[i - 1];
//            }
//
//        }
//
//        public void update(int i, int val) {
//            data[i] = val;
//            for (int j = i + 1; j < sum.length; j++) {
//                sum[j] = sum[j - 1] + data[j - 1];
//
//            }
//
//        }
//
//        public int sumRange(int i, int j) {
//            return i == 0 ? sum[j + 1] : sum[j + 1] - sum[i];
//
//        }
//    }

    public static class NumArray2 {
        private SegmentTree<Integer> segmentTree;

        public NumArray2(int[] nums) {
            if (nums.length > 0) {
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    data[i] = nums[i];
                }
                segmentTree = new SegmentTree<Integer>(data, (a, b) -> a + b);

            }

        }

        public int sumRange(int i, int j) {
            if (segmentTree == null) throw new IllegalArgumentException("error");
            return segmentTree.query(i, j);

        }

        public void update(int i, int val) {
            if (segmentTree == null) throw new IllegalArgumentException("error");
            segmentTree.set(i, val);

        }

        class SegmentTree<E> {

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
             * o(logn)
             *
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

                tree[index] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

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

        private interface Merger<E> {
            E merge(E l, E r);
        }

    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}

