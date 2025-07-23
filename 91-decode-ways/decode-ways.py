class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        dp = [-1]*n 

        def dfs(i):
            if i >= n:
                return 1

            if s[i] == "0":
                return 0
            
            if dp[i] != -1:
                return dp[i]

            take = dfs(i + 1)
            not_take = 0

            if (
                s[i] != "0"
                and i + 1 < n
                and ((s[i] == "2" and s[i + 1] <= "6") or s[i] < "2")
            ):
                not_take = dfs(i + 2)

            dp[i] = take + not_take
            return dp[i]

        return dfs(0)
