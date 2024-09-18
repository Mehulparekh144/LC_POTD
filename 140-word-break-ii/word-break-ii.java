class Solution {
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {

      res = new ArrayList<>();
      solve(0 , s , wordDict , new StringBuilder());
      return res;
    }

    private void solve(int i , String s , List<String> wordDict , StringBuilder sb){
      if(i >= s.length()){
        sb.deleteCharAt(sb.length() - 1);
        res.add(sb.toString());
        return;
      }

      for(int j = i ; j < s.length() ; j++){
        if(wordDict.contains(s.substring(i , j+1))){
          int len = sb.length();
          sb.append(s.substring(i , j+1)).append(" ");
          solve(j+1 , s , wordDict , sb);
          sb.setLength(len);
        }
      }
    }
}