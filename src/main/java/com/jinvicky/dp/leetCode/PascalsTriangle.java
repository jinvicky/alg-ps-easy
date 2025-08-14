package com.jinvicky.dp.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * [링크] https://leetcode.com/problems/pascals-triangle/description/?envType=study-plan&id=dynamic-programming-i
 * [문제]
 * 파스칼의 삼각형을 생성하라.
 * [풀이]
 * 나동빈의 정삼각형 문제랑 똑같다. 결론은 내 왼쪽 대각선과 내 위쪽 값을 더하는 것이다.
 * 하지만 2차원 배열을 정삼각형 별찍기처럼 구현하려고 하지 마라. 왼직사각형 형태로도 충분하다.
 * 5줄이 주어졌을 때
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 *
 * 피보나치처럼 특정 줄 이하는 그냥 사전에 결과 리턴해라.
 * 중요한건 배열의 2번째부터다. + 삼각형의 양 끝은 무조건 1로 끝난다.
 * DP 초기화 로직은 다음줄의 DP 연산을 위해서 필요하고, 한줄을 완성할 때는 별개로 시작과 끝에 1을 하드로 넣어야 한다.
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows]; // 혹은 [6][6]?
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(List.of(1)));

        if (numRows == 1)
            return answer;

        // DP 초기화 로직: 모든 줄의 양끝을 1로 초기화한다.
        for (int i = 0; i < numRows; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        answer.add(new ArrayList<>(List.of(1, 1)));

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // 시작을 1로 고정한다.
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // 내 위와 내 왼쪽 대각선을 더한다.
                row.add(dp[i][j]);
            }
            row.add(1); // 끝을 1로 고정한다.
            answer.add(row);
        }
        return answer;
    }
}