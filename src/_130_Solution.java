public class _130_Solution {
//    Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//
//    A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//            Example:
//
//    X X X X
//    X O O X
//    X X O X
//    X O X X
//    After running your function, the board should be:
//
//    X X X X
//    X X X X
//    X X X X
//    X O X X
public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
        return;
    }
    int rowNum = board.length;
    int colNum = board[0].length;
    // traverse elements at the top and bottom
    for (int i = 0; i < colNum; i++) {
        dfs(board, 0, i);
        dfs(board, rowNum - 1, i);
    }
    // traverse the elements on the left and on the right
    for (int i = 0; i < rowNum; i++) {
        dfs(board, i, 0);
        dfs(board, i, colNum - 1);
    }
    for (int i = 0; i < rowNum; i++) {
        for (int j = 0; j < colNum; j++) {
            if (board[i][j] == 'O') {
                board[i][j] = 'X';
            }
        }
    }
    for (int i = 0; i < rowNum; i++) {
        for (int j = 0; j < colNum; j++) {
            if (board[i][j] == '*') {
                board[i][j] = 'O';
            }
        }
    }
}

    public void dfs(char[][] board, int row, int col) {
        if (board[row][col] == 'O') {
            board[row][col] = '*';
            if (row > 1) {
                dfs(board, row - 1, col);
            }
            if (col > 1) {
                dfs(board, row, col - 1);
            }
            if (row < board.length - 1) {
                dfs(board, row + 1, col);
            }
            if (col < board[0].length - 1) {
                dfs(board, row, col + 1);
            }
        }
    }
}
