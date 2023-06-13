class Solution {
    public int equalPairs(int[][] grid) {
      int n = grid.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> rowList = new ArrayList<>();
                List<Integer> colList = new ArrayList<>();
                
                for (int k = 0; k < n; k++) {
                    rowList.add(grid[i][k]);
                    colList.add(grid[k][j]);
                }
                
                if (rowList.equals(colList)) {
                    count++;
                }
            }
        }
        
        return count;   
    }
}