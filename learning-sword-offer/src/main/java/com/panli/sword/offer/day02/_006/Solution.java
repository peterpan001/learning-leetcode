package com.panli.sword.offer.day02._006;

import com.panli.sword.offer.common.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 从尾到头打印链表，借助栈先进后出，即可实现
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {

        if (head == null) { // 如果链表为空，直接返回
            return new int[0];
        }

        ListNode cur = head; // 声明cur指向头节点
        Stack<Integer> stack = new Stack<Integer>(); // 声明栈，存储链表元素

        while (cur != null) { // 将链表元素放入栈中
            stack.push(cur.val);
            cur = cur.next;
        }

        int len = stack.size();
        int[] res = new int[len]; // 声明整型数组，将栈中元素存储，即可完成
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
