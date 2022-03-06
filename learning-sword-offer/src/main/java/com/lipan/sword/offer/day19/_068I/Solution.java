package com.lipan.sword.offer.day19._068I;

import com.lipan.sword.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author lipan
 * @date 2021-12-28
 */
public class Solution {

    /**
     * 利用二叉搜索树的性质，两次遍历
     * 找到 p 和 g 的路径，然后再找最近的公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> pPath = getPath(root, p); // 获取 p 节点路径
        List<TreeNode> qPath = getPath(root, q); // 获取 q 节点路径
        TreeNode ancestor = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) { // 找最近的公共祖先
                ancestor = pPath.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    /**
     * 获取根节点到 target 节点的路径
     *
     * @param root
     * @param target
     * @return
     */
    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (node.val > target.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    /**
     * 利用二叉搜索树的性质，一次遍历
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
