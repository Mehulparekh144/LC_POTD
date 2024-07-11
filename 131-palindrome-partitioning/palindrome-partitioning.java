class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(0 , res , new ArrayList<>() , s);
        return res;
    }

    private void solve(int i , List<List<String>> res , List<String> temp , String s){
      if(i == s.length()){
        res.add(new ArrayList<>(temp));
        return;
      }

      for(int j = i ; j < s.length() ; j++){
        if(isPalindrome(s , i , j)){
          temp.add(s.substring(i , j+1));
          solve(j+1 , res , temp , s);
          temp.removeLast();
        }
      }
    }

    private boolean isPalindrome(String s , int i , int j){
      while(i <= j){
        if(s.charAt(i) != s.charAt(j)){
          return false;
        }

        i++;
        j--;
      }

      return true;
    }
}