class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1;
        }
        double mprob = 1 / (double) maxPts;
        double[] dp = new double[Math.max(k + maxPts, n) + 2];
        for (int i = k; i <= n; i++) {
            dp[i] = 1;
        }
        dp[k - 1] = k - 1 + maxPts > n ? mprob * (n - k + 1) : 1;
        for (int i = k - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - dp[i + 1 + maxPts] * mprob + dp[i + 1] * mprob;
        }
        return dp[0];
    }
}