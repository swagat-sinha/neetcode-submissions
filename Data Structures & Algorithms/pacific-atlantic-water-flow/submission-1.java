class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length;
        int COL = heights[0].length;
        boolean[][] pacific = new boolean[ROW][COL];
        boolean[][] atlantic = new boolean[ROW][COL];
    

        for (int c = 0; c < COL; c++) {
            dfs(0, c, pacific, heights, heights[0][c]);
            dfs(ROW - 1, c, atlantic, heights, heights[ROW - 1][c]);
        }

        for (int r = 0; r < ROW; r++) {
            dfs(r, 0, pacific, heights, heights[r][0]);
            dfs(r, COL - 1, atlantic, heights, heights[r][COL - 1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (pacific[i][j]  && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights, int prevHeight) {
        // base case
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length
            || visited[r][c] || prevHeight > heights[r][c]) {
            return;
        }
        visited[r][c] = true;
        dfs(r + 1, c, visited, heights, heights[r][c]);
        dfs(r - 1, c, visited, heights, heights[r][c]);
        dfs(r, c + 1, visited, heights, heights[r][c]);
        dfs(r, c - 1, visited, heights, heights[r][c]);
    }
}
