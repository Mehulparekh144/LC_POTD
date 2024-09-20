class Solution {
    public int countPalindromicSubsequence(String s) {
      int count = 0;
      Set<Character> set = new HashSet<>();
      for(char ch : s.toCharArray()){
        set.add(ch);
      }

      for(char ch : set){
        int leftMost = -1, rightMost = -1;

        for(int i = 0 ; i < s.length() ; i++){
          if(s.charAt(i) == ch){
            if(leftMost == -1) leftMost = i;
            rightMost = i;
          }
        }

        Set<Character> set2 = new HashSet<>();
        for(int i = leftMost + 1 ; i <= rightMost-1 ; i++){
          set2.add(s.charAt(i));
        }

        count += set2.size();
      }

      return count;

        
    }
}