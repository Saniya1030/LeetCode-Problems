class Solution {
    public String simplifyPath(String path) {
        int n=path.length();
        Stack<String>st=new Stack<>();
        String paths[]=path.split("/");
        for(String str:paths)
        {
            if(str.equals(".") || str.equals(""))
            {
                continue;
            }
            else if(str.equals(".."))
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
            }
            else{
                st.push(str);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String dir:st)
        {
            sb.append("/").append(dir);
        }  
        if(sb.length()==0)
        {
            return "/";
        }    
        return sb.toString();
    }
}