class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int [] parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }

        for(int [] edge : edges){
            if(!union(parent,edge[0],edge[1])){
                return edge;
            }
        }

        return new int[0];
    }

    private int find(int parent[] ,int node){
        if(parent[node]!=node){
            parent[node]=find(parent,parent[node]);
        }
        return parent[node];
    }

    private boolean union(int parent[],int node1 ,int node2){
        int root1 = find(parent,node1);
        int root2 = find(parent,node2);

        if(root1==root2){
            return false;
        }
        parent[root1]=root2;

        return true;
    }
}
