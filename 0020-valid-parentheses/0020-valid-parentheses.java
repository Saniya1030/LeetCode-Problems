class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for( char ch:s.toCharArray())
        {
            if(st.isEmpty() || ch=='('|| ch=='{' ||ch=='[')
            {
                st.push(ch);
            }
            else {
            if(ch==')' && (st.isEmpty() || st.pop()!='(')){
                return false;
            }
            if(ch=='}' && (st.isEmpty() || st.pop()!='{'))
            {
                return false;
            }
            if(ch==']' && (st.isEmpty() || st.pop()!='['))
            {
                return false;
            }
        }
        }
        return st.isEmpty();
        
    }
}