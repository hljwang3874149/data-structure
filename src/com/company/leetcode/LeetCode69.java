package com.company.leetcode;

/**
 * https://leetcode.cn/problems/sqrtx/description/
 */
public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(new LeetCode69().mySqrt(8));

    }
    int mySqrt(int x) {
        if(x ==0 || x ==1) return x;
        int left =0,right =x,res=0;
        while (left<=right){
            int mid = left + (right-left)/2;
            int sqrt = x/mid;
            if(mid == sqrt){
                return mid;
            }else if (mid <sqrt){
                res =mid;
                left = mid+1;
            }else {
                right =mid-1;

            }
        }
        return res;

    }

    /**
     *
     * @param x
     * @return
     */
    int mySqrtND(int x) {
    if(x ==0 || x ==1 ) return x;
    double C = x ,x0 =x;
    while (true){
        double xi = 0.5*(x0+ C/x0);
        if (Math.abs(x0 - xi) < 1e-7) {
            break;
        }
        x0 = xi;
    }

    return (int)x0;

    }

}
