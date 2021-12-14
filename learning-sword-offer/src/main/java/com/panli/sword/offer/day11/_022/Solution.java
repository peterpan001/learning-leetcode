package com.panli.sword.offer.day11._022;

import com.panli.sword.offer.common.ListNode;

/**
 * 链表中倒数第 k 个节点
 *
 * @author lipan
 * @date 2021-12-14
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) { // 如果链表为空，直接返回
            return null;
        }
        ListNode fast = head, slow = head; // 定义快慢指针
        while (fast != null && k > 0) { // 快指针移动到第 k 个节点
            fast = fast.next;
            k--;
        }
        while (fast != null) { // 快慢一起移动，待快指针移动到末尾，此时 slow 指针即指向倒数第 k 个节点
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}


