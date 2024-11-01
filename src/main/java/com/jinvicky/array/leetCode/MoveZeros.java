package com.jinvicky.array.leetCode;

/**
 * LeetCode 283. Move Zeros
 *
 * 쉬운 문제인데 구현에 버벅여서 시간이 오래 걸림.
 *
 * [빠른풀이]
 * 그냥 0이 아닌 것들만 앞에서 미리 채우고 for문 1개 더 추가해서
 * 0이 아닌 마지막 인덱스부터 끝까지를 0으로 채운다.
 */
public class MoveZeros {

    public void moveZeros(int[] nums) {
        int idx = 0;
        int zeroCount = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[idx++] = nums[i];
            } else {
                zeroCount++;
            }
        }

        for(int j = nums.length - zeroCount; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
