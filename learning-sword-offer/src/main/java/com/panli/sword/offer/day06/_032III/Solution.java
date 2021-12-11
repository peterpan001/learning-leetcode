package com.panli.sword.offer.day06._032III;

import com.panli.sword.offer.common.TreeNode;

import java.util.*;

/**
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 利用队列的思想实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(final TreeNode root) {
        if (root == null) { // 如果数为空，直接返回
            return new ArrayList<List<Integer>>();
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ // 声明队列
            add(root);
        }};
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>(); // 声明集合

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (lists.size() % 2 == 1) { // 在第2，4，6，...层数 list 进行逆序
                Collections.reverse(list);
            }
            lists.add(list);
        }
        return lists;
    }
}
