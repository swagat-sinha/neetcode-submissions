class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,ArrayList<Integer>>adj = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        List<Integer> topSort = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adj,visited,visiting,topSort)){
                return new int[0];
            }
        }
      int [] result = new int[numCourses];
      for(int i=0;i<numCourses;i++){
        result[i]=topSort.get(i);
      }
        return result;
    }
    private boolean dfs(int src, Map<Integer,ArrayList<Integer>>adj, Set<Integer>visited,Set<Integer>visiting,List<Integer>topSort){

      if(visited.contains(src)){
        return true;
      }  
      if(visiting.contains(src)){
        return false;
      }
      visiting.add(src);

      for(int neighbor : adj.get(src)){
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
