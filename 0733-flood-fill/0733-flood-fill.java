class Solution {
        int[][] M;
        int NEW_COL;
        int SRC_COL;
        HashSet<int[]> VISITED;

        public int[][] floodFill(int[][] image, int r, int c, int color) {
            M = image;
            NEW_COL = color;
            VISITED = new HashSet<>();
            SRC_COL = M[r][c];
            if (M[r][c] == NEW_COL) return M;

            DFS(r, c);
            return M;
        }

        void DFS(int r, int c) {
            if (M[r][c] != SRC_COL || VISITED.contains(new int[]{r,c})) {
                return;
            }
            else {
                M[r][c] = NEW_COL;
                VISITED.add(new int[]{r,c});
                if (r > 0)          DFS(r-1, c);
                if (c > 0)          DFS(r, c-1);
                if (r < M.length-1) DFS(r+1, c);
                if (c < M[0].length-1) DFS(r, c+1);
            }
        }
}