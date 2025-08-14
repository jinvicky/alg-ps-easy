package com.jinvicky.dp.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * [링크] https://leetcode.com/problems/pascals-triangle-ii/description/?envType=study-plan&id=dynamic-programming-i
 * [문제]
 * 파스칼의 삼각형의 특정 줄을 반환하라.
 * [풀이]
 * 파스칼의 삼각형 문제에서 주어진 rowsIdx번째 리스트만 반환하면 됨. 응답값 타입만 변형될 뿐 동일.
 * 그리고 rowIdx가 3일 때 실제로 [4]번째 줄이기 때문에 rowsIdx+1 크기의 dp가 필요하다.
 */
class Solution {
    public List<Integer> getRow(int numRows) { // 본래는 int rowIdx다.
        int[][] dp = new int[numRows+1][numRows+1];
        List<List<Integer>> answer = new ArrayList<>();
        if (numRows == 0)
            return List.of(1);
        if (numRows == 1)
            return List.of(1, 1);

        answer.add(new ArrayList<>(List.of(1)));
        // DP 초기화 로직: 모든 줄의 양끝을 1로 초기화한다.
        for (int i = 0; i <= numRows; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        answer.add(new ArrayList<>(List.of(1, 1)));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // 시작을 1로 고정한다.
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // 내 위와 내 왼쪽 대각선을 더한다.
                row.add(dp[i][j]);
            }
            row.add(1); // 끝을 1로 고정한다.
            answer.add(row);
        }
        return answer.get(numRows);
    }
}
