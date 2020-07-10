package leetcode.medium;

public class WordDictionary {

    private Trie trie;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return Trie.search(word, trie, 0);
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        // ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        // [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        wd.search("pad");
        wd.search("bad");
        wd.search(".ad");
        wd.search("b..");
    }
}

class Trie {
    public Trie[] next;
    public boolean isEnd;
    
    public Trie() {
        next  = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie cur = this;
        for (char c: word.toCharArray()) {
            int cn = c - 'a';
            if (cur.next[cn] == null) {
                cur.next[cn] = new Trie();
            }
            cur = cur.next[cn];
        }
        cur.isEnd = true;
    }
    
    public static boolean search(String word, Trie root, int begin) {
        Trie cur = root;
        for (int i = begin; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Trie t: cur.next) {
                    if (t != null && search(word, t, i + 1)) return true;
                }
                return false;
            } else {
                int cn = c - 'a';
                if (cur.next[cn] == null) {
                    return false;
                } else {
                    cur = cur.next[cn];
                }
            }
        }
        return cur.isEnd;
    }
}