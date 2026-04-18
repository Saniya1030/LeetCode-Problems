class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<int[]>st=new Stack<>();
        int nge[]=new int[n];
        st.push(new int[]{temperatures[n-1],n-1});
        for(int i=n-2;i>=0;i--)
        {
           while(!st.isEmpty() && st.peek()[0]<=temperatures[i])
                {
                 st.pop();
                   
                }
                if(st.isEmpty())
                {
                    nge[i]=0;
                }
                else{
                    int peek[]=st.peek();
                    int days=peek[1]-i;
                    nge[i]=days;
                }
                st.push(new int[]{temperatures[i],i});
        }
        return nge;
    }
}