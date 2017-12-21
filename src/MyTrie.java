class MyTrie {

    private class Node {
        Node[] next;
        boolean isWord;
        Node() {
            this.next = new Node[26];
            this.isWord = false;
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public MyTrie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.next[word.charAt(i) - 'a'] == null) {
                current.next[word.charAt(i) - 'a'] = new Node();
            }
            current = current.next[word.charAt(i) - 'a'];
        }
        current.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = iterate(word);
        if (curr == null) return false;
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = iterate(prefix);
        if (curr == null) return false;
        for (Node n : curr.next) if (n != null) return true;
        return curr.isWord;
    }

    private Node iterate(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            if (curr.next[str.charAt(i) - 'a'] == null) return null;
            curr = curr.next[str.charAt(i) - 'a'];
        }
        return curr;
    }
}