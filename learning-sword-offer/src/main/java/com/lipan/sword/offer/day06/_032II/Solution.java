package com.lipan.sword.offer.day06._032II;

import com.lipan.sword.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树I
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 利用队列先进先出思想打印，并控制每一层节点个数
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(final TreeNode root) {
        if (root == null) { // 如果二叉树为空，直接返回
            return new ArrayList<List<Integer>>();
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ // 声明队列
            add(root);
        }};
        List<List<Integer>> lists = new ArrayList<List<Integer>>(); // 声明集合

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size(); // 记录当前层次节点个数
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
