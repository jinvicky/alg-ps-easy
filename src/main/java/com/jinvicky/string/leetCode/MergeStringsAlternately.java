package com.jinvicky.string.leetCode;

/**
 * LeetCode 1768. Merge Strings Alternately
 *
 * [과제]
 * 1. 로직 외우기
 * - 두 문자열의 공통 최소 길이를 구해서 그만큼 sb.append()를 한다.
 * - 두 문자열 중에 min 길이보다 긴 문자열을 구해서 substring()한 값을 그대로 붙인다.
 */
public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        int min = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < min; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if(word1.length() == min) {
            // 예를 들면 2부터 시작해서 4까지 substring()을 하면 2, 3까지 나온다.
            // 문자열이니까 0부터 시작하겠지?
            sb.append(word2.substring(min, word2.length()));
        } else {
            sb.append(word1.substring(min, word1.length()));
        }

        return sb.toString();
    }
}
