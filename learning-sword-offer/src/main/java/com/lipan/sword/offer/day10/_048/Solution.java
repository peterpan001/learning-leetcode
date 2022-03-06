package com.lipan.sword.offer.day10._048;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 *
 * @author lipan
 * @date 2021-12-13
 */
public class Solution {

    /**
     * 动态规划思路：
     * 状态定义：设动态规划列表 dp ，dp[j] 代表以字符 s[j] 为结尾的 “最长不重复子字符串” 的长度。
     * 转移方程：固定右边界 j ，设字符 s[j] 左边距离最近的相同字符为 s[i] ，即 s[i] = s[j]
     * 1. 当 i < 0，即 s[j]左边无相同字符，则 dp[j] = dp[j-1] + 1；
     * 2. 当 dp[j - 1] < j - i，说明字符 s[i]在子字符串 dp[j-1] 区间之外 ，则 dp[j] = dp[j - 1] + 1
     * 3. 当 dp[j−1]≥j−i ，说明字符 s[i] 在子字符串 dp[j-1] 区间之中 ，则 dp[j]的左边界由 s[i]决定，即 dp[j]=j−i
     * <p>
     * 当 i<0 时，由于 dp[j−1]≤j 恒成立，因而 dp[j−1]<j−i 恒成立，因此分支 1. 和 2. 可被合并
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> maps = new HashMap<Character, Integer>();
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = maps.getOrDefault(s.charAt(i), -1); // 获取索引 j
            maps.put(s.charAt(i), i); // 更新哈希表
            tmp = tmp < i - j ? tmp + 1 : i - j; // dp[i - 1] -> dp[i]
            res = Math.max(res, tmp); // max(dp[i - 1], dp[i])
        }
        return res;
    }

    /**
     * 动态规划 + 线性遍历
     * 左边界 i 获取方式： 遍历到 s[j] 时，初始化索引 i = j - 1，向左遍历搜索第一个满足 s[i]=s[j] 的字符即可
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;
            while (j >= 0 && s.charAt(i) != s.charAt(j)) { // 线性查找 j
                j--;
            }
            tmp = tmp < i - j ? tmp + 1 : i - j; // dp[i - 1] -> dp[i]
            res = Math.max(tmp, res); // max(dp[i - 1], dp[i])
        }
        return res;
    }
}
