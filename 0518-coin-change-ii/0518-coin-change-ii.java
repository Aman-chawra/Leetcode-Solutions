class Solution {
    int count=0;
    public int change(int amount, int[] coins) {
        if(coins.length == 0) return amount == 0 ? 1 : 0;
        Integer[][] dp = new Integer[coins.length+1][amount+1];
        return calculate(amount,coins,0,dp);
        //return count;
    }
    public int calculate(int amount,int[] coins,int index,Integer[][] dp){
        if(index >= coins.length) return 0;
        if(amount == 0) {return 1;}
        if(amount < 0) return 0;
        if(dp[index][amount] != null) return dp[index][amount];
        int ans=  calculate(amount-coins[index],coins,index,dp)+
        calculate(amount,coins,index+1,dp);
        dp[index][amount] = ans;
        return ans;
    }
}