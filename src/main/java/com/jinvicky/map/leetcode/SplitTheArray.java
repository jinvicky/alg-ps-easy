package com.jinvicky.map.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [실수]
 * key로 value를 조회해야 하는데 value를 키로 조회하는 실수를;;
 * <p>
 * 성능은 3ms
 */
public class SplitTheArray {

    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int key : nums) {
            int cnt = map.getOrDefault(key, 0) + 1;
            System.out.println(key + " and + cnt = " + cnt);
            map.put(key, cnt);
        }

        return false;
    }

    /**
     * 2ms 성능
     * 이제 map으로 쉽게 푼다면 배열로 바꿔서 공간을 절약할 수 없는지 확인하는 연습을 해야 한다.
     */
    public boolean isPossibleToSplitBetterPf(int[] nums) {
        int counts[] = new int[101];
        for (int i : nums) {
            if (counts[i] >= 2) {
                return false;
            }
            counts[i]++;
        }
        return true;
    }

    public static void main(String[] args) {
        SplitTheArray solution = new SplitTheArray();
        int[] arr = new int[]{1, 1, 2, 2, 3, 4};
        System.out.println(solution.isPossibleToSplit(arr));
    }
}

