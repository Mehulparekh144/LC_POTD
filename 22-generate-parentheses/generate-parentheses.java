class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    solve(0, 0, n, "", res);
    return res;
  }

  private void solve(int open , int closed , int n , String s , List<String> res){
      if(open == n && closed == n){
        res.add(s);
        return;
      }

      if(open < n){
        solve(open + 1 , closed , n , s + "(" , res );
      }

      if(closed < open){
        solve(open , closed + 1 , n , s + ")" , res);
      }
    }

}