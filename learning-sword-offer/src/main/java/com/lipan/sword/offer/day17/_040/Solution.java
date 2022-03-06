package com.lipan.sword.offer.day17._040;

import java.util.Arrays;
import java.util.Random;

/**
 * 最小的k个数
 *
 * @author lipan
 * @date 2021-12-19
 */
public class Solution {

    /**
     * 先排序然后取最小 k 个数
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || k == 0) {
            return new int[0];
        }
        int[] res = new int[k];
        Arrays.sort(arr); // 考虑自己实现快排、冒泡、归并、堆排序
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 借助快排的思想解决
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || k == 0) { // 如果数组为空或者 k == 0，直接返回空
            return new int[0];
        }
        if (k >= arr.length) { // 如果 k 大于数组，直接返回数组
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1); // 借助快排思想
    }

    private int[] quickSort(int[] arr, int k, int l, int r) {  // 选择起始元素为参考元素，开始划分
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[i]) {
                j--;
            }
            while (i < j && arr[i] <= arr[j]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) {
            return quickSort(arr, k, l, i - 1);
        }
        if (i < k) {
            return quickSort(arr, k, i + 1, r);
        }
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 基于快排解决
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (arr == null || k == 0) {
            return new int[0];
        }
        if (k >= arr.length) {
            return arr;
        }
        return Arrays.copyOf(arr, k);
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }
}
