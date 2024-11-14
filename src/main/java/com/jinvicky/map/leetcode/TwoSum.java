package com.jinvicky.map.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1. Two Sum
 *
 * [포인트]
 * 투 포인터보다 해시맵을 사용하는 것이 더 빠르다. 투 포인터는 배열을 정렬해야 하기 때문이다.
 * 배열을 순차 탐색 O(n)번 하므로, 기존에 해시맵에 있는 값들은 자연스레 i보다 앞에 있는 숫자이기 때문에 leftIndex가 된다.
 * {leftIndex, i}를 반환하면 된다.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];

            if (map.containsKey(search)) {
                int leftIndex = map.get(search);
                return new int[]{leftIndex, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 1};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
