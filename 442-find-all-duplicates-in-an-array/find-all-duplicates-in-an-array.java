class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            
            // If the value at the target index is negative, it's a duplicate
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                // Otherwise, mark it as visited by negating it
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
}