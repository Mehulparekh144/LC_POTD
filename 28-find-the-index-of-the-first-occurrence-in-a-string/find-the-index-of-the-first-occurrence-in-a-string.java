class Solution {
  public int strStr(String haystack, String needle) {
    int l = 0;
    int k = needle.length();
    StringBuilder sb = new StringBuilder();

    for(int r = 0 ; r < haystack.length() ; r++ ){
      sb.append(haystack.charAt(r));

      if(r >= k){
        l++;
      }

      if(sb.substring(l , r+1).equals(needle)) {
        return l;
      }
    }

    return -1;
  }
}