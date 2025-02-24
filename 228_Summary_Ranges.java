// 228. Summary Ranges
// https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start=0, i=0, j, n=nums.length;
        List<String> answer = new ArrayList<>();
        while(i<n) {
            start=i;
            while(start+1<n && nums[start]+1 == nums[start+1])
                start++;
            if(start == i) {
                answer.add(String.valueOf(nums[i]));
                i++;
            } else {
                String str = nums[i]+"->"+nums[start];
                answer.add(str);
                i=start+1;
            }
        }
        return answer;
    }
}