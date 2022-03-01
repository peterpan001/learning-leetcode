package com.panli.sword.offer.day29._049;

/**
 * 丑数
 *
 * @author lipan
 * @date 2022-02-27
 */
public class Solution {

    /**
     * 丑数：只包含因子2，3，5；因此：丑数 = 某较小丑数 * 某因子
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
