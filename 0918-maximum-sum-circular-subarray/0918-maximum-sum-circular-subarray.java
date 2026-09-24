class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=nums[0];
        int minSum=nums[0];
        int currMax=nums[0];
        int currMin=nums[0];
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        for(int i=1;i<nums.length;i++)
        {
            currMax=Math.max(nums[i],currMax+nums[i]);
            maxSum=Math.max(maxSum,currMax);

            currMin=Math.min(nums[i],currMin+nums[i]);
            minSum=Math.min(currMin,minSum);
        }
        if(maxSum<0)
        {
            return maxSum;
        }
        return Math.max(maxSum,sum-minSum);
    }
}