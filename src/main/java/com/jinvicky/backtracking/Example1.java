package com.jinvicky.backtracking;

/**
 * 백트래킹은 DFS 위주로 짠다.
 * * 조건에 부합하지 않으면 이전 수행으로 돌아가야 하기 때문이다.
 * * 행렬의 값을 비교할 때 선택한 숫자들의 행과 열이 모두 중복되지 않아야 한다.
 */
public class Example1 {
    static int[][] list;
    static boolean[] check;

    public static void main(String[] args) {
        list = new int[][]{{2,4,3}, {1,3,7}, {6,5,6}};
        check = new boolean[]{false, false, false};

        backTracking(0,0);
    }

    static void backTracking(int row, int score) {
        if(row==3) {
            System.out.println("score = " + score);
            return;
        }

        for(int i =0; i < 3; i++) {
            if(!check[i]) {
                check[i] = true;
                backTracking(row+1, score+list[row][i]);
                check[i]= false;
            }
        }
    }
}
