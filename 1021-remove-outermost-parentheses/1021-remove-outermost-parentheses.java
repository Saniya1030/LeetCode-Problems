class Solution {
   public String removeOuterParentheses(String s) {
        int sum=0;
        int start=0;
        int i=0;
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        while(i<n)
        {
            if(s.charAt(i)=='(')
            {
                sum++;
            }
            else{
                sum--;
            }
            if(sum==0)
            {
                sb.append(s.substring(start+1,i));
                start=i+1;
            }
            i++;
        }
        return sb.toString();
        
    }
}