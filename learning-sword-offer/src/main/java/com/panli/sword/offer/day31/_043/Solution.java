package com.panli.sword.offer.day31._043;

/**
 * 1~n整数中1出现的次数
 *
 * @author lipan
 * @date 2022-03-01
 */
public class Solution {

    public int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
