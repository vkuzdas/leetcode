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
        Node [] instances = new Node[101]; // 0 node does not exist
        boolean[] visited = new boolean[101];

        public Node cloneGraph(Node node) {
            if(node == null) return null;
            copyInstance(node);
            visited = new boolean[101];
            addNeighbors(node);
            return instances[1];
        }

        private void addNeighbors(Node node) {
            if (visited[node.val]) return;
            visited[node.val] = true;

            for(Node nbr : node.neighbors) {
                instances[nbr.val].neighbors.add(instances[node.val]); // add parent as neighbor of child
                if (!visited[nbr.val]) {
                    addNeighbors(nbr);
                }
            }
        }

        private void copyInstance(Node node) {
            if (visited[node.val]) return;

            Node clone = new Node(node.val);
            clone.neighbors = new ArrayList<>();
            instances[node.val] = clone;
            visited[node.val] = true;

            for(Node nbr : node.neighbors) {
                if (!visited[nbr.val]) {
                    copyInstance(nbr);
                }
            }
        }
}