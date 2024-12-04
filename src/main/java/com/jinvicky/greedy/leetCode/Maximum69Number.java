package com.jinvicky.greedy.leetCode;

/**
 * [회고]
 * SplitWithMinimumSum을 보고 문자열으로 변환 대신 int 계산식으로 풀었더니 성능 beat 100% 나왔다!
 * <p>
 * [어려웠던 점]
 * 아직 자릿수를 구하고, 배열로 출력하고 더해보는 과정에 테스트와 교정이 오래 걸린다.
 * d를 직접적으로 갱신하지 않아야 하며, 자릿수는 역순이지만, 실제로 arr에 넣어야 하는 인덱스는 순차이므로,
 * for문 변수 외에 별도 fToL 카운터를 두어서 그것으로 배열의 인덱스를 사용했다.
 * <p>
 * [유사 문제]
 * 2578. Split With Minimum Sum
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        int count = 0; // num의 자릿수
        int n = num;
        // 0. 9996의 자릿수를 출력한다. ok
        while (n > 0) {
            count++;
            n /= 10;
        }

        // 1. 9996을 숫자 배열로 출력해본다. ok
        int[] arr = new int[count];
        boolean fliped = false;
        int fToL1 = 0;
        for (int i = count - 1; i >= 0; i--) {
            int d = num / (int) Math.pow(10, i);

            boolean flipRequired = d != 9 && !fliped;
            if (flipRequired) {
                arr[fToL1] = 9;
                fliped = true;
            } else {
                arr[fToL1] = d;
            }
            num = num - (d * (int) Math.pow(10, i)); // WARN:: d=9식으로 직접적으로 건드리면 여기서 num 갱신에 실패한다.
            fToL1++;
        }

        // 이제 다 더해야 한다.
        int maxNumber = 0;
        int fToL = 0;
        for (int j = count - 1; j >= 0; j--) {
            int zeros = (int) Math.pow(10, j);
            maxNumber += zeros * arr[fToL];
            fToL++;

        }
        return maxNumber;
    }

    /**
     * 현타오는 동일 성능 간결 정답
     * 흠... 문자열 변환이 성능이 느린게 아니라 그냥 내가 한게 구린 거임...
     * 그래도 시도에 의의를 둠...
     */
    public int maximum69NumberBetterPf(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        for(int i = 0; i < digits.length; i++) {
            if(digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        Maximum69Number solution = new Maximum69Number();
        System.out.println(solution.maximum69Number(9996));
        System.out.println(solution.maximum69Number(9669));
    }
}
