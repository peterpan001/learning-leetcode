package com.panli.sword.offer.day21._065;

/**
 * 不用加减乘除做加法
 *
 * @author lipan
 * @date 2022-01-06
 */
public class Solution {

    /**
     * 无进位和 与 异或运算 规律相同，进位和 与 与运算 规律相同（并需左移一位）
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1; // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
