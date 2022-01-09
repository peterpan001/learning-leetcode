package com.panli.sword.offer.day21._015;

/**
 * 二进制中1的个数
 *
 * @author lipan
 * @date 2022-01-06
 */
public class Solution {


    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>>= 1;
        }
        return res;
    }

    /**
     * 根据 与运算 定义，设二进制数字 n ，则有:
     * 若 n & 1 = 0，则 n 二进制 最右一位 为 0，
     * 若 n & 1 = 1，则 n 二进制 最右一位 为 1。
     *
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    /**
     * n & (n−1)，其预算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }
}
