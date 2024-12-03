package com.jinvicky.array.leetCode;

import java.util.Arrays;

/**
 * [회고]
 * 숨겨진 규칙을 찾으면 간단한 문제지만 그렇지 못하면 한없이 힌트가 어려웠던 문제
 *
 * alice와 bob이 매 라운드마다 최소 숫자를 집어서 bob, alice 순으로 arr 앞에 넣는다.
 * => 결과값은 배열을 오름차순 정렬한 다음에 i와 i+1을 swap한 것과 같다.
 *
 * 입력값: 5,4,2,3
 * 정렬후: 2,3,4,5
 * 결과값: 3,2,5,4
 *
 * 3과 2를 교체하고 4와 5를 교체하면 정렬후->결과값이 된다.
 *
 * [주의]
 * 반복문에서 2칸씩 이동함을 주의한다.
 */
public class MinimumNumberGame {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i+=2) {
            // i와 i+1을 swap한다.
            int tmp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = tmp;
        }
        return nums;
    }
}
