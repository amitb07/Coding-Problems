//  46 Print all permutations of an array
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// https://leetcode.com/problems/permutations/

class Solution {
    //Backtracking problem: 
    // recursion solution 
    // Time Complexity: O(n * n!)
    // Auxiliary Space: O(n!)
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int i, n=nums.length;
        allPermutations(nums, 0, answer);
        return answer;
    }
    static void allPermutations(int[] nums, int len, List<List<Integer>> answer) {
        int i, n = nums.length;
        if(len == n) {
            List<Integer> list = new ArrayList<>();
            for(int j: nums) 
                list.add(j);
            answer.add(list);
            return;
        }
        for(i=len; i<n; i++) {
            swap(len, i, nums);
            allPermutations(nums, len+1, answer);
            swap(len, i, nums);
        }
    }
    static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}