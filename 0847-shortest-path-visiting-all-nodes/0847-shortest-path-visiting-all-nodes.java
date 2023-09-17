class Solution {
    int cost[][]; //min cost
    int n=0;
    int graph[][];
    int nums[];
    int dp[][];
    int ans=Integer.MAX_VALUE;
    public int shortestPathLength(int[][] graph) {
        if(graph.length==0)return 0;
        if(graph[0].length==0)return 0;
        this.graph=graph;
        n=graph.length;
        cost=new int[n][n];
        dp=new int[n][1<<(n)];
        for(int r=0;r<dp.length;r++){
            for(int c=0;c<dp[0].length;c++)dp[r][c]=Integer.MAX_VALUE;
        }
        //bfs
        for(int source=0;source<n;source++){
            Set<Integer>set=new HashSet<>();
            Queue<int[]>queue=new LinkedList<>();
            int start[]=new int[2];
            start[0]=source;start[1]=0;
            queue.add(start);
            set.add(source);
            while(queue.size()!=0){
                int parent[]=queue.poll();
                int current=parent[0];
                int level=parent[1];
                cost[source][current]=level;
                int neighbor[]=graph[current];
                for(int n:neighbor){
                    if(!set.contains(n)){
                        set.add(n);
                        int next[]=new int[2];
                        next[0]=n;next[1]=level+1;
                        queue.add(next);
                    }
                }
            }
        }
        /*n! way of going, for example 1->2->3->4, when you go from 3 to 4 for example, you want the shortest which may  have revisit some repeated node, 
		but it does not matter since you already store the minimum cost in the cost 2d array*/
        
        //out goal is to use dp to reduce the n!
        for(int i=0;i<n;i++){
            int num=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;//absent
                num=num|(1<<j);
            }
            dp[i][num]=fun(i,num)[1];
            ans=Math.min(ans,dp[i][num]);
        }
        return ans;
    }
    
    public int[] fun(int x,int num){ //dp        x:pre  num:a bit number
        //base case
        if(Integer.bitCount(num)==1){//
            int index=0;
            for(int i=0;i<32;i++){
                int bit=num&1;num=num>>1;
                if(bit==1)index=i;
            }
            int res[]=new int[2]; //cost, dp value
            res[0]=x;res[1]=cost[x][index];
            return res; 
        }
        List<Integer>list=new ArrayList<>();
        int copynum=num;
        for(int i=0;i<32;i++){
            int bit=copynum&1;copynum=copynum>>1;
            if(bit==1){
                list.add(i);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            int k=list.get(i);
            //turn off k bit
            int next=0;
            int copy=num;
            for(int j=0;j<32;j++){
                if(j==k){
                    copy=copy>>1;
                    continue;
                }
                int bit=copy&1;copy=copy>>1;
                next=next|(bit<<j);
            }
            if(dp[k][next]==Integer.MAX_VALUE){
                int arr[]=fun(k,next);
                dp[k][next]=arr[1];
            }
            min=Math.min(min,dp[k][next]+cost[x][k]);
        }
        int res[]=new int[2];
        res[0]=x;res[1]=min;
        return res;
    }
}