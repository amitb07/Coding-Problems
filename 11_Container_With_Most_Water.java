// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    // two pointer approach O(n) solution
    public int maxArea(int[] height) {
        int i=0, n=height.length, j=n-1, ans=0;
        while(i<j) {
            int area = (j-i) * Math.min(height[i], height[j]);
            ans = Math.max(area, ans);
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return ans;
    }
}