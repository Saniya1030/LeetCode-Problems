class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int zero[]=new int[n];
        if(Arrays.equals(nums,zero)){
            return 0;
        }
        int x=0;
        for(int i:nums)
        {
            x^=i;
        }
        if(x!=0)
        {
            return n;
        }
        else{
            return n-1;
        }
    }
}