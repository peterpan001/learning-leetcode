package com.lipan.sword.offer.day13._021;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author lipan
 * @date 2021-12-15
 */
public class Solution {

    /**
     * 左右指针解决此问题
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 1) { // 数据为空或者数组长度为1直接返回
            return nums;
        }
        int left = 0, right = nums.length - 1; // 声明左右指针
        while (left < right) { // 临界条件：左指针小于右指针
            while (left < right && nums[left] % 2 == 1) { // 左指针小于右指针且左指针元素为奇数，左指针++
                left++;
            }
            while (left < right && nums[right] % 2 == 0) { // 左指针小于右指针且右指针元素为偶数，右指针--
                right--;
            }
            int tmp = nums[left]; // 左右交换位置
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
