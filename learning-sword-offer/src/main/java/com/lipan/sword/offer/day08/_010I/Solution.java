package com.lipan.sword.offer.day08._010I;

/**
 * 斐波那契数列
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 斐波那契数列：f(0) = 0, f(1) = 1, f(n) = f(n-1) + f(n-2);
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
