class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                   int currentAreaForIsland  = traversal(grid,i,j);
                    maxArea = Math.max(maxArea,currentAreaForIsland);
                }
                
                
            }
        }

        return maxArea;
        
    }

public int traversal(int [][] grid , int i ,int j ){
int m = grid.length;
int n = grid[0].length;
if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
    return 0;
}

grid[i][j]=0;

return traversal(grid,i-1,j) + traversal(grid,i+1,j) + traversal(grid,i,j-1) + traversal(grid,i,j+1) +1 ;

}
}
