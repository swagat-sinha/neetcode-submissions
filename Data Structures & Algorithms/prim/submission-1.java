class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(Arrays.asList(d, w));
            adj.get(d).add(Arrays.asList(s, w));
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (List<Integer> neighbour : adj.get(0)) {
            int neighbourNode = neighbour.get(0), w = neighbour.get(1);
            minHeap.add(new int[] {w, 0, neighbourNode});
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int totalWeight =0;
        while (!minHeap.isEmpty() && visited.size() < n) {

            int[] curr = minHeap.poll();
            int w = curr[0] ,n1=curr[1] , n2=curr[2];
            if(visited.contains(n2)){
                continue;
            }
            totalWeight +=w;
            visited.add(n2);

            for(List<Integer> neighbour :adj.get(n2)){
                int neighbourNode = neighbour.get(0) ,  neighbourWeight = neighbour.get(1);

                if(!visited.contains(neighbourNode)){
                    minHeap.add(new int[]{neighbourWeight,n2,neighbourNode});
                }
            }
        }

        return visited.size()==n ?totalWeight : -1;
    }
}
