// 80. Remove Duplicates from Sorted Array II
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150

class Solution {

    public int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;        
    }
    
    public int removeDuplicates2(int[] nums) {
        int i, j, c=0, k=0,duplicates=0, n=nums.length;
        i=0; j=0;
        while(i<n) {
            j=i+1; c=0;
            while(j<n && nums[i] == nums[j]) {
                 c++; 
                if(c>1) {
                    nums[j] = Integer.MAX_VALUE;
                    duplicates++;
                }
                j++;
            }
            i=j;    
        }

        i=0; j=-1;
        while(i<n) {
            if(nums[i] == Integer.MAX_VALUE) {
                j=i+1;
                while(j<n && nums[j] == Integer.MAX_VALUE)
                    j++;
                if(j<n)
                    swap(nums, i, j);
            }
            i++;
        }
        return n-duplicates;
    }
    void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}