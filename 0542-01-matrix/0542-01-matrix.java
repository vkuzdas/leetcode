class Solution {
        int[][] M;
        int[][] D;
        boolean[][]V;
        Queue<int[]> Q;

        public int[][] updateMatrix(int[][] mat) {
            M = mat;

            V = new boolean[M.length][M[0].length];
            D = new int[M.length][M[0].length];
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[0].length; j++) {
                    D[i][j] = Integer.MAX_VALUE;
                }
            }

            Q = new ArrayDeque<>();
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[0].length; j++) {
                    if (M[i][j] == 0) {
                        Q.add(new int[]{i,j}); // add all zeros to Q
                        V[i][j] = true;
                        D[i][j] = 0;
                    }
                }
            }

            while (!Q.isEmpty()) {
                int[] top = Q.poll();
                int i = top[0];
                int j = top[1];

                if (i < M.length-1 && !V[i+1][j]) {
                    D[i+1][j] = D[i][j]+1;
                    V[i+1][j] = true;
                    Q.add(new int[] {i+1,j});
                }
                if (j < M[0].length-1 && !V[i][j+1]) {
                    D[i][j+1] = D[i][j]+1;
                    V[i][j+1] = true;
                    Q.add(new int[] {i,j+1});
                }
                if (i > 0 && !V[i-1][j]) {
                    D[i-1][j] = D[i][j]+1;
                    V[i-1][j] = true;
                    Q.add(new int[] {i-1,j});
                }
                if (j > 0 && !V[i][j-1]) {
                    D[i][j-1] = D[i][j]+1;
                    V[i][j-1] = true;
                    Q.add(new int[] {i,j-1});
                }
            }

            return D;
        }
}