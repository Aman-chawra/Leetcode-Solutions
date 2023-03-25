class Solution {
    private ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    private boolean visited[];

    public long countPairs(int n, int[][] edges) {

        for(int i = 0; i<n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        visited = new boolean[n];

        long ans=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                long connectedNodes = DFS(i);
                ans+=(n-connectedNodes)*connectedNodes;
            }
        }

        return ans/2;
    }

    private long DFS(int i){

        visited[i] = true;

        int connectedNodes = 1;

        ArrayList<Integer> neighbours = adjList.get(i);
        for(int nodes: neighbours){
            if(!visited[nodes]){
                connectedNodes+=DFS(nodes);
            }
        }

        return connectedNodes;
    }
}