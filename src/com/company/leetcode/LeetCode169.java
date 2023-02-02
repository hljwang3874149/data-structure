package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
 */
public class LeetCode169 {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {

        return toupiao(nums);
//        return  sort(nums);
//        return hashMap(nums);
    }

    private int toupiao(int[] nums) {
        int count =0;
        Integer candidate = null;
        for (int num : nums) {
            if(count==0){
                candidate = num;
            }
            count += (candidate ==num)?1:-1;
        }
        return candidate.intValue();

    }

    private int sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }

    private static int hashMap(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int half = nums.length>>1;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            Integer value = hashMap.getOrDefault(num, 0) + 1;
            if (value.intValue() > half) {
                return num;
            }
            hashMap.put(num, value);
        }

        return 0;
    }
}
