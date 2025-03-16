// 57. Insert Interval
// https://leetcode.com/problems/insert-interval/description/

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i, j, c=0,start=newInterval[0], end=newInterval[1], n=intervals.length;
        List<int[]> list = new ArrayList<>();
        
        i=0;
        while(i<n &&  intervals[i][1]< newInterval[0])
            list.add(new int[] {intervals[i][0], intervals[i++][1]});

        while(i<n && intervals[i][0] <= newInterval[1]) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        list.add(new int[]{start, end});
        while(i<n)
            list.add(new int[] {intervals[i][0], intervals[i++][1]});

        
        int[][] ans = new int[list.size()][2];
        for(i=0; i<list.size(); i++)
        {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}