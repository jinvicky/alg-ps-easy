package com.jinvicky.dp.leetCode;


/**
 * [링크] https://leetcode.com/problems/divisor-game/
 * [문제]
 * Alice와 Bob이 번갈아 가며 1부터 n까지의 숫자 중 하나를 선택하고, 그 숫자의 약수를 제거하는 게임.
 * Alice가 이길 수 있는지 여부를 반환.
 * [풀이]
 * n이 짝수이면 Alice가 이기고, 홀수이면 Bob이 이긴다.
 * 따라서 n이 짝수인지 홀수인지에 따라 결과를 반환한다.
 * 사실 DP라고 할 수 있나? 싶을 정도로 짝수면 true, 홀수면 false로 결정되는 간단한 문제이다.
 * 코드 어려움이 아니라 문제 파악이 더 어려운 문제
 */
class Solution {
    public boolean divisorGame(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2)
            return true;
        if (n == 3)
            return false;

        boolean[] dp = new boolean[n+1];

        dp[1] = false;
        dp[2] = true;
        dp[3] = false;

        for(int i = 4; i <= n; i++) {
            dp[i] = !dp[i-1];
        }
        return dp[n];
        // 위 풀이는 dp를 생각하며 틀딱으로 풀었고, 사실 return n % 2 == 0; 가 답이다.
    }
}
