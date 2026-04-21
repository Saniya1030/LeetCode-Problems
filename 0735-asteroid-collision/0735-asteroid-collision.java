class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer>st=new Stack<>();
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            boolean destroyed=false;
            while(!st.isEmpty() && st.peek()>0 && asteroids[i]<0)
            {
            if( Math.abs(asteroids[i])>st.peek())
            {
                st.pop();
                continue;
            }
             else if(Math.abs(asteroids[i])==st.peek())
            {
                st.pop();
                destroyed=true;
                break;
            }
            else {
                destroyed=true;
                break;
            }
        }
        if(!destroyed)
        {
            st.push(asteroids[i]);
        }
        }
        
        while(!st.isEmpty())
        {
            ans.add(0,st.pop());
        }
        int res[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
            res[i]=ans.get(i);
        }
        return res;
    }
}
    


















// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         int n=asteroids.length;
//         ArrayList<Integer> st=new ArrayList<>();
//         for(int i=0;i<n;i++)
//         {
//             if(asteroids[i]>0)
//             {
//                 st.add(asteroids[i]);
//             }
//             else{
//              while(!st.isEmpty() && st.get(st.size() - 1) > 0 && 
//                       st.get(st.size() - 1) < Math.abs(asteroids[i])) {
//                 st.remove(st.size()-1);
//             }
//             if(!st.isEmpty() && Math.abs(asteroids[i])== st.get(st.size()-1))
//             {
//                 st.remove(st.size()-1);
//             }
//             else if(st.isEmpty() || st.get(st.size()-1)<0)
//             {
//                 st.add(asteroids[i]);
//             }
//             }

//         }
//         int ans[]=new int[st.size()];
//         for(int i=0;i<st.size();i++)
//         {
//             ans[i]=st.get(i);

//         }
//         return ans;
//     }
// }