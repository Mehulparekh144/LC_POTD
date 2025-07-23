class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [-1]*n

        def dfs(i):
            if i >= len(nums):
                return 0
            
            if dp[i] != -1:
                return dp[i]

            take = nums[i] + dfs(i+2)
            not_take = dfs(i+1)

            dp[i] = max(take , not_take)
            return dp[i]
        
        return dfs(0)
        