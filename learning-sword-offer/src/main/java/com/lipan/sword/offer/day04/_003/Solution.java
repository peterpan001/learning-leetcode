package com.lipan.sword.offer.day04._003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 数组中重复的数字
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 借助 HashMap 实现
     *
     * @param nums
     * @return
     */
    public int findRepeatNumbe1(int[] nums) {
        if (nums == null || nums.length == 1) { // 如果数组为空或者长度为1，返回-1
            return -1;
        }
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) { // 如果 hashMap 的 key 存在，则返回此元素即可
                return nums[i];
            } else {
                maps.put(nums[i], 1); // 不存在，放入 hashMap 中，设置 val 为 1
            }
        }
        return -1;
    }

    /**
     * 借助 HashSet 实现
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length == 1) { // 如果数组为空或者长度为1，返回-1
            return -1;
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) { // 遍历数组，将元素放入 set 集合
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }

        return -1;
    }
}
