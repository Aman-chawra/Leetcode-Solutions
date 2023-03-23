class Solution {
    public int makeConnected(int n, int[][] connections) {
        if((n-1)>connections.length) return -1;
        List<List<Integer>> adj =new ArrayList<>();
        for( int i=0; i<=n ;i++){
            adj.add(new ArrayList());
        }
        for(int i=0; i<connections.length ;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean[] vis = new boolean[n];
        int count=0;
        dfs(adj,vis,0);
        vis[0]=true;
        for(int i=0; i<n;i++){
            if(vis[i]==false){
                count++;
                dfs(adj,vis,i);
            }
        }
        
      
        return count;
    }
    private void dfs(    List<List<Integer>> adj,boolean[]vis,int y){
        for(int ch:adj.get(y)){
            if(vis[ch]==false){
                vis[ch]=true;
                dfs(adj,vis,ch);
            }
        }
    }
}