class Solution {


    private final static int MOD = 1000000007;

    public int maxSumMinProduct(int[] nums) {
        Stack<Integer> s1 = new Stack<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Find previous smaller elements
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && nums[s1.peek()] >= nums[i]) {
                s1.pop();
            }
            if (s1.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = s1.peek();
            }
            s1.push(i);
        }

        s1.clear();

        // Find next smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!s1.isEmpty() && nums[s1.peek()] >= nums[i]) {
                s1.pop();
            }
            if (s1.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = s1.peek();
            }
            s1.push(i);
        }

        // Compute prefix sums
        long[] pfx = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pfx[i + 1] = pfx[i] + nums[i];
        }

        long res = 0;

        for (int i = 0; i < n; i++) {
            int leftBound = left[i] + 1;
            int rightBound = right[i] - 1;

            if (leftBound < 0) leftBound = 0;
            if (rightBound >= n) rightBound = n - 1;

            long sum = (pfx[rightBound + 1] - pfx[leftBound]) * nums[i];
            res = Math.max(res, sum);
        }

        return (int) (res % MOD);
    }
      
}
      
