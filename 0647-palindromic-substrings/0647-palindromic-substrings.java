class Solution {
    public int countSubstrings(String s) {
      int l;
      int r;
      int res = 0;
      for(int i = 0 ; i < s.length() ; i++){

        // ODD
        l = r = i;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
          res++;
          l--;
          r++;
        }

        //EVEN
        l = i;
        r = i+1;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
          res++;
          l--;
          r++;
        }


      }

      return res;
    }
}