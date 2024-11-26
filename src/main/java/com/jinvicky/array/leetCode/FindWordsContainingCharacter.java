package com.jinvicky.array.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * [풀이]
 * 리스트에 중복 인덱스가 들어가는 것을 방지하기 위해서
 * 1. answer가 비었으면 그냥 추가한다.
 * 2. 1이 아니면서 + list의 마지막 요소와 다르면 추가한다.
 *
 *
 * [변수명]
 * 단순히 answer말고 인덱스들을 반환하는 것이니 indices로 짓는 게 좋겠다.
 *
 */
public class FindWordsContainingCharacter {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (ch == x) {
                    if(indices.isEmpty()) {
                        indices.add(i);
                    } else if (indices.get(indices.size()-1) != i) {
                        indices.add(i);
                    }
                }
            }
        }
        return indices;
    }

    /**
     * 더 높은 성능
     */
    public List<Integer> findWordsContainingBetterPf(String[] words, char x) {
      List<Integer> indices = new ArrayList<>();
      for(int i = 0; i < words.length; i++) {
          if(words[i].indexOf(x) != -1) {
              indices.add(i);
          }
      }
      return indices;
    };
}
