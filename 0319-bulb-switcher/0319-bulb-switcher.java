class Solution {
    private boolean isPerfectSquare(int num){
       int sqr=   (int)Math.sqrt(num);
        return sqr*sqr ==num;
    }
    public int bulbSwitch(int n) {
        int  res =0;
        for(int i=1;i<=n;i++){
            if(isPerfectSquare(i)){
                res++;
            }
        }
        return res;
        
    }
}