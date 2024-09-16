class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // indeg
        // since input graph is DAG, you can just return all with 0 indeg
        int[] indeg = new int[n];
        for (List<Integer> edge : edges) {
            int dst = edge.get(1);   // from i to dst of i
            indeg[dst]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i]==0) res.add(i);
        }
        return res;


    }
}