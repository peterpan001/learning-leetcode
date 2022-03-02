package com.panli.sword.offer.day30._017;

/**
 * 打印从 1 到最大的 n 位数
 *
 * @author lipan
 * @date 2022-03-01
 */
public class Solution {

    public int[] printNumbers(int n) {
        int len = 1;
        while (n > 0) {
            len *= 10;
            n--;
        }
        int[] res = new int[len - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
