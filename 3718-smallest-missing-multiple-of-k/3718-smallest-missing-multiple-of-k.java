class Solution {
    public int missingMultiple(int[] nums, int k) {
       HashSet<Integer>st=new HashSet<>();
       for(int i=0;i<nums.length;i++)
       {
        st.add(nums[i]);
       } 
       int multiple=k;
        while(st.contains(multiple))
        {
            multiple+=k;
        }
        return multiple;
    
    }
}