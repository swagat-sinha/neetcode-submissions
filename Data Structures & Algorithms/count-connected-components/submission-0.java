class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int count =0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(adj,i,visited);
                count++;
            }
        }
        return count;
    }


    private void dfs(List<List<Integer>> adj, int src, Set<Integer> visited){

        if(visited.contains(src)){
            return;
        }

        visited.add(src);

        for(Integer neighbor : adj.get(src)){
            if(!visited.contains(neighbor)){
                dfs(adj,neighbor,visited);
            }
        }
    }
}
