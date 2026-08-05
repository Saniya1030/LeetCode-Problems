class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>>adjls=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjls.add(new ArrayList<>());
        }
        for(int []edges:invocations){
            adjls.get(edges[0]).add(edges[1]);
        }
        boolean suspecious[]=new boolean[n];

        dfs(k,n,adjls,suspecious);
        ArrayList<Integer>ans=new ArrayList<>();

        for(int []edges:invocations)
        {
            int u=edges[0];
            int v=edges[1];
            if(suspecious[u]==false && suspecious[v]==true)
            {
                for(int i=0;i<n;i++)
                {
                    ans.add(i);
                }
            return ans;

            }
        }
        for(int i=0;i<n;i++)
        {
            if(suspecious[i]==false)
            {
                ans.add(i);
            }
        }
        return ans;
    }
    private void dfs(int k,int n,ArrayList<ArrayList<Integer>>adjls,boolean suspecious[])
    {
        suspecious[k]=true;
        for(int it:adjls.get(k))
        {
            if(suspecious[it]==false)
            {
                dfs(it,n,adjls,suspecious);
            }
        }
    }
}