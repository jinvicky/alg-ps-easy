package com.jinvicky.array.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2차원 배열에서 모든 숫자가 정확히 1번씩만 나타난다.
 * 그런데 그 중 한 숫자는 2번 나타나고, 한 숫자는 누락되었다.
 * 2번 나타난 숫자와 누락된 숫자를 차례로 출력해라.
 * <p>
 * <p>
 * [회고]
 * 성능은 중간 등수 정도.
 * <p>
 * [풀이]
 * grid는 항상 n*n이고 모든 숫자가 1번씩 나타나므로 3*3이라면 1부터 9까지 출력된다고 생각했다.
 * 그래서 이중 for문을 1번 돌리되,
 * 1. 원래 1부터 9까지의 합계
 * 2. grid에서의 9개 요소의 합계
 * 3. map을 사용해서 중복되는 숫자를 변수에 저장
 * <p>
 * => 1 - (2-3)을 계산했다.
 */
public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int c = 1;
        int originalSum = 0;
        int gridSum = 0;

        int duplidateNum = -100;
        for (int[] items : grid) {
            for (int it : items) {
                int val = map.getOrDefault(it, 0);
                if (val + 1 == 2) {
                    duplidateNum = it; // 중복 출력 . ok
                }
                map.put(it, ++val);

                gridSum += it;
                originalSum += c;
                c++;
            }
        }
        int omitNum = originalSum - (gridSum - duplidateNum);
        return new int[]{duplidateNum, omitNum};
    }

    /**
     * 상위 50%, 성능 더 높은데 어려웠던 풀이
     */
    public int[] findMissingAndRepeatedValuesBetterPf(int[][] grid) {
        long n = grid.length * grid[0].length;

        long s1 = (long) (n * (n + 1)) / 2;
        long s2 = (long) (n * (n + 1) * (2 * n + 1)) / 6;
        long sum1 = 0; // grid의 모든 요소의 sum을 저장
        long sum2 = 0; // grid의 모든 요소의 제곱의 합을 저장

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum1 += grid[i][j];
                sum2 += (long) grid[i][j] * (long) grid[i][j];
            }
        }

        long val1 = sum1 - s1; // 중복된 값 - 누락된 값
        long val2 = sum2 - s2; // 중복된 값^2 - 누락된 값^2

        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        return new int[]{(int) x, (int) y};
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues findMissingAndRepeatedValues = new FindMissingAndRepeatedValues();
        int[][] testcase = new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues.findMissingAndRepeatedValuesBetterPf(testcase)));
    }
}
