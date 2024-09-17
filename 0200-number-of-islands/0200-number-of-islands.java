class Solution {
    boolean[][] VISITED;
    char[][] GRID;
    public int numIslands(char[][] grid) {
        int count = 0;
        GRID = grid;
        VISITED = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (VISITED[i][j]) continue;
                
                if (GRID[i][j] == '0') {
                    VISITED[i][j] = true;
                }
                else if (GRID[i][j] == '1') {
                    DFS(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFS(int i, int j) {
        VISITED[i][j] = true;

        if(i < GRID.length-1 && !VISITED[i+1][j] && GRID[i+1][j] == '1')
            DFS(i+1,j);

        if(i > 0 && !VISITED[i-1][j] && GRID[i-1][j] == '1')
            DFS(i-1,j);

        if(j < GRID[0].length-1 && !VISITED[i][j+1] && GRID[i][j+1] == '1')
            DFS(i,j+1);

        if(j > 0 && !VISITED[i][j-1] && GRID[i][j-1] == '1')
            DFS(i,j-1);
    }
}