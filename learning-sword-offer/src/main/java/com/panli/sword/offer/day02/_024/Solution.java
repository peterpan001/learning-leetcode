package com.panli.sword.offer.day02._024;

import com.panli.sword.offer.common.ListNode;

/**
 * 反转链表
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) { // 如果链表为空或只有一个节点，直接返回即可
            return head;
        }

        ListNode pre = null; // 声明节点的前一节点
        ListNode cur = head; // 声明当前节点
        ListNode next = null; // 声明节点的下一节点

        while (cur != null) { // 遍历链表
            next = cur.next; // 存储下一节点
            cur.next = pre; // 当前节点 next 修改指向前一节点
            pre = cur; // 移动 pre 节点到 cur 节点
            cur = next; // 移动 cur 节点到 next 节点
        }
        return pre;
    }
}
