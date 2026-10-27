class Solution {
    public int maximumCount(int[] nums) {
        int neg = findFirstGreaterOrEqual(nums, 0);
        int pos = nums.length - findFirstGreaterOrEqual(nums, 1);
        return Math.max(neg, pos);
    }
    
    // Helper function to find the first index where nums[i] >= target
    private int findFirstGreaterOrEqual(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}