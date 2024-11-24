package com.jinvicky.backtracking;

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
