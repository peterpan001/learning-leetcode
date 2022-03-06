package com.lipan.sword.offer.day14._012;

/**
 * 矩阵中的路径
 *
 * @author lipan
 * @date 2021-12-17
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word == null) { // 参数合法性校验
            return false;
        }

        char[] words = word.toCharArray(); // 将 word 转化为字符数组
        for (int i = 0; i < board.length; i++) { // 遍历 board，查找 word 路径
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) { // 深度遍历
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]) { // 临界条件
            return false;
        }
        if (k == words.length - 1) { // 如果 k 为数组长度，则存在此路径
            return true;
        }
        board[i][j] = '\0'; // 走过的路径都做特殊标记，防止回溯
        boolean res = dfs(board, words, i + 1, j, k + 1) // 上下左右进行深度遍历，查找此路径
                || dfs(board, words, i - 1, j, k + 1)
                || dfs(board, words, i, j + 1, k + 1)
                || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k]; // 回滚
        return res;
    }
}
