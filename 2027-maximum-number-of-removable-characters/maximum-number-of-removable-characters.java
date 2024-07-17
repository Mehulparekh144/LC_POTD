class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0;
        int r = removable.length;
        int ans = 0;

        while(l <= r){
          int m = l + (r-l)/2;

          if(isPossible(m , s , p , removable)){
            ans = m;
            l = m + 1;
          } else{
            r = m - 1;
          }
        }

        return ans;
    }


    private boolean isPossible(int k , String s , String p , int[] removable){
      Set<Integer> removed = new HashSet<>();

      for(int i = 0 ; i < k ; i++){
        removed.add(removable[i]);
      }

      int i = 0;
      int j = 0;

      while(i < s.length() && j < p.length()){
        if(!removed.contains(i) && s.charAt(i) == p.charAt(j)){
          i++;
          j++;
        } else{
          i++;
        }
      }

      return j == p.length();
    }
}