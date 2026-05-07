class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (!union(node1, node2, parent)) {
                return false;
            }
        }
        return true;
    }

    private int find(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }

        return parent[node];
    }

    private boolean union(int n1, int n2, int[] parent) {
        int root1 = find(n1,parent);
        int root2 = find(n2,parent);
        if (root1 == root2) {
            return false;
        }
        parent[root1] = root2;
        return true;
    }
}
