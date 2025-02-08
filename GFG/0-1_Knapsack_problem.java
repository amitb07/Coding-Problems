// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    // Approach1: Brute force: find all subsets with wt less than capacity and then find max value TC: 2^n  
    static int knapSack(int capacity, int val[], int wt[]) {
    
        return subset(capacity, val, wt, val.length);
    }
    
    static int subset(int capacity, int val[], int wt[], int ind) {
        if(ind==0 || capacity == 0)
            return 0;
        if(wt[ind-1]> capacity)
            return subset(capacity, val, wt, ind-1);
        else
            return Math.max(subset(capacity, val, wt, ind-1), val[ind-1]+subset(capacity-wt[ind-1], val, wt, ind-1));
    }
    
    // Approch2: Using dynamic programming store the value of subSets
    //    TC: O(n*capacity) Space: O(n^2)
    static int knapSack1(int capacity, int val[], int wt[]) {
        int i, j, n=val.length;
        int[][] dp = new int[n+1][capacity+1];
        for(i=1; i<=n; i++) {
            for(j=1; j<=capacity; j++) {
                if(j >= wt[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][capacity];
    }

    // Approch3: Most optimum solution using dynamic programming, store the value of only last row in above approach
    //    TC: O(n*capacity) Space: O(n)
    static int knapSack2(int capacity, int val[], int wt[]) {
        int i, j, n = val.length;
        int[] dp = new int[capacity+1];
        for(i=1; i<n+1; i++) {
            for(j=capacity; j>=0; j--){
                if(wt[i-1]<=j)
                    dp[j] = Math.max(dp[j], val[i-1]+dp[j-wt[i-1]]);
            }
        }
        return dp[capacity];
    }
}
