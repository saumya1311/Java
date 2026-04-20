class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target + 1];

        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<>();
        }

        // base case
        dp[0].add(new ArrayList<>());

        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];

            for (int j = num; j <= target; j++) {
                for (List<Integer> list : dp[j - num]) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(num);
                    dp[j].add(newList);
                }
            }
        }

        return dp[target];
    }
}