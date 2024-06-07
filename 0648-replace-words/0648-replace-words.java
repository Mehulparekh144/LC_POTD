class TrieNode{
  Map<Character,TrieNode> map;
  boolean isEnd;

  public TrieNode(){
    map = new HashMap<>();
    isEnd = false;
  }
}

class Trie{
  TrieNode root;
  public Trie(){
    root = new TrieNode();
  }

  public void insert(String word){
    TrieNode curr = root;
    for(char c : word.toCharArray()){
      if(!curr.map.containsKey(c)){
        curr.map.put(c , new TrieNode());
      }

      curr = curr.map.get(c);
    }

    curr.isEnd = true;
  }

    public String getRoot(String word) {
      TrieNode curr = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (!curr.map.containsKey(c)) {
          return "";
        }

        curr = curr.map.get(c);
        if (curr.isEnd) {
          return word.substring(0, i+1);
        }
      }

      return "";
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
      Trie trie = new Trie();
      for(String word : dictionary){
        trie.insert(word);
      }

      String[] words = sentence.split(" ");
      for(int i = 0 ; i < words.length ; i++){
        if(trie.getRoot(words[i]).equals("")){
          continue;
        }

        words[i] = trie.getRoot(words[i]);
      }

      return String.join(" " , words);
    }
}