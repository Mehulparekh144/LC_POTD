class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)

        @cache
        def dfs(i , target):

            if i >= n:
                if target == 0:
                    return 1
                return 0 
            
            np = dfs(i+1 , target)
            p = 0
            if target >= coins[i]:
                p = dfs(i , target - coins[i])
            
            return np + p
        
        return dfs(0 , amount)