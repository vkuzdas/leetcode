class Solution {
                class Coord {
            int x;
            int y;

            public Coord(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Coord coord = (Coord) o;
                return x == coord.x && y == coord.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        int EMPTY = 0;
        int FRESH = 1;
        int ROTT = 2;
        public int orangesRotting(int[][] grid) {
            int[][] paths = new int[grid.length][grid[0].length];
            HashSet<Coord> fresh = new HashSet<>();
            Queue<int[]> Q = new ArrayDeque<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == ROTT) {
                        Q.add(new int[]{i,j});
                    }
                    if (grid[i][j] == FRESH) {
                        fresh.add(new Coord(i,j));
                    }
                }
            }

            int maxPath = 0;
            while (!Q.isEmpty()) {
                int[] curr = Q.poll();
                int i = curr[0];
                int j = curr[1];

                if (i > 0 && grid[i-1][j] == FRESH) {
                    Q.add(new int[]{i - 1, j});
                    paths[i-1][j] = paths[i][j] + 1;
                    maxPath = Math.max(maxPath, paths[i-1][j]);
                    grid[i-1][j] = ROTT;
                    fresh.remove(new Coord(i-1, j));
                }

                if (i < grid.length-1 && grid[i+1][j] == FRESH) {
                    Q.add(new int[]{i + 1, j});
                    paths[i+1][j] = paths[i][j] + 1;
                    maxPath = Math.max(maxPath, paths[i+1][j]);
                    grid[i+1][j] = ROTT;
                    fresh.remove(new Coord(i+1, j));
                }

                if (j > 0 && grid[i][j-1] == FRESH) {
                    Q.add(new int[]{i, j - 1});
                    paths[i][j-1] = paths[i][j] + 1;
                    maxPath = Math.max(maxPath, paths[i][j-1]);
                    grid[i][j-1] = ROTT;
                    fresh.remove(new Coord(i, j-1));
                }

                if (j < grid[0].length-1 && grid[i][j+1] == FRESH) {
                    Q.add(new int[]{i, j + 1});
                    paths[i][j+1] = paths[i][j] + 1;
                    maxPath = Math.max(maxPath, paths[i][j+1]);
                    grid[i][j+1] = ROTT;
                    fresh.remove(new Coord(i, j+1));
                }
            }

            return fresh.isEmpty() ? maxPath : -1;
        }
}