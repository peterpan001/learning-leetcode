package com.lipan.sword.offer.day03._058II;

/**
 * 左旋转字符串
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 借助 api 实现
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords1(String s, int n) {

        if (s.length() < n) {
            return s;
        }
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     * 借助 StringBuilder 实现
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        if (s.length() < n) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) { // 利用数学取余思想
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }
}
