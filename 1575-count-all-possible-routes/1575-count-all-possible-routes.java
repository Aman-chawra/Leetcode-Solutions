class Solution {
    int mod = (int) 1e9 + 7;
    Integer[][] dp;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        int n = locations.length;
        dp = new Integer[n][fuel + 1];

        return solve(locations, start, finish, fuel);
    }

    private int solve(int[] locations, int currCity, int e, int fuel) {

        if (fuel < 0)
            return 0;
        if (dp[currCity][fuel] != null)
            return dp[currCity][fuel];

        int ans = (currCity == e) ? 1 : 0;

        for (int nextCity = 0; nextCity < locations.length; nextCity++) {
            if (nextCity != currCity)
                ans = (ans + solve(locations, nextCity, e, fuel -
                        Math.abs(locations[currCity] - locations[nextCity]))) % mod;
        }
        return dp[currCity][fuel] = ans;
    }
}