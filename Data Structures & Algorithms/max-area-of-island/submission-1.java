class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int maxArea =0;
        //traverse each node
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //node should not be visited before
                if(grid[i][j]==1){
                   int currArea = dfs(grid,i,j);
                   maxArea = Math.max(maxArea,currArea);
                }
            }
        }

       return maxArea; 
}

        private int dfs(int[][] grid , int i ,int j){

            int m = grid.length;
            int n = grid [0].length;

            //base condition
            if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
                return 0; //because it is out of grid or not peice of land that means it won't contribut anything to area
            }

            //making it as 0 so that we wont revisit this node again
            grid[i][j] =0;

            return dfs(grid,i+1,j)+ dfs(grid,i-1,j) + dfs(grid,i,j-1) +dfs(grid,i,j+1) +1;
        }
}
