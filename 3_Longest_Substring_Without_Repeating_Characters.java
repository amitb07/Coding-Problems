// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right=0, left=0, lastIndex, len=0, max=0,  n=s.length();
        HashMap<Character, Integer> hmap = new HashMap<>();
        while(right<n)
        {
            char ch = s.charAt(right);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, right);
                len++;
            }
            else {
                lastIndex=hmap.get(ch);
                for(int k=left; k<=lastIndex; k++)
                    hmap.remove(s.charAt(k));
                hmap.put(ch, right);
                left = lastIndex+1;
                len = right-left+1;
            }
            if(len>max)
                max=len;
            right++;
        }
        return max;   
    }
}