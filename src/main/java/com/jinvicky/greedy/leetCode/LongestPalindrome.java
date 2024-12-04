package com.jinvicky.greedy.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * [내 풀이]
 * 회문수이려면 홀수개인 알파벳이 1개, 그 외 모든 알파벳이 짝수개여야 한다.
 * oddCount로 1개의 홀수개 알파벳만을 허용
 * <p>
 * [성능 분석]
 * 정답이지만 더 높은 성능을 공부하자.
 * <p>
 * betterPf의 과정
 * a : 1 , b : 1, c: 4, d: 2일 때
 * <p>
 * 0+1-1=0
 * 0+1-1=0
 * 0+4=4
 * 4+2=6
 * odd=true이므로 6+1=7
 * <p>
 * [궁금한점]
 * 128번 순회를 거치는데 map을 쓰는게 연산상으로 더 성능이 좋지 않나? 왜 저게 1ms?
 * <p>
 * [답변]
 * 배열 기반 접근은 단순하고 효율적이며, 작은 범위의 키(ASCII 값)를 처리하는 경우, 해시맵보다 훨씬 성능이 좋습니다.
 * HashMap은 키의 범위가 불규칙하거나 유연성이 필요한 경우 적합하지만,
 * 이 문제처럼 **고정된 키 범위(128)**를 다룰 때는 배열 사용이 우수한 성능을 보장합니다.
 */
public class LongestPalindrome {

    public int longestPalindromeBetterPf(String s) {
        int[] count = new int[128]; // 영문 대소문자가 범위이므로 64+64=128
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int len = 0;
        boolean odd = false;

        for (int c : count) {
            if (c % 2 == 0) {
                len = len + c;
            } else {
                len = len + c - 1;
                odd = true;
            }
        }

        if (odd) {
            len = len + 1;
        }
        return len;
    }

    public int longestPalindrome(String s) {
        //일단 길이가 1이고 공백이 아니면
        if (s.length() == 1 && !s.equals(" ")) {
            return 1;
        }

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        int answer = s.length();
        for (Map.Entry<Character, Integer> pair : freqMap.entrySet()) {
            if (pair.getValue() % 2 != 0) {
                if (oddCount == 0) {
                    oddCount++;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        System.out.println(solution.longestPalindromeBetterPf("abccccdd"));
        System.out.println(solution.longestPalindrome("a"));
    }
}
