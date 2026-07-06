class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]>list=new ArrayList<>();
    int i=0;
    int j=0;
    while(i<firstList.length && j<secondList.length)
    {
        int s1=firstList[i][0];
        int e1=firstList[i][1];
        int e2=secondList[j][1];
        int s2=secondList[j][0];

        if(s2<=e1 && s1<=e2)
        {
            list.add(new int[]{Math.max(s1,s2),Math.min(e1,e2)});
        }
        if(e1>e2)
        {
            j++;
        }
        else{
            i++;
        }
    }
    return list.toArray(new int [list.size()][2]);

    }
}