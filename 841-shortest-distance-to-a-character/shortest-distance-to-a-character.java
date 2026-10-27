class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        
        // First pass: scan from left to right
        int prev = -n; // Initialize with a very small number
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = i - prev;
        }
        
        // Second pass: scan from right to left
        prev = 2 * n; // Initialize with a very large number
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = Math.min(answer[i], prev - i);
        }
        
        return answer;
    }
}