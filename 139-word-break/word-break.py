class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False for _ in range(n+1)]

        dp[n] = True

        for i in range(n-1 , -1 , -1):
            for k in range(i+1 , n+1):
                if s[i:k] in wordDict:
                    if dp[k]:
                        dp[i] = True
                
        return dp[0]