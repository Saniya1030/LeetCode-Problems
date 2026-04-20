class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        int area=0;
        int maxArea=0;
        int nse[]=nseElement(heights);
        int pse[]=pseElement(heights);
        for(int i=0;i<n;i++)
        {
            area=(heights[i]*(nse[i]-pse[i]-1));
            maxArea=Math.max(area,maxArea);

        }
        return maxArea;
    }

    private int[] nseElement(int heights[])
    {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int nse[]=new int[n];
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
    private int[] pseElement( int heights[])
    {
        int n=heights.length;
        Stack<Integer>st=new Stack<>();
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




// class Solution {
//     public int largestRectangleArea(int[] heights) {
//        int n=heights.length;
//        int nse,pse;
//        int largestArea=0;
//        int area=0;
        
//         Stack<Integer> st=new Stack<>();

//         for(int i=0;i<n;i++)
//         {
//             while(!st.isEmpty() && heights[st.peek()]>=heights[i])
//             {
//               int ind=st.pop();
//             pse=st.isEmpty()?-1:st.peek();
//             nse=i;

//            area=heights[ind]*(nse-pse-1);
//             largestArea=Math.max(largestArea,area);
//         }
//         st.push(i);
//         }
//         while(!st.isEmpty())
//         {
//             nse=n;
//             int ind=st.pop();
//             pse=st.isEmpty()?-1:st.peek();
//             area=heights[ind]*(nse-pse-1);
//             largestArea=Math.max(largestArea,area);
//         }
//         return largestArea;
//     }
// }
