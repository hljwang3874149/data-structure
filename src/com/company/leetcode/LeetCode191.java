package com.company.leetcode;

public class LeetCode191 {
    //    https://leetcode-cn.com/problems/number-of-1-bits/
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;

        //else 使用位移计算 24位 + 每次向左位移一位,与n做与运算 不等于0 count++
//        int count = 0;
//        int flag = 1;
        // int time =0;
//        while (flag != 0&&time<24) {
//        time++;
//            if ((n & flag) != 0) {
//                count++;
//            }
//            flag <<= 1;
//        }
//        return count;


    }


}
