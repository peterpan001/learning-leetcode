package com.lipan.sword.offer.day06._032I;


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
     * 借助队列先进先出思想打印二叉树
     *
     * @param root
     * @return
     */
    public int[] levelOrder(final TreeNode root) {
        if (root == null) { // 二叉树为空，直接返回
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ // 声明队列并存储root节点
            add(root);
        }};
        List<Integer> list = new ArrayList<Integer>(); // 声明 list 集合存储元素

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // 出队列，并将node值存储到list集合中
            list.add(node.val);
            if (node.left != null) { // 如果 node 节点左节点不为空，进队列
                queue.add(node.left);
            }
            if (node.right != null) { // 如果 node 节点右节点不为空，进队列
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
