package com.lipan.sword.offer.day13._057;

/**
 * 和为 s 的两个数字
 *
 * @author lipan
 * @date 2021-12-15
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 1 || nums[0] >= target) { // 临界条件
            return new int[0];
        }

        int left = 0, right = nums.length - 1; // 声明左右指针
        while (left < right) { // 临界条件：左指针小于右指针
            if (nums[left] + nums[right] == target) { // 如果左指针元素加右指针元素等于目标值，直接返回
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] > target) { // 如果大于目标值，则右指针--
                right--;
            } else { // 否则左指针++
                left++;
            }
        }
        return new int[0]; // 不存在这样的两个元素满足target值
    }
}
