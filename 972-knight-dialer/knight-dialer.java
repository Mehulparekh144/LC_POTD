import java.util.HashMap;
import java.util.Map;

class Solution {
  private static final int MOD = (int) 1e9 + 7;
  private Map<String, Integer> map;
  private static int[][] MOVES = {
     {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
    {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
  };

  public int knightDialer(int n) {
    map = new HashMap<>();

    int res = 0;

    for(int i = 0 ; i < 4 ; i++){
      for(int j = 0 ; j < 3 ; j++){
        if(isValid(i , j)){
          res = (res + solve(i , j , n))%MOD;
        }
      }
    }

    return res;

  }

  private int solve(int i, int j, int n) {

    if (n == 1) {
      return 1;
    }

    String key = i + "_" + j + "_" + n;
    if (map.containsKey(key))
      return map.get(key);

    int res = 0;

    for(int[] move : MOVES){
      int i1 = i + move[0];
      int j1 = j + move[1];

      if(isValid(i1 , j1)){
        res = (res + solve(i1 , j1 , n-1))%MOD;
      }
    }
    
    map.put(key, res);
    return res;
  }

  private boolean isValid(int i , int j){
    return (i >= 0 && j >= 0 && i < 4 && j < 3 && (i != 3 || j != 0) && (i != 3 || j != 2));
  }
}
