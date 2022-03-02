package com.panli.sword.offer.day30._051;

/**
 * 数组中的逆序对
 *
 * @author lipan
 * @date 2022-03-01
 */
public class Solution {

    /**
     * 暴力破解法，超时
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    int count;

    public int reversePairs1(int[] nums) {
        this.count = 0;
        merge(nums, 0, nums.length - 1);
        return count;
    }

    public void merge(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (right > left) {
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }
    }

    public void mergeSort(int[] nums, int left, int mid, int right) {

        int[] tmpArr = new int[right - left + 1];
        int idx = 0;
        int tmp1 = left, tmp2 = mid + 1;

        while (tmp1 <= mid && tmp2 <= right) {
            if (nums[tmp1] <= nums[tmp2]) {
                tmpArr[idx++] = nums[tmp1++];
            } else {
                //用来统计逆序对的个数
                count += (mid - tmp1 + 1);
                tmpArr[idx++] = nums[tmp2++];
            }
        }

        //把左边剩余的数移入数组
        while (tmp1 <= mid) {
            tmpArr[idx++] = nums[tmp1++];
        }
        //把右边剩余的数移入数组
        while (tmp2 <= right) {
            tmpArr[idx++] = nums[tmp2++];
        }
        //把新数组中的数覆盖nums数组
        for (int k = 0; k < tmpArr.length; k++) {
            nums[k + left] = tmpArr[k];
        }
    }
}
