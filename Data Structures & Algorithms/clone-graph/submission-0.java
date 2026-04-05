/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null){
            return null;
        }

      HashMap<Node,Node> mp = new HashMap<>();
      Node clonedGraph = dfs(node,mp);
       return clonedGraph;
        
    }

    private Node dfs(Node node,HashMap<Node,Node> mp){
        // if node already cloned
        if(mp.containsKey(node)){
           return mp.get(node); 
        }
        Node clonedNode = new Node(node.val);
        mp.put(node,clonedNode);
        
        for(Node neighbor : node.neighbors ){
           clonedNode.neighbors.add(dfs(neighbor,mp));
        }

        return clonedNode;    
    }
}