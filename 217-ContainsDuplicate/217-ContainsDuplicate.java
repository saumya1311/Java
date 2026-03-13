// Last updated: 3/14/2026, 12:05:44 AM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s=new HashSet<>();

        for(int num:nums){
            if(s.contains(num)){
                return true;
            }
            s.add(num);
        }
        return false;
    }
}