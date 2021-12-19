package com.panli.sword.offer.day14._013;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 机器人的运动范围
 *
 * @author lipan
 * @date 2021-12-17
 */
public class Solution {

    /**
     * 利用递归解答
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount1(int m, int n, int k) {
        if (k == 0) { // 如果 k 为 0，直接返回 1
            return 1;
        }
        boolean[][] vis = new boolean[m][n]; // 定义是否可以达标
        int ans = 0; // 存储结果
        vis[0][0] = true; //
        for (int i = 0; i < m; i++) { // 遍历 m*n 矩阵
            for (int j = 0; j < n; j++) {
                if (get(i) + get(j) > k) { // 如果(i,j)位数和大于k，跳过
                    continue;
                }
                // 边界判断，(i,j)如果可以，它一定是(i-1,j)或者(i,j-1)到达
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    int m, n, k;
    boolean[][] visited;

    /**
     * 广度优先搜索
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }

        return ans;
    }


    private int get(int x) { // 求 x 数位的和
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
