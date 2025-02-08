// detect cycle in Undirected Graph
// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//{ Driver Code Starts

// TC O(V+E) SpaceComplexity O(V)
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n=adj.size();
        int[] visited = new int[n];
        for(int i =0; i<n; i++) {
            if(visited[i] == 0)
                if(dfs(adj, visited, i, -1))
                    return true;
        }
        return false;   
    }
    
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int v, int parent) {
        visited[v] =1;
        ArrayList<Integer> neighbor = adj.get(v);
        for(int nb: neighbor) {
            if(visited[nb] == 0){
                if(dfs(adj, visited, nb, v))
                    return true;
            }
            else if(nb != parent)
                return true;
        }
        return false;
    }
}