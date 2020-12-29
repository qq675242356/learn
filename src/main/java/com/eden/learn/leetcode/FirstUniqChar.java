package com.eden.learn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqChar {
    public static void main(String[] args) {
//        String str = "loveleetcode";
        String str = "lovel";
        System.out.println(firstUniqChar2(str));
    }

    //todo 使用哈希表存储索引
    //@https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/
    public static int firstUniqChar2(String str) {
        Map<Character, Integer> table = new HashMap<>();
        char[] chars = str.toCharArray();
        int i = 0;
        for (char aChar : chars) {
            if (table.containsKey(aChar)) {
                table.put(aChar, -1);
            } else {
                table.put(aChar, i++);
            }
        }

        int first = chars.length;
        for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            if (entry.getValue() != -1 && first > entry.getValue()) {
                first = entry.getValue();
            }
        }
        return first;
    }

    //todo 使用哈希表存储频数
    public static int firstUniqChar(String str) {
        return 0;
    }
}
