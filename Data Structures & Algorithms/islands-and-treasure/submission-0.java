class Solution {
    private static final int INF = 2147483647 ;
    public void islandsAndTreasure(int[][] grid) {
       if(grid==null ||grid.length==0){
        return;
       } 

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
       //traverse the grid

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        //multi source bfs

        while(!queue.isEmpty()){
            int [] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int [] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow<0 || newCol<0 || newRow >=m || newCol>=n){
                    continue;
                }

                if(grid[newRow][newCol]==INF){
                    grid[newRow][newCol] = grid[row][col]+1;
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }
    }
}
