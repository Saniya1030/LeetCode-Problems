class Solution {
    public String decodeString(String s) {
        Stack<Integer>numst=new Stack<>();
        Stack<String>strst=new Stack<>();
        int num=0;
        String currstr="";
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                num=num*10+(ch-'0');
            }
            else if(ch=='[')
            {
                numst.push(num);
                strst.push(currstr);

                num=0;
                currstr="";
            }
            else if(ch==']')
            {
                int repeat=numst.pop();
                String prev=strst.pop();

                StringBuilder sb=new StringBuilder(prev);
                for(int i=0;i<repeat;i++)
                {
                    sb.append(currstr);
                }
                currstr=sb.toString();
            }
            else{
                currstr+=ch;
            }
        }
        return currstr;
    }
}