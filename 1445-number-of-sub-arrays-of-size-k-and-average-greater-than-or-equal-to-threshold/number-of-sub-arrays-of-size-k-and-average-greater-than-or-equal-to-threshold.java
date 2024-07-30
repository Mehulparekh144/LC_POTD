class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;

        int l = 0;
        int r = l + k - 1;

        while(r < arr.length){
          if(getAverage(arr , l , r) >= threshold){
            count++;
          }
          l++;
          r++;
        }

        return count;
    }

    private int getAverage(int[] arr , int i , int j){
      int len = j - i + 1;
      int sum = 0;
      for(int k = i ; k <= j ; k++){
        sum += arr[k];
      }

      return sum/len;
    }
}