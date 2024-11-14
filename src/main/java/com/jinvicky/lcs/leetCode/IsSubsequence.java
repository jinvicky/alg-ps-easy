package com.jinvicky.lcs.leetCode;

/**
 * LeetCode 392. Is Subsequence
 *
 * [회고]
 * 푸는데 어려움은 없었고, 20분 내로 푼 듯.
 * [오래 걸린 부분]
 * pointer가 이미 range에 도달했다면 바로 return true하는 부분을 for문에 추가했어야 했는데 안 해서 좀 걸렸다.
 *
 * [개선]
 * s와 t가 같을 때 = true
 * s의 길이 > t의 길이일 때 = false로 사전에 return하면 좋을듯?
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
          // 개선::
//        if(s.equals(t)) {
//            return true;
//        } else if (s.length() > t.length()) {
//            return false;
//        }

        int pointer = 0;
        int range = s.length();

        for (int i = 0; i < t.length(); i++) {
            if (pointer >= range) {
                return true;
            }
            if (s.charAt(pointer) == t.charAt(i)) {
                pointer++;
            }
        }
        return pointer >= range;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence.isSubsequence("axc", "ahbgdc"));
    }
}
