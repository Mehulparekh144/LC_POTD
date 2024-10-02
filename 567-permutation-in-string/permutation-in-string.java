class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for(char c : s1.toCharArray()){
          f1[c - 'a']++;
        }

        int l = 0;

        for(int r = 0 ; r < s2.length() ; r++){
          char ch = s2.charAt(r);
          int idx = ch - 'a';

          f2[idx]++;

          if((r-l + 1) == s1.length() ){
            if(Arrays.equals(f1, f2)){
              return true;
            } else{
              f2[s2.charAt(l) - 'a']--;
              l++;
            }
          }
        }

        return false;
    }
}