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
        public Node cloneGraph(Node node) {
            if (node==null) return null;
            HashSet<Node> visited = new HashSet<>();
            HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
            Stack<Node> S = new Stack<>();
            S.add(node);
            visited.add(node);

            while (!S.empty()) {
                Node curr = S.pop();
                ArrayList<Integer> nbrsOfCurr = new ArrayList<>();
                for(Node nbr : curr.neighbors) {
                    nbrsOfCurr.add(nbr.val);
                    if (visited.contains(nbr)) continue;
                    S.add(nbr);
                    visited.add(nbr);
                }
                adj.put(curr.val, nbrsOfCurr);
            }


            // instances
            Node[] instances = new Node[adj.size()+1]; // 0th index is empty
            for (int i = 1; i < adj.size()+1; i++) {
                instances[i] = new Node(i);
                instances[i].neighbors = new ArrayList<>();
            }

            // neighbors
            for (int i = 1; i < adj.size()+1; i++) {
                for (int nbr : adj.get(i)) {
                    instances[i].neighbors.add(instances[nbr]);
                }
            }

            return instances[1];

        }
}