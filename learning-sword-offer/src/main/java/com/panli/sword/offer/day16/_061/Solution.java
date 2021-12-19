package com.panli.sword.offer.day16._061;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺序
 *
 * @author lipan
 * @date 2021-12-19
 */
public class Solution {

    public boolean isStraight1(int[] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }
        Set<Integer> repeated = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (repeated.contains(num)) {
                return false;
            }
            repeated.add(num);
        }
        return max - min < 5;
    }

    public boolean isStraight2(int[] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }
}
