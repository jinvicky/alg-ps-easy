package com.jinvicky.array.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * [난이도]
 * 진짜 쉬움
 *
 * [포인트]
 * 무조건 처음과 마지막은 peak가 될 수 없다. range에서 양끝을 제외하고 for문을 돌린다.
 * prev와 next보다 크면 peak다.
 */
public class FindThePeaks {

    public List<Integer> findPeaks(int[] mountain) {
        if(mountain.length < 3) {
            return new ArrayList<>();
        }

        // first, last를 제외한 범위
        int s = 1;
        int e = mountain.length - 2;
        List<Integer> indices = new ArrayList<>();

        for(int i = s; i <= e; i++) {
            if(mountain[i] > mountain[i-1] && mountain[i]> mountain[i+1]) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        FindThePeaks solution = new FindThePeaks();
        System.out.println("solution = " + solution.findPeaks(new int[] {2,4,4}));
        System.out.println("solution = " + solution.findPeaks(new int[] {1,4,3,8,5}));
    }
}
