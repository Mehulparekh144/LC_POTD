class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        int[] hash = new int[n];
        int maxi = -1;
        int idx = -1;

        for(int i = 0 ; i < n ; i++){
            hash[i] = i;
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[i]%nums[prev] == 0 && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }

            if(dp[i] > maxi){
                maxi = dp[i];
                idx = i;
            }
        }

        System.out.println(Arrays.toString(dp));


        List<Integer> res = new ArrayList<>();
        res.add(nums[idx]);
        
        while(hash[idx] != idx){
            idx = hash[idx];
            res.add(nums[idx]);
        }
        Collections.reverse(res);
        return res;
    }
}