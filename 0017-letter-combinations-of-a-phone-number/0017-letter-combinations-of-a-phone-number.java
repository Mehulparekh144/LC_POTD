class Solution {
    public List<String> letterCombinations(String digits) {
      Map<Character,String> map = new HashMap<>();
      map.put('2' , "abc");
      map.put('3' , "def");
      map.put('4' , "ghi");
      map.put('5' , "jkl");
      map.put('6' , "mno");
      map.put('7' , "pqrs");
      map.put('8' , "tuv");
      map.put('9' , "wxyz");

      if(digits.length() == 0){
        return new ArrayList<>();
      }        
      List<String> res = new ArrayList<>();
      solve(0 , digits , "" , map , res);
      return res;
    }

    private void solve(int i , String digits , String path, Map<Character,String> map , List<String> res){
      if(path.length() == digits.length()){
        res.add(path);
        return;
      }

      String letters = map.get(digits.charAt(i));
      for(char l : letters.toCharArray()){
        solve(i+1 , digits , path + l , map , res);
      }
    }
}