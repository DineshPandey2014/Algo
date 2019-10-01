package String.Tri_Hash_Map_Impl;

import java.util.Map;

public class TrieNodeTest {

    public static void main (String args[]) {
        Trie node = new Trie();
        node.insert("Test");
        node.insert("Test One");
        node.insert("Test Three");
        node.insert("Dinesh Test");
        System.out.println("Is word in the dictionary "+ node.search("Test1"));

        traverseTree(node.root);
    }


    public static void traverseTree(TrieNode node) {

        for (Map.Entry<Character, TrieNode> entry : node.childrenMap.entrySet()) {
            TrieNode trieNode = entry.getValue();
            if(trieNode != null) {
                System.out.print(trieNode.c);
                traverseTree(trieNode);
            }
        }
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

