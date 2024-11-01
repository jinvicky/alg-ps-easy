package com.jinvicky.string.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 443. String Compression
 * <p>
 * [후기]
 * 느린 성능이지만 성공! 소요시간은... 6시간..?
 * <p>
 * [회고]
 * 메서드로 다 분리하고 로직 합치니까 더 단위적으로 생각할 수 있어서 범위를 좁힐 수 있어서 좋았음.
 * <p>
 * [int에서 char로 형변환하는 방법]
 * Integer -> String(String.valueOf) -> Character 식으로 변경한다.
 * [int -> string하는법]
 * 1. Integer로 만든 다음에 (이는 객체니까) toString()을 한다.
 * 2. String.valueOf()를 사용한다.
 * <p>
 * [char의 초깃값 설정]
 * - 결국 캐릭터들도 아스키다. 'A'보다 0을 추천한다.
 * char ch = 0;
 *
 * 일단 푸는 거니까 향상 for문인지 그냥 for문인지는 너무 심각하게 따지지 말자.
 */
public class StringCompression {

    public boolean isEnd(char[] chars, int i) {
        // 대체 언제 알파벳이 끝났다는 것을 알까?
        // 1. 내가 chars.length -1 까지 갔을 때, 내 다음 문자가 없을때지.
        if (i == chars.length - 1) {
            return true;
        }
        // 2. 내 다음 문자가 나와 다를 때
        if (chars[i] != chars[i + 1]) { // 이래도 위에서 length-1일 때를 걸렀으니 괜찮겠지
            return true;
        }
        return false;
    }

    public int compress(char[] chars) {
        int size = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            if (isEnd(chars, i)) {
                int count = map.get(currentChar);
                if (count == 1) {
                    chars[size++] = currentChar;
                } else {
                    chars[size++] = currentChar;
                    String toStr = String.valueOf(count);
                    for (int k = 0; k < toStr.length(); k++) {
                        chars[size++] = toStr.charAt(k);
                    }
                }
                map.remove(currentChar);
            }
        }
        return size;
    }

    /**
     * 투 포인터를 사용한 풀이 (그나마 이해하기 쉽고 성능 좋음)
     * 시간 복잡도는 O(n), 공간 복잡도는 O(1)
     */
    public int compressAnswer(char[] chars) {
        int ans = 0;

        for(int i = 0; i < chars.length;) {
            final char letter = chars[i];
            int count = 0;

            // 입력 배열에서 연속된 문자 개수 세기
            while(i < chars.length && chars[i] == letter) {
                ++count;
                ++i;
            }

            // 압축된 배열에 문자 쓰기
            chars[ans++] = letter;

            // 개수가 1보다 크면 개수도 압축된 배열에 쓰기
            if(count > 1) {
                for(final char c : String.valueOf(count).toCharArray()) {
                    chars[ans++] = c;
                }
            }
        }
        return ans; // 압축된 배열의 길이 반환
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();

        char[] input = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        input = new char[]{'a', 'b', 'c'}; // 통과

        int sliceIdx = stringCompression.compressAnswer(input);
        for (int i = 0; i < sliceIdx; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

