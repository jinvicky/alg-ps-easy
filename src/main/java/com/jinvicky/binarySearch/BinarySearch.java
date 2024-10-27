package com.jinvicky.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(binarySearch.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) { // 타겟보다 중간값이 더 작은 경우 왼쪽의 범위를 중간+1로 좁힌다.
                left = mid + 1;
            } else if (nums[mid] > target) { // 타겟보다 중간값이 더 큰 경우 오른쪽의 범위를 중간-1로 좁힌다.
                right = mid - 1;
            }
        }
        return -1;
    }
}
