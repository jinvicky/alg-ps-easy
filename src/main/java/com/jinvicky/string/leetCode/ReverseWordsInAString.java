package com.jinvicky.string.leetCode;

/**
 * LeetCode 151. Reverse Words in a String
 *
 * [꿀팁]
 * " "를 기준으로 자른다.
 * 문장의 앞뒤의 " "들은 전부 제거한다.
 * " "이 여러칸이 붙어 있으면 " " 1칸으로 줄인다.
 * 1. 위 3줄을 아래 1줄로 해결할 수 있다. 그냥 외워.
 * String[] words = s.trim().split("\\s+");
 *
 * 3. 공백 여부 체크를 위해 length() > 0을 사용한다.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--) {
            if(words[i].length() > 0) {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString().trim(); // 최종적으로 앞뒤 빈 공백 제거
    }
}
