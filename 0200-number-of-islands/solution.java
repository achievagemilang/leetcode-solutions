class Solution {
    public int numIslands(char[][] grid) {
        int numIsland = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    traverseIsland(i, j, visited, grid);
                    numIsland++;
                }
            }
        }

        return numIsland;
    }

    public void traverseIsland(int i, int j, boolean[][] visited, char[][] grid){
        if(isOutOfBounds(i, j, grid)) return;
        if(visited[i][j]) return;
        if(grid[i][j] == '0') return;

        visited[i][j] = true;

        int[][] directions = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};
        for(int[] dir: directions){
            int nextRow = i + dir[0];
            int nextCol = j + dir[1];

            traverseIsland(nextRow, nextCol, visited, grid);
        }
    }

    public boolean isOutOfBounds(int i, int j, char[][] grid){
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length; 
    }
}

