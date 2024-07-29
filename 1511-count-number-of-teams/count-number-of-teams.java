class Solution {
    public int numTeams(int[] rating) {
      int res = 0;
      int n = rating.length;

      for(int m = 1 ; m < n-1 ; m++){
        int leftSmaller = 0;
        int rightLarger = 0;

        for(int i = 0 ; i < m ; i++){
          if(rating[i] < rating[m]){
            leftSmaller++;
          }
        }

        for(int j = m+1 ; j < n ; j++){
          if(rating[j] > rating[m]){
            rightLarger++;
          }
        }

        res += leftSmaller*rightLarger; // Ascending

        int leftLarger = m - leftSmaller;
        int rightSmaller = n - m - 1 - rightLarger;

        res += leftLarger*rightSmaller;
      }

      return res;

    }
      
}