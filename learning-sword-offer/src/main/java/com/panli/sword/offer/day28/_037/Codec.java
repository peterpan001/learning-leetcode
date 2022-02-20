package com.panli.sword.offer.day28._037;

import com.panli.sword.offer.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 *
 * @author lipan
 * @date 2022-02-17
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { // 为空，直接返回: "[]"
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[idx].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[idx]));
                queue.add(node.left);
            }
            idx++;
            if (!vals[idx].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[idx]));
                queue.add(node.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
