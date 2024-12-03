package com.jinvicky.greedy.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [회고]
 * 맞았으나 느린 5ms 성능
 *
 * [어려웠던 점]
 * 중간에 용량을 늘릴 때 주어진 apple보다 클 때까지 용량을 늘려야 한다.
 *
 * [잘한점]
 * 그리디의 기본인 거스름돈 문제 복습하니 힌트가 보였다.
 */
public class AppleRedistributionIntoBoxes {

    /**
     * 그리디의 기본 : 동전 거스름돈 문제 참고
     */
    public static List<Integer> getChange(int amount, int[] coins) {
        List<Integer> change = new ArrayList<>();

        for (int coin : coins) {
            while (amount >= coin) {
                change.add(coin);
                amount -= coin;
            }
        }
        return change;
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        apple = Arrays.stream(apple)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        // int 배열을 내림차순 정렬하려면 stream을 써서 박싱을 하고 배열로 바꾸는 거였다.;;
        capacity = Arrays.stream(capacity)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int mCnt = 1; //최소 필요한 박스 개수
        int temp = capacity[0]; //용량을 담을 임시 공간
        int cIdx = 1; //용량을 꺼내기 위한 인덱스
        for (int ap : apple) {
            boolean noMoreCapacity = temp < ap;
            if (noMoreCapacity) {
                while (temp < ap) { // 용량이 사과보다 클때까지 최대 n번 동안 늘려야 한다.
                    mCnt++;
                    temp += capacity[cIdx++];
                }
            }
            temp -= ap;
        }
        return mCnt;
    }

    /**
     * 2ms 성능의 정답
     *
     */
    public int minimumBoxesBetterPf(int[] apple, int[] capacity) {
        int sum = 0;

        for(int val : apple) {
            sum = sum + val;
        }
        Arrays.sort(capacity);
        int count = 0;
        int rem = sum;

        for(int i = capacity.length-1; i >=0; i--) {
            if(rem <= capacity[i]) {
                count++;
                break;
            }
            if(rem > capacity[i]) {
                rem = rem-capacity[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AppleRedistributionIntoBoxes solution = new AppleRedistributionIntoBoxes();
        int[] apple = new int[]{5, 5, 5};
        int[] capacity = new int[]{2, 4, 2, 7};
        System.out.println(solution.minimumBoxesBetterPf(apple, capacity));
    }

}
