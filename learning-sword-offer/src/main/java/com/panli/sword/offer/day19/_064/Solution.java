package com.panli.sword.offer.day19._064;

/**
 * 求1+2+…+n
 *
 * @author lipan
 * @date 2021-12-28
 */
public class Solution {

    /**
     * 平均计算
     *
     * @param n
     * @return
     */
    public int sumNums1(int n) {
        return n * (n + 1) / 2;
    }


    int res = 0;

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int sumNums2(int n) {
        boolean x = n > 1 && sumNums2(n - 1) > 0;
        res += n;
        return res;
    }
}
