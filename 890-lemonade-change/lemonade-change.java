class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else { // bill == 20
                // Greedily use one $10 and one $5 first
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } 
                // Otherwise, fall back to three $5 bills
                else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}