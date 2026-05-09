class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();
        int minutes = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty() && freshCount > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] direction : directions) {
                    int row = r + direction[0];
                    int col = c + direction[1];

                    if (row >= 0 && row < ROW && col >= 0 && col < COL && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[] {row, col});
                        freshCount--;
                    }
                }

                
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}
