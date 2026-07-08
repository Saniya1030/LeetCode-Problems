class Solution {
    public int maxArea(int[] height) {
        int r=height.length-1;
        int area=0;
         int heightt=0;
        int maxArea=0;
        int l=0;
        while(l<r)
        {
            heightt=Math.min(height[l],height[r]);
            int width=r-l;
            area=heightt*width;
            maxArea=Math.max(maxArea,area);
            if(height[l]<height[r])
            {
                l++;

            }
            else{
                r--;
            }
        }
        return maxArea;
    }
}