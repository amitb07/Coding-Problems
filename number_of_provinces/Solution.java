//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] vis;
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        // code here
        vis = new int[v];
        int ans=0, i;
        for(i=0;i<v;i++)
        {
            if(vis[i]==0)
            {
                ans++;
                dfs(adj, i);
            }
        }
        return ans;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, int v)
    {
        vis[v]=1;
        ArrayList<Integer> l = adj.get(v);
        for(int i=0; i<l.size(); i++)
        {
            int t=l.get(i);
            if(t==1 && vis[i]==0)
            {
                dfs(adj, i);
            }
        }
    }
};
