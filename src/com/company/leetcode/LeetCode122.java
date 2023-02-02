package com.company.leetcode;

/**
 * 股票交易 -贪心算法
 */
public class LeetCode122 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        return maxProfit2(prices);
//        return maxProfit1(prices);
    }

    private int maxProfit2(int[] prices) {
        int count =0;
        for (int i = 1; i < prices.length; i++) {
            int value = prices[i]-prices[i-1];
            if(value>0){
                count+=value;
            }

        }
        return count;
    }

    private static int maxProfit1(int[] prices) {
        int count =-1;
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (count !=-1&&count< prices[i]){
                sum += prices[i]-count;
                count=-1;
            }
            if(count==-1 && i< prices.length-1&& prices[i]< prices[i+1]){
                    count = prices[i];
                }
            }

        return sum;
    }
}
