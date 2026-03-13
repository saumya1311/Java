// Last updated: 3/14/2026, 12:05:14 AM
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = (1 << (32 - Integer.numberOfLeadingZeros(n))) - 1;
        return n ^ mask;
    }
}