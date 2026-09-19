/* class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;  
        int a = 1; 
        int b = 2; 
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
} */
class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        return solve(n);
    }
    int solve(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = solve(n - 1) + solve(n - 2);
        return dp[n];
    }
}