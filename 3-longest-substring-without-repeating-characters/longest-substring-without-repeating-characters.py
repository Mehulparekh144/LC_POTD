class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i = 0
        m = {}

        length = 0

        for j, char in enumerate(s):
            if char in m:
                i = max(i , m[char] + 1)

            m[char] = j
        
            length = max(length , j-i+1)
        
        return length
        