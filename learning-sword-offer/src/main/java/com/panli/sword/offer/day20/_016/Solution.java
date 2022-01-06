package com.panli.sword.offer.day20._016;

/**
 * 数值的整数次方
 *
 * @author lipan
 * @date 2021-12-29
 */
public class Solution {

    /**
     * 数值的整数次方: (3, 7)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) { // 如果 x 为 0，直接返回 0
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) { // 如果 b < 0，将 b 变为正，x 变为 1/x
            x = 1 / x;
            b = -b;
        }
        while (b > 0) { // 递归
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
