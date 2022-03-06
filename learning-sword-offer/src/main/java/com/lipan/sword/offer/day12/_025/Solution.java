package com.lipan.sword.offer.day12._025;

import com.lipan.sword.offer.common.ListNode;

/**
 * 合并两个排序的链表
 *
 * @author lipan
 * @date 2021-12-15
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) { // 如果有一个为空直接返回另一个
            return l1 == null ? l2 : l1;
        }

        ListNode dum = new ListNode(0); // 声明临时节点，并指向此节点
        ListNode cur = dum;
        while (l1 != null && l2 != null) { // 遍历 l1 与 l2 将节点有序存储到 dum 链表里
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1.next;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2; // l1为空，接l2，否则接l1
        return dum.next;
    }
}
