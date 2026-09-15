class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0, ans);
        return ans;
    }
    void backtrack(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (!isSafe(board, row, col))
                continue;
            board[row][col] = 'Q';
            backtrack(board, row + 1, ans);
            board[row][col] = '.';
        }
    }
    boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }
}