class Solution {
    int current;
    public int maxAreaOfIsland(int[][] grid) {
        current = 0;
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    if(current > max) max = current;
                    current = 0;
                }
            }
        }
        return max;
    }
    private void dfs(int[][] grid, int r, int c){
        if(!inArea(grid, r, c)) return;
        if(grid[r][c] != 1) return;
        grid[r][c] = 2;
        current ++;

        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
    }
    private boolean inArea(int[][] grid, int r, int c){
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
// O(M* N)
// O(M* N)
