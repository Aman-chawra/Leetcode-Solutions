class Solution {
     public int numMusicPlaylists(int N, int L, int K) {
        long res = 1, mod = 1_000_000_007, r = L - K, dp[][] = new long[L + 1][N + 1];
        dp[0][0] = 1;  //dp[i][j] means i songs in pl, with j different song types;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j - 1] * (N - (j - 1)) % mod;  // jth, is new song;
                if (j > K) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j -K) % mod) % mod;  // jth, is old song;
                }
            }
        }
        return (int) dp[L][N];
    }
}