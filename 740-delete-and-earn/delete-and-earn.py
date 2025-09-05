class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        m = {}

        for num in nums:
            m[num] = 1 if num not in m else m[num] + 1
        
        nums = list(m.keys())
        nums.sort()
        n = len(nums)

        dp = [0 for _ in range(n+2)]

        for i in range(n-1, -1, -1):
            np = dp[i+1]
            curr = nums[i]
            p = curr* m[curr]

            if i+1 < n and nums[i+1] == curr + 1:
                p += dp[i+2]
            else:
                p += dp[i+1]
            
            dp[i] = max(p, np)
        
        return dp[0]

                

        