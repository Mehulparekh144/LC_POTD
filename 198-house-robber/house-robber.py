class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0]*n

        dp[n-1] = nums[n-1]
        dp[n-2] = max(nums[n-2] , nums[n-1])

        if n == 2:
            return max(dp[n-1] , dp[n-2])

        for i in range(n-3 , -1 , -1):
            take = nums[i] + dp[i+2]
            not_take = dp[i+1]
            dp[i] = max(take , not_take)
        
        return dp[0]