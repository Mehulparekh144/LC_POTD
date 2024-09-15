class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
      res = new ArrayList<>();
      solve(n , k , new ArrayList<>());
      return res;
    }

    private void solve(int n , int k , List<Integer> temp){
      if(k == 0){
        res.add(new ArrayList<>(temp));
        return;
      }

      if(n <= 0){
        return;
      }

      solve(n-1 , k , temp);

      temp.add(n);
      solve(n-1 , k-1 , temp);
      temp.removeLast();
    }
}