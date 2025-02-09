// https://leetcode.com/problems/binary-search/description/
// 704. Binary Search
TC: O(log(n))
class Solution {
    public int search(int[] nums, int target) {
        int low, mid, high, n=nums.length;
        low=0; high = n-1;
        while(low <= high) {
            mid = low+(high-low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}