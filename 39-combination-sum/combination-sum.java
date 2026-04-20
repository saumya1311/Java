class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // dp[t] = list of combinations that sum to t
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) dp.add(new ArrayList<>());

        dp.get(0).add(new ArrayList<>()); // base: one way to make 0

        // For each candidate, extend smaller sums
        for (int c : candidates) {
            for (int t = c; t <= target; t++) {
                // For each combination that makes (t - c), append c
                for (List<Integer> comb : dp.get(t - c)) {
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(c);
                    dp.get(t).add(newComb);
                }
            }
        }
        return dp.get(target);
    }
}