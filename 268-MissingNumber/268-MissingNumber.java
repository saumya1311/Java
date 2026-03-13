// Last updated: 3/14/2026, 12:05:34 AM
class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int no=(nums.length*(nums.length+1)/2);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        return no-sum;
    }
}