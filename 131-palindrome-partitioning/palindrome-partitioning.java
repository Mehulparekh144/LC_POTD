class Solution {
    List<List<String>> res;
    int n;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        n = s.length();
        solve(0 , s ,  new ArrayList<>());
        return res;
    }

    private void solve(int i , String s , List<String> temp ){
      if(i >= n){
        res.add(new ArrayList<>(temp));
        return;
      }

      for(int j = i ; j < n ; j++){
        if(isPalindrome(i , j , s)){
          temp.add(s.substring(i , j+1));
          solve(j+1 , s , temp);
          temp.removeLast();
        }
      }
    }

    private boolean isPalindrome(int i , int j , String s){
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