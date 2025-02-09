// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

// TC: O(log(n))

class Solution {
    // Most optimum approach : run binary search only once. one side of the mid will always be sorted. manipulate hi lo accordingly
        int search(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == key)
                return mid;

            if (arr[mid] >= arr[lo]) {
                if (key >= arr[lo] && key < arr[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else {
                if (key > arr[mid] && key <= arr[hi])
                    lo = mid + 1;

                else
                    hi = mid - 1;
            }
        }
        return -1;
    }

    // Approach2: find pivot: point where we get two sorted arrays. So run binarySearch twice
    public int search2(int[] arr, int key) {
        int lo, hi, n=arr.length;
        int pivot = findPivot(arr, 0, n-1);
        
        if(pivot == 0)
            return binarySearch(arr, 0, n-1, key);
            
        if(arr[0] > key)
            return binarySearch(arr, pivot, n-1, key);
            
        return binarySearch(arr, 0, pivot, key);       
    }
    int binarySearch(int[] arr, int lo, int hi, int key) {
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid]<key)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return -1;
    }
    int findPivot(int[] arr, int lo, int hi){
        while(lo<hi) {
            int mid = (lo+hi)/2;
            if(arr[lo] <= arr[hi])
                return lo;
            if(arr[mid]>arr[hi])
                lo = mid+1;
            else
                hi = mid;
        }
        return lo;
    }   
}