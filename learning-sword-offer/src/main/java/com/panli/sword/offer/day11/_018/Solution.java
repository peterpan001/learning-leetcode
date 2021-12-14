package com.panli.sword.offer.day11._018;

import com.panli.sword.offer.common.ListNode;

/**
 * 删除链表的节点
 *
 * @author lipan
 * @date 2021-12-14
 */
public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) { // 如果链表为空，直接返回null
            return null;
        }
        if (head.val == val) { // 如果删除的节点是头节点，直接返回 head.next
            return head.next;
        }
        ListNode pre = head, cur = head.next; // 记录前一节点与当前节点
        while (cur != null && cur.val != val) { // 遍历链表中节点值与 val 相等的节点
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) { // 如果 cur 不为空，直接修改 next 指针，pre 的 next 指向 cur 的next；
            pre.next = cur.next;
        }
        return head;
    }
}
