class Solution {
    public List<Integer> spiralOrder(int[][] mx) {
        int[] ci = new int[]{0, 1, 0, -1}, cj = new int[]{1, 0, -1, 0};  //for handling directions, change i and j
        int p = 0,i = 0, j = 0, m = mx.length, n= mx[0].length;
        boolean[][] v = new boolean[m][n];
        List<Integer> list = new ArrayList();
        while(check(i, j, mx, v)){
            list.add(mx[i][j]);
            v[i][j] = true;
            int ni = i+ci[p], nj = j+cj[p];
            if(!check(ni, nj, mx, v)){
                p = (p+1)%4;
                i = i+ci[p]; j = j+cj[p];
            }else{
                i = ni; j = nj;
            }
        }
        return list;
    }
    private boolean check(int i, int j, int[][] mx, boolean[][] v){
        return !(i >= mx.length || j >= mx[0].length || i < 0 || j < 0 || v[i][j]);
    }
}