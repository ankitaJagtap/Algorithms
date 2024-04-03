class WordSearch {

    public boolean searchWord(char[][] board, String word, int x, int y, int index) {

        if (word.length() == index)
            return true;

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }

        char ch = board[x][y];
        board[x][y] = '@';

        boolean ans = searchWord(board, word, x + 1, y, index + 1) ||
                searchWord(board, word, x - 1, y, index + 1) ||
                searchWord(board, word, x, y + 1, index + 1) ||
                searchWord(board, word, x, y - 1, index + 1);

        board[x][y] = ch;
        return ans;
    }

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (searchWord(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}