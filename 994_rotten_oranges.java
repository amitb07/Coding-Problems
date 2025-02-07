// https://leetcode.com/problems/rotting-oranges/description/
// 994. Rotting Oranges
class Solution {
    class rotten{
        int r,c,t;
        rotten(int r, int c, int t){
            this.r =r;
            this.c=c;
            this.t=t;
        }
    }
    // Breadth First search approach: TC O(R*C) Space Complexity O(R*C)

    public int orangesRotting(int[][] grid) {
        int i, j, count=0, ct=0, time=0;
        Queue<rotten> q = new LinkedList<>();
        for(i=0; i<grid.length; i++){
            for(j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2) {
                    q.add(new rotten(i,j,0));
                } else if(grid[i][j] == 1)
                    count++;
            }
        }
        if(count==0)
            return 0;
        while(!q.isEmpty()){ 
            rotten temp = q.poll();
            int sc = temp.c, sr=temp.r;
            time=temp.t;
            
            if(isRotten(sr-1, sc, grid)){
                ct++;
                grid[sr-1][sc] = 2;
                q.add(new rotten(sr-1, sc, time+1));
            }   
            if(isRotten(sr+1, sc, grid)) {
                ct++;
                grid[sr+1][sc] = 2;
                q.add(new rotten(sr+1, sc, time+1));
            }  
            if(isRotten(sr, sc-1, grid)) {
                ct++;
                grid[sr][sc-1] = 2;
                q.add(new rotten(sr, sc-1, time+1));
            }  
            if(isRotten(sr, sc+1, grid)) {
                ct++;
                grid[sr][sc+1] = 2;
                q.add(new rotten(sr, sc+1, time+1));
            }
                     
        }
        if(count!=ct)
            return -1;
        return time;
    }
    boolean isRotten(int r, int c, int[][] grid) {
        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 1 )
        {
            return true;
        }
        return false;
    }
}
