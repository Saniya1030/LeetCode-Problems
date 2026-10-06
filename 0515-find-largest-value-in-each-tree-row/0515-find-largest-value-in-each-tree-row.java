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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
      
        List<Integer>ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        q.offer(root);
        while(!q.isEmpty())
        {
            int max=Integer.MIN_VALUE;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode top=q.remove();
                max=Math.max(max,top.val);
                if(top.left!=null)
                {
                    q.offer(top.left);
                }
               if(top.right!=null){
                    q.offer(top.right);
                }
            }
            ans.add(max);
            
            }
    return ans;
    }
}