// 198. House Robber
// https://leetcode.com/problems/house-robber/description/

// Time Complexity O(n)

class Solution {
    public int rob(int[] nums) {
        int rob=0, noRob = 0;
        for(int val: nums) {
            int temp = Math.max(rob, noRob);
            rob = noRob+val;
            noRob = temp;
        } 
        return Math.max(rob, noRob);
    }
    
    public int rob2(int[] nums) {
        int ans=0, i, n=nums.length;
        int[] robValue = new int[n];
        
        for(i=0; i<n; i++) {
            if(i==0) {
                robValue[i] = nums[i];
            } else if(i==1) {
               robValue[i] = Math.max(nums[i], nums[i-1]);
            } else {
                robValue[i] = Math.max(robValue[i-1], nums[i] + robValue[i-2]);
            }
            ans = Math.max(ans, robValue[i]);
        }
        return ans;
    }
}