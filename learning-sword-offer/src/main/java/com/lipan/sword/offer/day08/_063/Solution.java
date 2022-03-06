package com.lipan.sword.offer.day08._063;

/**
 * 股票的最大利润
 *
 * @author lipan
 * @date 2021-12-11
 */
public class Solution {

    /**
     * 暴力破解法，遍历数组，计算出两两之差，取最大即可，O(n^2)时间复杂度
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 一次遍历，O(n) 时间复杂度
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {

        int minProfit = Integer.MAX_VALUE; // 存储最小值
        int maxProfit = 0; // 存储最大利润

        for (int i = 0; i < prices.length; i++) { // 遍历数组
            if (prices[i] < minProfit) { // 如果当前价格小于最小值，赋值，
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit) { // 否则看当前价格-最小值，是否大于最大利润
                maxProfit = prices[i] - minProfit; // 大于赋值
            }
        }
        return maxProfit; // 返回最大利润
    }
}
