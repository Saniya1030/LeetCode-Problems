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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        path(root,targetSum,temp,ans);
        return ans;
    }
    private void path(TreeNode root, int targetSum,List<Integer>temp,List<List<Integer>>ans)
    {
        if(root==null)
        {
            return;
        }
        temp.add(root.val);
        if(root.val==targetSum && root.left==null &&root.right==null)
        {
            ans.add(new ArrayList<>(temp));
        }
        else{
        path(root.left,targetSum-root.val,temp,ans);
        path(root.right,targetSum-root.val,temp,ans);
        }
        temp.remove(temp.size()-1);
}
}