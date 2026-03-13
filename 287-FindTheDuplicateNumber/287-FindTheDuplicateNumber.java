// Last updated: 3/14/2026, 12:05:31 AM
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];

        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }

        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}