from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        res = float('inf')

        l = 0
        n = len(s)
        m = len(t)

        if n < m:
            return ""

        d1 = {}
        d2 = {}

        for c in t:
            if c not in d2:
                d2[c] = 0
            d2[c] += 1
        
        have = 0
        need = len(d2)
        start = 0

        for r in range(n):
            ch = s[r]

            if ch not in d1:
                d1[ch] = 0
            d1[ch] += 1

            if ch in d2 and d1[ch] == d2[ch]:
                have += 1
            
            while have == need:
                if r-l+1 < res:
                    res = r-l+1
                    start = l

                d1[s[l]] -= 1

                if s[l] in d2 and d1[s[l]] < d2[s[l]]:
                    have -= 1
                l += 1
            
        
        if res == float('inf'):
            return ""
        
        return s[start:start+res]

            




        