package com.jinvicky.string.leetCode;

/**
 * LeetCode 1071. Greatest Common Divisor of Strings
 *
 * [오답]
 * 1. str1과 str2의 길이 체크를 하는 게 아니야. -> 둘이 붙인거랑 리버스로 붙인 거를 비교하는 것임.
 *
 * [힌트]
 * 두 수, 두 문자열 간의 공통적인 패턴을 찾고 싶다면 gcd를 고려.
 * 왜 최대공약수를 구할까?
 * -> 두 문자열이 공통으로 "나누어지는" 부분 문자열을 찾기 때문에
 *
 * [제일중요]
 * ***문자 x를 여러 번 이어붙여서 str1과 str2를 구성하려면 "x의 길이가 m과 n의 길이의 약수여야 하기 때문이다."***
 */
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        // 앞뒤로 바꿔서 붙여도 동일해야 그것으로 이루어졌다고 할 수 있다.
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // 두 문자열 길이의 최대공약수를 구한다. ABABAB의 경우 2가 나온다.
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a , int b) {
        return b == 0 ? a : gcd(b, a % b);

        // 위 코드 재귀 모르겠으면 아래처럼
//        while(b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings gcd = new GreatestCommonDivisorOfStrings();
        System.out.println(gcd.gcdOfStrings("ABABAB", "ABAB"));
    }
}
