package com.jinvicky.array.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [회고]
 * 맞았는데 성능이 너무 낮다.
 * 전제조건 : n1과 n2에 모두 존재하는 숫자여야 한다.
 * 결괏값: [n2에 존재하는 숫자의 count, n1에 존재하는 숫자의 count]
 */
public class FindCommonElementsBetweenTwoArrays {
    public int[] findIntersectionValues(int[] nums1,
                                        int[] nums2) {
        /**
         * n1과 n2 배열 사이에서 공통된 숫자를 찾아. 그 숫자가 있는 인덱스들의 총 개수를 구한다.
         */
        Map<Integer, Integer> n1Count = new HashMap<>();
        Map<Integer, Integer> n2Count = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int count = n1Count.getOrDefault(nums1[i], 0);
            n1Count.put(nums1[i], ++count);
        }

        for (int i = 0; i < nums2.length; i++) {
            int count = n2Count.getOrDefault(nums2[i], 0);
            n2Count.put(nums2[i], ++count);
        }

        int[] answer = new int[]{0, 0};
        for (Map.Entry<Integer, Integer> n1 : n1Count.entrySet()) {
            for (Map.Entry<Integer, Integer> n2 : n2Count.entrySet()) {
                if (n1.getKey().equals(n2.getKey())) {
                    answer[0] += n1.getValue();
                    answer[1] += n2.getValue();
                }
            }
        }
        return answer;
    }

    /**
     * map을 쓰지 않고 그냥 이중 for문을 2번 사용하는 것이 더 성능이 좋다.
     * 공간적 성능도 더 좋다...
     */
    public int[] findIntersectionValuesBetterPf(int[] nums1,
                                                int[] nums2) {
        int ans1 = 0;
        int ans2 = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    ans1++;
                    break;
                }
            }
        }

        for (int i : nums2) {
            for (int j : nums1) {
                if (i == j) {
                    ans2++;
                    break;
                }
            }
        }
        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        FindCommonElementsBetweenTwoArrays findCommonElementsBetweenTwoArrays = new FindCommonElementsBetweenTwoArrays();
        int[] nums1 = {4, 3, 2, 3, 1};
        int[] nums2 = {2, 2, 5, 2, 3, 6};
        int[] result = findCommonElementsBetweenTwoArrays.findIntersectionValuesBetterPf(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println("result[i] = " + result[i]);
        }
    }
}
