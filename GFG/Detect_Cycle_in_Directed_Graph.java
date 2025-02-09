// Cycle in a Directed Graph
// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// TimeComplexity: O(V+E) Space= O(2*V)
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new int[v];
        int[] path = new int[v];
        for(int i=0; i<v; i++) {
            if(visited[i]==0 && isCyclicUtil(adj, i, visited, path))
                    return true;
        }
        
        return false;
    }
    boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, int v, int[] visited, int[]  path) {
        if(visited[v] == 0) {
            visited[v]=1;
            path[v] = 1;
            ArrayList<Integer> neighbor = adj.get(v);
            for(int nb: neighbor) {
                if(visited[nb]==0 && isCyclicUtil(adj, nb, visited, path))
                        return true;
                        
                else if( path[nb] ==1)
                        return true;
            }
        }   
        path[v] = 0;
        return false;
    }
    
}