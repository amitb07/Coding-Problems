// Shortest Source to Destination PathShortest Source to Destination Path
// https://www.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1

// Approach: BFS TC: O(m*n) Space= O(m*n)
class Solution {
    int shortestDistance(int n, int m, int a[][], int x, int y) {
        // code here
        Queue<int[]> q = new LinkedList<>();
        if(a[0][0] == 0 || a[x][y] == 0)
            return -1;
        int[] start = {0, 0, 0};
        int ans=0;
        q.add(start);
        a[0][0] = 2;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1], dist = cur[2];
            if(row == x && col==y)
                return dist;

            else {
                a[row][col]=2;
                if(isValid(a, row-1, col)) {
                    int[] temp = { row-1, col, dist+1};
                    a[row-1][col] = 2;
                    q.add(temp);
                }
                if(isValid(a, row+1, col)) {
                    int[] temp = { row+1, col, dist+1};
                    a[row+1][col] = 2;
                    q.add(temp);
                }
                if(isValid(a, row, col-1)) {
                    int[] temp = { row, col-1, dist+1};
                    a[row][col-1] = 2;
                    q.add(temp);
                }
                if(isValid(a, row, col+1)) {
                    int[] temp = { row, col+1, dist+1};
                    a[row][col+1] = 2;
                    q.add(temp);
                }
            }
        }
        return -1;
    }
    boolean isValid(int[][]a, int r, int c){
        if(r>=0 && c>=0 && r<a.length && c<a[0].length && a[r][c]==1)
            return true;
        return false;
    }
};