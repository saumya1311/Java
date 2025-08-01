class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int var=1;

        for(int i:set){
            if(set.contains(i-1)) continue;

            else{
                int curr=i;
                int streak=1;
                while(set.contains(i+streak)){
                    curr++;
                    streak++;
                }
                var=Math.max(var,streak);
            }
        }
        return var;

    }
}