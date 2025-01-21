//  5. Longest Palindromic Substring
//  https://leetcode.com/problems/longest-palindromic-substring/description/

// Solution has two approaches
class Solution {
    //Approach 1: O(n^2) Expansion from center
    // here handle two cases:  odd and even length pallindrome
    public String longestPalindrome(String s) {
        int low, hi, i, j,len=0, start=0, n=s.length();
        for(i=0;i<n;i++)
        {
            for(j=0;j<=1;j++)
            {
                low=i; hi=j+i;
                while(low>=0 && hi<n && s.charAt(low)==s.charAt(hi))
                {
                    if(hi-low+1>len)
                    {
                        len=hi-low+1;
                        start=low;
                        System.out.println(s.substring(start, start+len)+" "+len);
                    }    
                    low--;
                    hi++;
                }
            }
        }
        return s.substring(start, start+len);
    }

    //Approach 2: O(n^3) but optimised than the brute force approach of evaluating all the substrings.
    // here we only evaluate substrings of length greater than the longest pallindrome substring found so far
    public String longestPalindromeApproch2(String s) {
        int i, j, max=-1, n=s.length();
        String ans="";
        for(i=0;i<n;i++)
        {
            for(j=i; j<n; j++)
            {
                if(j-i>max && isPalindrome(i,j, s))
                {
                    ans=s.substring(i,j+1);
                    max=j-i;
                }
            }
        }
        return ans;
    }
    static boolean isPalindrome(int start, int end, String s) 
    {
        String subString = s.substring(start, end+1);
        int i, n=subString.length();
        for(i=0; i<n/2; i++)
        {
            if(subString.charAt(i) != subString.charAt(n-i-1))
                return false;
        }
        return true;
    }
}