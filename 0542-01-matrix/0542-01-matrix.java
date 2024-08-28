class Solution {
        int [][] M;
        boolean [][] VIS;
        int [][] D;
        public int[][] updateMatrix(int[][] mat) {
            M = mat;
            VIS = new boolean[M.length][M[0].length];
            D = new int[M.length][M[0].length];

            Queue<int[]> Q = new ArrayDeque<>();

            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[0].length; j++) {
                    if (M[i][j] == 0) {
                        Q.add(new int[]{i,j});
                        VIS[i][j] = true;
                        D[i][j] = 0;
                    }
                }
            }

            while (!Q.isEmpty()) {
                int [] top = Q.poll();
                int i = top[0];
                int j = top[1];

                if (j > 0 && !VIS[i][j-1]) {
                    D[i][j - 1] = D[i][j] + 1;
                    Q.add(new int[]{i,j-1});
                    VIS[i][j-1] = true;
                }
                if (j < M[0].length-1 && !VIS[i][j+1]) {
                    D[i][j + 1] = D[i][j] + 1;
                    Q.add(new int[]{i,j+1});
                    VIS[i][j+1] = true;
                }
                if (i > 0 && !VIS[i-1][j]) {
                    D[i - 1][j] = D[i][j] + 1;
                    Q.add(new int[]{i-1,j});
                    VIS[i-1][j] = true;
                }
                if (i < M.length-1 && !VIS[i+1][j]) {
                    D[i + 1][j] = D[i][j] + 1;
                    Q.add(new int[]{i+1,j});
                    VIS[i+1][j] = true;
                }
            }
            return D;
        }
}