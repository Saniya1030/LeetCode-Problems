class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>>adjls=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjls.add(new ArrayList<>());
        }
        for(int rows[]:edges)
        {
            int u=rows[0];
            int v=rows[1];
            adjls.get(u).add(v);
            adjls.get(v).add(u);
        }
        boolean visited[]=new boolean[n];
        return dfs(adjls,visited,source,destination);
    }
    private boolean dfs(ArrayList<ArrayList<Integer>>adjls,boolean visited[],int source,int destination)
    {
        if(source==destination)
        {
            return true;
        }
        visited[source]=true;
        for(int i:adjls.get(source))
        {
            if(visited[i]!=true)
            {
               if( dfs(adjls,visited,i,destination)){
                return true;
               }
            }
        }
        return false;
    }
}