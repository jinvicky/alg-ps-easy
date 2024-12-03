package com.jinvicky.greedy.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountPrefixesOfAGivenString {

    public int countPrefixes(String[] words, String s) {
        StringBuilder sb = new StringBuilder();
        String[] prefixArr = new String[s.length()];

        char[] toChar = s.toCharArray();
        for (int i = 0; i < toChar.length; i++) {
            sb.append(toChar[i]);
            prefixArr[i] = sb.toString();
        }
        int count = 0;
        Arrays.sort(words);
        for (String w : words) {
            // 단어가 1글자인 경우
            if (w.length() == 1) {
                if (w.startsWith(String.valueOf(prefixArr[0]))) {
                    System.out.println("w = " + w);
                    count++;
                }
            } else {
                // w는 2글자 이상인데 pfx가 1글자인 경우를 어떻게 할 것인가?
                boolean flag = false;
                for (String pfx : prefixArr) {
                    flag = w.startsWith(String.valueOf(pfx));
                    if(flag) {
                        count++;
                        break;
                    }
//                    System.out.println("flag = " + flag + " and " + pfx + " and " + w);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CountPrefixesOfAGivenString solution = new CountPrefixesOfAGivenString();
        System.out.println(solution.countPrefixes(new String[]{"a", "b", "c", "ab", "bc", "abc"}, "abc"));
        System.out.println(solution.countPrefixes(new String[]{"feh", "w", "w", "lwd", "c", "s", "vk", "zwlv", "n", "w", "sw", "qrd", "w", "w", "mqe", "w", "w", "w", "gb", "w", "qy", "xs", "br", "w", "rypg", "wh", "g", "w", "w", "fh", "w", "w", "sccy"}, "w"));
    }
}
