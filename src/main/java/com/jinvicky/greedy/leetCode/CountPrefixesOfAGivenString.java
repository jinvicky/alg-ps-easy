package com.jinvicky.greedy.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * [회고]
 * 삽질을 하다가 이중 for문으로 성능 낮게 풀었다가 답을 보고 충격받은 문제
 *
 * [로직]
 * 접두사 문자열로 가능한 모든 접두사 조합이 있다. 단어들 중에 접두사 조합과 "일치"하는 것의 개수를 반환한다.
 *
 * [포인트]
 * 난 당연히 단어랑 접두사를 비교한다고 생각했다.
 * -> 그러나 반대로 비교한다. 접두사가 단어로 시작하면 카운트를 올린다.
 *
 * abc.startsWith(a) -> yes
 * abc.startsWith(b) -> no
 * abc.startsWith(c) -> no
 * abc.startsWith(ab) -> yes
 * abc.startsWith(bc) -> no
 * abc.startsWith(abc) -> yes
 *
 * [난이도]
 * 코드는 정말 easy함...
 */
public class CountPrefixesOfAGivenString {

    public int countPrefixesBetterPf(String[] words, String s) {
        int count = 0;
        for (String str : words) {
            if (s.startsWith(str)) { // 포인트. 접두사가 단어로 시작하는 지를 비교한다.
                count++;
            }
        }
        return count;
    }

    public int countPrefixes(String[] words, String s) {
        int sumCount = 0;
        Arrays.sort(words);

        //s로 dictionary를 만들기
        Set<String> prefixSett = new HashSet<>();
        String prefix = "";

        for (char c : s.toCharArray()) {
            prefix += c;
            prefixSett.add(prefix);
        }

        for (String w : words) {
            for (String ps : prefixSett) {
                if (w.equals(ps)) {
                    sumCount++;
                    break;
                }
            }
        }
        return sumCount;
    }


    public static void main(String[] args) {
        CountPrefixesOfAGivenString solution = new CountPrefixesOfAGivenString();
        System.out.println(solution.countPrefixes(new String[]{"a", "b", "c", "ab", "bc", "abc"}, "abc"));
        System.out.println(solution.countPrefixes(new String[]{"a", "a"}, "aa"));
        System.out.println(solution.countPrefixes(new String[]{"feh", "w", "w", "lwd", "c", "s", "vk", "zwlv", "n", "w", "sw", "qrd", "w", "w", "mqe", "w", "w", "w", "gb", "w", "qy", "xs", "br", "w", "rypg", "wh", "g", "w", "w", "fh", "w", "w", "sccy"}, "w"));
    }
}
