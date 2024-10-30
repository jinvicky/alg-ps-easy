package com.jinvicky.map.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 백준 1620번 문제 나는야 포켓몬 마스터 이다솜
 * Map을 사용한 기초 of 기초 문제
 * 포켓몬 사전을 map이라고 가정하고,
 * 포켓몬 번호와 포켓몬 이름을 key로 가진 map을 각각 만든 다음에 .get()으로 찾아서 출력한다.
 * Q. 문자인지 숫자인지 어떻게 구별하지?
 * A. 여기서는 항상 숫자로만 구성 혹은 문자로만 구성이었기 때문에
 * => r.readLine()으로 읽어서 첫번째 문자만 Character.isDigit()으로 숫자인지 판별했다.
 */
public class B1620Easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // 26
        int k = Integer.parseInt(input[1]); // 5

        Map<String, Integer> mapByName = new HashMap<>();
        Map<Integer, String> mapByNumber = new HashMap<>();

        for(int i = 0; i < n; i++) {
            // 맵에다가 포켓몬을 저장한다.
            String pokemon = br.readLine();
            int idx = i+1;
            mapByName.put(pokemon, idx);
            mapByNumber.put(idx, pokemon);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < k; i++) {
            String line = br.readLine();
            if(Character.isDigit(line.charAt(0))) {
                String pokemonName = mapByNumber.get(Integer.parseInt(line));
                sb.append(pokemonName).append("\n");
            } else {
                int idx = mapByName.get(line);
                sb.append(idx).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
