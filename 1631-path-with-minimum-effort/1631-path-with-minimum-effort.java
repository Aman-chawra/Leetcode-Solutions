class Solution {
    
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) 
         Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int[] dir = new int[]{0, 1, 0, -1, 0};
        pq.add(new int[]{0, 0, 0}); 
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int effort = top[0];
            int i = top[1];
            int j = top[2];
            if (effort > dist[i][j]) continue;
            if (i == n - 1 && j == m - 1) 
                return effort; 
            for (int k = 0; k < 4; k++) {
                int a = i + dir[k]; 
                int b = j + dir[k + 1];
                if (a >= 0 && a < n && b >= 0 && b < m) {
                    int newDist = Math.max(effort, Math.abs(heights[a][b] - heights[i][j]));
                    if (dist[a][b] > newDist) {
                        dist[a][b] = newDist;
                        pq.add(new int[]{dist[a][b], a, b});
                    }
                }
            }
        }
        return 0; 
    }
}