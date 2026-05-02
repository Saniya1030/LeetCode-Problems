class Solution {
    public int maxProduct(int[] nums) {
        
        int maxproduct=nums[0];
        int preffix=1;
        int suffix=1;
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            preffix*=nums[i];
            suffix*=nums[n-1-i];
            maxproduct=Math.max(maxproduct,Math.max(preffix,suffix));

             if(preffix==0)
            {
                preffix=1;
            }
             if(suffix==0)
            {
                suffix=1;
            }
        }
        return maxproduct;
    }
}