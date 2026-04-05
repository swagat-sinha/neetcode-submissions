class Solution {
    public boolean canFinish(int nuumCourses, int[][] prerequisites) {
      Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
      for(int i=0;i<nuumCourses;i++){
        adj.put(i,new ArrayList<>());
      }

      for(int[] prerequisite : prerequisites ){
        adj.get(prerequisite[0]).add(prerequisite[1]); //src--> destination
      }

      Set<Integer> visited = new HashSet<>();
      Set<Integer> visiting = new HashSet<>();
      List<Integer> topSort = new ArrayList<>();
      for(int i=0;i<nuumCourses;i++){
        if(!dfs(i,adj,visited,visiting,topSort)){
            return false;
        }
      }
    return true;
    }

    private boolean dfs(int src , Map<Integer,ArrayList<Integer>> adj, Set<Integer> visited, Set<Integer> visiting, List<Integer> topSort){

        if(visited.contains(src)){
            return true;
        }

        if(visiting.contains(src)){
            return false;
        }
        visiting.add(src);

        for( int neighbor : adj.get(src)){
           if(!dfs(neighbor,adj,visited,visiting,topSort)){
            return false; //cycle detected
           }
        }
        visiting.remove(src);
        visited.add(src);
        topSort.add(src);
        return true;

    }
}
//how to solve this question