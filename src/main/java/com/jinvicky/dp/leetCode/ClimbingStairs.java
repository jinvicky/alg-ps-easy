package com.jinvicky.dp.leetCode;

/**
 * [링크] https://leetcode.com/problems/climbing-stairs/description/?envType=problem-list-v2&envId=dynamic-programming
 * [문제]
 * 계단을 1번에 1칸 또는 2칸만 올라갈 수 있다.
 * 주어진 n칸의 계단을 오르는 방법의 수를 구하라.
 * [풀이]
 * 예시에서 값이 n=3일 때까지 주어진다.
 * 1일때는 당연히 1로만 1개의 방법으로 올라가고,
 * 2일때는 1칸씩 2번 올라가거나, 2칸을 한 번 올라가는 2가지 방법이 있다.
 * 3일때는 3가지 방법이 있다.
 * 결론은 초기화만 예시 케이스로 설정한 피보나치다.
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1]; // +1 길이로 생성할 것

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) { // <= n 으로 할 것. < 아님.
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}