class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>>adjls=new ArrayList<>();
        int n=isConnected.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            adjls.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                count++;
                dfs(i,adjls,visited);
            }
        }
        return count;
    }
    private void dfs(int start,ArrayList<ArrayList<Integer>>adjls,boolean []visited)
    {
        visited[start]=true;
        for(int i:adjls.get(start))
        {
            if(visited[i]!=true)
            {
                dfs(i,adjls,visited);
            }
        }
    }
}