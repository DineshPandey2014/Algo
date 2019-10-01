package String.Tri_Hash_Map_Impl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  Tri implementation https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 *
 *  Tri Java implementation http://www.techiedelight.com/implement-trie-data-structure-java/
 *
 *  God video for Tushar code as well
 *  https://www.youtube.com/watch?v=AXjmTQ8LEoI
 */
public class TrieNode {
    public char c;
    public Map<Character, TrieNode> childrenMap  = new LinkedHashMap<>();
    public boolean endOfWord;

    public TrieNode() { }

    public TrieNode(char c) {
        this.c = c;
    }
}

/**
 * In Trie every node (except the root node) stores one character or a digit. By traversing the trie down from the root
 * node to a particular node n. A common prefix of a character or digits can be formed which is shared by other branches
 * of the tries as well.
 *
 * In Trie every node except the root node stores one character or a digit.
 *
 */

