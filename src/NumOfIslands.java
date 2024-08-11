
//https://leetcode.com/problems/number-of-islands/description/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class NumOfIslands {


    public static void main(String[] args) {
//        System.out.println(
//            Solution.numIslands(new char[][]
//                    {
//                            {'1','1','1','1','0'},
//                            {'1','1','0','1','0'},
//                            {'1','1','0','0','0'},
//                            {'0','0','0','0','0'}
//                    })
//        );
//        System.out.println(
//            Solution.numIslands(new char[][]
//                    {
//                            {'1','1','1'},
//                            {'0','1','0'},
//                            {'1','1','1'}
//                    })
//        );
        System.out.println(
            Solution.numIslands(new char[][]
                    {
                            {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                            {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                            {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                            {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                            {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                            {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                            {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                            {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                            {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                            {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                            {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
                    })
        );


    }

    class Solution {
        public static int numIslands(char[][] grid) {
            int I = 0;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j]) {
                        if (grid[i][j] == '0') {
                            visited[i][j] = true;
                        }
                        else {
                            // start BFS from first island node, once all land from this icon
                            startBFS(new Pair(i,j), grid, visited);
                            I++;
                        }
                    }
                }
            }
            return I;
        }
        private static void startBFS(Pair from, char[][] grid, boolean[][] visited) {
            Queue<Pair> Q = new ArrayDeque<>();
            Q.add(from);
            visited[from.i][from.j] = true;

            while(!Q.isEmpty()) {
                Pair curr = Q.poll();

                ArrayList<Pair> nbrs = getNeighbors(curr, grid, visited);
                for (Pair p : nbrs) {
                    if (!visited[p.i][p.j]) {
                        Q.add(p);
                        visited[p.i][p.j] = true;
                    }
                }
            }
        }

        /**
         * Given XY position, grid and visited, return neighboring unvisited '1's
         */
        private static ArrayList<Pair> getNeighbors(Pair curr, char[][] grid, boolean[][] visited) {
            ArrayList<Pair> nbrs = new ArrayList<>();
            int imax = grid.length-1;
            int jmax = grid[0].length-1;

            // left
            if(curr.j != 0)
                if (grid[curr.i][curr.j-1] == '1' && !visited[curr.i][curr.j-1]) {
                    nbrs.add(new Pair(curr.i, curr.j-1));
                }
            // right
            if (curr.j < jmax)
                if (grid[curr.i][curr.j+1] == '1' && !visited[curr.i][curr.j+1]) {
                    nbrs.add(new Pair(curr.i, curr.j+1));
                }
            //up
            if (curr.i != 0)
                if (grid[curr.i-1][curr.j] == '1' && !visited[curr.i-1][curr.j]) {
                    nbrs.add(new Pair(curr.i-1, curr.j));
                }
            // down
            if (curr.i < imax)
                if (grid[curr.i+1][curr.j] == '1' && !visited[curr.i+1][curr.j]) {
                    nbrs.add(new Pair(curr.i+1, curr.j));
                }

            //---------------
//
//        //left-up
//        if (curr.i != 0 && curr.j != 0)
//            if (grid[curr.i-1][curr.j-1] == 1 && !visited[curr.i][curr.j]) {
//                nbrs.add(new Pair(curr.i-1, curr.j-1));
//            }
//        //left-down
//        if (curr.i < imax && curr.j != 0)
//            if (grid[curr.i+1][curr.j-1] == 1 && !visited[curr.i][curr.j]) {
//                nbrs.add(new Pair(curr.i+1, curr.j-1));
//            }
//        //right-up
//        if (curr.i != 0 && curr.j < jmax)
//            if (grid[curr.i-1][curr.j+1] == 1 && !visited[curr.i][curr.j]) {
//                nbrs.add(new Pair(curr.i-1, curr.j+1));
//            }
//        //right-down
//        if (curr.i < imax && curr.j < jmax)
//            if (grid[curr.i+1][curr.j+1] == 1 && !visited[curr.i][curr.j]) {
//                nbrs.add(new Pair(curr.i-1, curr.j+1));
//            }
            return nbrs;
        }

        static class Pair {
            int i;
            int j;

            public Pair(int i, int j) {
                this.i = i;
                this.j = j;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "i=" + i +
                        ", j=" + j +
                        '}';
            }
        }
    }



}

