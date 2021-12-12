package com.panli.sword.offer.day09._047;

/**
 * 礼物的最大价值
 *
 * @author lipan
 * @date 2021-12-12
 */
public class Solution {

    /**
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) { // 二维数组校验
            return 0;
        }
        int rows = grid.length; // 获取二维数组的行列长度
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) { // 遍历二维数组，每个位置都存储之前走过路的最大值
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) { // grid[0][0]上方、左方无元素，故其本身就是最大值
                    continue;
                }
                if (i == 0) { // 第一行，故只有列可以变换，即最大值取前一列进行加和
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) { // 第一列，故只有行可以变换，即最大值取前一行进行加和
                    grid[i][j] += grid[i - 1][j];
                } else { // 非第一行第一列，需比较上一行元素和上一列元素，哪个最大取哪个
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[rows - 1][columns - 1];
    }
}
