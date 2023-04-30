class Solution {
    class UnionFind {
        private int[] group;
        private int[] rank;
        private int groupCount;

        public UnionFind(int size) {
            rank = new int[size];
            groupCount = size;
            group = new int[size];
            for(int i = 1; i < size; i++) group[i] = i;
        }

        public boolean allConnected() {
            return groupCount == 1;
        }

        public boolean areConnected(int u, int v) {
            int g1 = findGroup(u);
            int g2 = findGroup(v);
            return g1 == g2;
        }

        public void join(int u, int v) {
            int g1 = findGroup(u);
            int g2 = findGroup(v);
            if(g1 == g2) return;
            if(rank[g1] > rank[g2]) {
                group[g2] = g1;
            } else if(rank[g1] < rank[g2]) {
                group[g1] = g2;
            } else {
                group[g1] = g2; rank[g2]++;
            }
            groupCount--;
        }

        private int findGroup(int n) {
            if(group[n] != n) {
                group[n] = findGroup(group[n]);
            }

            return group[n];
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // move type 3 edges to the beginning
        sortReverse(edges);

        UnionFind ufA = new UnionFind(n);
        UnionFind ufB = new UnionFind(n);

        int usefulEdgeCount = 0;
        for(int[] edge : edges) {
            int type = edge[0];
            // convert 1-idx node to 0-idx node
            int u = edge[1] - 1, v = edge[2] - 1;
            if(type == 1) {
                if(ufA.areConnected(u, v)) continue;
                ufA.join(u, v); usefulEdgeCount++;
            } else if(type == 2) {
                if(ufB.areConnected(u, v)) continue;
                ufB.join(u, v); usefulEdgeCount++;
            } else {
                boolean used = false;
                if(!ufA.areConnected(u, v)) {
                    ufA.join(u, v); used = true;
                }
                if(!ufB.areConnected(u, v)) {
                    ufB.join(u, v); used = true;
                }
                if(used) usefulEdgeCount++;
            }
        }

        if(!ufA.allConnected() || !ufB.allConnected()) return -1;
        else return edges.length - usefulEdgeCount;
    }

    private void sortReverse(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a2[0] - a1[0];
            }
        });
    }
}