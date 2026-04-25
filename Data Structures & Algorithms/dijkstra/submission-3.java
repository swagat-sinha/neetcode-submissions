class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int source = edge.get(0), dest = edge.get(1), weight = edge.get(2);
            adj.get(source).add(new Integer[] {dest, weight});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        minHeap.add(new int[] {0, src});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1=curr[0] , n1=curr[1];

            if(shortest.containsKey(n1)){
                continue;
            }
            shortest.put(n1,w1);

            for(Integer [] neighbor : adj.get(n1)){
               int n2= neighbor[0] ,w2=neighbor[1];

               if(!shortest.containsKey(n2)){
                minHeap.add(new int[]{w1+w2,n2});
               }
            }
        }

        for(int i=0;i<n;i++){
            if(!shortest.containsKey(i)){
                shortest.put(i,-1);
            }
        }

        return shortest;
    }
}
