class Solution {
    int[] vis; //this is an array to hold the visited cities
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; //n x n so getting n.
        vis = new int[n]; // assigning vis array
        HashMap<Integer, HashSet<Integer>> g = new HashMap(); //building the graph
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 0) continue;
                g.putIfAbsent(i, new HashSet());
                g.get(i).add(j); //these steps are for building the grpahs.
            }
        }
        //graphs will look like {1->{1,2,3}, 2->{1,2,3}, 3->{1,2,3}, 4->{4,5,6,7}.... so on}
        // this example graph is from above image
        int p = 0; //init provincial count
        for(int c: g.keySet()) {
            if (vis[c] == 1) continue; //if already visiting, don't go back again.
            p++;
            dfs(g, c); //dfs to check all the connected nodes and mark you have visited.
        }
        return p;
    }

    void dfs(HashMap<Integer, HashSet<Integer>> map, int c) {
        if (vis[c] == 1) return;
        vis[c] = 1;
        for(int c1: map.get(c)) {
            dfs(map, c1);
        }
    }
}