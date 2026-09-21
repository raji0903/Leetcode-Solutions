class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        // If lengths don't add up, s3 cannot be formed
        if (m + n != s3.length()) {
            return false;
        }

        // dp[j] indicates whether s3[0...i+j-1] can be formed by 
        // interleaving s1[0...i-1] and s2[0...j-1]
        boolean[] dp = new boolean[n + 1];

        // Base case: empty s1 and empty s2 form empty s3
        dp[0] = true;

        // Initialize first row (using characters only from s2)
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }

        // Fill the DP table row by row
        for (int i = 1; i <= m; i++) {
            // First column: using characters only from s1
            dp[0] = dp[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));

            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);
                
                boolean fromS1 = dp[j] && (s1.charAt(i - 1) == c);
                boolean fromS2 = dp[j - 1] && (s2.charAt(j - 1) == c);

                dp[j] = fromS1 || fromS2;
            }
        }

        return dp[n];
    }
}