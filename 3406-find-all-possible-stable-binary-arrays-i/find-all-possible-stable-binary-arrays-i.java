class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD = 1_000_000_007;

        // f[i][j][0] = stable arrays with i zeros, j ones, ending in 0
        // f[i][j][1] = stable arrays with i zeros, j ones, ending in 1
        long[][][] f = new long[zero + 1][one + 1][2];

        // Base cases: only zeros or only ones (run must be <= limit)
        for (int i = 1; i <= Math.min(zero, limit); i++) f[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) f[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // Append 0: came from anything ending in 0 or 1 at [i-1][j]
                // Subtract invalid: run of (limit+1) zeros -> remove f[i-limit-1][j][1]
                f[i][j][0] = (f[i-1][j][0] + f[i-1][j][1]
                             - (i - limit - 1 >= 0 ? f[i-limit-1][j][1] : 0)
                             + MOD) % MOD;

                // Append 1: came from anything ending in 0 or 1 at [i][j-1]
                // Subtract invalid: run of (limit+1) ones -> remove f[i][j-limit-1][0]
                f[i][j][1] = (f[i][j-1][0] + f[i][j-1][1]
                             - (j - limit - 1 >= 0 ? f[i][j-limit-1][0] : 0)
                             + MOD) % MOD;
            }
        }

        return (int) ((f[zero][one][0] + f[zero][one][1]) % MOD);
    }
}