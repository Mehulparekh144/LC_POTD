class Solution {
    Map<String,Integer> map;
     private int solve(int i , int k , int jump  , boolean canGoDown){
    if(i > k + 1){
      return 0;
    }
    String key = i + "_" + jump + "_" + canGoDown;
    if(map.containsKey(key)){
      return map.get(key);
    }
    int ways = 0;
    if(i == k){
      ways += 1;
    }

    if(canGoDown & i > 0) {
      ways += solve(i - 1, k, jump, false);
    }
      ways += solve(i + (int) Math.pow(2 , jump) , k , jump + 1  , true );
      map.put(key , ways);
      return ways;
  }

  public int waysToReachStair(int k) {
    map = new HashMap<>();
    return solve(1 , k , 0  , true);
  }
}