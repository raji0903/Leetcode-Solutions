class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Iterate through all possible starting points of the subarray
        for (int i = 0; i < n; i++) {
            // Iterate through all possible ending points of the subarray
            for (int j = i; j < n; j++) {
                if (isStrictlyIncreasing(nums, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper method to check if the array remains strictly increasing after removing subarray [i, j]
    private boolean isStrictlyIncreasing(int[] nums, int start, int end) {
        int prev = -1;
        for (int k = 0; k < nums.length; k++) {
            // Skip the elements inside the subarray to be removed
            if (k >= start && k <= end) {
                continue;
            }
            if (prev != -1 && nums[k] <= prev) {
                return false;
            }
            prev = nums[k];
        }
        return true;
    }
}