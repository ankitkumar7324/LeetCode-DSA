class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        
        while(i<n && intervals[i][1]< newInterval[0])
        {
            ans.add(intervals[i++]);
        }
        int []neww=newInterval;
        while(i<n && intervals[i][0]<=newInterval[1])
        {
            neww[0]=Math.min(intervals[i][0],neww[0]);
            neww[1]=Math.max(neww[1],intervals[i++][1]);
        }
        ans.add(neww);
        while(i<n)
        {
            ans.add(intervals[i++]);
        }
        int[][] result = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            result[j] = ans.get(j);
        }

        return result;
    }
}