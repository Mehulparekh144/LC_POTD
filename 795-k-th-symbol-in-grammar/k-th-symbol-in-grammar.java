class Solution {
    public int kthGrammar(int n, int k) {
      int left = 1;
      int right = (int) Math.pow(2 , n-1);
      int curr = 0;

      for(int i = 0 ; i < n ; i++){
        int mid = left + (right - left)/2;

        if(k <= mid){
          right = mid;
        } else{
          left = mid + 1;
          curr = curr == 0 ? 1 : 0;
        }
      }

      return curr;

    }


}