class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        int []score = new int[row];
        int j;
        for(int i=0;i<row;i++)
        {
            j=0;
            for(; j<col;j++)
            {
                if(mat[i][j] ==0)
                    break;
            }
            score[i] = j*row+i;
        }
        Arrays.sort(score);
        for(int i=0;i<score.length;i++)
        {
            score[i] = score[i]%row;
            
        }
        return Arrays.copyOfRange(score,0,k);
        
        
    }
}