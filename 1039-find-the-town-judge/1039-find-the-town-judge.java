class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n+1];
        int[] outdeg = new int[n+1];
        for (int i = 0; i < trust.length; i++) {
            int[] edge = trust[i];
            int src = edge[0];
            int dst = edge[1];
            outdeg[src]++;
            indeg[dst]++;
        }

        for (int i = 1; i < n+1; i++) {
            if(outdeg[i] == 0 && indeg[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}