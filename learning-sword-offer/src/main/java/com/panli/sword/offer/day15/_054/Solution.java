package com.panli.sword.offer.day15._054;

import com.panli.sword.offer.common.TreeNode;

/**
 * 二叉搜索树的第k大节点
 *
 * @author lipan
 * @date 2021-12-19
 */
public class Solution {


    int ret, k;

    /**
     * 二叉搜索树的 中序遍历倒序 为 递增序列
     * 故：二叉搜索树第 k 大的节点 "可转化为求" 此树的中序遍历倒序的第 k 个节点
     * <p>
     * 中序遍历：左根右；中序遍历倒序：右根左
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode root) {
        if (root == null) { // 终止条件
            return;
        }
        dfs(root.right); // 右子树
        if (--k == 0) {
            ret = root.val; // 根节点
            return;
        }
        dfs(root.left); // 左子树
    }
}
