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
    int maxPath =Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath;
        
    }
    private int helper(TreeNode root)
    {
        int sum=0;
        if(root==null)
        {
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
       sum=left+right+root.val;
       maxPath=Math.max(maxPath,sum);
       return root.val+Math.max(left,right);
    }
}