package com.panli.sword.offer.day13._058I;

import java.util.Stack;

/**
 * 反转单词顺序
 *
 * @author lipan
 * @date 2021-12-15
 */
public class Solution {

    /**
     * 利用快慢双指针从右开始遍历即可
     *
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        if (s == null) { // 校验
            return null;
        }
        s = s.trim(); // 去除多余空格
        int i = s.length() - 1; // 定义双指针，其实位置都指向最右边
        int j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) { // 遍历
            while (i >= 0 && s.charAt(i) != ' ') i--; // 不遇到 ' '，一直向左移动
            sb.append(s.substring(i + 1, j + 1)).append(" "); // 截取 i+1, j+1 即为一个单词
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过 ' '
            j = i; // 赋值下一个单词末尾位置
        }
        return sb.toString().trim();
    }

    /**
     * 使用栈解决
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        if (s == null) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            while (j < s.length() && s.charAt(j) != ' ') j++;
            stack.add(s.substring(i, j));
            while (j < s.length() && s.charAt(j) == ' ') j++;
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }
}
