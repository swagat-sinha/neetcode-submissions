class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,ArrayList<Integer[]>> adj = new HashMap<>();

        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<Integer[]>());
        }

        for(int [] time : times){
            int src = time[0] , dest =time[1] , weight = time[2];
            adj.get(src).add(new Integer[]{dest,weight});
        }
        Map<Integer,Integer> shortest = new HashMap<>();    
        Queue<Integer[]> minHeap = new PriorityQueue<>((n1,n2)-> n1[0]-n2[0]);
        minHeap.offer(new Integer[]{0,k});
        int minTime = Integer.MIN_VALUE;
        while(!minHeap.isEmpty()){
                Integer[] curr = minHeap.poll();
                Integer w = curr[0] ,n1 = curr[1];

                if(shortest.containsKey(n1)){
                    continue;
                }
                shortest.put(n1,w);
                for(Integer[] neighbor : adj.get(n1)){
                    Integer n2 = neighbor[0] , w1 = neighbor[1];

                    if(!shortest.containsKey(n2)){
                        minHeap.add(new Integer[]{w+w1,n2});    
                    }
                    


                }
        }

        for(int i=1;i<=n;i++){
            if(!shortest.containsKey(i)){
              return -1;
            }
            minTime = Math.max(minTime,shortest.get(i));
        }

    return minTime;
   }
}
