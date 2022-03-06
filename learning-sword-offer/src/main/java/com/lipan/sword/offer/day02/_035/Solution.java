package com.lipan.sword.offer.day02._035;

import com.lipan.sword.offer.common.Node;

import java.util.HashMap;

/**
 * 复杂链表的复制
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 复杂链表复制，借助 hashMap 实现，构建原链表节点与新链表节点之间的对应关系
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {

        if (head == null) { // 如果链表为空直接返回
            return null;
        }

        Node cur = head; // 声明节点指向头节点
        HashMap<Node, Node> maps = new HashMap<Node, Node>(); // 声明存储原/新链表节点关系集合

        while (cur != null) { // 遍历链表，存储原/新链表节点值关系集合
            maps.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head; // 重置

        while (cur != null) { // 遍历链表，存储原/新链表节点指针关系集合
            maps.get(cur).next = maps.get(cur.next);
            maps.get(cur).random = maps.get(cur.random);
            cur = cur.next;
        }
        return maps.get(head);
    }
}
