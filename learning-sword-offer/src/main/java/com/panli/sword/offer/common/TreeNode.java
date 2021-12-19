package com.panli.sword.offer.common;

/**
 * 二叉树类
 *
 * @author lipan
 * @date 2021-12-11
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
