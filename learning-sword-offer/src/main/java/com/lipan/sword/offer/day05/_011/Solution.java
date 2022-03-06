package com.lipan.sword.offer.day05._011;

/**
 * 旋转数组的最小数字
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {


    /**
     * 暴力破解法
     *
     * @param numbers
     * @return
     */
    public int minArray1(int[] numbers) {
        if (numbers == null) { // 数组校验
            return -1;
        }
        int min = numbers[0];
        for (int num : numbers) { // 遍历，查找最小元素
            min = num < min ? num : min;
        }
        return min;
    }

    /**
     * demo：[3,4,5,1,2]
     * 二分查找法，以 nums[len-1] 为判断条件，
     * 如果大于它，low = mid + 1；
     * 如果小于它，high = mid；
     * 否则 high = high - 1
     *
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        if (numbers == null) { // 数组校验
            return -1;
        }
        int low = 0; // 左指针
        int high = numbers.length - 1; // 右指针
        while (low < high) { // 临界值
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

}
