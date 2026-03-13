// Last updated: 3/14/2026, 12:05:06 AM
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n= spells.length;
        int m= potions.length;

        int[]  result=new int[n];

        for(int i=0;i<n;i++){
            long minPotion= (success+spells[i]-1)/spells[i];

            int left=0;
            int right=m-1;
            int index=m;

            while(left<=right){
                int mid=left+(right-left)/2;

                if(potions[mid]>=minPotion){
                    index=mid;
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            result[i]=m-index;
        }
        return result;
    }
}