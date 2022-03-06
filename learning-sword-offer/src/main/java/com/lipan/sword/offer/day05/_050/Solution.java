package com.lipan.sword.offer.day05._050;

import java.util.HashMap;

/**
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 借助 HashMap 实现
     * 第一次遍历存储<char, count>，第二次遍历判断count为1的
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s == null || s == "") { // 非空判断
            return ' ';
        }
        HashMap<Character, Integer> maps = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) { // 遍历，组成<char, count> 的 map 集合
            if (maps.containsKey(s.charAt(i))) {
                maps.put(s.charAt(i), maps.get(s.charAt(i)) + 1);
            } else {
                maps.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) { // 遍历，查找 count 为 1 的字符
            if (maps.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
