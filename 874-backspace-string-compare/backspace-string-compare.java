class Solution {

    public boolean backspaceCompare(String s, String t) {
      int sLen = s.length();
      int tLen = t.length();

      int s1 = sLen - 1;
      int t1 = tLen - 1;

      while(s1 >= 0 || t1 >= 0){
        s1 = getValidIdx(s , s1);
        t1 = getValidIdx(t , t1);

        char sc = s1 >= 0 ? s.charAt(s1) : '0';
        char tc = t1 >= 0 ? t.charAt(t1) : '0';

        if(sc != tc) return false;
        s1--;
        t1--;
      }

      return true;
    }

    private int getValidIdx(String s , int i){
      int backspaces = 0;
      while(i >= 0){
        if(backspaces == 0 && s.charAt(i) != '#'){
          break;
        } else if(s.charAt(i) == '#'){
          backspaces++;
        } else{
          backspaces--;
        }
        i--;
      }

      return i;
    }

}