// 215. Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    // Using priority queue
    public int findKthLargest(int[] arr, int k) {
        int i, j;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(arr).forEach(element -> pq.add(element));
        for(i=0; i<arr.length-k; i++)
            pq.poll();
        return pq.peek();
    }

    // Using heap
    public int findKthLargest2(int[] arr, int k) {
        int i, n=arr.length;
        for(i=n/2-1; i>=0; i--)
            heapify(arr, i, n);
        for(i=n-1; i>=0 && k>1; i--, k--){
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr[0];
    }

    void heapify(int[] arr, int i, int n)
    {
        if(i>n-1)
            return;
        int l = 2*i+1, r=2*i+2, largest=i;
        if(l<n && arr[l]>arr[largest])
            largest = l;
        if(r<n && arr[r] > arr[largest])
            largest = r;
        if(largest!=i)
        {
            swap(arr, largest, i);
            heapify(arr, largest, n);
        }
    }
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}