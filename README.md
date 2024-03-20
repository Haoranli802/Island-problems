# Island_Problem

用深搜解决，岛屿模版
    
    void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」
        
        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    
    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length 
            	&& 0 <= c && c < grid[0].length;
    }

LC200 岛屿数量:

首先遍历2D数组，找到第一个陆地，然后以此陆地为基点，深搜可延伸的陆地，然后标记到过的陆地。继续遍历找到不相邻的陆地视为另一个岛屿。

LC695 最大面积岛屿：

dfs返回面积，或者用一个global variable来记录每个岛屿的陆地面积，去最大值即可。
