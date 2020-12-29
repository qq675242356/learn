package com.eden.learn.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static void main(String[] args) {
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]
    }

    //todo
    //@https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-kge-gao-pin-yuan-su-zui-xiao-dui-by-npfv/
    public static int[] topKFrequent(int[] nums,int k){
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[2];
            }
        });

        for (int num : nums) {
            if (queue.size()==k){
//                queue.for
            }else {
                queue.offer(new int[]{num,1});
            }
        }

        return null;
    }

}
