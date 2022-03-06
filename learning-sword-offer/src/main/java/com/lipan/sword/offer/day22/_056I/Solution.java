package com.lipan.sword.offer.day22._056I;

/**
 * 数组中数字出现的次数
 *
 * @author lipan
 * @date 2022-01-10
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {      // 1. 遍历异或
            n ^= num;
        }
        while ((n & m) == 0) {      // 2. 循环左移，计算 m
            m <<= 1;
        }
        for (int num : nums) {      // 3. 遍历 nums 分组
            if ((num & m) != 0) {   // 4. 当 num & m != 0
                x ^= num;
            } else {
                y ^= num;           // 4. 当 num & m == 0
            }
        }
        return new int[]{x, y};     // 5. 返回出现一次的数字
    }
}
