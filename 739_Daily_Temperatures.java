// 739. Daily Temperatures
// https://leetcode.com/problems/daily-temperatures/
// Time Complexity: O(N) 
// Auxiliary Space: O(N)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int i, n=temperatures.length;
        int[] ans = new int[n];
        ans[n-1] = 0;
        st.push(n-1);
        for(i=n-2; i>=0; i--)
        {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) 
                st.pop(); 
            
            ans[i] = (st.isEmpty())? 0 : st.peek()-i;
            
            st.push(i);
        } 
        return ans;
    }
}