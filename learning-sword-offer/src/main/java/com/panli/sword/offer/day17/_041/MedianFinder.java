package com.panli.sword.offer.day17._041;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 *
 * 建立两个堆，一个大顶堆，一个小顶堆。先放入谁，奇数时就取谁的堆顶元素，偶数时就取两个堆顶元素平均即可；
 *
 * @author lipan
 * @date 2021-12-19
 */
public class MedianFinder {

    Queue<Integer> small, big;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        small = new PriorityQueue<>(); // 小顶堆
        big = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆
    }

    public void addNum(int num) {
        if (small.size() == big.size()) {
            small.add(num);
            big.add(small.poll());
        } else {
            big.add(num);
            small.add(big.poll());
        }
    }

    public double findMedian() {
        return big.size() == small.size() ? (big.peek() + small.peek()) / 2.0 : big.peek();
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */