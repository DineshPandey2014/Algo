package Trie;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerearth.com/practice/data-structures/advanced-data-structures/trie-keyword-tree/tutorial/
 *
 * https://www.youtube.com/watch?v=AXjmTQ8LEoI
 *
 * Usage of Trie :
 *
 * 1) Prefix search. Operation Search,Insert, Delete,
 *
 * 2) Time Complexity : If we have n words and and average length of words say l
 *    Time COmplexity  O (n l)
 *
 * 3) Say height of Tri tree is n --> Longest length of the word.
 * 4) Search of the word time complexity will be O(l) . l > l is the length of word. . If the word of the longest word is l
 * 5) If we have n word. Time complexity for n word will
 * 5)
 *
 *        *
 *
 *      /      \
 *     C       T
 *     \        \
 *     A         O
 *   /   \       /  \
 *   L    P     *    P
 *  /    /              \
 *  *   *              *
 *
 *  Search : CALP
 *
 *  How lookup works :
 *  1) Don't look up each prefix from the root.
 *  2) Build on the past call
 *  3) We can return the reference of the node of the child. And then we check next character is child in this reference node.
 *
 *
 *
 *
 * Questions :
 * 1. Given a board find all the matching word;
 * 2. Given a list of words find all celeberity of words.
 * 3. AutoComplete ( When user is typing the words it will show all the mathing words and sentences.
 *
 *  Tries:

 Tries are an extremely special and useful data-structure that are based on the prefix of a string.
 They are used to represent the “Retrieval” of data and thus the name Trie.

 */
public class Trie {



//  public Trie() {
//
//  }


  public static void main(String args[]) {

    String name = "dinesh";
    insert(name);
  }

  // Iterative implemenation of insert trie.
  public static void insert(String word) {
    TrieNode root = new TrieNode();
    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node =  current.children.get(ch);
      if(node == null) {
        node = new TrieNode();
        current.children.put(ch, node);
      }
      current = node;
    }
    // Mark the current nodes endofword as true.
    current.endOfWord = true;
  }

  /**
   * Recursive implementation of insert trie.
   */

  public void insertRecursive(String word) {

  }

  private void insertRecursive(TrieNode current, String word, int index) {
    if(index == word.length()) {
      current.endOfWord = true;
      return;
    }

    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if(node == null) {
      node = new TrieNode();
      current.children.put(ch, node);
    }
    insertRecursive(node, word, index + 1);
  }
}

class TrieNode {
  Map<Character, TrieNode> children;
  boolean endOfWord;

  public TrieNode() {
    children = new HashMap<>();
    endOfWord = false;
  }
}
