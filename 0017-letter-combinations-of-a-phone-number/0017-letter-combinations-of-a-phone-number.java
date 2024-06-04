class Solution {
    List<String> result;
    Map<String,String> map;
    public void solve(int i , String digits ,String s){
      if(s.length() == digits.length() ){
        result.add(s);
        return;
      }
      for(char c : map.get(String.valueOf(digits.charAt(i))).toCharArray()){
        solve(i + 1 , digits , s + c );
      }
    }
    
    public List<String> letterCombinations(String digits) {
      result = new ArrayList<>();
      map = new HashMap<>();
      map.put("2" , "abc");
      map.put("3" , "def");
      map.put("4" , "ghi");
      map.put("5" , "jkl");
      map.put("6" , "mno");
      map.put("7" , "pqrs");
      map.put("8" , "tuv");
      map.put("9" , "wxyz");
      if(digits.isEmpty()){
        return result;
      }
      solve(0 , digits , "");
      return result;
    }
}