package com.jinvicky.map.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 백준 1764번 문제 - 듣보잡
 *
 * [오래 걸린 부분]
 * 사전순으로 출력하라는 부분을 떠올리는 게 어려웠음.
 * => TreeMap으로 변경하면 자동적으로 알파벳 오름차순 순서로 정렬할 수 있음
 */
public class B1764Easy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        Map<String, Integer> mapOfHeard = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            mapOfHeard.put(br.readLine(), 0);
        }

        Map<String, Integer> mapOfSeen = new TreeMap<>();

        for(int j = 0; j < k; j++) {
            mapOfSeen.put(br.readLine(), 0);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        // 두 맵에 모두 없는 경우 출력한다.
        for(String key : mapOfHeard.keySet()) {
            if(mapOfSeen.containsKey(key)) {
                sb.append(key).append("\n");
                count++;
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
