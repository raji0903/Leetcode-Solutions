import java.util.Random;
import java.util.TreeMap;

class Solution {
    private int[][] rects;
    private TreeMap<Integer, Integer> map;
    private int totalPoints;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.totalPoints = 0;
        this.rand = new Random();

        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            // Number of integer points in the current rectangle
            int points = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            totalPoints += points;
            map.put(totalPoints, i);
        }
    }
    
    public int[] pick() {
        // Pick a random point index from 0 to totalPoints - 1
        // ceilingKey finds the first rectangle range that covers this random index
        int randomKey = map.ceilingKey(rand.nextInt(totalPoints) + 1);
        int rectIndex = map.get(randomKey);
        
        int[] r = rects[rectIndex];
        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);
        
        return new int[] { x, y };
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */