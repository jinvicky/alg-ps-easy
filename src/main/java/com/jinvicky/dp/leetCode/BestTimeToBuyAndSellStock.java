package com.jinvicky.dp.leetCode;

/**
 * [링크] https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * [문제]
 * 주식을 사고 팔아서 얻는 최대 이익을 반환, 단 사기 전에는 팔 수 없음.
 * [풀이]
 * DP 변수로도 해결이 가능하지만, 어째서 매번 dp[] 를 사용해야 문제를 푸는 편이다.
 * 그래서 []로 풀고 변수로 바꾸고 있다.
 * 최댓값을 구하는 것이므로 Math.max()를 떠올리고 + 비교할 최소 구매 가격, 기준 변수를 언제? 업데이트할 건지 생각한다.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int biggest = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - buyPrice;
            biggest = Math.max(biggest, profit);
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
        }

        return biggest;
    }
}