class Solution {

    int[][] dp;
    int[][] cost; 

    public int palindromePartition(String s, int k) {
        int n = s.length();

        cost = new int[n][n]; 
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    cost[i][j] = cost[i + 1][j - 1];
                } else {
                    cost[i][j] = 1 + cost[i + 1][j - 1];
                }
            }
        }

        dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(s, 0, k);
    }

    private int solve(String s, int i, int k) {
        int n = s.length();

        if (i == n) return 1000000;

        if (k == 1) {
            return cost[i][n - 1]; 
        }

        if (dp[i][k] != -1) return dp[i][k];

        int ans = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {

            if (n - j < k) break;

            int left = cost[i][j];
            int right = solve(s, j + 1, k - 1);

            ans = Math.min(ans, left + right);
        }

        return dp[i][k] = ans;
    }
}