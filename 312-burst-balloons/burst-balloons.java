class Solution {
    int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        dp = new int[n + 2][n + 2];
        return solve(arr, 1, n);
    }

    private int solve(int[] arr, int i, int j) {
        if (i > j) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        int max = 0;

        for (int k = i; k <= j; k++) {
            int left = solve(arr, i, k - 1);
            int right = solve(arr, k + 1, j);

            int coins = arr[i - 1] * arr[k] * arr[j + 1];

            int total = left + right + coins;

            max = Math.max(max, total);
        }

        return dp[i][j] = max;
    }
}