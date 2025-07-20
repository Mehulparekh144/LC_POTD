class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set()

        for num in nums:
            s.add(num)

        length = 0

        for num in s:
            if num-1 in s:
                continue
            
            j = 1
            while num+j in s:
                j += 1
            
            length = max(length , j)
        
        return length