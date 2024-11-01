package com.jinvicky.map.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1945. Sum of Digits of String After Convert
 *
 * [소요시간]
 * 2시간 14분 걸려서 정답. 성능은 제출자중 보통 수준
 *
 * [헤맴]
 * 맨 처음에 정말 4중 for문까지 갔었다. 문제는 2422로 이루어진 페어가 2개인데 중복이 사라져서 1이 되는 이슈를 해결못했다.
 * 그리고 discussion 보고 힌트 얻어서 해결
 *
 * [오래걸린 부분]
 * * 1과 11이 들어오면 111이 되는데 이를 구분할 수가 없음 => 중복만 식별하면 되므로 그냥 값 뒤에 '-' 붙여서 해결
 *
 * [걍..해]
 * 헷갈리는 부분은 그냥 별도 메서드로 빼버렸다. calcWidth(), calcHeight()
 */
public class EqualRowAndColumnPairs {

    public String calcWidth(int[][] grid, int i) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < grid.length; k++) {
            sb.append(grid[i][k]).append("-");
        }
        return sb.toString();
    }

    public String calcHeight(int[][] grid, int i) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < grid.length; k++) {
            sb.append(grid[k][i]).append("-");
        }
        return sb.toString();
    }

    public int equalPairs(int[][] grid) {
        int ans = 0;
        Map<String, Integer> widthMap = new HashMap<>();
        Map<String, Integer> heightMap = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            String wKey = calcWidth(grid, i);
            String hKey = calcHeight(grid, i);
            widthMap.put(wKey, widthMap.getOrDefault(wKey, 0) + 1);
            heightMap.put(hKey, heightMap.getOrDefault(hKey, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : widthMap.entrySet()) {
            if (heightMap.containsKey(entry.getKey())) {
                int hValue = heightMap.get(entry.getKey());
                ans += (hValue  * entry.getValue());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EqualRowAndColumnPairs equalRowAndColumnPairs = new EqualRowAndColumnPairs();
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        grid = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
//        grid = new int[][]{{13, 13}, {13, 13}};
//        grid = new int[][]{{11, 1}, {1, 11}};
        System.out.println(equalRowAndColumnPairs.equalPairs(grid));
    }
}
