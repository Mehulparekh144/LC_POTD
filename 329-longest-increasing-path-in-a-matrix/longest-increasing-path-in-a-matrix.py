class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]

        @cache
        def dfs(i, j, prev):

            if i < 0 or j < 0 or i >= m or j >= n or matrix[i][j] <= prev:
                return 0

            length = 0
            for d in dirs:
                x = i + d[0]
                y = j + d[1]
                length = max(length, dfs(x, y, matrix[i][j]))

            return 1 + length

        res = 0
        for i in range(m):
            for j in range(n):
                res = max(res, dfs(i, j, -float("inf")))
        return res
