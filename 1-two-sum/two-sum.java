class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sum=new HashMap<>();

        for (int i=0;i<nums.length;i++){
            int remainder=(target-nums[i]);
            
            if (sum.containsKey(remainder)){
                return new int[] { sum.get(remainder),i};
            }
            sum.put(nums[i],i);
        }
        return new int []{};
    }
}