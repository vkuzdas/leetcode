class Solution {
        int [][] M;
        boolean [][] V;
        int newColor;
        int startColor;
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {

            M = image;
            startColor = image[sr][sc];
            newColor = color;
            V = new boolean[M.length][M[0].length];

            if (image[sr][sc] != newColor)
                BFS(sr, sc);

            return M;
        }

        private void BFS(int i, int j) {
            if (M[i][j] == startColor) {
                M[i][j] = newColor;
            } else {
                return;
            }
            V[i][j] = true;

            if (i < M.length-1 && !V[i+1][j])
                BFS(i+1,j);

            if (j < M[0].length-1 && !V[i][j+1])
                BFS(i,j+1);

            if (i > 0 && !V[i-1][j])
                BFS(i-1,j);

            if (j > 0 && !V[i][j-1])
                BFS(i,j-1);
        }
}