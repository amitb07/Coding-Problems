// 70. Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/description/

// Time Complexity  O(n)
class Solution {
    public int climbStairs(int n) {
        if(n<3)
            return n;
        int a = 1, b = 2, steps=0, temp;
        for(int i = 3; i<=n; i++) {
            steps = a + b;
            a = b;
            b = steps;
        }
        return steps;
    }
}
