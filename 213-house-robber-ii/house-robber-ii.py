class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]
        
        if n == 2:
            return max(nums[0] , nums[1])

        return max(
            self.solve(nums[0:n-1]),
            self.solve(nums[1:])
        )

    def solve(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0]*n

        prev1 = nums[n-1]
        prev2 = max(nums[n-2] , nums[n-1])

        for i in range(n-3 , -1 , -1):
            take = nums[i] + prev1
            not_take = prev2
            curr = max(take , not_take)
            prev1 = prev2
            prev2 = curr
        
        return prev2