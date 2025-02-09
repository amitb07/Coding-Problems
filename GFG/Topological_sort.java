// https://www.geeksforgeeks.org/problems/topological-sort/1
// Time Complexity: O(V+E). The above algorithm is simply DFS with an extra stack. So time complexity is the same as DFS
// Auxiliary space: O(V). The extra space is needed for the stack
class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        
        ArrayList<Integer> answer = new ArrayList<>();
        int[] visited = new int[adj.size()];
        Stack<Integer> sol = new Stack<>();
        
        for(int i=0; i<adj.size(); i++) {
            if(visited[i] == 0)
                dfs(adj, i, visited, sol);
        }
        
        while(!sol.isEmpty())
            answer.add(sol.pop());
        
        return answer;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, int v, int[] visited, Stack<Integer> sol){
        visited[v] = 1;
        for(int neighbor: adj.get(v)){
            if(visited[neighbor] == 0){
                dfs(adj, neighbor, visited, sol);
            }
        }
        sol.push(v);
    }
}