package com.jinvicky.greedy.leetCode;

/**
 * [회고]
 * 동전 거스름돈과 동일한 문제.
 * 가장 큰 분인 60부터 나눗셈과 나머지 연산을 이용해서 풀이.
 */
public class MinimumNumberOfOperationsToConvertTime {

    public int convertTime(String current, String correct) {
        String[] curr = current.split(":");
        String[] corr = correct.split(":");

        int curSum = 0;
        int corSum = 0;

        curSum+=Integer.parseInt(curr[0]) * 60;
        corSum+=Integer.parseInt(corr[0]) * 60;
        curSum+=Integer.parseInt(curr[1]);
        corSum+=Integer.parseInt(corr[1]);

        int neededTime = corSum-curSum;
        int answer = 0;

        int[] times = new int[]{60, 15, 5, 1};
        for(int tm : times) {
            answer += neededTime / tm;
            neededTime %= tm;
        }
        return answer;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToConvertTime solution = new MinimumNumberOfOperationsToConvertTime();
        System.out.println(solution.convertTime("02:30", "04:35"));
    }
}
