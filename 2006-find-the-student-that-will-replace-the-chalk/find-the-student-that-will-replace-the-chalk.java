class Solution {
    public int chalkReplacer(int[] chalk, int k) {
      
      long totalChalks = 0;
      // Get the total chalks and mod it by k so that we know how many chalks will be needed in last round.
      for(int ch : chalk){
        totalChalks += ch;
      }

      int remain = (int) (k%totalChalks);

      for(int i = 0 ; i < chalk.length  ; i++){
        if(remain < chalk[i]) return i;
        remain -= chalk[i];
      }

      return 0;

    
    }
}