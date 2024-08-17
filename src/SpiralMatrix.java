import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
//        System.out.println(s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(s.spiralOrder(new int[][]{
                {1  ,2  ,3  ,4},
                {5  ,6  ,7  ,8},
                {9  ,10 ,11 ,12},
                {13 ,14 ,15 ,16},
                {17 ,18 ,19 ,20},
                {21 ,22 ,23 ,24}
        }));
    }

    /**
     * Traverse matrix in a spiral order
     */
    private static class Solution {

        private final char RIGHT = 'r';
        private final char DOWN  = 'd';
        private final char LEFT  = 'l';
        private final char UP    = 'u';

        public List<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> ret = new ArrayList<>();

            boolean[][] visited = new boolean[matrix.length][matrix[0].length];

            int[] curr = new int[]{0,0};
            ret.add(matrix[curr[0]][curr[1]]);
            visited[curr[0]][curr[1]] = true;

            char[] direction = new char[1];
            direction[0] = RIGHT;

            while(nextPosValid(curr, matrix, visited, direction)) {
                int i = curr[0]; // current ROW
                int j = curr[1]; // current COL

                ret.add(matrix[i][j]);
                visited[i][j] = true;
            }
            return ret;
        }

        /**
         * returns whether there is a neighboring field that we are allowed to visit
         *      1) continue in the set direction
         *      2) if that is not possible, change the direction
         *      3) if the second direction cannot be followed, then there are no other fields to visit, return FALSE
         */
        private boolean nextPosValid(int[] curr, int[][] matrix, boolean[][] visited, char[] direction) {
            char newDir = 'x';
            if (direction[0] == RIGHT) {
                // check the next right pos
                if (curr[1]+1 < matrix[0].length && !visited[curr[0]][curr[1]+1]) {
                    curr[1]++; 
                } else {
                    newDir = DOWN;
                }
            }
            else if (direction[0] == DOWN) {
                if (curr[0]+1 < matrix.length && !visited[curr[0]+1][curr[1]]) {
                    curr[0]++;
                } else {
                    newDir = LEFT;
                }
            }
            else if (direction[0] == LEFT) {
                if (curr[1]-1 >= 0 && !visited[curr[0]][curr[1]-1]) {
                    curr[1]--; 
                } else {
                    newDir = UP;
                }
            }
            else if (direction[0] == UP) {
                if (curr[0]-1 > 0 && !visited[curr[0]-1][curr[1]]) {
                    curr[0]--; 
                } else {
                    newDir = RIGHT;
                }
            }

            if (newDir == 'x') {
                // new dir was not set, therefore next pos is valid
                return true;
            }


            // Try going new direction
            // if that does not work either, return false
            if (newDir == RIGHT) {
                // check the next right pos
                if (curr[1]+1 <= matrix[0].length && !visited[curr[0]][curr[1]+1]) {
                    curr[1]++; 
                } else {
                    return false;
                }
            }
            else if (newDir == DOWN) {
                if (curr[0]+1 < matrix.length && !visited[curr[0]+1][curr[1]]) {
                    curr[0]++;
                } else {
                    return false;
                }
            }
            else if (newDir == LEFT) {
                if (curr[1]-1 >= 0 && !visited[curr[0]][curr[1]-1]) {
                    curr[1]--; 
                } else {
                    return false;
                }
            }
            else if (newDir == UP) {
                if (curr[0]-1 >= 0 && !visited[curr[0]-1][curr[1]]) {
                    curr[0]--; 
                } else {
                    return false;
                }
            }
            direction[0] = newDir;
            return true;
        }
    }
}
