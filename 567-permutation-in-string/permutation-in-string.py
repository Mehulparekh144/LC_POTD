class Solution:

 
    def checkInclusion(self, s1: str, s2: str) -> bool:

        def getOrder(c):
            return ord(c) - ord('a')

        m = len(s1)
        n = len(s2)

        if m > n:
            return False
        
        f1 = [0]*26
        f2 = [0]*26

        for i in range(m):
            print(i)
            print(getOrder(s1[i]))
            f1[getOrder(s1[i])] += 1
            f2[getOrder(s2[i])] += 1

        matches = 0
        for i in range(26):
            if f1[i] == f2[i]:
                matches += 1

        l = 0

        for r in range(m , n):
            if matches == 26:
                return True

            ch = s2[r]
            f2[getOrder(ch)] += 1

            if f1[getOrder(ch)] == f2[getOrder(ch)]:
                matches += 1
            elif f1[getOrder(ch)] == f2[getOrder(ch)] - 1:
                matches -= 1
            
            ch = s2[l]
            f2[getOrder(ch)] -= 1

            if f1[getOrder(ch)] == f2[getOrder(ch)]:
                matches += 1
            elif f1[getOrder(ch)] == f2[getOrder(ch)] + 1:
                matches -= 1
            
            l += 1
        
        return matches == 26

        