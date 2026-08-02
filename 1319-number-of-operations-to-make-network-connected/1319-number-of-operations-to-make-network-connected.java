class Solution {
    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>>adjls=new ArrayList<>();
        int component=0;
        if(connections.length<n-1)
        {
            return -1;
        }
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            adjls.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++)
        {
                    int u=connections[i][0];
                    int v=connections[i][1];

                    adjls.get(u).add(v);
                    adjls.get(v).add(u);
                
            
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                component++;
                dfs(i,adjls,visited);
            }
        }
        return component-1;
    }
    private void dfs(int start,ArrayList<ArrayList<Integer>>adjls,boolean []visited)
    {
        visited[start]=true;
        for(int it:adjls.get(start))
        {
            if(visited[it]!=true)
            {
                visited[it]=true;
                dfs(it,adjls,visited);
            }
        }
    }
}