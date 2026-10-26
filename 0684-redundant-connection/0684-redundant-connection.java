class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>>adjls=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adjls.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            boolean visited[]=new boolean[n+1];
            if(dfs(u,v,visited,adjls))
            {
                return new int[]{u,v};
            }
            adjls.get(u).add(v);
            adjls.get(v).add(u);
        }
        return new int[0];
    }
    private boolean dfs(int node,int target,boolean visited[],ArrayList<ArrayList<Integer>>adjls)
    {
        if(node==target)
        {
            return true;
        }
        visited[node]=true;
        for(int it:adjls.get(node))
        {
            if(visited[it]==false)
            {
                if(dfs(it,target,visited,adjls))
                {
                    return true;
                }
            }
        }
        return false;
    }
}