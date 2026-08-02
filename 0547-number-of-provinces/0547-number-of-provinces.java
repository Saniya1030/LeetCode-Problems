class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>>adjls=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjls.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1  && i!=j)
                {
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }

        boolean visited[]=new boolean[n];
        int count=0;  
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                count++;
                dfs(i,visited,adjls);
            }
        }
        return count;
    }
    private void dfs(int start,boolean visited[],ArrayList<ArrayList<Integer>>adjls)
    {
        visited[start]=true;
        for(int it:adjls.get(start))
        {
            if(visited[it]!=true)
            {
                dfs(it,visited,adjls);
            }
        }
    }
}