package com.lipan.sword.offer.day24._014I;

/**
 * 剪绳子
 *
 * @author lipan
 * @date 2022-01-16
 */
public class Solution {

    /**
     * 最优：3，把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况；
     * 次优：2，若最后一段绳子长度为2；则保留，不再拆为1+1；
     * 最差：1，若最后一段绳子长度为1；则应把一份3+1替换为2+2，因为 2*2 > 3*1；
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
