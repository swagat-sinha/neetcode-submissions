class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //prepare adjacency list
        Map<Integer,ArrayList<ArrayList<Integer>>> adj = new HashMap<>();
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<ArrayList<Integer>>());
        }

        for(int[] time : times){
            int source = time[0];
            int dest = time[1];
            int weight = time[2];
            adj.get(source).add(new ArrayList<>(Arrays.asList(dest,weight)));
        }

        Map<Integer,Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        minHeap.offer(new int[]{0,k});
        while(!minHeap.isEmpty()){
            int []curr =minHeap.poll();
            int currTime = curr[0];
            int currNode = curr[1];

            if(shortest.containsKey(currNode)){
                continue;
            }
            shortest.put(currNode,currTime);

            for( ArrayList<Integer> neighbor : adj.get(currNode)){

                int neighborNode = neighbor.get(0);
                int neighborWeight = neighbor.get(1);

                if(!shortest.containsKey(neighborNode)){
                     minHeap.offer(new int[] {currTime+neighborWeight, neighborNode});
                }
               
            }
        }
        int minTime = 0;
        for(int i=1;i<=n;i++){
            if(!shortest.containsKey(i)){
                return -1;
            }
            minTime = Math.max(minTime,shortest.get(i));

        }
        return minTime;
    }
}
