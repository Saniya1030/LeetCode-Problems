class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        path.add(0);
        dfs(0,path,graph,ans);
        return ans;
    }
    private void dfs(int source,List<Integer>path,int [][]graph,List<List<Integer>>ans)
    {
        int n=graph.length;
        if(source==n-1)
        {
            ans.add(new ArrayList<>(path));
        }
        for(int it:graph[source])
        {
            path.add(it);
            dfs(it,path,graph,ans);
            path.remove(path.size()-1);
        }
    }
}