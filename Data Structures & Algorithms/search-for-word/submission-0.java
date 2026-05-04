class Solution {
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int currRow, int currCol, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        }

        if (currRow < 0 || currCol < 0 || currRow >= rows || currCol >= cols
            || board[currRow][currCol] != word.charAt(wordIndex)) {
            return false;
        }

        char originalChar = board[currRow][currCol];
        board[currRow][currCol] = '#';
        boolean found = dfs(board, word, currRow + 1, currCol, wordIndex + 1)
            || dfs(board, word, currRow - 1, currCol, wordIndex + 1)
            || dfs(board, word, currRow, currCol + 1, wordIndex + 1)
            || dfs(board, word, currRow, currCol - 1, wordIndex + 1);
        board[currRow][currCol] = originalChar;

        return found;
    }
}
