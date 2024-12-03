package com.jinvicky.lcs.leetCode;


/**
 * LeetCode 1897. Redistribute Characters to Make All Strings Equal
 * <p>
 * [난이도] - EASY
 * <p>
 * [회고]
 * slice 계산이 어려웠다.
 * 중간에 IS_DIFF의 경우 바로 break;를 했어야 했는데 그러지 못해서 마지막 테스트 케이스에서 에러 해결하느라 오래 걸렸다.
 */
public class MakeThreeStringsEqual {

    private boolean isSame(char ch1, char ch2) {
        return ch1 == ch2;
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        int minLength = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        int slice = -1;
        for (int i = 0; i < minLength; i++) {
            final boolean IS_DIFF = !(isSame(s1.charAt(i), s2.charAt(i)) && isSame(s2.charAt(i), s3.charAt(i)));

            if (IS_DIFF) {
                if (i == 0) return -1;

                if (i <= minLength - 1) {
                    slice = i;
                    break;
                } else {
                    slice = minLength;
                }
            }
        }
        if (slice == -1) {
            slice = minLength;
        }
        // 각 문자열의 길이에서 slice 포인터를 뺀 다음에 다 더하면 총 지워야 할 연산의 count가 나온다.
        return (s1.length() - slice) + (s2.length() - slice) + (s3.length() - slice);
    }

    public static void main(String[] args) {
        MakeThreeStringsEqual makeThreeStringsEqual = new MakeThreeStringsEqual();
        System.out.println(makeThreeStringsEqual.findMinimumOperations("abc", "abb", "ab"));
        System.out.println(makeThreeStringsEqual.findMinimumOperations("dac", "bac", "cac"));
        System.out.println(makeThreeStringsEqual.findMinimumOperations("oby", "obz", "obf"));
        System.out.println(makeThreeStringsEqual.findMinimumOperations("kui", "m", "v"));
        System.out.println(makeThreeStringsEqual.findMinimumOperations("aca", "abcc", "accba"));
    }
}
