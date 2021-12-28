package com.panli.sword.offer.day18._055II;

import com.panli.sword.offer.common.TreeNode;

/**
 * 平衡二叉树
 *
 * @author lipan
 * @date 2021-12-27
 */
public class Solution {

    /**
     * 平衡二叉树：左子树与右子树深度之差绝对值不超过1
     * 自顶向下遍历
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth1(root.left) - depth1(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int depth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth1(root.left), depth1(root.right)) + 1;
    }

    /**
     * 自下向上遍历
     *
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return depth2(root) >= 0;
    }

    private int depth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDep = depth2(root.left);
        int rightDep = depth2(root.right);
        if (leftDep == -1 || rightDep == -1 || Math.abs(leftDep - rightDep) > 1) {
            return -1;
        } else {
            return Math.max(depth2(root.left), depth2(root.right)) + 1;
        }
    }

}
