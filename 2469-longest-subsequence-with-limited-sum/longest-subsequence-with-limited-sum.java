import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        // Step 1: Sort nums to pick the smallest elements first
        Arrays.sort(nums);
        
        int n = nums.length;
        int m = queries.length;
        
        // Step 2: Compute prefix sums in-place to store cumulative totals
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        
        int[] answer = new int[m];
        
        // Step 3: Answer each query using binary search
        for (int i = 0; i < m; i++) {
            int q = queries[i];
            int index = Arrays.binarySearch(nums, q);
            
            if (index >= 0) {
                // Exact match found, index + 1 elements can be taken
                answer[i] = index + 1;
            } else {
                // binarySearch returns (-(insertion point) - 1) if not found
                int insertionPoint = -index - 1;
                answer[i] = insertionPoint;
            }
        }
        
        return answer;
    }
}