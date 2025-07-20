class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        i = 0
        j = n-1

        while i < j:
            s = nums[i] + nums[j]

            if s > target:
                j-=1
            elif s < target:
                i+=1
            else:
                return [i+1, j+1]
        
        