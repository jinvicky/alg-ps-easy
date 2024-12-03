package com.jinvicky.leetCode;


/**
 * LeetCode 62. Unique Paths
 *
 * [소요시간]
 * 15분 내로 정답
 * [오래 걸린 부분]
 * i와 j가 1일 때 continue; 해야 하는데 이 부분 조금 걸렸다.
 *
 * [풀이]
 * 나동빈 코테 책 기본 dp 예제 공식이다.
 * 오른쪽 또는 아래로만 이동할 수 있다고 하면 m과 n이 주어졌을 때 [m+1][n+1] 배열을 만든다.
 * 각 칸은 dp의 본인 왼쪽과 본인 위쪽의 경우의 수의 SUM이다.
 * 계속 dp에서 참조해서 재사용함으로써 O(m*n)의 시간복잡도를 가진다.
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j== 1) {
                    dp[i][j] = 1;
                    continue;
                }

                int fromTop = dp[i-1][j];
                int fromLeft = dp[i][j-1];
                dp[i][j] = fromLeft + fromTop;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
}
