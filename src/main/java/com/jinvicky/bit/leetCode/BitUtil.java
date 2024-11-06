package com.jinvicky.bit.leetCode;

/**
 * 비트 연산을 활용한 문제 템플릿
 */
public class BitUtil {

    /**
     * a와 b 두 정수의 비트 차이를 계산한다.
     */
    public int countBitDifferences(int a, int b) {
        return Integer.bitCount(a^b);
    }

    /**
     * 숫자 배열 내에서 단일인 숫자를 반환한다.
     * 무슨 항등식을 이용함. 두 숫자가 같으면 0이 나오고 0이랑 단일 숫자랑 계산하면 단일 숫자가 반환됨
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result ^= num;
        }
        return result;
    }

    /**
     * 정수의 비트를 반전한다. 5(0101) -> 2(0010)
     */
    public int invertBits(int n) {
        return~n;
    }

    /**
     * 정수가 2의 제곱인지 확인한다.
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) ==0;
    }


}
