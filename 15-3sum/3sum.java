class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> fin=new ArrayList<>();

        for(int num = 0; num < nums.length; num++){
            if(nums[num]>0) break;

            if(num>0 && nums[num]==nums[num-1]) continue;
            int l=num+1;
            int r=nums.length-1;

            while(l<r){
                int sum=nums[num]+nums[l]+nums[r];
                if(sum>0){
                    r--;
                }
                else if(sum<0){
                    l++;
                }
                else{
                    fin.add(Arrays.asList(nums[num],nums[l],nums[r]));
                    l++;
                    r--;
                
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }  
   
                }
            }
        }
        return fin;
    }
}