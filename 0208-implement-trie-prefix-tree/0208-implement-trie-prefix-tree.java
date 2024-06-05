class TrieNode {
  Map<Character, TrieNode> map;
  boolean isEnd;

  public TrieNode() {
    map = new HashMap<>();
    isEnd = false;
  }
}

class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode curr = root;
    for (char c : word.toCharArray()) {
      if (!curr.map.containsKey(c)) {
        curr.map.put(c, new TrieNode());
      }
      curr = curr.map.get(c);
    }

    curr.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode curr = root;
    for (char c : word.toCharArray()) {
      if (!curr.map.containsKey(c)) {
        return false;
      }
      curr = curr.map.get(c);
    }

    return curr.isEnd;
  }

  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (char c : prefix.toCharArray()) {
      if (!curr.map.containsKey(c)) {
        return false;
      }
      curr = curr.map.get(c);
    }

    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */