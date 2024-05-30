class Solution {
    public int countTriplets(int[] arr) {
      int count = 0;

      for(int i = 0; i < arr.length - 1 ; i++){
        for(int j = i + 1 ; j < arr.length ; j++){
          for(int k = j ; k < arr.length ; k++){
            int a = 0;
            int b = 0;

            for(int m = i ; m < j ; m++){
              a ^= arr[m];
            }

            for(int n = j ; n <= k ; n++){
              b ^= arr[n];
            }

            if(a == b) count++; 
          }
        }
      }

      return count;
    }
}