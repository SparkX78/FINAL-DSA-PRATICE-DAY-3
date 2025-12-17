public class NumberOFIsland {
    public static int number(int[][] grid){
        if(grid == null || grid.length == 0|| grid[0].length == 0){
            return 0;
        }
        int count = 0 ;
        int rows = grid.length;
        int cols =  grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i, j);
                    count++;
                }
            }
        }
        return count;

    }

    private static void dfs(int[][] grid, int i , int j){
        if(i < 0 || i >= grid.length || j< 0|| j >= grid[0].length || grid[i][j] == 0){
            return;
        }

        
        grid[i][j] = 0;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public static void main(String[] args){
        int[][] grid = { {0, 1, 1, 1},
                         {0, 0, 1, 1},
                         {0, 1, 1, 1},
                         {0, 0, 0, 1}};

        System.out.println("NUMBER OF ISLANDS : " + number(grid));
    }
}
