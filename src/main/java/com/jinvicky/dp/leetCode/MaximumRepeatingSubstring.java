package com.jinvicky.dp.leetCode;

/**
 * [링크] https://leetcode.com/problems/maximum-repeating-substring/description/?envType=study-plan&id=dynamic-programming-i
 * [문제]
 * sequence에서 word의 최대 반복 count를 구하라.
 * [풀이]
 * 왜 DP일까?
 * dp는 1. 메모이제이션, 2. 혹은 연속된 반복 횟수를 “각 지점까지” 효율적으로 누적해서 계산하고 싶을 때 사용한다.
 * 반복 횟수를 "누적"해서 사용하고 싶다
 * == 누적해놨다가 여기에 더해서 결과를 내고 싶다 하면 DP를 떠올려야 한다.
 *
 * word를 직접 += 하면 제곱으로 늘어나기 때문에 repeat이라는 메모이제이션 변수가 필요하다.
 */
class Solution {
    public int maxRepeating(String sequence, String word) {
        String repeat = word; // 반복할 DP 공간
        int count = 0;
        while(sequence.contains(repeat)) { // 주어진 문자열이 repeat을 포함하는 동안 반복
            count++;
            repeat += word;
        }
        return count;
    }
}