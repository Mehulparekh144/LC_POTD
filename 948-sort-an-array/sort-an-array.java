class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums , 0 , nums.length - 1);
    }

    private int[] mergeSort(int[] nums , int l , int r){
      if (l == r) {
            return new int[] { nums[l] };
        }
      int m = (l + r) >> 1;

      int[] left = mergeSort(nums , l , m);
      int[] right = mergeSort(nums , m+1 , r);

      return merge(left , right);
    }

    private int[] merge(int[] left , int[] right){
      int m = left.length , n = right.length;
      int[] combined = new int[m + n];
      int i = 0 , j = 0 , idx = 0;

      while(i < m && j < n){
        if(left[i] < right[j]){
          combined[idx++] = left[i];
          i++;
        }  else{
          combined[idx++] = right[j];
          j++;
        }
      }

      while(i < m){
        combined[idx++] = left[i++];
      }

      while(j < n){
        combined[idx++] = right[j++];
      }

      return combined;
    }

}