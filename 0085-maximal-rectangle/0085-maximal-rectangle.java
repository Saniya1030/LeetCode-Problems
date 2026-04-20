class Solution {
    public int maximalRectangle(char[][] matrix) {
        int sum=0;
        int maxArea=0;
        if(matrix==null ||matrix.length==0)
        {
            return 0;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int []height=new int [m];

        for(int i=0;i<n;i++)
        {
            sum=0;
            for(int j=0;j<m;j++)
            {
               
                if(matrix[i][j]=='1')
                {
                    height[j]+=1;
                }
                else{
                   height[j]=0;
                }
            }
            maxArea=Math.max(maxArea,largestrectangle(height));
        }
        return maxArea;
    }
    private int largestrectangle(int heights[]){
        int nse[]=findnse(heights);
        int pse[]=findpse(heights);
        int n=heights.length;
        int width=0;
        int area=0;
        int  max=0;
        for(int i=0;i<n;i++)
        {
            width=nse[i]-pse[i]-1;
            area=heights[i] * width;
            max=Math.max(max,area);
        }
        return max;

    }
    private int[] findnse(int heights[])
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
    private int[] findpse(int heights[])
    {
        Stack<Integer>st=new Stack<>();
        int n=heights.length;
        int pse[]=new int [n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>= heights[i])
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
