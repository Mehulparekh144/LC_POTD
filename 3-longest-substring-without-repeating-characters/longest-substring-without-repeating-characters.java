class Solution {
    public int lengthOfLongestSubstring(String s) {
      Map<Character,Integer> map = new HashMap<>();
      int l = 0;
      int maxLength = 0;

      for(int r = 0 ; r < s.length() ; r++){
        char c1 = s.charAt(r);
        map.put(c1, map.getOrDefault(c1 , 0) + 1);

        while(map.get(c1) > 1){
          char c2 = s.charAt(l);
          map.put(c2 , map.get(c2) - 1);
          if(map.get(c2) == 0){
            map.remove(c2);
          }
          l++;
        }

        maxLength = Math.max(maxLength , r - l + 1);
      }  

      return maxLength;
    }
}