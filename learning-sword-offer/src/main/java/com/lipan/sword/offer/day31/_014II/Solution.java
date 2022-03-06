package com.lipan.sword.offer.day31._014II;

/**
 * 剪绳子II
 *
 * @author lipan
 * @date 2022-03-01
 */
public class Solution {

    public int cuttingRope(int n) {
        if (n == 2) { // n 为 2，分成 1 和 1
            return 1;
        }
        if (n == 3) { // n 为 3，分成 1 和 2
            return 2;
        }
        if (n == 4) { // n 为 4，分成 2 和 2
            return 4;
        }
        long res = 1;
        while (n > 4) { // n 大于 4 时，按 3 分 得到的面积最大
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (n * res % 1000000007);
    }
}
