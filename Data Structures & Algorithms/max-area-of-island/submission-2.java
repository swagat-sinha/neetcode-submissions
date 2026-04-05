class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int currArea = dfs(grid,i,j);
                    maxArea = Math.max(maxArea,currArea);
                }

            }
        }
        return maxArea;

    }



    public int dfs(int [][]grid,int i ,int j){
        //base case
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;

        return dfs(grid,i+1,j) +dfs(grid,i-1,j) + dfs(grid,i,j-1) + dfs(grid,i,j+1) +1;
    }
}
