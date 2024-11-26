package com.jinvicky.array.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2차원 배열에서 모든 숫자가 정확히 1번씩만 나타난다.
 * 그런데 그 중 한 숫자는 2번 나타나고, 한 숫자는 누락되었다.
 * 2번 나타난 숫자와 누락된 숫자를 차례로 출력해라.
 *
 *
 * [회고]
 * 성능은 중간 등수 정도.
 *
 * [풀이]
 * grid는 항상 n*n이고 모든 숫자가 1번씩 나타나므로 3*3이라면 1부터 9까지 출력된다고 생각했다.
 * 그래서 이중 for문을 1번 돌리되,
 * 1. 원래 1부터 9까지의 합계
 * 2. grid에서의 9개 요소의 합계
 * 3. map을 사용해서 중복되는 숫자를 변수에 저장
 *
 * => 1 - (2-3)을 계산했다.
 */
public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int c = 1;
        int originalSum = 0;
        int gridSum = 0;
        
        int duplidateNum = -100;
        for(int[] items : grid) {
            for(int it : items) {
                int val = map.getOrDefault(it, 0);
                if(val+1 == 2) {
                    duplidateNum = it; // 중복 출력 . ok
                }
                map.put(it, ++val);

                gridSum+=it;
                originalSum+=c;
                c++;
            }
        }
        int omitNum = originalSum - (gridSum - duplidateNum);
        return new int[]{duplidateNum, omitNum};
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues findMissingAndRepeatedValues = new FindMissingAndRepeatedValues();
        int[][] testcase = new int[][]{{9,1,7}, {8,9,2}, {3,4,6}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues.findMissingAndRepeatedValues(testcase)));
    }
}
