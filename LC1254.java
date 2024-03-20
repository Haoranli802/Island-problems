class Solution {
    public int closedIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] == 0) dfs(grid, i, 0);
            if(grid[i][grid[0].length - 1] == 0) dfs(grid, i, grid[0].length - 1);
        }
        for(int j = 0; j < grid[0].length; j++){
            if(grid[0][j] == 0) dfs(grid, 0, j);
            if(grid[grid.length - 1][j] == 0) dfs(grid, grid.length - 1, j);
        }
        int res = 0;
        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length - 1; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }
    private void dfs(int[][] grid, int r, int c){
        if(!inArea(grid, r, c)) return;
        if(grid[r][c] == 1) return;
        grid[r][c] = 1;
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
    }
    private boolean inArea(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
// O（MN）， O（MN）
