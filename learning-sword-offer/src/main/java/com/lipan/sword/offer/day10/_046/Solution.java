package com.lipan.sword.offer.day10._046;

/**
 * 把数字翻译成字符串
 *
 * @author lipan
 * @date 2021-12-13
 */
public class Solution {


    public int translateNum1(int num) {
        if (num < 0) { // 如果 num 小于 0，直接返回
            return 0;
        }

        String str = String.valueOf(num); // num数字转化为字符串

        int len = str.length(); // 获取长度，如果长度为1，直接返回
        if (len < 2) {
            return len;
        }

        char[] chars = str.toCharArray(); // 将字符串转化为字符数组
        int[] dp = new int[len + 1]; // dp[i]：字符串 str[0...i)能翻译成小写字母的种数

        dp[0] = 1; // 0 个字符种类数为1
        dp[1] = 1; // 1 个字符种类数为1

        for (int i = 1; i < len; i++) {
            dp[i + 1] = dp[i]; // 当前字母只能至少 1 种翻译方法
            int currentNum = 10 * (chars[i - 1] - '0') + (chars[i] - '0');
            if (currentNum > 9 && currentNum < 26) {
                dp[i + 1] = dp[i] + dp[i - 1]; // 当前字母与前一个字母构成一种翻译方法
            }
        }
        return dp[len];
    }
}
