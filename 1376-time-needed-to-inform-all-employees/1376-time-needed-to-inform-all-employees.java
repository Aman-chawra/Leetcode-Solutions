class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                adj.get(manager[i]).add(i);
            }
        }

        Queue<int[]> q= new LinkedList<>();
        int res=0;
        q.add(new int[]{headID,0});
        while(!q.isEmpty()){
            int[] cur =q.poll();
            int i=cur[0];
            int t=cur[1];
            res=Math.max(res,t);
            for(int emp:adj.get(i))
                q.add(new int[]{emp,informTime[i]+t});
        }
        return res;
    }
}