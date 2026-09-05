class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
         int stable=0;
        int preffix[]=new int[n];
        int suffix[]=new int[n];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            preffix[i]=max;
        }
        for(int i=n-1;i>=0;i--)
        {
            min=Math.min(min,nums[i]);
            suffix[i]=min;
        }
        for(int i=0;i<n;i++)
        {
            if(preffix[i]-suffix[i]<=k)
            {
                return i;
            }
        }
        return -1;

       
    }
}