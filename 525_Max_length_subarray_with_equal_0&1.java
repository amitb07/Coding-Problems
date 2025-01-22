// 525 maximum length of a contiguous subarray with an equal number of 0 and 1
// https://leetcode.com/problems/contiguous-array/

class Solution {
    // O(n) solution using prefix sum
    public int findMaxLength(int[] nums) {
        int i, t, j, sum=0, len=0, n=nums.length, ans=0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(i=0;i<n;i++) {
            t=(nums[i] == 0)? -1: 1;
            sum+=t;
            if(sum==0)
                ans = Math.max(i+1, ans);
            if(hmap.containsKey(sum))
                ans=Math.max(ans, i-hmap.get(sum));
            else
                hmap.put(sum, i);
        }
        return ans;
    }
}