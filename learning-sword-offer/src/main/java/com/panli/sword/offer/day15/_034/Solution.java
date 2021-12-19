package com.panli.sword.offer.day15._034;

import com.panli.sword.offer.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 * @author lipan
 * @date 2021-12-19
 */
public class Solution {

    LinkedList<List<Integer>> ret = new LinkedList<>(); // 存储结果
    LinkedList<Integer> path = new LinkedList<>(); // 存储路径

    /**
     * 深度遍历，从根节点到叶子节点，如果满足，添加到 ret 中即可（先序遍历，根左右）
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) { // 终止条件
            return;
        }
        path.add(root.val); // 将节点值放入path中
        target -= root.val; // target 减去当前节点值
        if (root.left == null && root.right == null && target == 0) {
            // 如果节点左右叶子节点为空，且 target 为 0，代表此路径符合要求
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, target); // 递归遍历左节点
        dfs(root.right, target); // 递归遍历右节点
        path.removeLast(); // 路径恢复：向上回溯前，需要将当前节点从路径 path 中删除
    }
}
