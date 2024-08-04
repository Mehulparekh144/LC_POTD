class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> l = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
          int sum = 0;
          for(int j = i ; j < n ; j++){
            sum += nums[j];
            l.add(sum);
          }
        }

        Collections.sort(l);

        int res = 0;
        for(int i = left ; i <= right ; i++){
          res += l.get(i-1);
          res %= MOD;
        }

        return res%MOD;
    }
}