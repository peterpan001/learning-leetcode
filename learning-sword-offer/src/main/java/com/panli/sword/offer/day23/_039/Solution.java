package com.panli.sword.offer.day23._039;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字
 *
 * @author lipan
 * @date 2022-01-16
 */
public class Solution {

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 投票
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += x == num ? 1 : -1;
        }
        for (int num : nums) {
            if (num == x) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : -1; // 无众数返回-1
    }
}
