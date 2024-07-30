class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxFreq = 0;
        int len = 0;

        int l = 0;

        for(int r = 0 ; r < s.length() ; r++){
          char c = s.charAt(r);
          count[c - 'A']++;
          maxFreq = Math.max(maxFreq , count[c - 'A']);

          if((r - l + 1) - maxFreq > k ){
            count[s.charAt(l) - 'A']--;
            l++;
          }

          len = Math.max(len , r-l+1);
        }

        return len;
    }
}