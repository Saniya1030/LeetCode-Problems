class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int arr[]=new int[2];
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
           ans=target-nums[i];
            while(map.containsKey(ans))
            {
                return new int[]{map.get(ans),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}