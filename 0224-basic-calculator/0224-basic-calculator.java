class Solution {
    public int calculate(String s) {
        Stack<Integer>st=new Stack<>();
        int n=s.length();
        int result=0;
        int num=0;
        int sign=1;;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                num=num*10+(ch-'0');
            }
            else if(ch=='+')
            {
                result+=num*sign;
                num=0;
                sign=1;
            }
            else if(ch=='-')
            {
                result+=num*sign;
                num=0;
                sign=-1;
            }
             else if(ch==('('))
            {
                st.push(sign);
                st.push(result);
                result=0;
                sign=1;
            }
            else if(ch==')')
            {
                result+=sign*num;
                num=0;
                int lastResult=st.pop();
                int lastSign=st.pop();
                result=lastResult+lastSign* result;
            }
        }
        result+=sign*num;
        return result;
    }
}