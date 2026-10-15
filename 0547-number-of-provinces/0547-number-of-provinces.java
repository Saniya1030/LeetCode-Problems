class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>>adjls=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        {
            adjls.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }
        int count=0;
        boolean visited[]=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
            if(!visited[i])
            {
            count++;
            dfs(i,visited,adjls);
        }
        }
        return count;
    }
    private void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>>adjls)
    {
        visited[node]=true;
        for(int it:adjls.get(node))
        {
            if(!visited[it])
            {
                dfs(it,visited,adjls);
            }
        }
    }
}