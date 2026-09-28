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
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        dfs(result,targetSum,temp,root);
        return result;
    }
    private void dfs(List<List<Integer>>result,int targetSum,List<Integer>temp,TreeNode root)
    {
         if(root==null)
        {
            return ;
        }
        temp.add(root.val);

        if(root.val==targetSum && root.left==null && root.right==null)
        {
            result.add(new ArrayList<>(temp));
        }
        else{
            dfs(result,targetSum-root.val,temp,root.left);
            dfs(result,targetSum-root.val,temp,root.right);
        }
         temp.remove(temp.size()-1);
    }
    
}