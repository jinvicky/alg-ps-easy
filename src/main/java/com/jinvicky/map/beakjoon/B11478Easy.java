package com.jinvicky.map.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 백준 11478번 문제 - 서로 다른 부분 문자열의 개수
 *
 * [오래 걸린 부분]
 * 문자열을 부분적으로 쪼개서 모든 경우의 수를 만들어 내기.
 * 처음에 for문 1개로 했더니 collection이 1개일 때만 나와서
 * for문 2개로 처리함으로써 성공.
 * 중간에 자르는 범위가 range를 벗어날 때 break; 처리를 추가함.
 */
public class B11478Easy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Map<String, Integer> map = new HashMap<>();

        int collectCount = 1;
        for(int j = 0; j < input.length(); j++) {
            for(int i = 0; i < input.length(); i++) {
                if(i + collectCount > input.length()) {
                    break;
                }
                String subStr = input.substring(i, i + collectCount);

                if(!map.containsKey(subStr)) {
                    map.put(subStr, 0); // map의 key 개수가 중요해서 value는 의미 없음.
                }
            }
            collectCount++;
        }
        System.out.println(map.size());
    }
}
