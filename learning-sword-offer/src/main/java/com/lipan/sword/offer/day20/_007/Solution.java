package com.lipan.sword.offer.day20._007;

import com.lipan.sword.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重建二叉树
 *
 * @author lipan
 * @date 2021-12-29
 */
public class Solution {

    /**
     * 迭代
     * 前序遍历：根左右
     * 中序遍历：左根右
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preList.add(preorder[i]);
            inList.add(inorder[i]);
        }
        return buildTreeHandle(preList, inList);
    }

    private TreeNode buildTreeHandle(List<Integer> preList, List<Integer> inList) {
        if (inList.size() == 0) {
            return null;
        }
        int rootVal = preList.remove(0);
        int mid = inList.indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHandle(preList, inList.subList(0, mid));
        root.right = buildTreeHandle(preList, inList.subList(mid + 1, inList.size()));
        return root;
    }
}
