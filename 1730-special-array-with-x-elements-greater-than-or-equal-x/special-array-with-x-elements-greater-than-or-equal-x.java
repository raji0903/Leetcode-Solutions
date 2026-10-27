class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        // x can range from 0 to n
        for (int x = 0; x <= n; x++) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }
        return -1;
    }
}