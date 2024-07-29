class Solution {
  public int minimumLength(String s) {
    int l = 0;
    int r = s.length() - 1;

    char[] c = s.toCharArray();

    while(l < r){
      if(c[l] == c[r]){
        char curr = c[l];

        while(l <= r && c[l] == curr){
          l++;
        }

        while(l <= r && c[r] == curr){
          r--;
        }
      }
      else{
        break;
      }

    }

    return r - l + 1;
  }
}