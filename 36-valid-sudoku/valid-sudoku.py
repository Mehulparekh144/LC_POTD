class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        s = set()

        for i in range(9):
            for j in range(9):

                if board[i][j] == "." : continue

                row = f"row,{i},{board[i][j]}"
                col = f"col,{j},{board[i][j]}"
                grid = f"grid,{i//3},{j//3},{board[i][j]}"

                if row in s or col in s or grid in s:
                    return False

                s.add(row)
                s.add(col)
                s.add(grid)
        
        return True