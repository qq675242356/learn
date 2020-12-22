package com.eden.learn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoCode {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] ints = towSum1(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    // 暴力枚举
    public static int[] towSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
               if (target == nums[i]+nums[j]){
                   return new int[]{i,j};
               }
            }
        }
        return null;
    }

    //@https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
    // 两次循环改为hash表 边循环边找结果

    public static int[] towSum1(int[] nums, int target) {
        Map<Integer,Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (table.containsKey(target-num)){
                return new int[]{i,table.get(target-num)};
            }
            table.put(num,i);
        }
        return new int[0];
    }
}
