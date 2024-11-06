package com.jinvicky.bit.leetCode;

/**
 * LeetCode 1318. Minimum Flips to Make a OR b Equal to c
 * <p>
 * [회고]
 * 풀었으나 진법 변환이 부산하다.
 * 비트 연산 학습이 필요함.
 */
public class MinimumFlipsToMake {

    private static String padWithZeros(String str, int maxLength) {
        // 길이가 짧은 문자열에 '0'을 붙임
        StringBuilder paddedString = new StringBuilder(str);
        // 필요한 만큼 '0'을 앞에 추가
        while (paddedString.length() < maxLength) {
            paddedString.insert(0, '0'); // 왼쪽에 '0' 추가
        }
        return paddedString.toString();
    }

    public int minFlips(int a, int b, int c) {
        int ans = 0;

        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);
        String binC = Integer.toBinaryString(c);

        int maxLength = Math.max(binA.length(), Math.max(binB.length(), binC.length()));
        binA = padWithZeros(binA, maxLength);
        binB = padWithZeros(binB, maxLength);
        binC = padWithZeros(binC, maxLength);

        for (int i = 0; i < binC.length(); i++) {
            int ta = binA.charAt(i) - '0';
            int tb = binB.charAt(i) - '0';
            int tc = binC.charAt(i) - '0';

            if (tc == 1) {
                if (ta + tb == 0) {
                    ans += 1;
                }
            } else { // tc==0
                if (ta + tb == 1) {
                    ans += 1;
                } else if (ta + tb == 2) {
                    ans += 2;
                } else {
                    ans += 0;
                }
            }
        }
        return ans;
    }

    public int minFlipsAnswer(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);

            /**
             * a,b,c의 가장 오른쪽 비트
             */
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 0) {
                flips += bitA + bitB;
            } else {
                if (bitA == 0 && bitB == 0) {
                    flips++;
                }
            }

            /**
             * a,b,c를 오른쪽으로 1비트 시프트
             */
            a >>= 1;
            b >>= 1;
            c >>= 1;

            /**
             * abc
             * ---
             * 835
             * 412
             * 201
             * 100
             *
             * 종료
             */
        }
        return flips;
    }

    public static void main(String[] args) {
        int a = 8;
        int b = 3;
        int c = 5;
        MinimumFlipsToMake minimumFlipsToMake = new MinimumFlipsToMake();
        System.out.println(minimumFlipsToMake.minFlipsAnswer(a, b, c));
    }
}
