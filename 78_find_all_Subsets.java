// https://leetcode.com/problems/subsets/description/
// find all subsets of given array. 
// backtracking problem.
// Time complexity: O(2^n)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int i, j, n=nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findSubset(nums, -1, list, answer);   
        return answer;
    }
    void findSubset(int[] nums, int ind, List<Integer> list, List<List<Integer>> answer)
    {
        List<Integer> inc = new ArrayList<>(list);
        List<Integer> exc = new ArrayList<>(list);
        if(ind == nums.length-1) {
            answer.add(list);
            return;
        }
        findSubset(nums, ind+1, exc, answer);
        inc.add(nums[ind+1]);
        findSubset(nums, ind+1, inc, answer);
    }
}