package com.panli.sword.offer.day20._033;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author lipan
 * @date 2021-12-29
 */
public class Solution {

    /**
     * 后序遍历:左右根
     * 二叉搜索树：左子树小于根节点，右子树大于根节点
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder1(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int idx = i;
        while (postorder[idx] < postorder[j]) {
            idx++;
        }
        int poivt = idx;
        while (postorder[idx] > postorder[j]) {
            idx++;
        }
        return idx == j && recur(postorder, i, poivt - 1) && recur(postorder, poivt, j - 1);
    }
}
