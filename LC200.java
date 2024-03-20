class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int column){
        if(!inArea(grid, row, column)){
            return;
        }
        if(grid[row][column] != '1') return;

        grid[row][column] = '2';
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }
    private boolean inArea(char[][] grid, int r, int c){
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
// O(MN), O(MN)
