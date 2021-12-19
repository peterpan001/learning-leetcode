package com.panli.sword.offer.day15._036;

import com.panli.sword.offer.common.TreeNode;

/**
 * 二叉搜索树与双向链表
 *
 * @author lipan
 * @date 2021-12-19
 */
public class Solution {

    TreeNode pre, head;

    /**
     * 二叉搜索树的中序遍历为：递增序列
     * 1.排序链表：节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点。
     * 2.双向链表：在构建相邻节点的引用关系时，设前驱节点pre和当前节点cur，不仅应构建pre.right=cur,也应构建 cur.left=pre
     * 3.循环链表： 设链表头节点 head 和尾节点 tail ，则应构建 head.left = tail 和 tail.right = head
     *
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) { // 如果root为空，直接返回null
            return null;
        }
        dfs(root); // 中序遍历搜索二叉树
        head.left = pre; // 赋值头节点左指针为pre
        pre.right = head; // 赋值pre节点右指针为头节点（此时pre指向的是末节点）
        return head;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) { // 如果当前节点为空，直接返回
            return;
        }
        dfs(cur.left); // 递归左节点
        if (pre != null) { // 修改节点指针，如果前一节点不为空，前一节点右指针指向当前节点
            pre.right = cur;
        } else { // 如果为空，说明当前节点为头节点
            head = cur;
        }
        cur.left = pre; // 当前节点左指针指向前一节点
        pre = cur; // 节点向下移动一位，递归继续
        dfs(cur.right); // 递归右节点
    }
}
