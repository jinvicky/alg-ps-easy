package com.jinvicky.greedy.leetCode;

/**
 * [회고]
 * 이게 왜 greedy인지 모르겠다..
 * X를 만나면 2칸 스킵하면 됨.
 */
public class MinimumMovesToConvertString {
    public int minimumMoves2(String s) {
        if (!s.contains("X")) {
            return 0;
        } else if (s.length() == 3) { // X가 있지만 길이가 3이면 최대 1번 치환.
            return 1;
        }

        char[] arr = s.toCharArray();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'X') {
                i += 2;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MinimumMovesToConvertString solution = new MinimumMovesToConvertString();
        System.out.println(solution.minimumMoves2("OOOO"));
        System.out.println(solution.minimumMoves2("OXOX"));
        System.out.println(solution.minimumMoves2("XXXXX"));
    }
}
