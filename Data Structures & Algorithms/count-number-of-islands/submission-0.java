class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    traversal(grid,visited,i,j);
                    count++;
                    }
            }
        }
        return count;
    }

    public void traversal(char[][] grid,boolean[][] visited,int i , int j){
        
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i >=m || j>=n){
            return;
        }

        if(grid[i][j]=='0' || visited[i][j]){
            return;
        }

        visited[i][j]= true;

        traversal(grid,visited,i-1,j);
        traversal(grid,visited,i+1,j);
        traversal(grid,visited,i,j-1);
        traversal(grid,visited,i,j+1);


    }
}
