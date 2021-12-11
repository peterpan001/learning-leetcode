package com.panli.sword.offer.day07._026;

import com.panli.sword.offer.common.TreeNode;

/**
 * 树的子树
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 判断 B 是否为 A 的子树，
     * 条件：A 不为空 && B 不为空 且(A，B) || (A.left, B) || (A.right, B)
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && ((recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
