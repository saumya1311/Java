// Last updated: 3/14/2026, 12:06:20 AM
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max_area=0;

        Stack<Integer> stack=new Stack<>();

        int n=heights.length;
        for (int i=0; i<=heights.length;i++){
            int cht=(i==n)?0:heights[i];

            while(!stack.isEmpty() && cht<heights[stack.peek()]){
                int len=heights[stack.pop()];
                int wid=(stack.isEmpty())?i:i-stack.peek()-1;
                max_area=Math.max(max_area,len*wid);
            }
            stack.push(i);          
        }
        return max_area;
    }
}