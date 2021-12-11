package com.panli.sword.offer.common;

/**
 * 复杂链表
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Node {

    public int val;

    public Node next;

    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
