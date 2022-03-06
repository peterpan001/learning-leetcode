package com.lipan.sword.offer.day05._004;

/**
 * 二维数组中的查找
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 暴力破解法，遍历二维数组
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { // 数组校验
            return false;
        }

        for (int i = 0; i < matrix.length; i++) { // 遍历二维数组
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 借助二维数组，从左到有递增，从上到下递增规律进行判断
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { // 数组校验
            return false;
        }

        int rows = matrix.length, columns = matrix[0].length; // 获取二维数组的行数和列数
        int row = matrix.length - 1, column = 0; // 从最后一行第一列元素开始查找
        while (row >= 0 && column < columns) { // 临界条件
            if (matrix[row][column] == target) { // 相等返回
                return true;
            } else if (matrix[row][column] > target) { // 如果大于目标值，行--，否则列++
                row--;
            } else {
                column++;
            }
        }
        return false;
    }
}
