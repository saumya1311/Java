class Solution {
    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }

    private List<Integer> solve(String exp) {
        if (memo.containsKey(exp)) {
            return memo.get(exp);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '+' || c == '-' || c == '*') {

                List<Integer> left = solve(exp.substring(0, i));
                List<Integer> right = solve(exp.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') result.add(l + r);
                        else if (c == '-') result.add(l - r);
                        else result.add(l * r);
                    }
                }
            }
        }

        
        if (result.isEmpty()) {
            result.add(Integer.parseInt(exp));
        }

        memo.put(exp, result);
        return result;
    }
}