class Solution {
  public int maxProduct(String s) {
    int n = s.length();
    // BitMask -> Length of subsequence
    Map<Integer,Integer> map = new HashMap<>();

    // 0 excluded coz 0 means no subsequence
    for(int mask = 1 ; mask < (1 << n ) ; mask++){
      StringBuilder sub = new StringBuilder();

      for(int i = 0 ; i < n ; i++){
        if((mask & (1 << i)) != 0 ){
          sub.append(s.charAt(i));
        }
      }

      if(isPalindrome(sub.toString())){
        map.put(mask , sub.length());
      }
    }

    int res = 0;
    for(Map.Entry<Integer,Integer> e1 : map.entrySet()){
      for(Map.Entry<Integer,Integer> e2 : map.entrySet()){
        int k1 = e1.getKey() , k2 = e2.getKey();
        if((k1 & k2) == 0){
          res = Math.max(res , map.get(k1)*map.get(k2));
        }
      }
    }

    return res;
  }
    
    
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        
        return true;
    }
}