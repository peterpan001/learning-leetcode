package com.lipan.sword.offer.day07._027;

import com.lipan.sword.offer.common.TreeNode;

/**
 * 二叉树的镜像
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 二叉树的镜像，递归遍历二叉树，并不断交换左右子树
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left); // 递归遍历左子树
        TreeNode right = mirrorTree(root.right); // 递归遍历右子树
        root.left = right; // 左右子树交换
        root.right = left;
        return root;
    }
}
