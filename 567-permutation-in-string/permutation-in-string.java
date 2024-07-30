class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
          return false;
        }

        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(int i = 0 ; i < s1.length() ; i++){
          f1[s1.charAt(i) - 'a']++;
          f2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0 ; i < 26 ; i++){
          if(f1[i] == f2[i]){
            matches++;
          }
        }

        int l = 0;

        for(int r = s1.length() ; r < s2.length() ; r++){
          if(matches == 26) return true;

          char c1 = s2.charAt(r);
          f2[c1 - 'a']++;

          if(f1[c1 - 'a'] == f2[c1 - 'a']){
            matches++;
          } else if(f1[c1 - 'a'] + 1 == f2[c1 - 'a']){
            matches--;
          }

          char c2 = s2.charAt(l);
          f2[c2 - 'a']--;

          if(f1[c2 - 'a'] == f2[c2 - 'a']){
            matches++;
          } else if(f1[c2 - 'a'] - 1 == f2[c2 - 'a']){
            matches--;
          }

          l++;
          
        }

        return matches == 26;


    }
}