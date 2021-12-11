package com.panli.sword.offer.day03._005;

/**
 * 替换空格
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 借助 StringBuilder 实现
     *
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        if (s == null) {
            return null;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder(); // 声明 StringBuilder 可变字符序列进行存储
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 借助 api 实现
     *
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        if (s == null) {
            return null;
        }
        return s.replace(" ", "%20");
    }

    /**
     * 借助字符数组实现
     *
     * @param s
     * @return
     */
    public String replaceSpace3(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = new char[s.length() * 3];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[idx++] = '%';
                chars[idx++] = '2';
                chars[idx++] = '0';
            } else {
                chars[idx++] = s.charAt(i);
            }
        }
        return new String(chars, 0, idx);
    }
}
