// 15 3Sum : Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// https://leetcode.com/problems/3sum/description/

class Solution {

    // 2pointers approach => Time: O(n^2) Space: O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        int i, j, sum, n=nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(i=0; i<n; i++) {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int l=i+1, r=n-1;
            while(l<r) {
                sum = nums[i]+nums[l]+nums[r];
                if(sum==0)
                {
                    answer.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l] == nums[l+1])
                        l++;
                    while(l<r && nums[r] == nums[r-1])
                        r--;
                    l++;
                    r--;
                }
                else if(sum<0)
                    l++;
                else
                    r--;
            }
        }
        return answer;
    }