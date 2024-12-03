package com.jinvicky.greedy.leetCode;

import java.util.Arrays;
import java.util.Collections;

public class ArrayPartition {

    /**
     * 6ms 성능
     */
    public int arrayPairSum6ms(int[] nums) {
        int[] exist = new int[20001]; // -10000부터 10000까지의 모든 정수를 표현
        for(int i = 0; i < nums.length; i++) {
            exist[nums[i] +10000]++;
        }

        boolean isOdd = true;
        int res = 0;
        for(int i = 0; i < exist.length; i++) {
            while(exist[i]-- > 0) {
                if(isOdd) {
                    res += i - 10000; // 배열의 인덱스를 실제 값으로 변환하여, 홀수 인덱스에서만 최소값을 더한다.
                    // 쌍의 최소값의 합을 최대화한다고 함...
                }
                isOdd = !isOdd;
            }
        }
        return res;
    }

    /**
     * 12ms 성능 (여기까지가 내 머리 내에서 이해 가능)
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 14ms 성능 (내 코드)
     */
    public int arrayPairSum12ms(int[] nums) {
        nums = Arrays.stream(nums)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int maxSum = 0;

        for(int i = 0; i < nums.length; i+=2) {
            maxSum+= Math.min(nums[i], nums[i+1]);
        }

        return maxSum;
    }
}
