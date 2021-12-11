package com.panli.sword.offer.day04._053I;

import java.util.HashMap;

/**
 * 在排序数组中查找数字
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 借助 HashMap 实现，先将所有元素个数统计出来<num, count>
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (maps.containsKey(num)) {
                maps.put(num, maps.get(num) + 1);
            } else {
                maps.put(num, 1);
            }
        }

        return maps.get(target) == null ? 0 : maps.get(target);
    }

    /**
     * 遍历元素，如果等于target，则 res+1，最后返回 res
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int res = 0;
        for (int num : nums) {
            res = num == target ? res + 1 : res;
        }
        return res;
    }
}
