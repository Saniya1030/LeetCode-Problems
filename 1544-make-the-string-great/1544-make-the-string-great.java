class Solution {
    public String makeGood(String s) {
        Stack<Character>st=new Stack<>();
        int n=s.length();
                if (s.length() == 0) return "";

        st.push(s.charAt(n-1));
        StringBuilder sb=new StringBuilder();
        for(int i=n-2;i>=0;i--)
        {
            char curr=s.charAt(i);
            if(!st.isEmpty()){
                 char top=st.peek();
            if(Character.toLowerCase(curr)==Character.toLowerCase(top) && top!=curr)
            {
                st.pop();
            }
            else {
                st.push(curr);
            }
            }
            else st.push(curr);
        }
        while(!st.isEmpty())
        {
            char ch=st.pop();
            sb.append(ch);
        }
        return sb.toString();
        
    }
}