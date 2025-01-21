// 300. Longest increasing subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    // Dynamic programming approach
    public int lengthOfLIS(int[] nums) {
        int i, j, max, ans=1, n=nums.length;
        int[] lis = new int[n];
        //lis[0]=1;
        for(i=0;i<n;i++)
        {
            max=0;
            for(j=0; j<i; j++)
            {
                if(nums[j]<nums[i] && lis[j]>max)
                    max=lis[j];
            }
            lis[i]=max+1;
            if(lis[i]>ans)
                ans=lis[i];
        }
        return ans;
    }
}