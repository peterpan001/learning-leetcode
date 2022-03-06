package com.lipan.sword.offer.day18._055I;

import com.lipan.sword.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的深度
 *
 * @author lipan
 * @date 2021-12-27
 */
public class Solution {

    /**
     * 二叉树的后序遍历
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    /**
     * 二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
