class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int area=0;
        int maxArea=0;
        int nse[]=nseElement(heights);
        int pse[]= pseElement(heights);
        for(int i=0;i<n;i++)
        {
         area=heights[i]*(nse[i]-pse[i]-1);
         maxArea=Math.max(maxArea,area);
        }
         return maxArea;
    }
    private int[] nseElement(int heights[])
    {
        int n=heights.length;
        int nse[]=new int[n];
        Stack<Integer>st=new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
         while(!st.isEmpty() && heights[st.peek()]>=heights[i])
         {
            st.pop();
         }
         if(st.isEmpty())
         {
         
            nse[i]=n;
         }
         else{
            nse[i]=st.peek();
         }
            st.push(i);
        }
        return nse;
    }

    private int[] pseElement(int heights[])
    {
        Stack<Integer>st=new Stack<>();
        int n=heights.length;
        int pse[]=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
}