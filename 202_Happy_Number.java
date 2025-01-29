class Solution {
    // https://leetcode.com/problems/happy-number/description/
    // Fast slow pointer approach. Time complexity is better.
    public boolean isHappy(int n) {
        int slow = n, fast=n;
        do {
            slow = square(slow);
            fast=square(square(fast));
        }
        while(slow!=fast); 
        if(slow == 1 || fast == 1)
            return true;
        
        return false;
    }
    int square(int n)
    {
        int square = 0;
        while(n>0){
            square+=(n%10)*(n%10);
            n/=10;
        }
        return square;
    }

    // normal approach
    public boolean isHappy2(int n) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int i, remainder, num, newNum;
        while(!hmap.containsKey(n)) {
            hmap.put(n, 1);
            num = n; newNum = 0;
            while(num>0) {
                remainder = num%10;
                newNum += remainder*remainder;
                num = num/10;
            }
            if(newNum == 1)
                return true;
            n = newNum;
        }
        return false;
    }
}