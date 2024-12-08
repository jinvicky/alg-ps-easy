package com.jinvicky.greedy.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 성능은 느리지만 일단 1번에 풀었다!!
 * 소요시간 15분 내외
 *
 * [나의 풀이]
 * A 토끼가 1이라고 대답한다면 실제로 A 색깔의 토끼는 2마리다. (본인 제외 1이라고 대답했으므로)
 * 토끼의 answer+1을 그룹으로 정하고 map의 key로 잡는다.
 * 색깔별로 키를 잡는 것이 아니라 그룹이 꽉차면 해당 색깔의 토끼는 꽉찼다고 생각하고 그룹을 초기화한다.
 *
 * 최종적으로 map에 존재하는 그룹들은 key의 개수만큼 정답에 +=해준다.
 *
 * [오래걸린점]
 * 원시형 배열은 내림차순 정렬할 때 Collections.reverseOrder()가 안 먹힌다.
 * => 그럼 오름차순 정렬하고 for문으로 뒤에서부터 접근하면 된다!
 */
public class RabbitInForest {

    public int numRabbitsBetterPf(int[] answers) {
        int ans = 0;
        int[] count = new int[1000];

        for (final int answer : answers) {
            if (count[answer] % (answer + 1) == 0) { // 소위, 그룹이 꽉 찼다.
                // answer+1로 나누어떨어진다는 것은 answer+1의 배수라는 것. count[answer] 계속 증가한다.
                ans += answer + 1; // 한 그룹의 크기 추가
            }
            ++count[answer]; // 앞에 ++하지 않으면 위의 if문 계산이 틀린다. 또한 이 순서여야만 한다.
        }
        return ans;
    }


    public int numRabbits(int[] answers) {
        Map<Integer, Integer> rbMap = new HashMap<>();
        Arrays.sort(answers);

        int minRabbits = 0; // 최소 토끼는 몇마리인가
        for (int i = answers.length - 1; i >= 0; i--) { // 정답이 큰 토끼부터 계산한다.
            if (answers[i] == 0) {
                // 유일 토끼는 맵에 저장하지 않고 바로 정답에 더한다.
                minRabbits++;
                continue;
            }
            int key = answers[i] + 1;

            int prevValue = rbMap.getOrDefault(key, 0);
            if(prevValue == key) {
                minRabbits+=key; // 그룹의 토끼수만큼 더하고 해당 그룹은 삭제한다.
                rbMap.remove(key);
            }
            rbMap.put(key, rbMap.getOrDefault(key, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> m : rbMap.entrySet()) {
            minRabbits+=m.getKey();
        }
        return minRabbits;
    }

    public static void main(String[] args) {
        RabbitInForest solution = new RabbitInForest();
//        System.out.println(solution.numRabbits(new int[]{1, 1, 2}));
        System.out.println(solution.numRabbitsBetterPf(new int[]{0,0,1,1,1}));
    }
}
