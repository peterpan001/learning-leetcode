package com.lipan.sword.offer.day01._009;


import java.util.Stack;

/**
 * @author lipan
 * @descrition 用两个栈实现队列
 * @date 2021-12-07
 */
public class CQueue {

    Stack<Integer> stackPop; // 队列头栈
    Stack<Integer> stackPush; // 队列尾栈

    public CQueue() {
        stackPop = new Stack<Integer>(); // 队列头栈
        stackPush = new Stack<Integer>(); // 队列尾栈
    }

    // 进队列，进队列尾栈
    public void appendTail(int value) {
        stackPush.push(value);
    }

    // 出队列，出队列头栈
    public int deleteHead() {
        // 如果队列头栈为空，则将队列尾栈数据放入队列头栈
        // 如果队列头栈不为空，直接输出队列头栈的第一个元素
        if (stackPop.isEmpty()) {
            while (stackPush.size() > 0) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.isEmpty() ? -1 : stackPop.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
