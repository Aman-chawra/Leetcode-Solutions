class Solution {
    
    int[] delrow=new int[]{-1,1,0,0};
    int[] delcol=new int[]{0,0,-1,1};
    Queue<Pair> queue=new LinkedList<>();
    
    public int shortestBridge(int[][] grid)
    {
        int firstx=-1;
        int firsty=-1;
        int n=grid.length;
        
        boolean[][] visited=new boolean[n][n];
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    firstx=i;
                    firsty=j;
                    break;
                }
            }
        }
        
        dfs(firstx,firsty,grid,n);      
     
        int dist=0;
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int i=0;i<size;i++)
            {
                Pair p=queue.remove();
                int currx=p.first;
                int curry=p.second;
                
                for(int j=0;j<4;j++)
                {
                    int newx=currx+delrow[j];
                    int newy=curry+delcol[j];
                    
                    if(newx>=0 && newy>=0 && newx<n && newy<n && grid[newx][newy]==1)
                    {
                        return dist;
                    }
                    
                    else if(newx>=0 && newy>=0 && newx<n && newy<n && grid[newx][newy]==0)
                    {
                        grid[newx][newy]=-1;
                        queue.add(new Pair(newx,newy));
                    }
                    
                }
            }
            dist++;
        }
        return dist;
    }
    
    public void dfs(int i, int j, int[][] grid, int n)
    {
        
        if(i>=0 && j>=0 && i<n && j<n && grid[i][j]==1)
        {
            grid[i][j]=2;
            queue.add(new Pair(i,j));
            dfs(i+1,j,grid,n);
            dfs(i-1,j,grid,n);
            dfs(i,j+1,grid,n);
            dfs(i,j-1,grid,n);
        }
        
        return;
    }
}

class Pair{
    int first;
    int second;
    
    public Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}