package com.panli.sword.offer.day16._045;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * @author lipan
 * @date 2021-12-19
 */
public class Solution {

    /**
     * 利用内置函数进行排序
     *
     * @param nums
     * @return
     */
    public String minNumber1(int[] nums) {
        if (nums == null) {
            return null;
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    /**
     * 快速排序
     *
     * @param nums
     * @return
     */
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    /**
     * 快排思想，选取种子节点，以此节点为分界点，左边小于此节点，右边大于此节点，然后递归左右部分即可
     *
     * @param strs
     * @param l
     * @param r
     */
    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}
