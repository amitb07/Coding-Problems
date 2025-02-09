// Floyd Warshall
// https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

// TC: O(V^3)
class Solution {
    public void shortestDistance(int[][] mat) {
        int n = mat.length;
        int k=0;
        while (k<n) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (mat[i][k] != -1 && mat[k][j] != -1) {
                        if (mat[i][j] == -1) {
                            mat[i][j] = mat[i][k] + mat[k][j];
                            continue;
                        }
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
            k++;
        }
    }
}