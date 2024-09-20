class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int flips = 0;

        for(char c : s.toCharArray()){
          if(c == '['){
            open++;
          } else{
            open--;
          }

          // If there are more closing than opening, then we have to make a swap, this will result in getting one opening bracket thus open = 1
          if(open < 0){
            flips++;
            open = 1;
          }
        }

        return flips;
    }
}