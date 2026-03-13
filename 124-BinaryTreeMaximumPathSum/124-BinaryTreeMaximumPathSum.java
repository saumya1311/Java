// Last updated: 3/14/2026, 12:06:07 AM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxsum=Integer.MIN_VALUE;

    public int maxvalue(TreeNode root){
        if(root==null) return 0;

        int leftmax=Math.max(maxvalue(root.left),0);
        int rightmax=Math.max(maxvalue(root.right),0);

        int currsum=root.val+leftmax+rightmax;
        maxsum=Math.max(maxsum,currsum);

        return root.val+Math.max(leftmax,rightmax);
    }
    public int maxPathSum(TreeNode root) {
        maxvalue(root);
        return maxsum;
    }
}