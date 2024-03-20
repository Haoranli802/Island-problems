class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    private int dfs(int[][] grid, int r, int c){
        if(!inArea(grid, r, c)){
            return 1;
        }
        if(grid[r][c] == 0) return 1;
        if(grid[r][c] != 1) return 0;
        grid[r][c] = 2;

        return dfs(grid, r, c - 1) +
                dfs(grid, r, c + 1) +
                dfs(grid, r - 1, c) +
                dfs(grid, r + 1, c);
    }
    private boolean inArea(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
// O(MN), O(MN)
//深搜

class Solution {
    public int islandPerimeter(int[][] grid) {
        int inland = 0;
        int outland = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    outland ++;
                    if(i + 1 < grid.length && grid[i + 1][j] == 1){
                        inland ++;
                    }
                    if(j + 1 < grid[0].length && grid[i][j + 1] == 1){
                        inland ++;
                    }
                }
            }
        }
        return 4 * outland - 2 * inland;
    }
}
// O(MN), O(1)
// 数论
