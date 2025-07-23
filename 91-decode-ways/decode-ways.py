class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        dp = [0]*(n+1) 

        dp[n] = 1

        for i in range(n-1 , -1 , -1):
            if s[i] == '0':
                dp[i] = 0
            else:
                take = dp[i+1]
                not_take = 0
                if (
                    s[i] != "0"
                    and i+1 < n
                    and ((s[i] == "2" and s[i + 1] <= "6") or s[i] < "2")
                ):
                    not_take = dp[i+2]

                dp[i] = take + not_take
        
        return dp[0]
