class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l < r:
            m = l + (r-l)//2

            if nums[m] <= nums[r]: #Normal condition so go on the left
                r = m 
            else:
                l = m + 1 #Go on the left as we are closer to the rotatedt start
        
        return nums[l]
        