class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if(s1.length() > s2.length()) return false;
      int l = 0;
      int[] f1 = new int[26];
      int[] f2 = new int[26];

      for(int i = 0 ; i < s1.length() ; i++){
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(i);
        f1[c1 - 'a']++;
        f2[c2 - 'a']++;
      }

      int matches = 0;

      for(int i = 0 ; i < 26 ; i++){
        if(f1[i] == f2[i]) matches += 1;
      }

      for(int r = s1.length() ; r < s2.length() ; r++){
        if(matches == 26) return true;
        int idx = s2.charAt(r) - 'a';
        f2[idx]++;

        if(f1[idx] == f2[idx]){
          matches++;
        } else if(f1[idx] + 1 == f2[idx]){
          matches--;
        }

        idx = s2.charAt(l) - 'a';
        f2[idx]--;
        if(f1[idx] == f2[idx]){
          matches++;
        } else if(f1[idx] - 1 == f2[idx]){
          matches--;
        }

        l++;
      }

      return matches == 26;
    }

}