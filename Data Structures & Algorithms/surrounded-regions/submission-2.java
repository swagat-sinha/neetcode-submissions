class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        for(int r=0;r<ROWS;r++){
            dfs(board,r,0);
            dfs(board,r,COLS-1);
        }

        for(int c=0;c<COLS;c++){
            dfs(board,0,c);
            dfs(board,ROWS-1,c);
        }    

        // all surrounded cells ---> mark as X

        for(int i=0;i<ROWS;i++){
            for(int j =0;j<COLS;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if (board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }    


    }
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
            || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row , col+1);
        dfs(board, row , col-1);
    }
}
