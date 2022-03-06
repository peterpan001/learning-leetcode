package com.lipan.sword.offer.day09._042;

/**
 * 连续子数组的最大和
 *
 * @author lipan
 * @date 2021-12-12
 */
public class Solution {

    /**
     * 连续子数组的最大和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        if (nums == null) { // 如果数组为空，则直接返回0
            return 0;
        }

        int preRes = 0; // 存储临时连续子数组的最大和
        int maxRes = nums[0]; // 存储最终连续子数组的最大和
        for (int num : nums) {
            preRes = Math.max(preRes + num, num);
            maxRes = Math.max(preRes, maxRes);
        }
        return maxRes;
    }
}
