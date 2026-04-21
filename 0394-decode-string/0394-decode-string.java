class Solution {
    public String decodeString(String s) {
        Stack<String>strStack=new Stack<>();
        Stack<Integer>numStack=new Stack<>();
        int num=0;
    String currStr="";
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                num=num*10+(ch-'0');
            }
            else if(ch=='[')
            {
                numStack.push(num);
                strStack.push(currStr);

                num=0;
                currStr="";
            }
            else if(ch==']')
            {
                int repeat=numStack.pop();
                String prevstr=strStack.pop();
                StringBuilder sb=new StringBuilder(prevstr);

                for(int i=0;i<repeat;i++)
                {                    
                    sb.append(currStr);
                }
                currStr=sb.toString();
            }
            else{
                currStr+=ch;
            }

        }
        return currStr;
        
    }
}