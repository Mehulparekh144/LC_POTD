class Solution {
    List<String> res;
    Map<Character,List<Character>> map;
    public List<String> letterCombinations(String digits) {

      res = new ArrayList<>();
      if(digits.isEmpty()){
        return res;
      }
      map = new HashMap<>();    

      map.put('2' , List.of('a' , 'b', 'c'));
      map.put('3' , List.of('d' , 'e' , 'f'));
      map.put('4' , List.of('g' , 'h' , 'i'));     
      map.put('5' , List.of('j' , 'k' , 'l'));     
      map.put('6' , List.of('m' , 'n' , 'o'));     
      map.put('7' , List.of('p' , 'q' , 'r' , 's'));     
      map.put('8' , List.of('t' , 'u' , 'v'));     
      map.put('9' , List.of('w' , 'x' , 'y' , 'z'));     

      solve(0 , digits , "");
      return res;
    }

    private void solve(int i , String digits , String curr){
      if(i == digits.length()){
        res.add(curr);
        return;
      }

      char ch = digits.charAt(i);
      for(char adj : map.get(ch)){
        solve(i+1 , digits , curr + adj);
      }
    }
}