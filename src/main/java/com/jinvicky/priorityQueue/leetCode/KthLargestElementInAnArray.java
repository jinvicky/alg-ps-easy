package com.jinvicky.priorityQueue.leetCode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode 215. Kth Largest Element in an Array
 *
 * [오래걸린부분]
 * 문제를 잘못 해석해서 중복 숫자를 제외하는 줄 알았음
 *
 * [풀이]
 * 보통 Arrays.sort()를 해야 하는데 우선순위 큐를 사용하면 자동으로 정렬이 된다.
 * 내림차순으로 정렬된 배열에서 k번째 수를 poll()해서 가져오면 된다.
 * 배열로 더 빨리 처리하는 법도 있지만 유형이 우선순위 큐이므로 이걸로 정리
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) {
            pq.add(num);
        }

        int ans = 0;
        while(k-- > 0) {
          ans = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
