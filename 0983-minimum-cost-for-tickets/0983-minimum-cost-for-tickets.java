class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        boolean[] isTravelDays = new boolean[lastDay+1];

        for(int day: days)
            isTravelDays[day] = true;

        for(int i=1; i<=lastDay; i++) {
            if(!isTravelDays[i]) {
                dp[i] = dp[i-1];
                continue;
            }
            //we have to buy ticket to travel
            dp[i] = costs[0] + dp[i-1];
            //min of ticket bought 7 days ago or todays ticket
            dp[i] = Math.min(costs[1]+dp[Math.max(i-7,0)],dp[i]);
            //min of ticket bought 30 days ago or todays ticket
            dp[i] = Math.min(costs[2]+dp[Math.max(i-30,0)],dp[i]);
        }

        return dp[lastDay];
    }
}

