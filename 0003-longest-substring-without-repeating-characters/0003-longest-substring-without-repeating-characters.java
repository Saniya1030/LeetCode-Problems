class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int l=0;
        int r=0;
        int n=s.length();
        int count=0;
        int maxCount=0;
        while(r<n)
        {
                    char ch=s.charAt(r);

            while(map.containsKey(ch))
            {
                map.remove(s.charAt(l));
                l++;
            }
            map.put(ch,1);
            maxCount=Math.max(maxCount,r-l+1);
             r++;
        }
        return maxCount;
    }
}