class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int maxArea=0;
        int l=0;
        int r=n-1;
        int area=0;
        int width=0;
        while(l<=r)
        {
            width=r-l;
            if(height[l]<=height[r])
            {
                area=height[l]*width;
                maxArea=Math.max(maxArea,area);
                l++;
            }
            else{
                area=height[r]*width;
                maxArea=Math.max(maxArea,area);
                r--;
            }
        }
        return maxArea;
    }
}