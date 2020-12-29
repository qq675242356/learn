package com.eden.learn.leetcode;

public class LongestCommonPrefix {

    //todo
    //@https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/


    public static void main(String[] args) {
        String[] strs = {"leet", "lee", "le"};
//        String prefix = longestCommonPrefix2(strs);
        String prefix = longestCommonPrefix3(strs);
        System.out.println(prefix);

    }

    //todo 横向扫描
    public static String longestCommonPrefix1(String[] strs) {
        return null;
    }

    //纵向扫描
    public static String longestCommonPrefix2(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                //i==str[j].length()  判断相等 并且在||前面 ，不让会报 String index out of range: 2
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //todo 分治
    public static String longestCommonPrefix3(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix3(strs, 0, strs.length - 1);
    }

    //todo 二分
    public static String longestCommonPrefix4(String[] strs) {
        return null;
    }

    public static String longestCommonPrefix3(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        int mid = (end-start)/2 + start;
        String left = longestCommonPrefix3(strs, start, mid);
        String right = longestCommonPrefix3(strs, mid+1, end);
        return commonPrefix(left,right);
    }

    public  static String commonPrefix(String left,String right){
        int minLen = Math.min(left.length(),right.length());
        for (int i = 0; i < minLen; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0,i);

        }
        return left.substring(0,minLen);
    }

}
