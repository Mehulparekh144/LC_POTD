class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)

        if s % 2 != 0:
            return False

        n = len(nums)
        target = s // 2

        dp = [[False for _ in range(target + 1)] for _ in range(n)]

        for t in range(target+1):
            dp[0][t] = t == nums[0]

        for i in range(1, n):
            for t in range(target+1):
                np = dp[i - 1][t]
                p = False
                if t >= nums[i]:
                    p = dp[i - 1][t - nums[i]]

                dp[i][t] = p | np

        return dp[n - 1][target]
