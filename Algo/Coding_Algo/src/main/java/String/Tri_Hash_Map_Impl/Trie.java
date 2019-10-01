package String.Tri_Hash_Map_Impl;

import java.util.Map;

/**
 * #Tushar Trie implementation
 * https://www.youtube.com/watch?v=AXjmTQ8LEoI
 *
 *  Tri implementation https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 *
 *  Trie and prefix tree are same.
 *
 *  Different ways of implementaiton.
 *
 *  1. Nested HashMap based implementation.
 *
 *  Once we build a trie we do following operation
 *
 *  1. Adding a word to Trie (From given a bunch af dictionary)
 *  2. Membership check.
 *  3. Identifies all the the words that matches called prefix match.
 *  4. Delete word.
 *
 *  Questions for Tries :
 *
 *  Q1. Finding all the words in the dictionary that matches certain pattern.
 *
 *  Q2.
 *
 *
 *
 *
 *
 *
 *
 */
public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();

    }

    public void insert(String word) {
      Map<Character, TrieNode> children = root.childrenMap;

      for(int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);

        TrieNode t;
        if(children.containsKey(c)) {
            t = children.get(c);
        } else {
            t = new TrieNode(c);
            children.put(c , t);
        }
        children = t.childrenMap;

        if( i == word.length() -1) {
            t.endOfWord = true;
        }
      }

    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if(t == null) {
            return false;
        }

        return t.endOfWord;
    }

    public TrieNode searchNode(String str) {
         Map<Character, TrieNode> childrenMap = root.childrenMap;
        TrieNode t = null;
         for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(childrenMap.containsKey(c)) {
                t = childrenMap.get(c);
                childrenMap = t.childrenMap;
            } else {
                return null;
            }
         }
         return t;
    }




}
