class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        left = []
        l = 1
        n = len(nums)

        for i in range(n):
            left.append(l)
            l *= nums[i]
        
        right = []
        r = 1
        for i in range(n-1 , -1 , -1):
            left[i] *= r
            r *= nums[i]
        
        return left