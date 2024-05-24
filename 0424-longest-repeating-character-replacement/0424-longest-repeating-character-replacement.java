class Solution {
    public int characterReplacement(String s, int k) {
      int l = 0;
      int[] count = new int[26];
      int maxLen = 0;
      int maxCount = 0;

      for(int r = 0 ; r < s.length() ; r++){
        count[s.charAt(r) - 'A']++;
        maxCount = Math.max(maxCount , count[s.charAt(r) - 'A']);

        if((r - l + 1) - maxCount > k){
          count[s.charAt(l) -'A']--;
          l++;
        }

        maxLen = Math.max(maxLen , r-l+1);
      }
      return maxLen;
    }
}