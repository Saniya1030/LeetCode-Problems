class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer>res=new ArrayList<>();
        Arrays.sort(nums);
        int currElement=nums[0];
        for(int i=0;i<nums.length;currElement++,i++)
        {
            if(currElement<nums[i])
            {
                res.add(currElement);
                i--;
            }
        }
        return res;
        
    }
}