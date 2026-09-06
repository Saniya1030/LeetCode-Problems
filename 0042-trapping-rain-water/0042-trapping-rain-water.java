class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lMax=0;
        int rMax=0;
        int l=0;
        int total=0;
        int r=n-1;
        while(l<=r)
        {
            if(height[l]>=height[r])
            {
                if(height[r]>rMax)
                {
                    rMax=height[r];
                }
                else{
                    total+=rMax-height[r];
                }
                r--;
            }
            else{
                if(height[l]>lMax)
                {
                    lMax=height[l];
                }
                else{
                    total+=lMax-height[l];
                }
                l++;
            }
        }
        return total;
    }
}