class Solution {
    public int minSwaps(String s) {
        int close = 0;
        int max = 0;

        for(char c : s.toCharArray()){
          if(c == '['){
            close--;
          } else{
            close++;
          }

          max = Math.max(max , close);
        }

        return (max + 1)/2;
    }
}