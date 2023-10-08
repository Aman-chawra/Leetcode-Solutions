class Solution {
     public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1= nums1.length;
        int len2= nums2.length;
        int [][]dp= new int[len1+1][len2+1];
        int result=Integer.MIN_VALUE;
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
             
                if(i==0||j==0){
                    dp[i][j]=Integer.MIN_VALUE;
                }
                else if(i==1){
                    int tmp= nums1[i-1]*nums2[j-1];
                    dp[i][j]= Math.max(tmp,dp[i][j-1]);
                }
                else if(j==1){
                    int tmp= nums1[i-1]*nums2[j-1];
                    dp[i][j]= Math.max(tmp,dp[i-1][j]);
                }
                else{
                    
                    int tmp= nums1[i-1]*nums2[j-1];
                   
                    dp[i][j]= Math.max(Math.max(tmp+dp[i-1][j-1],tmp),Math.max(dp[i-1][j],dp[i][j-1]));
                    
                    if(dp[i][j]>result){
                        result=dp[i][j];
                    }
                }
            }
        }
        return result;    
    }
}