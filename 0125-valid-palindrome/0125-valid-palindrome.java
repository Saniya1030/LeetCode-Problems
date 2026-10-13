class Solution {
    public boolean isPalindrome(String s) {
      
        String ss=s.toLowerCase().replaceAll("[^a-z0-9]","");
          int left=0;
        int right=ss.length()-1;
        while(left<right)
        {
            if(ss.charAt(right)!=ss.charAt(left))
            {
                return false;
            }
            
                right--;
                left++;
            
        }
        return true;
    }
}