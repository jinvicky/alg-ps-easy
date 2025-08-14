package com.jinvicky.dp.leetCode;

/**
 * [링크] https://leetcode.com/problems/is-subsequence/description/?envType=study-plan&id=dynamic-programming-i
 * [문제]
 * 주어진 문자열 s가 t의 부분 수열인지 확인하라.
 * [풀이]
 * s의 각 문자가 t에서 순서대로 나타나는지 확인하는 문제.
 * 빈 문자열 ""일 때와 s가 t보다 짧아서(이미 true를 만족) charAt() 비교가 어려울 때 사전에 return true한다.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int order = 0;
        for (int i = 0; i < t.length(); i++) {
            if (order == s.length()) return true;
            if (t.charAt(i) == s.charAt(order)) {
                order++;
            }
        }
        return order == s.length();
        //  s를 기준으로 잡아버렸더니 풀 수 없었음. 당연함 s는 기준이고 실제 타겟은 t인데!
    }
}
