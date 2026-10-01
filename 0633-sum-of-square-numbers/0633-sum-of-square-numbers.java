class Solution {
    public boolean judgeSquareSum(int c) {
        long a=0;
        long b=(long) Math.sqrt(c);
      long sum=0;
      while(a<=b)
      {
      sum=a*a+b*b;

      if(sum==c)
      {
        return true;
      }
        if(sum<c)
        {
            a++;
        }
        else{
            b--;
        }
      }
        return false;
    }
}