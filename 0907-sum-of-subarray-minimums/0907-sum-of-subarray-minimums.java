class Solution {
    public int sumSubarrayMins(int[] arr) {
        int []psee=findpsee(arr);
        int []nsee=findnsee(arr);
        int n=arr.length;
        int mod=(int)1e9+7;
        long sum=0;
        long value=0;
       for(int i=0;i<n;i++)
       {
        long freq=(i-psee[i])*(nsee[i]-i);
        sum=(arr[i]*freq)%mod;
        value=(sum+value)%mod;
       }
       return (int)value;
    }
    private int[] findpsee(int arr[])
    {
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        int pse[]=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
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
    private int[] findnsee(int arr[])
    {
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        int nse[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
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
}












// class Solution {
//     public int sumSubarrayMins(int[] arr) {
// int mod = (int)1e9 + 7;
//         int n=arr.length;
//         int sum=0;
//         int minimum=0;
//         for(int i=0;i<arr.length;i++)
//         {
//             minimum=arr[i];
//             for(int j=i;j<n;j++)
//             {
//                 minimum=Math.min(minimum,arr[j]);
//                 sum=(sum+minimum)%mod;
//             }
//         }
//         return sum;
//     }
// }



