class Solution {
    public int calculate(String s) {
        Stack<Integer>st=new Stack<>();
        char sign='+';
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                num=num*10+(ch-'0');
            }
if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1)            {
                if(sign=='+') st.push(+num);
                if(sign=='-')st.push(-num);
                                if (sign == '*') st.push(st.pop() * num);
                if(sign=='/')st.push(st.pop()/num);
             
              num=0;
              sign=ch;
            }
        }
            int sum=0;
            while(!st.isEmpty())
            {
                sum+=st.pop();
            }
        

        return sum;

        
    }
}