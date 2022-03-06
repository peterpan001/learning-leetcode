package com.lipan.sword.offer.day07._028;

import com.lipan.sword.offer.common.TreeNode;

/**
 * 对称的二叉树
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 对称二叉树定义：
     * 1. L.val=R.val ：即此两对称节点值相等
     * 2. L.left.val=R.right.val ：即 LL 的 左子节点 和 RR 的 右子节点 对称
     * 3. L.right.val=R.left.val ：即 LL 的 右子节点 和 RR 的 左子节点 对称
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    protected boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
