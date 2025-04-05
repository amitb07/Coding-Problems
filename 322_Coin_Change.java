// 322. Coin Change
// https://leetcode.com/problems/coin-change/description/

// Time complexity: O(amount*coins)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int i, j, k, n=coins.length, inf=amount+1;
        int[] a = new int[amount+1];
        for(i=1; i<=amount; i++)
        {
            a[i] = inf;
            j=i;
            for(k=0; k<n; k++)
            {
                int t = j-coins[k];
                if(t == 0 || (t >= 0 && a[t] > 0))
                    a[i] = Math.min(a[i], a[t]+1);
            }
            if(a[i] == inf)
                a[i] = -1;
        }
        
        return a[amount];
    }
}