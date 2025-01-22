// 560. Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/description/

class Solution {
    // optimum solution O(n)
    // store the value of current currentSum in the hashmap
    // increment count of ans if currentSum == k or 
    // if hashMap contains currentSum-k then add ans+=hashMap.get(currentSum-k);
    public int subarraySum(int[] nums, int k) {
        int i, j, currentSum=0, ans=0, n=nums.length;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        for(i=0; i<n; i++) {
            currentSum += nums[i];
            if(currentSum == k)
                ans++;
                
            if(prefixSumMap.containsKey(currentSum-k)) 
                ans+= prefixSumMap.get(currentSum-k);
            if(prefixSumMap.containsKey(currentSum))
                prefixSumMap.put(currentSum, prefixSumMap.get(currentSum)+1);
            else
                prefixSumMap.put(currentSum, 1);
        }
        return ans;
    }

// Naive approach O(n^2) 
// find all subarrays sum and compare it with k
    public int subarraySum2(int[] nums, int k) {
        int left=0, right=0, currentSum=0, n=nums.length, ans=0; 
        for(int i=0;i<n;i++)
        {   currentSum=0;
            for(int j=i; j<n; j++)
            {
                currentSum+=nums[j];
                if(currentSum==k)
                    ans++;
            }
        }
        return ans;
    }
}