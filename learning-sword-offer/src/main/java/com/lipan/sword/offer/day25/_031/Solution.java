package com.lipan.sword.offer.day25._031;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author lipan
 * @date 2022-02-09
 */
public class Solution {

    /**
     * 栈的压入、弹出序列，借助栈验证
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
