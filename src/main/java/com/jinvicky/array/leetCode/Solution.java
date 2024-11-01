package com.jinvicky.array.leetCode;

/**
 * LeetCode 238. Product of Array Except Self
 *
 * [회고]
 * 풀긴 풀었는데 이 친구를 10분 안에 못 풀면 코테는 어림도 없을 것 같아....
 *
 * [나의 풀이]
 * 0이 1개 이상이면 모든 값이 0이다.
 * 0이 1개면 0인 본인 제외 전부 0이다.
 * 0이 0개라면 전체 arr[nums.length -1]에서 본인을 나누기 한다.
 *
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int zeroCount = 0;

        arr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
                arr[i] = arr[i-1];
            } else {
                // 잘 틀림:: 재사용을 하려면 nums[i-1]이 아니라 arr[i-1]이다. dp 때도 틀리더니
                arr[i] = arr[i-1] * nums[i];
            }
        }

        if(zeroCount > 1) {
            return new int[nums.length];
        } else if (zeroCount == 1) {
            int[] result = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    result[i] = arr[nums.length-1];
                }
            }
            return result;
        } else {
            //0이 없는 경우
            int[] result = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                result[i] = arr[nums.length-1] / nums[i];

            }
            return result;
        }
    }

    /**
     * [더 효율적인 풀이]
     * 1. 왼쪽부터 오른쪽 끝까지 nums[i]를 곱한 값을 newArr[i]에 넣는다.
     * 2. 오른쪽부터 왼쪽끝까지
     * 2-1. newArr[i] * rightValue를 newArr[i]에 넣는다.
     * 2-2. rightValue * nums[i]를 rightValue에 넣는다.
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] newArr = new int[nums.length];

        int leftValue = 1;
        for(int i = 0; i < nums.length; i++) {
            // 순서가 중요하다. 적용 - 계산이다.
            newArr[i] = leftValue;
            leftValue*=nums[i];
        }

        int rightValue = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            newArr[i]*=rightValue;
            rightValue*=nums[i]; // newArr이 아닌 nums에서 곱한다는 것이 중요하다.
        }

        // 결과적으로 newArr은 left[i]과 right[i]의 곱이다. 그래서 음수는 양수도 되고 그럼~
        return newArr;
    }

        public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        int[] result = solution.productExceptSelf(nums);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}