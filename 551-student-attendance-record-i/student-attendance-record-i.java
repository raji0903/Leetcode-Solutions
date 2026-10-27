class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absentCount++;
                if (absentCount >= 2) {
                    return false;
                }
            }
        }
        
        // Check if the student was late for 3 or more consecutive days
        if (s.contains("LLL")) {
            return false;
        }
        
        return true;
    }
}