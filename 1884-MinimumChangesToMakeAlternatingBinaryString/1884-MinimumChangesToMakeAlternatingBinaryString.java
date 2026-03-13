// Last updated: 3/14/2026, 12:05:11 AM
class Solution {
    public int minOperations(String s) {
        int count = 0, n = s.length();
        for (int i = 0; i < n; i++)
            count += (s.charAt(i) ^ i) & 1;
          
        return Math.min(count, n - count);
    }
}