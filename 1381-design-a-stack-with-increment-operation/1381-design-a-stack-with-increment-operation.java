class CustomStack {
    Stack<Integer>st;
    int maxSize;
    public CustomStack(int maxSize) {
       st=new Stack<>();
       this.maxSize=maxSize;
    }
    
    public void push(int x) {
        if(st.size()!=maxSize)
        {
            st.push(x);
        }   
    }
    
    public int pop() {
        if(!st.isEmpty())
        {
        return st.pop();
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int limit=Math.min(k,st.size());
        for(int i=0;i<limit;i++)
        {
            st.set(i,st.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */