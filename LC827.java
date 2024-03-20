class Solution {
    int index;
    public int largestIsland(int[][] grid) {
        index = 2;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int cur = dfs(grid, i, j);
                    map.put(index++, cur);
                    max = Math.max(max, cur);
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    max = Math.max(max, findMaxCombine(map, grid, i, j));
                }
            }
        }
        return max;
    }
    private int findMaxCombine(Map<Integer, Integer> map, int[][] grid, int r, int c){
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        if(r - 1 >= 0){
            sum += map.get(grid[r - 1][c]);
            set.add(grid[r - 1][c]);
        }
        if(r + 1 < grid.length && !set.contains(grid[r + 1][c])){
            sum += map.get(grid[r + 1][c]);
            set.add(grid[r + 1][c]);
        }
        if(c - 1 >= 0 && !set.contains(grid[r][c - 1])){
            sum += map.get(grid[r][c - 1]);
            set.add(grid[r][c - 1]);
        }
        if(c + 1 < grid[0].length && !set.contains(grid[r][c + 1])){
            sum += map.get(grid[r][c + 1]);
            set.add(grid[r][c + 1]);
        }
        return sum + 1;
    }
    private int dfs(int[][] grid, int r, int c){
        if(!inArea(grid, r, c)) return 0;
        if(grid[r][c] != 1) return 0;
        grid[r][c] = index;

        return 1 +
        dfs(grid, r, c - 1) +
        dfs(grid, r, c + 1) +
        dfs(grid, r - 1, c) +
        dfs(grid, r + 1, c);
    }
    private boolean inArea(int[][] grid, int r, int c){
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
// O(N^2)
// O(N^2)
