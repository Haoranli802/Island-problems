class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for(int i = 0; i < grid1.length; i++){
            for(int j = 0; j < grid1[0].length; j++){
                if(grid1[i][j] == 0 && grid2[i][j] == 1){
                    dfs(grid2, i, j);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < grid1.length; i++){
            for(int j = 0; j < grid1[0].length; j++){
                if(grid2[i][j] == 1){
                    dfs(grid2, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(int[][] grid, int r, int c){
        if(!inArea(grid, r, c)) return;
        if(grid[r][c] == 0) return;
        grid[r][c] = 0;

        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
    }
    private boolean inArea(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
//O（MN），O（MN）
