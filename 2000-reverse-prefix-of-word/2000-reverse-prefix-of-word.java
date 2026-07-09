class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character>st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        
        int ind=word.indexOf(ch);
        for(int i=0;i<=ind;i++)
        {
            st.push(word.charAt(i));
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.append(word.substring(ind+1));
        return sb.toString();
    }
}