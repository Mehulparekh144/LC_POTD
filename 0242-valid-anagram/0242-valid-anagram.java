class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
          return false;
        }
        char[] sCount = new char[26];
        char[] tCount = new char[26];

        for(int i = 0 ; i < s.length() ; i++){
          sCount[s.charAt(i) - 'a']++;
          tCount[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(sCount , tCount);
    }
}