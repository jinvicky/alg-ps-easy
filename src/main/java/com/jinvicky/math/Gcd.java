package com.jinvicky.math;

/**
 * 최대공약수뿐만 아니라
 *
 * 숫자, 문자열을 비교하면서 공통 부분을 찾고 싶을 때 많이 사용하는 GCD 알고리즘
 */
public class Gcd {

    /**
     * 두 수의 최대공약수 구하기
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 세 수의 최대공약수의 약수의 개수 구하기 (유클리드 호제법)
     */
    public int gcdOfThree(int a, int b, int c) {
        int answer = 0;
        int min = 0;
        int gcd = 0;

        min = Math.min(Math.min(a,b), c);

        // 최대를 구하려면 큰->작은수가 효율적이다.
        for(int i = min; i > 0; i--) {
            if(a%i ==0 && b%i==0 && c%i==0) {
                gcd = i;
                break;
            }
        }

        for(int i = 1; i <= gcd; i++) {
            if(gcd % i == 0) { // 1부터 gcd까지 수 중에서 나누어떨어지면 약수에 해당한다.
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;

        System.out.println("num1 and num2 = " + num1 + " and " + num2);
        System.out.println("gcd(num1, num2) = " + gcd(num1, num2));
        
        int a = 24;
        int b = 9;
        int c = 15;
        int ret = new Gcd().gcdOfThree(a, b, c);

        System.out.println("ret = " + ret);
    }
}
