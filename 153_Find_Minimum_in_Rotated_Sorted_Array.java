// 153. Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/


class Solution {
    public int findMin(int[] arr) {
        int lo, hi, mid, n=arr.length;
        lo =0; hi = n-1;
        while(lo<hi) {
            mid = (lo+hi)/2;
            if(arr[lo] <= arr[hi])
                return arr[lo];
            if(arr[mid]>arr[hi])
                lo = mid+1;
            else
                hi = mid;
        }
        return arr[lo];
    }
}