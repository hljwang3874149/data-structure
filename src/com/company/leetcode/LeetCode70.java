package com.company.leetcode;

public class LeetCode70 {
    //    https://leetcode-cn.com/problems/climbing-stairs/
    public int climbStairs(int n) {
        if (n < 3) return n;
        int pre = 1, cur = 2;
        for (int i = 2; i < n; i++) {
            int tmp = cur;
            cur = pre + cur;
            pre = tmp;
        }
        return cur;
    }

}
