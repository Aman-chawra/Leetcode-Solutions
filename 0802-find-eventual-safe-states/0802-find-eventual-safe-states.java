class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer>res=new LinkedList<>();
        if(graph == null || graph.length == 0)
            return res;
        
        int n=graph.length;
        int[] color=new int[n];
        
        for(int i=0;i<n;i++) {
            
            if(dfs(graph, i, color))
                res.add(i);
        }
        
        return res;
    }
    
    public boolean dfs(int[][] graph, int u, int[] color) {
        if(color[u]!=0)
            return color[u]==1;
        
        color[u]=2;
        
        for(int v : graph[u]) {
            
            if(!dfs(graph, v, color))
                return false;
        }
        color[u]=1;
        return true;
    }
}