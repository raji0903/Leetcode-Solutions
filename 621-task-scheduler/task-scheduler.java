class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        
        // Count frequencies of each task
        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }
        
        // Count how many tasks have the maximum frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }
        
        // Calculate the minimum intervals required
        int intervals = (maxFreq - 1) * (n + 1) + maxCount;
        
        // Return the maximum of the calculated intervals and the total number of tasks
        return Math.max(intervals, tasks.length);
    }
}