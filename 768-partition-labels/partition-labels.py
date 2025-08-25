class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        m = {}

        for i,c in enumerate(s):
            m[c] = i
        
        i = 0
        j = 0
        farthest = 0
        res = []

        while j < len(s):
            c = s[j]
            farthest = max(farthest, m[c])

            if j == farthest:
                res.append(j-i+1)
                i = farthest + 1
            
            j += 1
        
        return res

