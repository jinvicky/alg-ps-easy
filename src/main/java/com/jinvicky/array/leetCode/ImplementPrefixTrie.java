package com.jinvicky.array.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 208. Implement Trie (Prefix Tree)
 *
 * [용도]
 * - 트라이 자료구조는 검색어 자동완성 기능에서 언급되는 효율적인 자료구조다.
 * - Trie와 TrieNode로 구성되어 있으며, Trie의 각 알파벳들은 TrieNode[]로 이루어져 있다.
 *         root
 *         / \
 *        c   d
 *       / \   \
 *      a   (o)
 *     / \   \
 *    t   r   g
 *
 * - char마다 TrieNode를 가지며, 차차 연결되는 구조다.
 * - 여기에 dad가 추가된다면 아래 형태를 띈다.
 *
 *         root
 *          |
 *          d
 *         / \
 *        a   o
 *       /     \
 *      d       g
 *
 * [방법]
 * - 면접에서 트라이 구현이 나왔는데 당장 기억이 안 나면 TreeMap이라도 써서 풀어라.
 *
 * [질문]
 * Q. 왜 isEnd()를 확인해야 할까? (또는 단어인지 확인하기 위해서 isWord 변수명을 쓴다)
 * A. 노드가 단어의 끝인지 확인해야 1. 단순 접두사인지, 2. 완전한 단어인지를 구분할 수 있다.
 */
public class ImplementPrefixTrie {

    public static void main(String[] args) {
        ImplementPrefixTrie trie = new ImplementPrefixTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); // true
    }

    private TrieNode root;

    public ImplementPrefixTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(!node.consistsKey(c)) {
                node.put(c, new TrieNode()); // 트라이 노드를 생성해서 키에 넣고
            }
            /**
             * 이해못했었던 코드
             */
            node = node.get(c); // 위에서 .put()한 노드를 가져와서 그걸 넣는다.
        }
        node.setEnd(); // 해당 알파벳 단어의 끝을 의미한다. 예) apple의 a
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            if(node.consistsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = this.searchPrefix(word);
        return node != null & node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.searchPrefix(prefix);
        return node != null;
    }

}

class TrieNode {
    private TrieNode[] children;
    private final int CAP = 26;
    private boolean isEnd;

    public TrieNode() {
        children = new TrieNode[CAP];
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public TrieNode get(char c) {
        return this.children[c-'a'];
    }

    // 인자로 받은 트라이 노드를 해당 children[]에 넣는다.
    public void put(char c, TrieNode node) {
        this.children[c-'a'] = node;
    }

    public boolean consistsKey(char c) {
        return this.children[c - 'a'] != null;
    }
}

/**
 * [명심]
 * 맵으로 구현한 트라이의 성능은 정말 최악이다.
 * 코테에서 정말 기억이 안 날때 풀고, -> 바로 개선할 자료구조나 다른 방법을 찾는다.
 */
class TrieByMap {
    private Map<String, Boolean> treeMap;

    public TrieByMap() {
        this.treeMap = new HashMap<>();
    }

    public void insert(String word) {
        this.treeMap.put(word, true);
    }

    public boolean search(String word) {
        if(this.treeMap.get(word) == null) {
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        for(Map.Entry<String, Boolean> e : this.treeMap.entrySet()) {
            String key = String.valueOf(e.getKey());
            if(key.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}