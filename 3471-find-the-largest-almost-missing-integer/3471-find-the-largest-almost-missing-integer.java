class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int l=0;
        int r=k-1;
        while(r<n)
        {
            HashSet<Integer>set=new HashSet<>();
            for(int i=l;i<=r;i++)
            {
                set.add(nums[i]);
            }
            for(int x:set)
            {
                map.put(x,map.getOrDefault(x,0)+1);
            }
            l++;
            r++;
        }
        int ans=-1;
        for(int i:map.keySet())
        {
            if(map.get(i)==1)
            {
                ans=Math.max(ans,i);
            }
        }
        return ans;
    }
}