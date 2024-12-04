package com.jinvicky.greedy.leetCode;

import java.util.Arrays;

/**
 * 쉬운 문제로 시간복잡도도 O(n), 그렇지만 더 성능이 좋은 코드를 보고 개선해보자.
 *
 * [피드백]
 *
 * 숫자 연산이 문자열 변환 및 조작 과정보다 간결하고 읽기가 쉽다.
 * 문자열보다 정수형 배열이 메모리가 적게 사용된다.
 * 숫자를 직접 다루니 문자열 조작에 따른 추가 비용이 없어서 더 빠르고 효율적인 연산이 가능하다.
 *
 * Integer.parseInt()와 문자열 사용이 연산을 느리게 한다. (물론 사용해야 하는 경우는 쓰지만, 이 경우는 숫자 연산이 가능했던 문제였기에..)
 */
public class SplitWithMinimumSum {

    public int splitNum(int num) {
        // 숫자를 배열로 치환
        String[] arr = String.valueOf(num).split(""); // 4,3,2,5 문자열 저장
        Arrays.sort(arr); // 2,3,4,5

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                sb1.append(arr[i]);
            } else {
                sb2.append(arr[i]);
            }
        }
        // 다시 숫자로 치환해서 더해서 반환
        return  Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
    }

    public int splitNumBetterPf(int num) {
        int count = 0;
        int n = num;
        while(n > 0) {
            count = count+1;
            n = n / 10;
        }

        int[] arr = new int[count];
        for(int i = 0; i < count; i++){
            int value = num % 10;
            arr[i] = value;
            num = num / 10;
        }

        Arrays.sort(arr);

        int num1 = 0;
        int num2 = 0;

        for(int i = 0; i < arr.length; i+=2) {
            num1 = (num1 * 10) + arr[i];
            if((i+1) < arr.length) {
                num2 = (num2 * 10) + arr[i+1];
            }
        }
        return num1+num2;
    }

    public static void main(String[] args) {
        SplitWithMinimumSum solution = new SplitWithMinimumSum();
        System.out.println(solution.splitNum(4325));
    }
}
