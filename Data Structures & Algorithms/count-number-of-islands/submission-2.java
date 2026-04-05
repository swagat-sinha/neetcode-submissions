class Solution {
    public int numIslands(char[][] grid) {
    
   int m = grid.length;
   int n = grid[0].length;

    int count = 0;
   for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){

        if(grid[i][j]=='1'){
            dfs(grid,i,j);
            count++;
        }

    }
   }
return count;
    }

    private void  dfs(char[][] grid ,int i , int j){

        int m =grid.length;
        int n = grid[0].length;

        //base case

        //if we go outside the grid

         if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0'){
            return;
         }   
        //mark that node as visited by equating to 0
        grid[i][j]='0';
        //traverse top,bottom,left,right
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }


}
