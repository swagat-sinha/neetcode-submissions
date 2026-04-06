class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
    Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

    for(int i=0;i<n;i++){
        adj.put(i,new ArrayList<Integer>());
    }  

    for(int[] edge : edges){
        int src= edge[0] ,dest = edge[1];
        adj.get(src).add(dest);
    }

    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();
    List<Integer> topSort = new ArrayList<>();
    for(int i=0;i<n;i++){
        if(!dfs(i,adj,visited,visiting,topSort)){
            return new ArrayList<>();
        }
    }
    Collections.reverse(topSort);

    return topSort;
    }


    private boolean dfs(int src , Map<Integer,ArrayList<Integer>> adj , Set<Integer> visited, Set<Integer> visiting ,List<Integer> topSort ){


        if(visiting.contains(src)){
            return false; //cycle detected
        }

        if(visited.contains(src)){
        return true;
    }

        visiting.add(src);

        for(Integer neighbor :  adj.get(src)){
    if(!dfs(neighbor,adj,visited,visiting,topSort)){
        return false;
    }
}
visiting.remove(src);
visited.add(src);
topSort.add(src);
return true;

    }

    
}