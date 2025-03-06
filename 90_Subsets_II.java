// 90. Subsets II
// https://leetcode.com/problems/subsets-ii/description/

class Solution {

    // Approach1: optimal solution:: only creates subset that are not duplicate, 
    // TC: O(2^n) but better than approach2 as it creates less no. of subsets
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int i, n=nums.length;
        Arrays.sort(nums);
        subset(answer, nums, new ArrayList<Integer>(), 0);
        return answer;
    }
    void subset(List<List<Integer>> answer, int[] nums, List<Integer> curList, int ind) {
        answer.add(new ArrayList(curList));
        int start = ind,i;
        for(i=start; i<nums.length; i++) {
            if(i>start && nums[i] == nums[i-1])
                continue;
            curList.add(nums[i]);
            subset(answer, nums, curList, i+1);
            curList.remove(curList.size()-1);
        }
    }

// Approach2: less optimal: first create all possible subsets and then validate if a similar subset exists in answer
// TC: O(2^n)
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int i, n=nums.length;
        Arrays.sort(nums);
        subset(nums, answer, 0, new ArrayList<>());
        return answer;
    }
    void subset(int[] nums, List<List<Integer>> answer, int ind, List<Integer> currentList) {
        if(ind == nums.length) {
            if(!answer.contains(currentList))
                answer.add(currentList);
            return;
        }
        int j=ind+1;
        while(j<nums.length && nums[j] == nums[ind])
            j++;
        List<Integer> includeList = new ArrayList(currentList);
        includeList.add(nums[ind]);
        subset(nums, answer, ind+1, includeList);
        subset(nums, answer, ind+1, currentList);
    }
}