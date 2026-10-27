import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // 1. Initialize queues with ocean borders
        // Pacific: Top row (r = 0) and Left col (c = 0)
        // Atlantic: Bottom row (r = rows - 1) and Right col (c = cols - 1)
        for (int r = 0; r < rows; r++) {
            pacificQueue.offer(new int[]{r, 0});
            pacificReachable[r][0] = true;
            
            atlanticQueue.offer(new int[]{r, cols - 1});
            atlanticReachable[r][cols - 1] = true;
        }

        for (int c = 0; c < cols; c++) {
            pacificQueue.offer(new int[]{0, c});
            pacificReachable[0][c] = true;
            
            atlanticQueue.offer(new int[]{rows - 1, c});
            atlanticReachable[rows - 1][c] = true;
        }

        // 2. Run BFS for both oceans
        bfs(heights, pacificQueue, pacificReachable);
        bfs(heights, atlanticQueue, atlanticReachable);

        // 3. Find cells that can reach both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] reachable) {
        int rows = heights.length;
        int cols = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : DIRECTIONS) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                // Check boundaries, if already visited, and flow condition (water flows uphill backwards: next >= current)
                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols 
                        && !reachable[nextR][nextC] 
                        && heights[nextR][nextC] >= heights[r][c]) {
                    reachable[nextR][nextC] = true;
                    queue.offer(new int[]{nextR, nextC});
                }
            }
        }
    }
}