class UnionFind {
    int[] parent;

    public UnionFind(int n){
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int a,int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return false;

        parent[pb] = pa;
        return true;
    }
}

class Solution {

    public int minimumSpanningTree(List<List<Integer>> edges, int n) {

        Queue<int[]>minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(List<Integer> edge : edges){
            int s=edge.get(0) , d =edge.get(1) , w=edge.get(2);
            minHeap.add(new int[]{w,s,d});
        }
        UnionFind unionFind = new UnionFind(n);

        List<Integer[]> mst = new ArrayList<>(); //to store mst (only edges I am storing)
        int totalWeight =0;
        while(mst.size() < n-1 && !minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int w = curr[0] ,  n1 =curr[1] ,  n2 =curr[2];

            if(!unionFind.union(n1,n2)){
                continue;
            }
            totalWeight+=w;
            mst.add(new Integer[]{n1,n2});
        }

    return mst.size()==n-1 ? totalWeight:-1;

    }
}
