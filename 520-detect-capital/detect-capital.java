class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        int n = word.length();
        
        // Count how many uppercase letters are in the word
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }
        
        // Case 1: All letters are uppercase
        // Case 2: All letters are lowercase
        if (count == n || count == 0) {
            return true;
        }
        
        // Case 3: Only the first letter is uppercase
        if (count == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        
        return false;
    }
}