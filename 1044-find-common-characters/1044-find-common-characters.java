class Solution {

  public static List<String> commonChars(String[] words){
    List<String> res = new ArrayList<>();
    int[] freq = new int[26];

      for(char c : words[0].toCharArray()){
        freq[c - 'a']++;
      }

    for(String word : words){
      int[] temp = new int[26];
      for(char c : word.toCharArray()){
        temp[c - 'a'] = Math.min(temp[c - 'a'] + 1 , freq[c - 'a']);
      }
      System.arraycopy(temp , 0 , freq , 0 , 26);
  }

  for(int i = 0 ; i < 26 ; i++){
    for(int j = 0 ; j < freq[i] ; j++){
      char c = (char) (i + 'a');
      res.add(String.valueOf(c));
    }
  }
  return res;
}

}