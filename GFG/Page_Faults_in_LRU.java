// Page Faults in LRU
// https://www.geeksforgeeks.org/problems/page-faults-in-lru5603/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;
// TimeComplexity O(n*capacity) SpaceComplexity: O(capacity)
class Solution{
    static int pageFaults(int n, int c, int pages[]){
        // code here
        int pageFault=0;
        List<Integer> q = new ArrayList<>();
        for(int i: pages) {
            int ind = q.indexOf(i);
            if(ind == -1) {
                 pageFault++;
                if(q.size() < c)
                    q.add(i);
                else {
                    q.remove(0);
                    q.add(i);
                }
            }
            else {
              q.remove(ind);
              q.add(i);   
            }
        }
        return pageFault;
    }
}