class Solution {
    public int numIslands(char[][] grid) {
    
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    traversal(grid,i,j);
                    count++;
                    }
            }
        }
        return count;
    }

    public void traversal(char[][] grid,int i , int j){
        
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i >=m || j>=n || grid[i][j]=='0'){
            return;
        }

        grid[i][j]= '0';

        traversal(grid,i-1,j);
        traversal(grid,i+1,j);
        traversal(grid,i,j-1);
        traversal(grid,i,j+1);


    }
}
