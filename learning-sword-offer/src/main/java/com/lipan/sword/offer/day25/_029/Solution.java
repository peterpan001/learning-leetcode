package com.lipan.sword.offer.day25._029;

/**
 * 顺时针打印矩阵
 *
 * @author lipan
 * @date 2022-02-09
 */
public class Solution {

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, idx = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            for (int i = left; i <= right; i++) { // 从左到右
                res[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) { // 从上到下
                res[idx++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }
            for (int i = right; i >= left; i--) { // 从右到左
                res[idx++] = matrix[bottom][i];
            }
            if (top > --bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) { // 从下到上
                res[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
