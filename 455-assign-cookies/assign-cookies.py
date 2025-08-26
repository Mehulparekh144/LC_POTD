class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()

        m = len(g)
        n = len(s)

        i = j = 0 

        while i < m and j < n:
            if s[j] >= g[i]:
                i += 1
            j += 1

        return i 
        