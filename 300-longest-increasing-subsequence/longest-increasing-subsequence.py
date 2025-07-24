class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1]*n

        for i in range(n):
            for prev in range(i):
                if nums[i] > nums[prev] and 1 + dp[prev] > dp[i]:
                    dp[i] = 1 + dp[prev]
        
        return max(dp)

        