// https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
// Chocolate Distribution Problem

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int i, ans = Integer.MAX_VALUE;
        for(i=0; i<arr.size()-m+1;i++)
        {
            ans = Math.min(ans, arr.get(i+m-1)-arr.get(i));
        }
        return ans;
    }
}

