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


        if(node == null){
            return null;
        }
        Map<Node,Node> mp = new HashMap<>();
       return cloneGraphHelper(node,mp);        
    }

    private Node cloneGraphHelper(Node node, Map<Node,Node> mp){
    if(mp.containsKey(node)){
        return mp.get(node);
    }
    Node cloneNode = new Node(node.val);
    mp.put(node,cloneNode);
    for(Node neighbor : node.neighbors){
        cloneNode.neighbors.add(cloneGraphHelper(neighbor,mp));
    }

return cloneNode;
    }
}