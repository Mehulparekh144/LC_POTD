class Solution {
    public boolean canArrange(int[] arr, int k) {
      int[] freq = new int[k];

      for(int a : arr){
        int rem = a%k;
        if(rem < 0){
          rem += k;
        }

        freq[rem]++;
      }

      // All the frequencies must be multiple of 2. So that they can be made a pair; 

      if(freq[0]%2 != 0) return false;

      for(int r = 1 ; r <= k/2 ; r++){
        if(freq[r] != freq[k-r]){
          return false;
        }
      }

      return true;
    }
}