class Solution {

    private boolean isPalindrome(String s){
      int i = 0;
      int j = s.length() - 1;

      while(i <= j){
        if(s.charAt(i) != s.charAt(j)) return false;
        i++;
        j--;
      }

      return true;
    }

    private void solve(int i , String s , List<List<String>> res , List<String> temp){
      if(i >= s.length()){
        res.add(new ArrayList<>(temp));
      }

      for(int j = i ; j < s.length() ; j++){
        if(isPalindrome(s.substring(i , j+1))){
          temp.add(s.substring(i , j+1));
          solve(j+1 , s , res , temp);
          temp.removeLast();
        }
      }
    }
    public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
      solve(0 , s , res , new ArrayList<>());
      return res;
    }
}