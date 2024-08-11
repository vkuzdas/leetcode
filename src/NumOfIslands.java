
//https://leetcode.com/problems/number-of-islands/description/

public class NumOfIslands {


    public static void main(String[] args) {
        Solution.numIslands(new char[][]
                {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                });
    }

    class Solution {
        public static int numIslands(char[][] grid) {
            int I = 0;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j]) {
                        if (grid[i][j] == 0) {
                            visited[i][j] = true;
                        }
                        else {
                            // start BFS from first island node, once all land from this icon

                            startBFS(new Pair(i,j), grid, visited, I);
                        }
                    }
                }
            }
            return I;
        }
    }

    private static void startBFS(Pair from, char[][] grid, boolean[][] visited, int i) {


    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}

