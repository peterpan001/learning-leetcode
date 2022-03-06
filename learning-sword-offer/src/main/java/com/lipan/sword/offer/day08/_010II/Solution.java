package com.lipan.sword.offer.day08._010II;

/**
 * 青蛙跳台阶问题
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * f(0) = 1, f(1) = 1, f(2) = 2, f(3) = f(2) + f(1)
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
