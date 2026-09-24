class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax=nums[0];
        int currMin=nums[0];
        int maxSum=nums[0];
        int minSum=nums[0];
        int total=0;
        for(int i:nums)
        {
            total+=i;
        }
        for(int i=1;i<nums.length;i++)
        {
            //kadanes maximum
            currMax=Math.max(nums[i],currMax+nums[i]);
            maxSum=Math.max(maxSum,currMax);

            //kadanes minimum
            currMin=Math.min(nums[i],currMin+nums[i]);
            minSum=Math.min(minSum,currMin);
        }
        if(maxSum<0)
        {
            return maxSum;
        }
        return Math.max(maxSum,total-minSum);
    }
}