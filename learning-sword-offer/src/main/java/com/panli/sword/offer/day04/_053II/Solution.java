package com.panli.sword.offer.day04._053II;

/**
 * 0～n-1 中缺失的数字
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 利用二分思想解决
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        if (nums == null) { // 如果数组为空，直接返回
            return -1;
        }

        int i = 0; // 左指针
        int j = nums.length - 1; // 右指针

        while (i <= j) { // 终止条件
            int m = (i + j) / 2; // 取中间位置
            if (nums[m] == m) { // 如果相等，则在右边，否则在左边
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
