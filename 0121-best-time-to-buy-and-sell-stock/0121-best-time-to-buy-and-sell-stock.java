class Solution {
    public int maxProfit(int[] prices) {

        
        
        int least = Integer.MAX_VALUE;
        int overall = 0;
        int profit = 0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<least)
                least = prices[i];
            profit = prices[i]-least;
            if(overall<profit)
                overall = profit;
        }
        return overall;
        
      
        
    }
}