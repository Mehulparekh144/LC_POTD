import "strconv"

func isValidSudoku(board [][]byte) bool {
    set := map[string]bool{};

    for i := 0 ; i < 9 ; i++{
        for j := 0 ; j < 9 ; j++ {

            if board[i][j] == '.' {continue}



            row  := "row" + strconv.Itoa(i) + "-" + string(board[i][j]);
            col  := "col" + strconv.Itoa(j) + "-" + string(board[i][j]);
            grid := "grid" + strconv.Itoa(i/3) + "-" + strconv.Itoa(j/3) + "-" + string(board[i][j]);

            if set[row] || set[col] || set[grid] {
                return false;
            }

            set[row] = true;
            set[col] = true;
            set[grid] = true;

        }
    }

    return true;
}