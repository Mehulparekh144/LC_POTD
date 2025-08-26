class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        @cache
        def solve(i, j):
            if i < 0 or j < 0 or  i >= len(triangle) or j >= len(triangle[i]):
                return float('inf')
            
            if i == len(triangle) - 1:
                return triangle[i][j]

            return triangle[i][j] + min(solve(i+1, j+1) , solve(i+1, j)) 
        
        return solve(0, 0)
        