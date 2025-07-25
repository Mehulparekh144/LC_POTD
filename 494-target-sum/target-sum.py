class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)

        @cache
        def dfs(i , t):
            if i == n:
                return 1 if t == target else 0
            
            return dfs(i+1 , t - nums[i]) + dfs(i+1 , t + nums[i])
        
        return dfs(0 , 0)