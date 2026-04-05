class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {

        Map<Integer,ArrayList<ArrayList<Integer>>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<ArrayList<Integer>>());
        }

        for( List<Integer> edge : edges){
            int source = edge.get(0);
            int dest = edge.get(1);
            int weight = edge.get(2);
            adj.get(source).add(new ArrayList<>(Arrays.asList(dest,weight)));
        }

        Map<Integer,Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        minHeap.offer(new int[]{0,src});

        while(!minHeap.isEmpty()){
         int [] curr = minHeap.poll();
         int cost = curr[0]; 
         int node = curr[1];

         if(shortest.containsKey(node)){
            continue;
         }   

         shortest.put(node,cost);
         for(List<Integer> neighbor : adj.get(node)){
            int neighborNode = neighbor.get(0);
            int neighborWeight = neighbor.get(1);

            if(!shortest.containsKey(neighborNode)){
                minHeap.offer(new int[]{cost + neighborWeight, neighborNode});
            }
         }
        }

        for(int i=0; i<n; i++) {
            if(!shortest.containsKey(i)) shortest.put(i, -1);
        }

        return shortest;
    }  
}