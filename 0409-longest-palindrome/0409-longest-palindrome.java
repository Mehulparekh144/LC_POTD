class Solution {
    public int longestPalindrome(String s) {
        int length = 0;
        Set<Character> set = new HashSet<>();

        for(char c : s.toCharArray()){
          if(set.contains(c)){
            length+=2;
            set.remove(c);
          } else{
            set.add(c);
          }
        }

        if(!set.isEmpty()){
          length++;
        }

        return length;
    }
}