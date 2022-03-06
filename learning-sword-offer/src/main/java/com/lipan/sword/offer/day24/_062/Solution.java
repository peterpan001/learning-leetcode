package com.lipan.sword.offer.day24._062;

/**
 * 圆圈中最后剩下的数字
 *
 * @author lipan
 * @date 2022-01-16
 */
public class Solution {

    /**
     * 数学 + 迭代
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }


    /**
     * 数学 + 递归
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n, int m) {
        return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }
}
