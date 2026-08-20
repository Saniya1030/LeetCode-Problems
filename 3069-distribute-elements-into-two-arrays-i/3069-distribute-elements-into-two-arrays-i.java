class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int ans[]=new int[nums.length];
        int arr1[]=new int[n];
        int arr2[]=new int[n];
        int j=0;
        int p1=0;
        int p2=0;
        arr1[p1++]=nums[0];
        arr2[p2++]=nums[1];
        for(int i=2;i<nums.length;i++)
        {
            if(arr1[p1-1]>arr2[p2-1])
            {
                arr1[p1++]=nums[i];
            }
            else{
                arr2[p2++]=nums[i];
            }
        }
        for(int i=0;i<p1;i++)
        {
            ans[j++]=arr1[i];
            
        }
        for(int i=0;i<p2;i++)
        {
            ans[j++]=arr2[i];
            
        }
        return ans;
    }
}