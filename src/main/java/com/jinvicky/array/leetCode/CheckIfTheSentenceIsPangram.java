package com.jinvicky.array.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * [짚고 가자]
 * set이면 충분한데 map을 쓰지 말자.
 * String.indexOf()로 가능하다면 공간 비용이 필요없다.
 *
 * 아는 대로 일단 짜고 리팩토링을 하자. 일단 구리더라도 짜라.
 */
public class CheckIfTheSentenceIsPangram {

    /**
     * 클래식대로 풀어보자.
     * 빈도수 배열을 만들고 탐색. 26개로 길이 한정이니 배열이 공간을 덜 차지할 것이라고 판단.
     */
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) {
            return false;
        }
        int[] frequency = new int[26];

        for(char c : sentence.toCharArray()) {
            System.out.println(c-'a');
            frequency[c - 'a']++;
        }

        for(int i = 0; i < frequency.length; i++) {
            if(frequency[i] < 1) {
                return false;
            }
        }
        return true;
    }

    // set이나 map이나... value가 아닌 key 개수로 판단할 거니 set이 더 맞음.
    public boolean checkIfPangram3(String sentence) {
        if(sentence.length() > 26) return false;
        Set<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;
    }

    /**
     * 최고의 성능 정답. 어떠한 자료구조도 쓰지 않고, String.indexOf()로 해결
     * 왜 이걸 생각 못했지?
     */
    public boolean checkIfPangramBestPf(String sentence) {
        if(sentence.length() < 26) {
            return false;
        }
        for(char i = 'a'; i <= 'z'; i++) {
            if(sentence.indexOf(i) == -1) {
                return false;
            }
        }
        return true;
    }

        public static void main(String[] args) {
        CheckIfTheSentenceIsPangram solution = new CheckIfTheSentenceIsPangram();
        System.out.println(solution.checkIfPangramBestPf("thequickbrownfoxjumpsoverthelazydog"));
    }
}
