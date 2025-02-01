// 912. Sort an Array
// https://leetcode.com/problems/sort-an-array/description/
// Time = O(nlog(n)) Space: O(1)
class Solution {
    public int[] sortArray(int[] arr) {
        maxHeap(arr);
        int i, n=arr.length;
        for(i=n-1; i>=0; i--) {
            swap(arr, 0, i);
            Heapify(arr, 0, i);
        }
        return arr;
    }
    void maxHeap(int[] arr) {
        int n=arr.length;
        for(int i=n/2-1; i>=0; i--)
            Heapify(arr, i, n);
    }
    
    void Heapify(int[] arr, int ind, int n){
        int l = 2*ind+1;
        int r = 2*ind+2;
        int largest = ind;
        if(l<n && arr[l] > arr[largest])
            largest = l;
        if(r<n && arr[r] > arr[largest])
            largest = r;
        if(ind != largest)
        {
            swap(arr, ind, largest);
            Heapify(arr, largest, n);
        }
    }
    
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
