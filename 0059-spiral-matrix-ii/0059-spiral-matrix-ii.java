class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int p=1;
        int minRow=0,minCol=0,maxRow=n-1,maxCol=n-1;
        while(p<=n*n){
            for(int i=minCol;i<=maxCol;i++){
                arr[minRow][i]=p++;
            }
            minRow++;
            for(int i=minRow;i<=maxRow;i++){
                arr[i][maxCol]=p++;
            }
            maxCol--;
            for(int i=maxCol;i>=minCol;i--){
                arr[maxRow][i]=p++;
            }
            maxRow--;
            for(int i=maxRow;i>=minRow;i--){
                arr[i][minCol]=p++;
            }
            minCol++;
        }
        return arr;
    }
}