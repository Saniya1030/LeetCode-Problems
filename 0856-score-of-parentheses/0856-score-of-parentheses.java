class Solution {
    public int scoreOfParentheses(String s) {
        int count = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(0);
            } else {
               int inside=st.pop();
               if(inside==0)
               {
                st.push(st.pop()+1);
               }
               else{
                st.push(2*inside+st.pop());
               }
            }
        }


        return st.peek();
    }
}