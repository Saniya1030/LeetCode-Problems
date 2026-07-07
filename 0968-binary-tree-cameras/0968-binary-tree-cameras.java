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
    int noOfCameras=0;
    public int minCameraCover(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        return dfs(root)==-1?noOfCameras+1:noOfCameras;
    }
    private int dfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(left==-1 ||right==-1)
        {
            noOfCameras++;
            return 1;
        }
        if(left==1 ||right==1)
        {
            return 0;
        }
        return -1;
    }
}