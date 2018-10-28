package com.company.leetcode;

import com.company.tree.segment.SegmentTree;

public class LeetCode302_segment {


    class NumArray {
        private SegmentTree<Integer> segmentTree;

        public NumArray(int[] nums) {
            if (nums.length > 0) {
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) {

                    data[i] = nums[i];
                }
                segmentTree = new SegmentTree<Integer>(data, (a, b) -> a + b);

            }

        }

        public int sumRange(int i, int j) {
            return segmentTree.query(i, j);

        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    class NumArray2 {
        private int[] sum;
        private SegmentTree<Integer> segmentTree;

        public NumArray2(int[] nums) {
            if (nums == null || nums.length == 0) return;
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++) {
                sum[i] = nums[i] + sum[i - 1];
            }

        }

        public int sumRange(int i, int j) {
            return i == 0 ? sum[j] : sum[j + 1] - sum[i];

        }
    }

}
