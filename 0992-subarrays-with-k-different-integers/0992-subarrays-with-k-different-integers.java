class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return atmost(nums,k)-atmost(nums,k-1);

    }
    private int atmost(int nums[],int k)
    {
        int left=0;
        int count=0;
        int n=nums.length;
        
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int r=0;r<n;r++)
        {
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
        
        while(map.size()>k)
        {
            int value=nums[left];
            map.put(value,map.get(value)-1);
            if(map.get(value)==0)
            {
                map.remove(value);
            }
            left++;
        }
        count+=r-left+1;
        }
        return count;
    }
}