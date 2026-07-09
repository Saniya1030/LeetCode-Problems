class Solution {
    public String reversePrefix(String s, int k) {
        Stack<Character>st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<k;i++)
        {
            st.push(s.charAt(i));
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.append(s.substring(k,s.length()));
        return sb.toString();
    }
}