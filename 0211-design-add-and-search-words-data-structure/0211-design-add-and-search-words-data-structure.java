class TrieNode{
  Map<Character,TrieNode> map;
  boolean isEnd;

  public TrieNode(){
    map = new HashMap<>();
    isEnd = false;
  }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
          if(!curr.map.containsKey(c)){
            curr.map.put(c , new TrieNode());
          }

          curr = curr.map.get(c);
        }

        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(0 , word , curr );
    }

    private boolean dfs(int i , String word , TrieNode root){
      TrieNode curr = root;

      for(int j = i; j < word.length() ; j++){
        char c = word.charAt(j);

        if(c == '.'){
          for(TrieNode child : curr.map.values()){
            if(dfs(j+1 , word, child )){
              return true;
            }
          }

          return false;
        } else{
          if(!curr.map.containsKey(c)){
            return false;
          }

          curr = curr.map.get(c);
        }
      }
      
      return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */