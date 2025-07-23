class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)

        prev = [0] * (amount + 1)

        for j in range(amount+1):
            if j%coins[0] == 0:
                prev[j] = j//coins[0]
            else:
                prev[j] = float('inf')

        for i in range(1, n):
            curr = [0] * (amount + 1)
            for j in range(amount+1):
                np = prev[j]
                p = float('inf')
                if j >= coins[i]:
                    p = 1 + curr[j-coins[i]]  
                
                curr[j] = min(p , np)
            
            prev = curr
            
        return -1 if prev[amount] == float('inf') else prev[amount]
        