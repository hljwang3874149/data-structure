package com.company.leetcode;

public class LeetCode50 {
    public static void main(String[] args) {
        System.out.println(0.00000000D == 0.000f);
//        new LeetCode50().myPow(2.00000,10);
        Integer a =40, a1 =40;
        Integer b =350,b1= 350;
        System.out.println(new Integer(50) == new Integer(50));
        System.out.println(new Integer(350) == new Integer(350));
        System.out.println(a==a1);
        System.out.println(b==b1);

    }

    public double myPow(double x, int n) {

        if(x ==0D) return 0D;

        return doPow3(x, n);

    }

    private double doPow3(double x, long n) {
        if(n ==0){
            return 1.0D;
        }
        if(x <0){
            return 1 / doPow3(x, -n);
        }
        if((n &1)==1){
            return x * doPow3(x, n - 1);
        }
        return doPow3(x * x, n >> 1);
    }

    private double doPow2(double x, int n) {
        if (x == 0D) return 0D;
        long m = n;
        double res = 1.0D;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }
        while (m > 0) {
            if ((m & 1) == 1) res *= x;
            x *= x;
            m >>= 1;

        }
        return res;
    }

    private double doPow(double x, long n) {
        if (n < 0) {
            return 1 / doPow(x, -n);
        }
        if ((n & 1) != 0) {
            return x * doPow(x, n - 1);
        }

        return doPow(x * x, n >> 1);
    }
}
