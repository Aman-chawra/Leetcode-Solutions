class Solution {
    int m,n;
    int[][] dirs = new int[][] { {1 ,0}, {-1 ,0} ,{0 ,1}, {0, -1},
                             {1 , 1}, {-1 , -1},{-1 , 1},{1, - 1}};

    
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.m = grid.length;
        this.n = grid.length;
        
      if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0 , 0});
        grid[0][0] = 1;

        int res = 0;

        while(!q.isEmpty())
        {
            int sz = q.size();
            res += 1;
            
            for(int i = 0;i < sz;i++)
            {
                int[] curr = q.poll();

                int x = curr[0] ,y = curr[1];
                
             if(x == m - 1 && y == n - 1) return res;  

                for(int[] dir : dirs)
                {
                   int nx = dir[0] + x;
                   int ny = dir[1] + y;
                   
                   if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0) continue;
                    
                  grid[nx][ny] = 1;  
                   q.add(new int[] {nx,ny});
                }
            }

        }

        return -1;  
    }
}