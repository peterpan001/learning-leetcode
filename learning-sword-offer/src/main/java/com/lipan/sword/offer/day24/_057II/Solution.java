package com.lipan.sword.offer.day24._057II;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 *
 * @author lipan
 * @date 2022-01-16
 */
public class Solution {

    /**
     * 滑动窗口
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> list = new ArrayList<>();
        while (i <= target / 2) {
            if (target < sum) { // 左边界向右移动
                sum -= i;
                i++;
            } else if (target > sum) { // 右边界向右移动
                sum += j;
                j++;
            } else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int z = i; z < j; z++) {
                    arr[z - i] = z;
                }
                list.add(arr);
                sum -= i; // 左边界向右移动
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
