class Solution {
  public int[] sortArray(int[] nums) {
    int n = nums.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(n, nums, i);
    }

    for (int i = n - 1; i >= 0; i--) {
      swap(i, 0, nums);
      heapify(i, nums, 0);
    }

    return nums;
  }

  private void heapify(int n, int[] nums, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && nums[l] > nums[largest]) {
      largest = l;
    }

    if (r < n && nums[r] > nums[largest]) {
      largest = r;
    }

    if(largest != i){
      swap(i , largest , nums);
      heapify(n , nums  , largest);
    }
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}