class Solution {
    public int maxProfit(int[] prices, int fee) {
        int bp= prices[0];
        int max=0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] > bp + fee){
                int profit= prices[i] - bp - fee;
                max += profit;
                bp = prices[i] - fee;
            }
            else if (prices[i] < bp){
                bp= prices[i];
            }
        }
        return max;
    }
}