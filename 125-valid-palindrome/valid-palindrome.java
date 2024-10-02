class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l <= r){
          char c1 = Character.toLowerCase(s.charAt(l));
          char c2 = Character.toLowerCase(s.charAt(r));

          if(!Character.isLetterOrDigit(c1)){
            l++;
            continue;
          } else if(!Character.isLetterOrDigit(c2)){
            r--;
            continue;
          } else if(c1 != c2){
            return false;
          }

          l++;
          r--;
        }

        return true;
    }
}