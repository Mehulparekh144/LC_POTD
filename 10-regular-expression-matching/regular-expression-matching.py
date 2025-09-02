class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m = len(s)
        n = len(p)

        dp = {}

        def solve(i, j):
            if j == n:
                return i == m
            
            if (i,j) in dp:
                return dp[(i,j)]

            res =  i < m and (s[i] == p[j] or p[j] == '.')
            
            if j+1 < n and p[j+1] == '*':
                take = res and solve(i+1, j)
                not_take = solve(i, j+2)

                dp[(i,j)] = take or not_take
                return dp[(i, j)]

            if res:
                dp[(i,j)] = solve(i+1, j+1)
                return dp[(i,j)]

            return False
        
        return solve(0, 0)



        