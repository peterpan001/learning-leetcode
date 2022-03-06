package com.lipan.sword.offer.day22._056II;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中数字出现的次数
 *
 * @author lipan
 * @date 2022-01-10
 */
public class Solution {

    /**
     * HashMap 统计
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 位与运算
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < counts.length; i++) {
                counts[i] = num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < counts.length; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    /**
     * 状态机
     *
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
