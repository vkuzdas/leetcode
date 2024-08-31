package cheatsheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CloneGraph {
    private static class Solution {

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
                // tady zalezi na poradi
                // pokud budes setovat nbrs jenom tech ktere nejsou visited, setnes vzdy jenom jednu hranu
                instances[nbr.val].neighbors.add(instances[node.val]);
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

    static class Node {
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


    private static class SolutionIterative {

        Node [] instances = new Node[101]; // 0 node does not exist

        public Node cloneGraph(Node node) {
            if(node == null) return null;
            copyInstances(node);
            addNeighbors(node);
            return instances[1];
        }

        private void addNeighbors(Node node) {
            boolean[] visited = new boolean[101];

            Stack<Node> S = new Stack<>();
            S.push(node);
            visited[node.val] = true;

            while (!S.empty()) {
                Node top = S.pop();

                for(Node nbr : top.neighbors) {
                    instances[nbr.val].neighbors.add(instances[top.val]);
                    if(!visited[nbr.val]) {
                        visited[nbr.val] = true;
                        S.push(nbr);
                    }
                }
            }
        }

        private void copyInstances(Node node) {
            boolean[] visited = new boolean[101];

            Stack<Node> S = new Stack<>();
            S.push(node);
            visited[node.val] = true;

            while (!S.empty()) {
                Node top = S.pop();

                Node clone = new Node(top.val);
                clone.neighbors = new ArrayList<>();
                instances[clone.val] = clone;

                for(Node nbr : top.neighbors) {
                    if(!visited[nbr.val]) {
                        visited[nbr.val] = true;
                        S.push(nbr);
                    }
                }
            }
        }

    }
}
