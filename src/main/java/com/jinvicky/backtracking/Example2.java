package com.jinvicky.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example2 {

    static int N;
    static int M;
    static int[] list;
    static boolean[] check;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[M];
        check = new boolean[N];

        backTracking(0);
        br.close();
        System.out.println(sb);
    }

    static void backTracking(int row) {
        if (row == M) {
            for(int value : list) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(check[i] == false) {
                check[i] = true; // 방문여부 true로 놓기
                list[row]= i+1;
                backTracking(row+1);
                check[i] = false;
            }
        }
    }
}
