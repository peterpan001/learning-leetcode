package com.lipan.sword.offer.day01._030;

import java.util.Stack;

/**
 * @author lipan
 * @description 包含 min 函数的栈
 * @date 2021-12-07
 */
public class MinStack {

    Stack<Integer> normalStack; // 存储正常元素
    Stack<Integer> sortStack; // 存储有序元素，即存储当前最小元素，故取最小数时，即从此容器取

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        normalStack = new Stack<Integer>();
        sortStack = new Stack<Integer>();
    }

    /**
     * 元素进栈
     *
     * @param x
     */
    public void push(int x) {
        normalStack.push(x);
        if(sortStack.empty() || sortStack.peek() >= x){
            sortStack.push(x);
        }
    }

    /**
     * 出栈
     */
    public void pop() {
        if(normalStack.pop().equals(sortStack.peek())){
            sortStack.pop();
        }
    }

    /**
     * 栈顶元素
     *
     * @return
     */
    public int top() {
        return normalStack.peek();
    }

    /**
     * 栈最小元素
     *
     * @return
     */
    public int min() {
        return sortStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
