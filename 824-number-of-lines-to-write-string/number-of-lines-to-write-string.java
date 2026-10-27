class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;
        
        for (char c : s.toCharArray()) {
            int charWidth = widths[c - 'a'];
            
            // If adding the current character exceeds 100 pixels, move to a new line
            if (currentWidth + charWidth > 100) {
                lines++;
                currentWidth = charWidth;
            } else {
                currentWidth += charWidth;
            }
        }
        
        return new int[] { lines, currentWidth };
    }
}