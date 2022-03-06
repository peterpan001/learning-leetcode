package com.lipan.sword.offer.day12._052;

import com.lipan.sword.offer.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的第一个公共节点
 *
 * @author lipan
 * @date 2021-12-15
 */
public class Solution {

    /**
     * 双指针法，两指针都走完两个链表，相遇的节点即为第一个公共节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 借助 set 集合进行判断
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
