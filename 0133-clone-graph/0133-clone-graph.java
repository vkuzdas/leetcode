/*
// Definition for a Node.
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
        boolean [] visited = new boolean[101];
        Node[] instances = new Node[101];
        
        public Node cloneGraph(Node node) {
            if(node == null) return null;
            fillInstances(node);
            visited = new boolean[101];
            setNeighbours(node);
            return instances[1];
        }

        private void setNeighbours(Node node) {
            for (Node nbr : node.neighbors) {
                // create bidirectional link between parent-neighbor instances
                instances[node.val].neighbors.add(instances[nbr.val]);
                instances[nbr.val].neighbors.add(instances[node.val]);
                setNeighbours(nbr);
            }
        }


        void fillInstances(Node node) {
            visited[node.val] = true;
            Node newNode = new Node(node.val);
            newNode.neighbors = new ArrayList<>();
            instances[newNode.val] = newNode;
            for (Node nbr : node.neighbors) {
                if(!visited[nbr.val]) {
                    fillInstances(node);
                }
            }
        }
}