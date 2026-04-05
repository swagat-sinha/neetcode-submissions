class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {

        Map<Integer,ArrayList<Integer[]>> adj = new HashMap<>();

        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<Integer[]>());
        }
    for (List<Integer> edge : edges){
        int s =edge.get(0) , d= edge.get(1) ,w = edge.get(2);
        adj.get(s).add(new Integer[]{d,w});
    }   
    Map<Integer,Integer>shortest = new HashMap<>();
    Queue<Integer[]> minHeap = new PriorityQueue<>((n1,n2)->n1[0]-n2[0]);
    minHeap.add(new Integer[]{0,src});

    while(!minHeap.isEmpty()){
        Integer [] curr = minHeap.poll();
        Integer w = curr[0] , n1 = curr[1];
            if(shortest.containsKey(n1)){
                continue;
            }

         shortest.put(n1,w);

         for(Integer[] neighbor :adj.get(n1)){
            Integer w2= neighbor[1] , n2 = neighbor[0];

                if(!shortest.containsKey(n2)){
                    minHeap.add(new Integer[]{w+w2,n2});
                }
            
         }
    }

    for (int i = 0; i < n; i++) {
        if (!shortest.containsKey(i)) {
            shortest.put(i, -1);
        }
    }

    return shortest;
    }  
}